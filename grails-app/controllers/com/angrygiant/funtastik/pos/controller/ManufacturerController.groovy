package com.angrygiant.funtastik.pos.controller

import org.springframework.dao.DataIntegrityViolationException
import com.angrygiant.funtastik.pos.domain.Manufacturer
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class ManufacturerController {

    static allowedMethods = [save: "POST", update: "POST", delete: "GET"]

    def inventoryService

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        def manufacturers = Manufacturer.list(params)

        Map hasManufacturers = [:]
        for (Manufacturer manufacturer : manufacturers) {
            hasManufacturers.put(manufacturer.id, inventoryService.haveManufacturersBeenUsed(manufacturer))
        }

        [manufacturerInstanceList: manufacturers, manufacturerInstanceTotal: Manufacturer.count(), hasManufacturers: hasManufacturers]
    }

    def create() {
        [manufacturerInstance: new Manufacturer(params)]
    }

    def save() {
        def manufacturerInstance = new Manufacturer(params)
        if (!manufacturerInstance.save(flush: true)) {
            render(view: "create", model: [manufacturerInstance: manufacturerInstance])
            return
        }

        flash.message = "Successfully added '${manufacturerInstance.name}' to the System"
        redirect(action: "create")
    }

    def edit() {
        def manufacturerInstance = Manufacturer.get(params.id)
        if (!manufacturerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'manufacturer.label', default: 'Manufacturer'), params.id])
            redirect(action: "list")
            return
        }

        [manufacturerInstance: manufacturerInstance]
    }

    def update() {
        def manufacturerInstance = Manufacturer.get(params.id)
        if (!manufacturerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'manufacturer.label', default: 'Manufacturer'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (manufacturerInstance.version > version) {
                manufacturerInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'manufacturer.label', default: 'Manufacturer')] as Object[],
                        "Another user has updated this Manufacturer while you were editing")
                render(view: "edit", model: [manufacturerInstance: manufacturerInstance])
                return
            }
        }

        manufacturerInstance.properties = params

        if (!manufacturerInstance.save(flush: true)) {
            render(view: "edit", model: [manufacturerInstance: manufacturerInstance])
            return
        }

        flash.message = "Successfully saved Changes"
        redirect(action: "edit", id: manufacturerInstance.id)
    }

    def delete() {
        def manufacturerInstance = Manufacturer.get(params.id)
        if (!manufacturerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'manufacturer.label', default: 'Manufacturer'), params.id])
            redirect(action: "list")
            return
        }

        try {
            manufacturerInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'manufacturer.label', default: 'Manufacturer'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'manufacturer.label', default: 'Manufacturer'), params.id])
            redirect(action: "list")
        }
    }
}
