<%@ page import="com.angrygiant.funtastik.pos.domain.InventoryItem" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'inventoryItem.label', default: 'InventoryItem')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-inventoryItem" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                    default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-inventoryItem" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list inventoryItem">

        <g:if test="${inventoryItemInstance?.skuCode}">
            <li class="fieldcontain">
                <span id="skuCode-label" class="property-label"><g:message code="inventoryItem.skuCode.label"
                                                                           default="Sku Code"/></span>

                <span class="property-value" aria-labelledby="skuCode-label"><g:fieldValue
                        bean="${inventoryItemInstance}" field="skuCode"/></span>

            </li>
        </g:if>

        <g:if test="${inventoryItemInstance?.name}">
            <li class="fieldcontain">
                <span id="name-label" class="property-label"><g:message code="inventoryItem.name.label"
                                                                        default="Name"/></span>

                <span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${inventoryItemInstance}"
                                                                                        field="name"/></span>

            </li>
        </g:if>

        <g:if test="${inventoryItemInstance?.description}">
            <li class="fieldcontain">
                <span id="description-label" class="property-label"><g:message code="inventoryItem.description.label"
                                                                               default="Description"/></span>

                <span class="property-value" aria-labelledby="description-label"><g:fieldValue
                        bean="${inventoryItemInstance}" field="description"/></span>

            </li>
        </g:if>

        <g:if test="${inventoryItemInstance?.itemType}">
            <li class="fieldcontain">
                <span id="itemType-label" class="property-label"><g:message code="inventoryItem.itemType.label"
                                                                            default="Item Type"/></span>

                <span class="property-value" aria-labelledby="itemType-label"><g:link controller="itemType"
                                                                                      action="show"
                                                                                      id="${inventoryItemInstance?.itemType?.id}">${inventoryItemInstance?.itemType?.encodeAsHTML()}</g:link></span>

            </li>
        </g:if>

        <g:if test="${inventoryItemInstance?.subType}">
            <li class="fieldcontain">
                <span id="subType-label" class="property-label"><g:message code="inventoryItem.subType.label"
                                                                           default="Sub Type"/></span>

                <span class="property-value" aria-labelledby="subType-label"><g:link controller="itemSubType"
                                                                                     action="show"
                                                                                     id="${inventoryItemInstance?.subType?.id}">${inventoryItemInstance?.subType?.encodeAsHTML()}</g:link></span>

            </li>
        </g:if>

        <g:if test="${inventoryItemInstance?.manufacturer}">
            <li class="fieldcontain">
                <span id="manufacturer-label" class="property-label"><g:message code="inventoryItem.manufacturer.label"
                                                                                default="Manufacturer"/></span>

                <span class="property-value" aria-labelledby="manufacturer-label"><g:link controller="manufacturer"
                                                                                          action="show"
                                                                                          id="${inventoryItemInstance?.manufacturer?.id}">${inventoryItemInstance?.manufacturer?.encodeAsHTML()}</g:link></span>

            </li>
        </g:if>

        <g:if test="${inventoryItemInstance?.color}">
            <li class="fieldcontain">
                <span id="color-label" class="property-label"><g:message code="inventoryItem.color.label"
                                                                         default="Color"/></span>

                <span class="property-value" aria-labelledby="color-label"><g:link controller="color" action="show"
                                                                                   id="${inventoryItemInstance?.color?.id}">${inventoryItemInstance?.color?.encodeAsHTML()}</g:link></span>

            </li>
        </g:if>

        <g:if test="${inventoryItemInstance?.wholesalePrice}">
            <li class="fieldcontain">
                <span id="wholesalePrice-label" class="property-label"><g:message
                        code="inventoryItem.wholesalePrice.label" default="Wholesale Price"/></span>

                <span class="property-value" aria-labelledby="wholesalePrice-label"><g:fieldValue
                        bean="${inventoryItemInstance}" field="wholesalePrice"/></span>

            </li>
        </g:if>

        <g:if test="${inventoryItemInstance?.retailPrice}">
            <li class="fieldcontain">
                <span id="retailPrice-label" class="property-label"><g:message code="inventoryItem.retailPrice.label"
                                                                               default="Retail Price"/></span>

                <span class="property-value" aria-labelledby="retailPrice-label"><g:fieldValue
                        bean="${inventoryItemInstance}" field="retailPrice"/></span>

            </li>
        </g:if>

    %{--<g:if test="${inventoryItemInstance?.qoh}">--}%
    %{--<li class="fieldcontain">--}%
    %{--<span id="qoh-label" class="property-label"><g:message code="inventoryItem.qoh.label"--}%
    %{--default="Qoh"/></span>--}%

    %{--<span class="property-value" aria-labelledby="qoh-label"><g:fieldValue bean="${inventoryItemInstance}"--}%
    %{--field="qoh"/></span>--}%

    %{--</li>--}%
    %{--</g:if>--}%

        <g:if test="${inventoryItemInstance?.taxable}">
            <li class="fieldcontain">
                <span id="taxable-label" class="property-label"><g:message code="inventoryItem.taxable.label"
                                                                           default="Taxable"/></span>

                <span class="property-value" aria-labelledby="taxable-label"><g:formatBoolean
                        boolean="${inventoryItemInstance?.taxable}"/></span>

            </li>
        </g:if>

        <g:if test="${inventoryItemInstance?.barcoded}">
            <li class="fieldcontain">
                <span id="barcoded-label" class="property-label"><g:message code="inventoryItem.barcoded.label"
                                                                            default="Barcoded"/></span>

                <span class="property-value" aria-labelledby="barcoded-label"><g:formatBoolean
                        boolean="${inventoryItemInstance?.barcoded}"/></span>

            </li>
        </g:if>

        <g:if test="${inventoryItemInstance?.archived}">
            <li class="fieldcontain">
                <span id="archived-label" class="property-label"><g:message code="inventoryItem.archived.label"
                                                                            default="Archived"/></span>

                <span class="property-value" aria-labelledby="archived-label"><g:formatBoolean
                        boolean="${inventoryItemInstance?.archived}"/></span>

            </li>
        </g:if>

        <g:if test="${inventoryItemInstance?.departments}">
            <li class="fieldcontain">
                <span id="departments-label" class="property-label"><g:message code="inventoryItem.departments.label"
                                                                               default="Departments"/></span>

                <g:each in="${inventoryItemInstance.departments}" var="d">
                    <span class="property-value" aria-labelledby="departments-label"><g:link controller="department"
                                                                                             action="show"
                                                                                             id="${d.id}">${d?.encodeAsHTML()}</g:link></span>
                </g:each>

            </li>
        </g:if>

    </ol>
    <g:form>
        <fieldset class="buttons">
            <g:hiddenField name="id" value="${inventoryItemInstance?.id}"/>
            <g:link class="edit" action="edit" id="${inventoryItemInstance?.id}"><g:message
                    code="default.button.edit.label" default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
