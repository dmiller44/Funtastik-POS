<table class="table table-striped table-bordered table-condensed">
  <thead>
    <tr>
      <th>Name</th>
    </tr>
  </thead>
  <tbody>
    <g:each in="${itemTypeInstanceList}" status="i" var="itemTypeInstance">
        <tr>
            <td><g:link action="show"
                        id="${itemTypeInstance.id}">${fieldValue(bean: itemTypeInstance, field: "name")}</g:link></td>
        </tr>
    </g:each>
  </tbody>
</table>

<div class="pagination pagination-centered">
    <bootstrap:paginate total="${itemTypeInstanceTotal}"/>
</div>