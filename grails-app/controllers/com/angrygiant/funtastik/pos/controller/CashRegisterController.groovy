package com.angrygiant.funtastik.pos.controller

import com.angrygiant.funtastik.pos.domain.Customer
import com.angrygiant.funtastik.pos.domain.InventoryItem
import com.angrygiant.funtastik.pos.domain.PosLineItem
import com.angrygiant.funtastik.pos.domain.PosPaymentEntry
import com.angrygiant.funtastik.pos.domain.PosTransaction
import com.angrygiant.funtastik.pos.domain.Size
import com.angrygiant.funtastik.pos.domain.transaction.PaymentMethods
import com.angrygiant.funtastik.pos.domain.transaction.TransactionStatus
import grails.converters.JSON
import org.apache.commons.lang.StringUtils

import java.sql.Timestamp

class CashRegisterController {

    def springSecurityService
    def sizesService
    def cashRegisterService
    def inventoryService

    def index() {
        PosTransaction transaction

        if (!params.id) {
            log.debug("Creating new transaction as OPEN")
            transaction = new PosTransaction()
            transaction.cashier = springSecurityService.currentUser
            transaction.status = TransactionStatus.OPEN
            transaction.transactionDate = new Timestamp(new Date().time)

            transaction.save(flush: true)
        } else {
            transaction = PosTransaction.get(params.id)

            if (!transaction) {
                log.error("No transaction found for ID " + params.id)
                //TODO set flash error
                redirect(uri: '/cashregister/main')
            }
        }

        double subtotal = cashRegisterService.calculateSubtotalForTransaction(transaction)
        double salesTax = cashRegisterService.calculateSalesTaxForTransaction(transaction)
        double totalDue = cashRegisterService.calculateTotalAmountDueForTransaction(transaction)

        //calculate if transaction should be closed.
        if (totalDue <= 0 && transaction?.payments?.size() > 0 && transaction?.lineItems?.size() > 0) {
            transaction.status = TransactionStatus.COMPLETED
            if (transaction.save(flush: true)) {
                for (PosLineItem item : transaction.lineItems) {
                    inventoryService.adjustQuantityForItem(item.item, item.size, item.quantity)
                }
            }
        }

        render(view: 'transaction', model: [transaction: transaction, subtotal: subtotal, salesTax: salesTax, totalDue: totalDue])
    }

    def addQuantityToLineItem() {
        PosLineItem lineItem = PosLineItem.get(params.lineItemId)

        if (!lineItem) {
            log.error("Could not adjust quantity for line item...not found")
            redirect(action: 'index', id: params.transactionId)
            return
        }

        lineItem.quantity = Integer.parseInt(params.quantity)
        lineItem.save(flush: true)

        redirect(action: 'index', id: params.transactionId)
    }

    def addItemToTransaction() {
        if (!params.queryItem || !params.id || !params.itemSize) {
            log.error("No sku, transaction id or item size specified - going back")
            //set flash message for screen
            redirect(action: 'index', id: params.id)
            return
        }

        PosTransaction transaction = PosTransaction.get(params.id)
        if (!transaction) {
            log.error("No transaction found for ID " + params.id)
            //TODO set flash error
            redirect(uri: '/cashregister/main')
            return
        }

        InventoryItem inventoryItem = InventoryItem.findBySkuCode(params.queryItem)
        Size size = Size.get(params.itemSize)

        if (!inventoryItem || !size) {
            log.error("Could not find item or size: ${params.queryItem} - ${params.itemSize}")
            //set flash message for screen
            redirect(action: 'index', id: params.id)
            return
        }

        PosLineItem lineItem = PosLineItem.findByItemAndSizeAndTransaction(inventoryItem, size, transaction)

        if (!lineItem) {
            lineItem = new PosLineItem()
            lineItem.item = inventoryItem
            lineItem.size = size
            lineItem.quantity = 1
            lineItem.transaction = transaction

            lineItem.save(flush: true)
        } else {
            lineItem.quantity++
            lineItem.save(flush: true)
        }

        //TODO set success flash message
        redirect(action: 'index', id: params.id)
    }

    def removeItemFromTransaction() {
        PosLineItem lineItem = PosLineItem.get(params.id)

        if (!lineItem) {
            log.error("Could not find line item with id ${params.id}")
            //TODO set flash error
            redirect(action: 'index', id: params.transactionId)
        }

        lineItem.delete(flush: true);

        redirect(action: 'index', id: params.transactionId)
    }

