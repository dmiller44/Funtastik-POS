<table class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>Name</th>
        <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${itemTypeInstanceList}" status="i" var="itemTypeInstance">
        <tr>
            <td><g:link action="edit"
                        id="${itemTypeInstance.id}">${fieldValue(bean: itemTypeInstance, field: "name")}</g:link></td>
            <td>
                <g:if test="${!hasItemTypes.get(itemTypeInstance.id)}">
                    <a href="${createLink(action: 'delete', id: itemTypeInstance?.id)}"
                       onclick="return confirm('Do you really wish to delete ${itemTypeInstance?.name}?');">
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
    <bootstrap:paginate total="${itemTypeInstanceTotal}"/>
</div>