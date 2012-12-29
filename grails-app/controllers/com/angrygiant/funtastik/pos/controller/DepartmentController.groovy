package com.angrygiant.funtastik.pos.controller

import org.springframework.dao.DataIntegrityViolationException
import com.angrygiant.funtastik.pos.domain.Department
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class DepartmentController {

    static allowedMethods = [save: "POST", update: "POST", delete: "GET"]

    def inventoryService

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        def departments = Department.list(params)

        Map hasDepartments = [:]
        for (Department dept : departments) {
            hasDepartments.put(dept.id, inventoryService.haveDepartmentsBeenUsed(dept))
        }

        [departmentInstanceList: departments, departmentInstanceTotal: Department.count(), hasDepartments: hasDepartments]
    }

    def create() {
        [departmentInstance: new Department(params)]
    }

    def save() {
        def departmentInstance = new Department(params)
        if (!departmentInstance.save(flush: true)) {
            render(view: "create", model: [departmentInstance: departmentInstance])
            return
        }

        flash.message = "Successfully added '${departmentInstance.name} to the System"
        redirect(action: "create")
    }

    def edit() {
        def departmentInstance = Department.get(params.id)
        if (!departmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'department.label', default: 'Department'), params.id])
            redirect(action: "list")
            return
        }

        [departmentInstance: departmentInstance]
    }

    def update() {
        def departmentInstance = Department.get(params.id)
        if (!departmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'department.label', default: 'Department'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (departmentInstance.version > version) {
                departmentInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'department.label', default: 'Department')] as Object[],
                        "Another user has updated this Department while you were editing")
                render(view: "edit", model: [departmentInstance: departmentInstance])
                return
            }
        }

        departmentInstance.properties = params

        if (!departmentInstance.save(flush: true)) {
            render(view: "edit", model: [departmentInstance: departmentInstance])
            return
        }

        flash.message = "Changes saved successfully"
        redirect(action: "edit", id: departmentInstance.id)
    }

    def delete() {
        def departmentInstance = Department.get(params.id)
        if (!departmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'department.label', default: 'Department'), params.id])
            redirect(action: "list")
            return
        }

        try {
            departmentInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'department.label', default: 'Department'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'department.label', default: 'Department'), params.id])
            redirect(action: "list")
        }
    }
}
