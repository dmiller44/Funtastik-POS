<table class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${itemTypeInstanceList}" status="i" var="itemTypeInstance">
        <tr>
            <td><g:link action="edit"
                        id="${itemTypeInstance.id}">${fieldValue(bean: itemTypeInstance, field: "name")}</g:link></td>
        </tr>
    </g:each>
    </tbody>
</table>
<span style="float: right;"><a href="${createLink(action: 'create')}" class="btn">Add...</a></span>

<div class="pagination pagination-centered">
    <bootstrap:paginate total="${itemTypeInstanceTotal}"/>
</div>