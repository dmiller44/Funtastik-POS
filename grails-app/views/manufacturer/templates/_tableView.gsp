<table class="table table-striped table-bordered table-condensed">
  <thead>
    <tr>
      	<th></th>
		<th>Name</th>
		<th>Phone Number</th>
		<th>Web Site</th>
    </tr>
  </thead>
  <tbody>
    <g:each in="${manufacturerInstanceList}" status="i" var="manufacturerInstance">
        <tr>
			<td><g:if test="{manufacturerInstance?.preferredVendor}"><i class="icon-star"></i></g:if></td>
            <td><g:link action="edit"
                        id="${manufacturerInstance.id}">${fieldValue(bean: manufacturerInstance, field: "name")}</g:link></td>
			<td>
				${manufacturerInstance?.phoneNumber ?: 'N/A'}
			</td>
			<td>
				${manufacturerInstance?.webSite ?: 'N/A'}
			</td>
        </tr>
    </g:each>
  </tbody>
</table>
<span style="float: right;"><a href="#" class="btn">Add...</a></span>

<div class="pagination pagination-centered">
    <bootstrap:paginate total="${manufacturerInstanceTotal}"/>
</div>