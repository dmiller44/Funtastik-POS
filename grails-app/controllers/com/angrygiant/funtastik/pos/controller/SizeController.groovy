package com.angrygiant.funtastik.pos.controller

import com.angrygiant.funtastik.pos.domain.ItemType
import org.springframework.dao.DataIntegrityViolationException
import com.angrygiant.funtastik.pos.domain.Size
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class SizeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "GET"]

    def sizesService

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 25, 100)
        Map hasSizes = [:]

        def sizes = Size.list(params)

        for (Size s : sizes) {
            hasSizes.put(s.id, sizesService.hasSizesUsed(s))
        }

        [sizeInstanceList: sizes, sizeInstanceTotal: Size.count(), hasSizes: hasSizes]
    }

    def listDependents() {
        if (!params.id) {
            redirect(action: "list", params: params)
        }
        ItemType itemType = ItemType.get(params.id)

        params.max = Math.min(params.max ? params.int('max') : 25, 100)
        def model = [sizeInstanceList: Size.findAllByItemType(itemType, params), sizeInstanceTotal: Size.findAllByItemType(itemType, params).size()]

        render(view: 'list', model: model)
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

        flash.message = "Successfully saved size '${sizeInstance?.name}' for Type '${sizeInstance?.itemType?.name}'"
        redirect(action: "create")
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

        flash.message = "Successfully saved Changes"
        redirect(action: "edit", id: sizeInstance.id)
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
            redirect(action: "list")
        }
    }
}
