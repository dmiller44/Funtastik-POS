<%@ page import="com.angrygiant.funtastik.pos.domain.InventoryItem" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'inventoryItem.label', default: 'InventoryItem')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-inventoryItem" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                    default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-inventoryItem" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="skuCode"
                              title="${message(code: 'inventoryItem.skuCode.label', default: 'Sku Code')}"/>

            <g:sortableColumn property="name" title="${message(code: 'inventoryItem.name.label', default: 'Name')}"/>

            <g:sortableColumn property="description"
                              title="${message(code: 'inventoryItem.description.label', default: 'Description')}"/>

            <th><g:message code="inventoryItem.itemType.label" default="Item Type"/></th>

            <th><g:message code="inventoryItem.subType.label" default="Sub Type"/></th>

            <th><g:message code="inventoryItem.manufacturer.label" default="Manufacturer"/></th>

        </tr>
        </thead>
        <tbody>
        <g:each in="${inventoryItemInstanceList}" status="i" var="inventoryItemInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${inventoryItemInstance.id}">${fieldValue(bean: inventoryItemInstance, field: "skuCode")}</g:link></td>

                <td>${fieldValue(bean: inventoryItemInstance, field: "name")}</td>

                <td>${fieldValue(bean: inventoryItemInstance, field: "description")}</td>

                <td>${fieldValue(bean: inventoryItemInstance, field: "itemType")}</td>

                <td>${fieldValue(bean: inventoryItemInstance, field: "subType")}</td>

                <td>${fieldValue(bean: inventoryItemInstance, field: "manufacturer")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${inventoryItemInstanceTotal}"/>
    </div>
</div>
</body>
</html>
