package com.angrygiant.funtastik.pos.domain

import com.angrygiant.funtastik.pos.domain.transaction.TransactionStatus
import com.angrygiant.funtastik.security.Users

import java.sql.Timestamp

class PosTransaction {

    static hasMany = [lineItems: PosLineItem, payments: PosPaymentEntry]

    Users cashier
    Customer customer
    Timestamp transactionDate = new Timestamp(new Date().time)
    double transactionDiscount = 0.0
    String transactionStatus = "OPEN"

    static constraints = {
        lineItems(nullable: true)
        cashier(nullable: false)
        customer(nullable: true)
        transactionDate(nullable: false)
        transactionDiscount()
    }

    static transients = ['status']

    TransactionStatus getStatus() {
        transactionStatus ? TransactionStatus.byId(transactionStatus) : TransactionStatus.OPEN
    }

    void setStatus(TransactionStatus status) {
        this.transactionStatus = status.id
    }
}
