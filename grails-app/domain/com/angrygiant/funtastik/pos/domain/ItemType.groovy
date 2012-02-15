package com.angrygiant.funtastik.pos.domain

class ItemType {

    String name
    boolean retired

    static constraints = {
        name(blank: false, nullable: false, unique: true)
        retired()
    }

    String toString() {
        return name
    }
}
