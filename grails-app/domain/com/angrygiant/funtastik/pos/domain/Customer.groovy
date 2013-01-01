package com.angrygiant.funtastik.pos.domain

class Customer {

    String firstName
    String lastName
    String middleInitial

    String bonusCardNumber = ""

    boolean teamMember = false

    static constraints = {
        firstName(nullable: false, blank: false)
        lastName(nullable: false, blank: false)
        middleInitial(nullable: true, blank: true)
        bonusCardNumber(nullable: true, blank: true)
        teamMember()
    }

    static transients = ["fullName"]

    //convenience methods
    String getFullName() {
        return "${firstName} ${lastName}"
    }

    void setFullName(String fullName) {
        String[] parts = fullName.split(" ")

        if (parts.length == 2) {
            this.firstName = parts[0]
            this.lastName = parts[1]
        } else if (parts.length == 3) {
            this.firstName = parts[0]
            this.middleInitial = parts[1]
            this.lastName = parts[2]
        } else {
            log.error("I can't set full name with that format!!! - was passed ${fullName}")
        }
    }
}
