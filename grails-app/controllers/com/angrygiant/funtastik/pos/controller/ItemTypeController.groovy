package com.angrygiant.funtastik.pos.controller

import org.springframework.dao.DataIntegrityViolationException
import com.angrygiant.funtastik.pos.domain.ItemType
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class ItemTypeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        def query = {
            if (params.name) {
                ilike('name', '%' + params.name + '%')
            }
            if (params.sort) {
                order(params.sort, params.order)
            }
        }

        def criteria = ItemType.createCriteria()

        params.max = Math.min(params.max ? params.int('max') : 10, 100)

        def itemTypes = criteria.list(query, max: params.max, offset: params.offset)
        def filters = [name: params.name]

        def parameters = [itemTypeInstanceList: itemTypes, itemTypeInstanceTotal: ItemType.count(), filters: filters]

        render(view: 'list', model: parameters)
    }

    def create() {
        [itemTypeInstance: new ItemType(params)]
    }

    def save() {
        def itemTypeInstance = new ItemType(params)
        if (!itemTypeInstance.save(flush: true)) {
            render(view: "create", model: [itemTypeInstance: itemTypeInstance])
            return
        }

        flash.message = "Item Type '${itemTypeInstance.name}' successfully added to the System"
        redirect(action: "edit", id: itemTypeInstance.id)
    }

    def edit() {
        def itemTypeInstance = ItemType.get(params.id)
        if (!itemTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemType.label', default: 'ItemType'), params.id])
            redirect(action: "list")
            return
        }

        [itemTypeInstance: itemTypeInstance]
    }

    def update() {
        def itemTypeInstance = ItemType.get(params.id)
        if (!itemTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemType.label', default: 'ItemType'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (itemTypeInstance.version > version) {
                itemTypeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'itemType.label', default: 'ItemType')] as Object[],
                        "Another user has updated this ItemType while you were editing")
                render(view: "edit", model: [itemTypeInstance: itemTypeInstance])
                return
            }
        }

        itemTypeInstance.properties = params

        if (!itemTypeInstance.save(flush: true)) {
            render(view: "edit", model: [itemTypeInstance: itemTypeInstance])
            return
        }

        flash.message = "Changes saved Successfully"
        redirect(action: "edit", id: itemTypeInstance.id)
    }

    def delete() {
        def itemTypeInstance = ItemType.get(params.id)
        if (!itemTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemType.label', default: 'ItemType'), params.id])
            redirect(action: "list")
            return
        }

        try {
            itemTypeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'itemType.label', default: 'ItemType'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'itemType.label', default: 'ItemType'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
