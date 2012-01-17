<%@ page import="com.angrygiant.funtastik.pos.domain.ItemSubType" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'itemSubType.label', default: 'ItemSubType')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-itemSubType" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                  default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-itemSubType" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="name" title="${message(code: 'itemSubType.name.label', default: 'Name')}"/>

            <g:sortableColumn property="retired"
                              title="${message(code: 'itemSubType.retired.label', default: 'Retired')}"/>

            <th><g:message code="itemSubType.itemType.label" default="Item Type"/></th>

        </tr>
        </thead>
        <tbody>
        <g:each in="${itemSubTypeInstanceList}" status="i" var="itemSubTypeInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${itemSubTypeInstance.id}">${fieldValue(bean: itemSubTypeInstance, field: "name")}</g:link></td>

                <td><g:formatBoolean boolean="${itemSubTypeInstance.retired}"/></td>

                <td>${fieldValue(bean: itemSubTypeInstance, field: "itemType")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${itemSubTypeInstanceTotal}"/>
    </div>
</div>
</body>
</html>
