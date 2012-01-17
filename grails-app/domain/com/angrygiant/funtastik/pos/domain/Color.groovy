package com.angrygiant.funtastik.pos.domain

class Color {

    String name

    static constraints = {
        name(blank: false, nullable: false)
    }
}
