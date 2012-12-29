<table class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>Name</th>
        <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${departmentInstanceList}" status="i" var="departmentInstance">
        <tr>
            <td><g:link action="edit"
                        id="${departmentInstance.id}">${fieldValue(bean: departmentInstance, field: "name")}</g:link></td>
            <td>
                <g:if test="${!hasDepartments.get(departmentInstance.id)}">
                    <a href="${createLink(action: 'delete', id: departmentInstance?.id)}"
                       onclick="return confirm('Do you really wish to delete ${departmentInstance?.name}?');">
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
    <bootstrap:paginate total="${departmentInstanceTotal}"/>
</div>