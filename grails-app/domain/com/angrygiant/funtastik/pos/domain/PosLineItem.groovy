package com.angrygiant.funtastik.pos.domain

class PosLineItem {

    static belongsTo = [transaction: PosTransaction]

    InventoryItem item
    Size size
    int quantity = 1

    static constraints = {
        item(nullable: false)
        size(nullable: false)
        quantity()
    }
}
