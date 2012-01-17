<%@ page import="com.angrygiant.funtastik.pos.domain.ItemSubType" %>



<div class="fieldcontain ${hasErrors(bean: itemSubTypeInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="itemSubType.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" required="" value="${itemSubTypeInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemSubTypeInstance, field: 'retired', 'error')} ">
    <label for="retired">
        <g:message code="itemSubType.retired.label" default="Retired"/>

    </label>
    <g:checkBox name="retired" value="${itemSubTypeInstance?.retired}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemSubTypeInstance, field: 'itemType', 'error')} required">
    <label for="itemType">
        <g:message code="itemSubType.itemType.label" default="Item Type"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="itemType" name="itemType.id" from="${com.angrygiant.funtastik.pos.domain.ItemType.list()}"
              optionKey="id" required="" value="${itemSubTypeInstance?.itemType?.id}" class="many-to-one"/>
</div>

