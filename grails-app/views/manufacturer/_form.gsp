<%@ page import="com.angrygiant.funtastik.pos.domain.Manufacturer" %>



<div class="fieldcontain ${hasErrors(bean: manufacturerInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="manufacturer.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" required="" value="${manufacturerInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: manufacturerInstance, field: 'phoneNumber', 'error')} ">
    <label for="phoneNumber">
        <g:message code="manufacturer.phoneNumber.label" default="Phone Number"/>

    </label>
    <g:textField name="phoneNumber" value="${manufacturerInstance?.phoneNumber}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: manufacturerInstance, field: 'webSite', 'error')} ">
    <label for="webSite">
        <g:message code="manufacturer.webSite.label" default="Web Site"/>

    </label>
    <g:textField name="webSite" value="${manufacturerInstance?.webSite}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: manufacturerInstance, field: 'preferredVendor', 'error')} ">
    <label for="preferredVendor">
        <g:message code="manufacturer.preferredVendor.label" default="Preferred Vendor"/>

    </label>
    <g:checkBox name="preferredVendor" value="${manufacturerInstance?.preferredVendor}"/>
</div>

