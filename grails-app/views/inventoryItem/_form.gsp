<%@ page import="com.angrygiant.funtastik.pos.domain.InventoryItem" %>



<div class="fieldcontain ${hasErrors(bean: inventoryItemInstance, field: 'skuCode', 'error')} required">
    <label for="skuCode">
        <g:message code="inventoryItem.skuCode.label" default="Sku Code"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="skuCode" required="" value="${inventoryItemInstance?.skuCode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: inventoryItemInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="inventoryItem.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" required="" value="${inventoryItemInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: inventoryItemInstance, field: 'description', 'error')} ">
    <label for="description">
        <g:message code="inventoryItem.description.label" default="Description"/>

    </label>
    <g:textField name="description" value="${inventoryItemInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: inventoryItemInstance, field: 'itemType', 'error')} required">
    <label for="itemType">
        <g:message code="inventoryItem.itemType.label" default="Item Type"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="itemType" name="itemType.id" from="${com.angrygiant.funtastik.pos.domain.ItemType.list()}"
              optionKey="id" required="" value="${inventoryItemInstance?.itemType?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: inventoryItemInstance, field: 'manufacturer', 'error')} required">
    <label for="manufacturer">
        <g:message code="inventoryItem.manufacturer.label" default="Manufacturer"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="manufacturer" name="manufacturer.id" from="${com.angrygiant.funtastik.pos.domain.Manufacturer.list()}"
              optionKey="id" required="" value="${inventoryItemInstance?.manufacturer?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: inventoryItemInstance, field: 'color', 'error')} required">
    <label for="color">
        <g:message code="inventoryItem.color.label" default="Color"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="color" name="color.id" from="${com.angrygiant.funtastik.pos.domain.Color.list()}" optionKey="id"
              required="" value="${inventoryItemInstance?.color?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: inventoryItemInstance, field: 'wholesalePrice', 'error')} required">
    <label for="wholesalePrice">
        <g:message code="inventoryItem.wholesalePrice.label" default="Wholesale Price"/>
        <span class="required-indicator">*</span>
    </label>
    <g:field type="number" name="wholesalePrice" required=""
             value="${fieldValue(bean: inventoryItemInstance, field: 'wholesalePrice')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: inventoryItemInstance, field: 'retailPrice', 'error')} required">
    <label for="retailPrice">
        <g:message code="inventoryItem.retailPrice.label" default="Retail Price"/>
        <span class="required-indicator">*</span>
    </label>
    <g:field type="number" name="retailPrice" required=""
             value="${fieldValue(bean: inventoryItemInstance, field: 'retailPrice')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: inventoryItemInstance, field: 'qoh', 'error')} required">
    <label for="qoh">
        <g:message code="inventoryItem.qoh.label" default="Qoh"/>
        <span class="required-indicator">*</span>
    </label>
    <g:field type="number" name="qoh" required="" value="${fieldValue(bean: inventoryItemInstance, field: 'qoh')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: inventoryItemInstance, field: 'taxable', 'error')} ">
    <label for="taxable">
        <g:message code="inventoryItem.taxable.label" default="Taxable"/>

    </label>
    <g:checkBox name="taxable" value="${inventoryItemInstance?.taxable}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: inventoryItemInstance, field: 'barcoded', 'error')} ">
    <label for="barcoded">
        <g:message code="inventoryItem.barcoded.label" default="Barcoded"/>

    </label>
    <g:checkBox name="barcoded" value="${inventoryItemInstance?.barcoded}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: inventoryItemInstance, field: 'archived', 'error')} ">
    <label for="archived">
        <g:message code="inventoryItem.archived.label" default="Archived"/>

    </label>
    <g:checkBox name="archived" value="${inventoryItemInstance?.archived}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: inventoryItemInstance, field: 'departments', 'error')} ">
    <label for="departments">
        <g:message code="inventoryItem.departments.label" default="Departments"/>

    </label>
    <g:select name="departments" from="${com.angrygiant.funtastik.pos.domain.Department.list()}" multiple="multiple"
              optionKey="id" size="5" value="${inventoryItemInstance?.departments*.id}" class="many-to-many"/>
</div>

