package com.angrygiant.funtastik.pos.controller

import org.springframework.dao.DataIntegrityViolationException
import com.angrygiant.funtastik.pos.domain.Size

class SizeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [sizeInstanceList: Size.list(params), sizeInstanceTotal: Size.count()]
    }

    def create() {
        [sizeInstance: new Size(params)]
    }

    def save() {
        def sizeInstance = new Size(params)
        if (!sizeInstance.save(flush: true)) {
            render(view: "create", model: [sizeInstance: sizeInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'size.label', default: 'Size'), sizeInstance.id])
        redirect(action: "show", id: sizeInstance.id)
    }

    def show() {
        def sizeInstance = Size.get(params.id)
        if (!sizeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'size.label', default: 'Size'), params.id])
            redirect(action: "list")
            return
        }

        [sizeInstance: sizeInstance]
    }

    def edit() {
        def sizeInstance = Size.get(params.id)
        if (!sizeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'size.label', default: 'Size'), params.id])
            redirect(action: "list")
            return
        }

        [sizeInstance: sizeInstance]
    }

    def update() {
        def sizeInstance = Size.get(params.id)
        if (!sizeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'size.label', default: 'Size'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (sizeInstance.version > version) {
                sizeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'size.label', default: 'Size')] as Object[],
                        "Another user has updated this Size while you were editing")
                render(view: "edit", model: [sizeInstance: sizeInstance])
                return
            }
        }

        sizeInstance.properties = params

        if (!sizeInstance.save(flush: true)) {
            render(view: "edit", model: [sizeInstance: sizeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'size.label', default: 'Size'), sizeInstance.id])
        redirect(action: "show", id: sizeInstance.id)
    }

    def delete() {
        def sizeInstance = Size.get(params.id)
        if (!sizeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'size.label', default: 'Size'), params.id])
            redirect(action: "list")
            return
        }

        try {
            sizeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'size.label', default: 'Size'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'size.label', default: 'Size'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
