package com.angrygiant.funtastik.pos.domain

class InventoryItem {

    static hasMany = [departments: Department]

    String name
    String description
    int qoh = 0
    double wholesalePrice
    double retailPrice
    boolean taxable = false
    boolean barcoded = false
    String skuCode
    boolean archived = false
    ItemType itemType
    ItemSubType subType
    Manufacturer manufacturer
    Color color

    static constraints = {
        skuCode(blank: false, nullable: false, unique: true)
        name(blank: false, nullable: false, unique: true)
        description(blank: true, nullable: true)
        itemType(nullable: false)
        subType(nullable: true)
        manufacturer(nullable: false)
        color(nullable: false)
        wholesalePrice()
        retailPrice()
        qoh()
        taxable()
        barcoded()
        archived()
    }
}
