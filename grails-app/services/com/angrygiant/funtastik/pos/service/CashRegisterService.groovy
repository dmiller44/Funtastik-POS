package com.angrygiant.funtastik.pos.service

import com.angrygiant.funtastik.pos.domain.PosLineItem
import com.angrygiant.funtastik.pos.domain.PosPaymentEntry
import com.angrygiant.funtastik.pos.domain.PosTransaction

class CashRegisterService {

    public static final double PA_SALES_TAX = 0.06

    double calculateSubtotalForTransaction(PosTransaction transaction) {
        double subtotal = 0

        for (PosLineItem lineItem : transaction.lineItems) {
            subtotal += lineItem.price * lineItem.quantity
        }

        if (transaction.transactionDiscount > 0) {
            double discountAmount = subtotal * transaction.transactionDiscount

            subtotal -= discountAmount
        }

        return subtotal
    }

    double calculateSalesTaxForTransaction(PosTransaction transaction) {
        double salesTax = 0

        double totalToTax = 0
        for (PosLineItem lineItem : transaction.lineItems) {
            if (lineItem.item.taxable) {
                totalToTax += lineItem.price * lineItem.quantity
            }
        }

        if (transaction.transactionDiscount > 0) {
            double discountAmount = totalToTax * transaction.transactionDiscount

            totalToTax -= discountAmount
        }

        salesTax = totalToTax * PA_SALES_TAX

        return salesTax
    }

    double calculateTotalAmountDueForTransaction(PosTransaction transaction) {
        double totalPrice = calculateSubtotalForTransaction(transaction) + calculateSalesTaxForTransaction(transaction)

        double totalDue = totalPrice

        for (PosPaymentEntry entry : transaction.payments) {
            totalDue -= entry.amount
        }

        return totalDue
    }
}
