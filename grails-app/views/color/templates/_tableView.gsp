<table class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>Name</th>
        <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${colorInstanceList}" status="i" var="colorInstance">
        <tr>
            <td><g:link action="edit"
                        id="${colorInstance.id}">${fieldValue(bean: colorInstance, field: "name")}</g:link></td>
            <td>
                <g:if test="${!hasColors.get(colorInstance.id)}">
                    <a href="${createLink(action: 'delete', id: colorInstance?.id)}"
                       onclick="return confirm('Do you really wish to delete ${colorInstance?.name}?');">
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
    <bootstrap:paginate total="${colorInstanceTotal}"/>
</div>