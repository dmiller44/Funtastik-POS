package com.angrygiant.funtastik.pos.controller

import grails.test.mixin.*
import com.angrygiant.funtastik.pos.controller.ItemSubTypeController
import com.angrygiant.funtastik.pos.domain.ItemSubType

@TestFor(ItemSubTypeController)
@Mock(ItemSubType)
class ItemSubTypeControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/itemSubType/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.itemSubTypeInstanceList.size() == 0
        assert model.itemSubTypeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.itemSubTypeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.itemSubTypeInstance != null
        assert view == '/itemSubType/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/itemSubType/show/1'
        assert controller.flash.message != null
        assert ItemSubType.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/itemSubType/list'


        populateValidParams(params)
        def itemSubType = new ItemSubType(params)

        assert itemSubType.save() != null

        params.id = itemSubType.id

        def model = controller.show()

        assert model.itemSubTypeInstance == itemSubType
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/itemSubType/list'


        populateValidParams(params)
        def itemSubType = new ItemSubType(params)

        assert itemSubType.save() != null

        params.id = itemSubType.id

        def model = controller.edit()

        assert model.itemSubTypeInstance == itemSubType
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/itemSubType/list'

        response.reset()


        populateValidParams(params)
        def itemSubType = new ItemSubType(params)

        assert itemSubType.save() != null

        // test invalid parameters in update
        params.id = itemSubType.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/itemSubType/edit"
        assert model.itemSubTypeInstance != null

        itemSubType.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/itemSubType/show/$itemSubType.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        itemSubType.clearErrors()

        populateValidParams(params)
        params.id = itemSubType.id
        params.version = -1
        controller.update()

        assert view == "/itemSubType/edit"
        assert model.itemSubTypeInstance != null
        assert model.itemSubTypeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/itemSubType/list'

        response.reset()

        populateValidParams(params)
        def itemSubType = new ItemSubType(params)

        assert itemSubType.save() != null
        assert ItemSubType.count() == 1

        params.id = itemSubType.id

        controller.delete()

        assert ItemSubType.count() == 0
        assert ItemSubType.get(itemSubType.id) == null
        assert response.redirectedUrl == '/itemSubType/list'
    }
}
