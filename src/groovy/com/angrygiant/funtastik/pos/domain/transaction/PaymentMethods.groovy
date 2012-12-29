package com.angrygiant.funtastik.pos.domain.transaction

/**
 * Created with IntelliJ IDEA.
 * User: hfdpm100
 * Date: 12/29/12
 * Time: 12:46 PM
 * To change this template use File | Settings | File Templates.
 */
public enum PaymentMethods {
    CASH("CASH"),
    CHECK("CHECK"),
    CREDITCARD("CREDITCARD"),
    GIFTCARD("GIFTCARD")

    final String id

    private PaymentMethods(String id) {
        this.id = id
    }

    static PaymentMethods byId(String id) {
        values().find {
            it.id == id
        }
    }
}