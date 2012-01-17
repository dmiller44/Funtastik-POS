package com.angrygiant.funtastik.pos.domain

class ItemSubType {

    static belongsTo = [itemType: ItemType]

    String name
    boolean retired = false

    static constraints = {
        name(nullable: false, blank: false)
        retired()
    }
}
