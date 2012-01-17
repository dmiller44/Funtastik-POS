package com.angrygiant.funtastik.pos.domain

class Size {

    static belongsTo = [itemType: ItemType]

    String name

    static constraints = {
        name(blank: false, nullable: false)
    }
}
