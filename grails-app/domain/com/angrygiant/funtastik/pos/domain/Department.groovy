package com.angrygiant.funtastik.pos.domain

class Department {

    String name
    boolean retired = false

    static constraints = {
        name(nullable: false, blank: false)
        retired()
    }

    String toString() {
        return name
    }
}
