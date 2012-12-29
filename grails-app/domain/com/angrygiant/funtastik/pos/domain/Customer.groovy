package com.angrygiant.funtastik.pos.domain

class Customer {

    String firstName
    String lastName
    String middleInitial

    String bonusCardNumber = ""

    static constraints = {
        firstName(nullable: false, blank: false)
        lastName(nullable: false, blank: false)
        middleInitial(nullable: true, blank: true)
        bonusCardNumber(nullable: true, blank: true)
    }
}
