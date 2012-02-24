<table class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th></th>
        <th></th>
        <th>SKU Code</th>
        <th>Name</th>
        <th>Type</th>
        <th>Color</th>
        <th>Wholesale Price</th>
        <th>Retail Price</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${inventoryItemInstanceList}" status="i" var="inventoryItemInstance">
        <tr>
            <td><g:if test="${inventoryItemInstance?.barcoded}"><i class="icon-barcode"></i></g:if></td>
            <td><g:if test="${inventoryItemInstance?.taxable}"><i class="icon-star"></i></g:if></td>
            <td><g:link action="edit"
                        id="${inventoryItemInstance.id}">${fieldValue(bean: inventoryItemInstance, field: "skuCode")}</g:link></td>
            <td>
                ${inventoryItemInstance?.name ?: 'N/A'}
            </td>
            <td>
                ${inventoryItemInstance?.itemType?.name ?: 'N/A'}
            </td>
            <td>
                ${inventoryItemInstance?.color?.name ?: 'N/A'}
            </td>
            <td>
                ${inventoryItemInstance?.wholesalePrice ?: 'N/A'}
            </td>
            <td>
                ${inventoryItemInstance?.retailPrice ?: 'N/A'}
            </td>
        </tr>
    </g:each>
    </tbody>
</table>
<span style="float: right;"><a href="${createLink(action: 'create')}" class="btn">Add...</a></span>

<div class="pagination pagination-centered">
    <bootstrap:paginate total="${inventoryItemInstanceTotal}"/>
</div>