package com.angrygiant.funtastik.pos.controller

import org.springframework.dao.DataIntegrityViolationException
import com.angrygiant.funtastik.pos.domain.Color
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class ColorController {

    static allowedMethods = [save: "POST", update: "POST", delete: "GET"]

    def inventoryService

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

        def criteria = Color.createCriteria()

        params.max = Math.min(params.max ? params.int('max') : 25, 100)

        def colors = criteria.list(query, max: params.max, offset: params.offset)
        def filters = [name: params.name]

        Map isUsed = [:]

        for (Color c : colors) {
            isUsed.put(c.id, inventoryService.haveColorsBeenUsed(c))
        }

        def parameters = [colorInstanceList: colors, colorInstanceTotal: Color.count(), filters: filters, hasColors: isUsed]

        render(view: 'list', model: parameters)
    }

    def create() {
        [colorInstance: new Color(params)]
    }

    def save() {
        def colorInstance = new Color(params)
        if (!colorInstance.save(flush: true)) {
            render(view: "create", model: [colorInstance: colorInstance])
            return
        }

        flash.message = "Successfully added '${colorInstance.name}' to the System"
        redirect(action: "create")
    }

    def edit() {
        def colorInstance = Color.get(params.id)
        if (!colorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'color.label', default: 'Color'), params.id])
            redirect(action: "list")
            return
        }

        [colorInstance: colorInstance]
    }

    def update() {
        def colorInstance = Color.get(params.id)
        if (!colorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'color.label', default: 'Color'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (colorInstance.version > version) {
                colorInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'color.label', default: 'Color')] as Object[],
                        "Another user has updated this Color while you were editing")
                render(view: "edit", model: [colorInstance: colorInstance])
                return
            }
        }

        colorInstance.properties = params

        if (!colorInstance.save(flush: true)) {
            render(view: "edit", model: [colorInstance: colorInstance])
            return
        }

        flash.message = "Color changes were successfully saved!"
        redirect(action: "edit", id: colorInstance.id)
    }

    def delete() {
        def colorInstance = Color.get(params.id)
        if (!colorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'color.label', default: 'Color'), params.id])
            redirect(action: "list")
            return
        }

        try {
            colorInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'color.label', default: 'Color'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'color.label', default: 'Color'), params.id])
            redirect(action: "list")
        }
    }
}
