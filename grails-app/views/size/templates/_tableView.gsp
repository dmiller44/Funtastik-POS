<table class="table table-striped table-bordered table-condensed">
  <thead>
    <tr>
      	<th>Size</th>
		<th>Parent Item Type</th>
    </tr>
  </thead>
  <tbody>
    <g:each in="${sizeInstanceList}" status="i" var="sizeInstance">
        <tr>
            <td><g:link action="show"
                        id="${sizeInstance.id}">${fieldValue(bean: sizeInstance, field: "name")}</g:link></td>
			<td>
				${sizeInstance?.itemType?.name ?: 'N/A'}
			</td>
        </tr>
    </g:each>
  </tbody>
</table>

<div class="pagination pagination-centered">
    <bootstrap:paginate total="${sizeInstanceTotal}"/>
</div>