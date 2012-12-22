package com.angrygiant.funtastik.pos.controller

import org.springframework.dao.DataIntegrityViolationException
import com.angrygiant.funtastik.pos.domain.InventoryItem
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class InventoryItemController {

    static allowedMethods = [save: "POST", update: "POST", delete: "GET"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [inventoryItemInstanceList: InventoryItem.list(params), inventoryItemInstanceTotal: InventoryItem.count()]
    }

    def create() {
        [inventoryItemInstance: new InventoryItem(params)]
    }

    def save() {
        def inventoryItemInstance = new InventoryItem(params)
        if (!inventoryItemInstance.save(flush: true)) {
            render(view: "create", model: [inventoryItemInstance: inventoryItemInstance])
            return
        }

        flash.message = "Inventory Item successfully created"
        redirect(action: "list")
    }

    def show() {
        def inventoryItemInstance = InventoryItem.get(params.id)
        if (!inventoryItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'inventoryItem.label', default: 'InventoryItem'), params.id])
            redirect(action: "list")
            return
        }

        [inventoryItemInstance: inventoryItemInstance]
    }

    def edit() {
        def inventoryItemInstance = InventoryItem.get(params.id)
        if (!inventoryItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'inventoryItem.label', default: 'InventoryItem'), params.id])
            redirect(action: "list")
            return
        }

        [inventoryItemInstance: inventoryItemInstance]
    }

    def update() {
        def inventoryItemInstance = InventoryItem.get(params.id)
        if (!inventoryItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'inventoryItem.label', default: 'InventoryItem'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (inventoryItemInstance.version > version) {
                inventoryItemInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'inventoryItem.label', default: 'InventoryItem')] as Object[],
                        "Another user has updated this InventoryItem while you were editing")
                render(view: "edit", model: [inventoryItemInstance: inventoryItemInstance])
                return
            }
        }

        inventoryItemInstance.properties = params

        if (!inventoryItemInstance.save(flush: true)) {
            render(view: "edit", model: [inventoryItemInstance: inventoryItemInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'inventoryItem.label', default: 'InventoryItem'), inventoryItemInstance.id])
        redirect(action: "show", id: inventoryItemInstance.id)
    }

    def delete() {
        def inventoryItemInstance = InventoryItem.get(params.id)
        if (!inventoryItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'inventoryItem.label', default: 'InventoryItem'), params.id])
            redirect(action: "list")
            return
        }

        try {
            inventoryItemInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'inventoryItem.label', default: 'InventoryItem'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'inventoryItem.label', default: 'InventoryItem'), params.id])
            redirect(action: "list")
        }
    }
}
