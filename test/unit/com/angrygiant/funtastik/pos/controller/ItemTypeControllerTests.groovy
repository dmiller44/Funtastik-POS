package com.angrygiant.funtastik.pos.controller



import org.junit.*
import grails.test.mixin.*
import com.angrygiant.funtastik.pos.domain.ItemType

@TestFor(ItemTypeController)
@Mock(ItemType)
class ItemTypeControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/itemType/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.itemTypeInstanceList.size() == 0
        assert model.itemTypeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.itemTypeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.itemTypeInstance != null
        assert view == '/itemType/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/itemType/show/1'
        assert controller.flash.message != null
        assert ItemType.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/itemType/list'


        populateValidParams(params)
        def itemType = new ItemType(params)

        assert itemType.save() != null

        params.id = itemType.id

        def model = controller.show()

        assert model.itemTypeInstance == itemType
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/itemType/list'


        populateValidParams(params)
        def itemType = new ItemType(params)

        assert itemType.save() != null

        params.id = itemType.id

        def model = controller.edit()

        assert model.itemTypeInstance == itemType
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/itemType/list'

        response.reset()


        populateValidParams(params)
        def itemType = new ItemType(params)

        assert itemType.save() != null

        // test invalid parameters in update
        params.id = itemType.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/itemType/edit"
        assert model.itemTypeInstance != null

        itemType.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/itemType/show/$itemType.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        itemType.clearErrors()

        populateValidParams(params)
        params.id = itemType.id
        params.version = -1
        controller.update()

        assert view == "/itemType/edit"
        assert model.itemTypeInstance != null
        assert model.itemTypeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/itemType/list'

        response.reset()

        populateValidParams(params)
        def itemType = new ItemType(params)

        assert itemType.save() != null
        assert ItemType.count() == 1

        params.id = itemType.id

        controller.delete()

        assert ItemType.count() == 0
        assert ItemType.get(itemType.id) == null
        assert response.redirectedUrl == '/itemType/list'
    }
}