    def addTransactionDiscount() {
        PosTransaction transaction = PosTransaction.get(params.transactionId)

        double discount = Double.parseDouble(params.transactionDiscount)

        if (discount < 1 && discount > 0) {
            log.warn("You can add values > 1...assuming it's 'whole' equivalent, in this case, ${discount * 100}%")
            transaction.transactionDiscount = discount
            transaction.save(flush: true)
        } else if (discount > 100 || discount < 0) {
            log.error("Invalid discount amount! Ignoring...")
            //TODO set flash error message
        } else {
            discount = discount / 100
            transaction.transactionDiscount = discount
            transaction.save(flush: true)
        }

        redirect(action: 'index', id: params.transactionId)
    }

    def markTransactionPending() {
        PosTransaction transaction = PosTransaction.get(params.transactionId)

        transaction.status = TransactionStatus.PENDING

        transaction.save(flush: true)

        redirect(action: 'index', id: transaction.id)
    }

    def markTransactionOpen() {
        PosTransaction transaction = PosTransaction.get(params.transactionId)

        transaction.status = TransactionStatus.OPEN

        transaction.save(flush: true)

        redirect(action: 'index', id: transaction.id)
    }

    def markTransactionCancelled() {
        PosTransaction transaction = PosTransaction.get(params.transactionId)

        transaction.status = TransactionStatus.CANCELLED

        transaction.save(flush: true)

        redirect(action: 'index', id: transaction.id)
    }

    def markTransactionLayaway() {
        PosTransaction transaction = PosTransaction.get(params.transactionId)

        transaction.status = TransactionStatus.LAYAWAY

        transaction.save(flush: true)

        redirect(action: 'index', id: transaction.id)
    }

    def getPendingTransactions() {
        def transactions = PosTransaction.findAllByTransactionStatus(TransactionStatus.PENDING.id)

        render(view: 'lookupTransactions', model: [transactions: transactions])
    }

    def getLayawayTransactions() {
        def transactions = PosTransaction.findAllByTransactionStatus(TransactionStatus.LAYAWAY.id)

        render(view: 'lookupTransactions', model: [transactions: transactions])
    }

    def addPaymentToTransaction() {
        PosTransaction transaction = PosTransaction.get(params.transactionId)

        double amount = Double.parseDouble(params.paymentAmount)
        String method = params.paymentMethod
        String refNumber = params.paymentReferenceNumber

        PosPaymentEntry entry = new PosPaymentEntry()
        entry.amount = amount
        entry.method = PaymentMethods.byId(method)
        entry.referenceNumber = refNumber
        entry.paymentDate = new Timestamp(new Date().time)
        entry.cashier = springSecurityService.currentUser
        entry.transaction = transaction

        entry.save(flush: true)

        redirect(action: 'index', id: transaction.id)
    }

    def removePaymentEntryFromTransaction() {
        PosPaymentEntry paymentEntry = PosPaymentEntry.get(params.id)

        if (!paymentEntry) {
            log.error("Could not find entry with id ${params.id}")
            //TODO set flash error
            redirect(action: 'index', id: params.transactionId)
        }

        paymentEntry.delete(flush: true);

        redirect(action: 'index', id: params.transactionId)
    }

    def addCustomerToTransaction() {
        PosTransaction transaction = PosTransaction.get(params.transactionId)

        if (params.customerId == "-1") {
            transaction.customer = null;
            transaction.save(flush: true);

            redirect(action: 'index', id: transaction.id)
            return
        }

        Customer customer
        if (StringUtils.isBlank(params.customerId)) {
            log.info("Creating new customer for transaction..")
            //create a new customer object
            String[] pieces = params.customerName.toString().split(" ")

            customer = new Customer()
            customer.firstName = pieces[0]

            if (pieces.size() > 0) {
                customer.lastName = pieces[1]
            }

            customer.homePhone = params.phoneNumber.toString()

            if (!customer.save(flush: true)) {
                log.error("Could not save customer...")
                customer.errors.allErrors.each {
                    log.error(it.defaultMessage)
                }
                customer = null
            }
        } else {
            log.info("Adding existing customer of id ${params.customerId}")
            customer = Customer.get(params.customerId)
        }

        if (customer) {
            transaction.customer = customer
            transaction.save(flush: true)
        }

        redirect(action: 'index', id: transaction.id)
    }

    def ajaxGetSizes() {
        log.warn("looking up sizes for SKU: " + params.skuCode)
        InventoryItem inventoryItem = InventoryItem.findBySkuCode(params.skuCode)

        if (!inventoryItem) {
            def sizesList = ["sizes": []]
            render sizesList as JSON
            return
        }

        def sizes = sizesService.getSizesForItem(inventoryItem.id, inventoryItem.itemType.id)
        def sizesList = ["sizes": sizes]
        render sizesList as JSON
    }

    def ajaxGetCustomers() {
        log.warn("Searching for ${params.q}")
        def list = Customer.findAllByFirstNameOrLastNameIlike(params.q, params.q)

        render list as JSON
    }
}
