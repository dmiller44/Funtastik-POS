<%@ page import="com.angrygiant.funtastik.pos.domain.Department" %>



<div class="fieldcontain ${hasErrors(bean: departmentInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="department.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" required="" value="${departmentInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: departmentInstance, field: 'retired', 'error')} ">
    <label for="retired">
        <g:message code="department.retired.label" default="Retired"/>

    </label>
    <g:checkBox name="retired" value="${departmentInstance?.retired}"/>
</div>

