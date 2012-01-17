<%@ page import="com.angrygiant.funtastik.pos.domain.ItemType" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'itemType.label', default: 'ItemType')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-itemType" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                               default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-itemType" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="name" title="${message(code: 'itemType.name.label', default: 'Name')}"/>

            <g:sortableColumn property="retired"
                              title="${message(code: 'itemType.retired.label', default: 'Retired')}"/>

        </tr>
        </thead>
        <tbody>
        <g:each in="${itemTypeInstanceList}" status="i" var="itemTypeInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${itemTypeInstance.id}">${fieldValue(bean: itemTypeInstance, field: "name")}</g:link></td>

                <td><g:formatBoolean boolean="${itemTypeInstance.retired}"/></td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${itemTypeInstanceTotal}"/>
    </div>
</div>
</body>
</html>
