package com.angrygiant.funtastik.pos.domain

class Address {

    static belongsTo = Customer

    String streetAddress
    String extendedStreetAddress
    String city
    String stateAbbr
    String zipCode

    static constraints = {
        streetAddress(nullable: false, blank: false)
        extendedStreetAddress(nullable: true, blank: true)
        city(nullable: false, blank: false)
        stateAbbr(nullable: false, blank: false)
        zipCode(nullable: false, blank: false)
    }
}
