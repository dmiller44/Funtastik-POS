package com.angrygiant.funtastik.pos.domain

import com.angrygiant.funtastik.pos.domain.transaction.PaymentMethods
import com.angrygiant.funtastik.security.Users

import java.sql.Timestamp

class PosPaymentEntry {

    String paymentMethod = "CASH"
    double amount = 0.0
    String referenceNumber
    Timestamp paymentDate = new Timestamp(new Date().time)
    Users cashier

    static constraints = {
        paymentMethod(nullable: false, blank: false)
        amount()
        referenceNumber(nullable: true, blank: true)
        paymentDate(nullable: false)
        cashier(nullable: false)
    }

    static transients = ['method']

    PaymentMethods getMethod() {
        this.paymentMethod ? PaymentMethods.byId(this.paymentMethod) : PaymentMethods.CASH
    }

    void setMethod(PaymentMethods method) {
        this.paymentMethod = method.id
    }
}
