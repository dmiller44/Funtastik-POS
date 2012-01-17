package com.angrygiant.funtastik.pos.domain

class Manufacturer {

    String name
    String phoneNumber
    String webSite
    boolean preferredVendor = false

    static constraints = {
        name(blank: false, nullable: false, unique: true)
        phoneNumber(blank: true, nullable: true)
        webSite(blank: true, nullable: true)
        preferredVendor()
    }

    String toString() {
        return name
    }
}
