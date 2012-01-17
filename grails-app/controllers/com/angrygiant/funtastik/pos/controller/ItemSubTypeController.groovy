package com.angrygiant.funtastik.pos.controller

import org.springframework.dao.DataIntegrityViolationException
import com.angrygiant.funtastik.pos.domain.ItemSubType

class ItemSubTypeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [itemSubTypeInstanceList: ItemSubType.list(params), itemSubTypeInstanceTotal: ItemSubType.count()]
    }

    def create() {
        [itemSubTypeInstance: new ItemSubType(params)]
    }

    def save() {
        def itemSubTypeInstance = new ItemSubType(params)
        if (!itemSubTypeInstance.save(flush: true)) {
            render(view: "create", model: [itemSubTypeInstance: itemSubTypeInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'itemSubType.label', default: 'ItemSubType'), itemSubTypeInstance.id])
        redirect(action: "show", id: itemSubTypeInstance.id)
    }

    def show() {
        def itemSubTypeInstance = ItemSubType.get(params.id)
        if (!itemSubTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemSubType.label', default: 'ItemSubType'), params.id])
            redirect(action: "list")
            return
        }

        [itemSubTypeInstance: itemSubTypeInstance]
    }

    def edit() {
        def itemSubTypeInstance = ItemSubType.get(params.id)
        if (!itemSubTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemSubType.label', default: 'ItemSubType'), params.id])
            redirect(action: "list")
            return
        }

        [itemSubTypeInstance: itemSubTypeInstance]
    }

    def update() {
        def itemSubTypeInstance = ItemSubType.get(params.id)
        if (!itemSubTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemSubType.label', default: 'ItemSubType'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (itemSubTypeInstance.version > version) {
                itemSubTypeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'itemSubType.label', default: 'ItemSubType')] as Object[],
                        "Another user has updated this ItemSubType while you were editing")
                render(view: "edit", model: [itemSubTypeInstance: itemSubTypeInstance])
                return
            }
        }

        itemSubTypeInstance.properties = params

        if (!itemSubTypeInstance.save(flush: true)) {
            render(view: "edit", model: [itemSubTypeInstance: itemSubTypeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'itemSubType.label', default: 'ItemSubType'), itemSubTypeInstance.id])
        redirect(action: "show", id: itemSubTypeInstance.id)
    }

    def delete() {
        def itemSubTypeInstance = ItemSubType.get(params.id)
        if (!itemSubTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemSubType.label', default: 'ItemSubType'), params.id])
            redirect(action: "list")
            return
        }

        try {
            itemSubTypeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'itemSubType.label', default: 'ItemSubType'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'itemSubType.label', default: 'ItemSubType'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
