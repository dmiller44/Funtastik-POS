<%@ page import="com.angrygiant.funtastik.pos.domain.Color" %>



<div class="fieldcontain ${hasErrors(bean: colorInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="color.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" required="" value="${colorInstance?.name}"/>
</div>

