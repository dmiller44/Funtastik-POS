<table class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th></th>
        <th>Name</th>
        <th>Phone Number</th>
        <th>Web Site</th>
        <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${manufacturerInstanceList}" status="i" var="manufacturerInstance">
        <tr>
            <td><g:if test="${manufacturerInstance?.preferredVendor}"><i class="icon-star"></i></g:if></td>
            <td><g:link action="edit"
                        id="${manufacturerInstance.id}">${fieldValue(bean: manufacturerInstance, field: "name")}</g:link></td>
            <td>
                ${manufacturerInstance?.phoneNumber ?: 'N/A'}
            </td>
            <td>
                ${manufacturerInstance?.webSite ?: 'N/A'}
            </td>
            <td>
                <g:if test="${!hasManufacturers.get(manufacturerInstance.id)}">
                    <a href="${createLink(action: 'delete', id: manufacturerInstance?.id)}"
                       onclick="return confirm('Do you really wish to delete ${manufacturerInstance?.name}?');">
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
    <bootstrap:paginate total="${manufacturerInstanceTotal}"/>
</div>