package com.angrygiant.funtastik.pos.domain

class InventoryItemRecord {

    InventoryItem inventoryItem
    Size size
    int qoh = 0
    double priceQuantifier = 1.0

    static constraints = {
        inventoryItem(nullable: false)
        size(nullable: false)
        qoh()
        priceQuantifier()
    }
}
