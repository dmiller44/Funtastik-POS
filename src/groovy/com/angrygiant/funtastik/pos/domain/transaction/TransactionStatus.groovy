package com.angrygiant.funtastik.pos.domain.transaction

/**
 * Created with IntelliJ IDEA.
 * User: hfdpm100
 * Date: 12/29/12
 * Time: 12:32 PM
 * To change this template use File | Settings | File Templates.
 */
public enum TransactionStatus {
    OPEN("OPEN"),
    PENDING("PENDING"),
    CANCELLED("CANCELLED"),
    LAYAWAY("LAYAWAY"),
    COMPLETED("COMPLETED")

    final String id

    private TransactionStatus(String id) {
        this.id = id
    }

    static TransactionStatus byId(String id) {
        values().find {
            it.id == id
        }
    }
}