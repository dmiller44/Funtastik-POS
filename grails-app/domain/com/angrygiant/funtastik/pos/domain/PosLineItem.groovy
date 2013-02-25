package com.angrygiant.funtastik.pos.domain

class PosLineItem {

    static belongsTo = [transaction: PosTransaction]

    InventoryItem item
    Size size
    int quantity = 1
    double price

    static constraints = {
        item(nullable: false)
        size(nullable: false)
        price(nullable: false)
        quantity()
    }
}
