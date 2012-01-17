<%@ page import="com.angrygiant.funtastik.pos.domain.Manufacturer" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'manufacturer.label', default: 'Manufacturer')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-manufacturer" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                   default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-manufacturer" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="name" title="${message(code: 'manufacturer.name.label', default: 'Name')}"/>

            <g:sortableColumn property="phoneNumber"
                              title="${message(code: 'manufacturer.phoneNumber.label', default: 'Phone Number')}"/>

            <g:sortableColumn property="webSite"
                              title="${message(code: 'manufacturer.webSite.label', default: 'Web Site')}"/>

            <g:sortableColumn property="preferredVendor"
                              title="${message(code: 'manufacturer.preferredVendor.label', default: 'Preferred Vendor')}"/>

        </tr>
        </thead>
        <tbody>
        <g:each in="${manufacturerInstanceList}" status="i" var="manufacturerInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${manufacturerInstance.id}">${fieldValue(bean: manufacturerInstance, field: "name")}</g:link></td>

                <td>${fieldValue(bean: manufacturerInstance, field: "phoneNumber")}</td>

                <td>${fieldValue(bean: manufacturerInstance, field: "webSite")}</td>

                <td><g:formatBoolean boolean="${manufacturerInstance.preferredVendor}"/></td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${manufacturerInstanceTotal}"/>
    </div>
</div>
</body>
</html>
