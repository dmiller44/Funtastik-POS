<%@ page import="com.angrygiant.funtastik.pos.domain.Size" %>



<div class="fieldcontain ${hasErrors(bean: sizeInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="size.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" required="" value="${sizeInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: sizeInstance, field: 'itemType', 'error')} required">
    <label for="itemType">
        <g:message code="size.itemType.label" default="Item Type"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="itemType" name="itemType.id" from="${com.angrygiant.funtastik.pos.domain.ItemType.list()}"
              optionKey="id" required="" value="${sizeInstance?.itemType?.id}" class="many-to-one"/>
</div>

