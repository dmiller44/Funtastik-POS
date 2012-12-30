package com.angrygiant.funtastik.pos.controller

import com.angrygiant.funtastik.pos.domain.InventoryItem
import com.angrygiant.funtastik.pos.domain.InventoryItemRecord
import com.angrygiant.funtastik.pos.domain.PosLineItem
import com.angrygiant.funtastik.pos.domain.PosTransaction
import com.angrygiant.funtastik.pos.domain.Size
import com.angrygiant.funtastik.pos.domain.transaction.TransactionStatus
import grails.converters.JSON

import java.sql.Timestamp

class CashRegisterController {

    def springSecurityService
    def sizesService

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

        render(view: 'transaction', model: [transaction: transaction])
    }

    def addItemToTransaction() {
        println params.queryItem
        println params.itemSize
        println params.id

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

        PosLineItem lineItem = new PosLineItem()
        lineItem.item = inventoryItem
        lineItem.size = size
        lineItem.quantity = 1
        lineItem.transaction = transaction

        lineItem.save(flush: true)

        //TODO set success flash message
        redirect(action: 'index', id: params.id)
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
}
