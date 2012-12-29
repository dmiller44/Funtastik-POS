<table class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>Size</th>
        <th>Parent Item Type</th>
        <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${sizeInstanceList}" status="i" var="sizeInstance">
        <tr>
            <td><g:link action="edit"
                        id="${sizeInstance.id}">${fieldValue(bean: sizeInstance, field: "name")}</g:link></td>
            <td>
                ${sizeInstance?.itemType?.name ?: 'N/A'}
            </td>
            <td>
                <g:if test="${!hasSizes.get(sizeInstance.id)}">
                    <a href="${createLink(action: 'delete', id: sizeInstance?.id)}"
                       onclick="return confirm('Do you really wish to delete ${sizeInstance?.name}?');">
                        <i class="icon-remove"></i>
                    </a>
                </g:if>
            </td>

        </tr>
    </g:each>
    </tbody>
</table>
<span style="float: right;"><a href="${createLink(action: 'create')}" class="btn">Add...</a></span>

<div class="pagination pagination-centered">
    <bootstrap:paginate total="${sizeInstanceTotal}"/>
</div>