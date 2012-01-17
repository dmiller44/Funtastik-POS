package com.angrygiant.funtastik.pos.domain

class Department {

    String name
    boolean retired = false

    static constraints = {
        name(nullable: false, blank: false, unique: true)
        retired()
    }

    String toString() {
        return name
    }
}
