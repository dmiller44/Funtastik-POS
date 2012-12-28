package com.angrygiant.funtastik.pos.controller

import com.angrygiant.funtastik.pos.domain.InventoryItemRecord
import com.angrygiant.funtastik.pos.domain.Size
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

        def inventoryItemRecords = InventoryItemRecord.findAllByInventoryItem(inventoryItemInstance)

        [inventoryItemInstance: inventoryItemInstance, inventoryItemRecords: inventoryItemRecords]
    }

    def addSizeToItem() {
        def inventoryItemInstance = InventoryItem.get(params.id)

        if (!inventoryItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'inventoryItem.label', default: 'InventoryItem'), params.id])
            redirect(action: "list")
            return
        }

        def itemSizes = Size.findAllByItemType(inventoryItemInstance.itemType)

        [inventoryItemInstance: inventoryItemInstance, sizes: itemSizes]
    }

    def saveSizeToItem() {
        def inventoryItemInstance = InventoryItem.get(params.inventoryItem)

        def size = Size.get(params."size.id")

        InventoryItemRecord record = new InventoryItemRecord()
        record.setInventoryItem(inventoryItemInstance)
        record.setQoh(Integer.parseInt(params.qoh))
        record.setPriceQuantifier(Double.parseDouble(params.priceQuantifier))
        record.setSize(size)

        if (!record.save(flush: true)) {
            flash.message = "ERROR: Could not save new size!!!"
            redirect(action: 'edit', id: inventoryItemInstance.id)
            return
        }

        flash.message = "Siz added successfully"
        redirect(action: "edit", id: inventoryItemInstance.id)
    }

    def deleteSizeOnItem() {
        def inventoryRecordInstance = InventoryItemRecord.get(params.id)
        def inventoryId = inventoryRecordInstance.inventoryItem.id

        if (!inventoryRecordInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'inventoryRecordInstance.label', default: 'InventoryItem'), params.id])
            redirect(action: "edit", id: inventoryId)
            return
        }

        inventoryRecordInstance.delete(flush: true)

        redirect(action: "edit", id: inventoryId)
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

        flash.message = "Changes saved successfully"
        redirect(action: "edit", id: inventoryItemInstance.id)
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
