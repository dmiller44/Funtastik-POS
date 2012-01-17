<%@ page import="com.angrygiant.funtastik.pos.domain.ItemType" %>



<div class="fieldcontain ${hasErrors(bean: itemTypeInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="itemType.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" required="" value="${itemTypeInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemTypeInstance, field: 'retired', 'error')} ">
    <label for="retired">
        <g:message code="itemType.retired.label" default="Retired"/>

    </label>
    <g:checkBox name="retired" value="${itemTypeInstance?.retired}"/>
</div>

