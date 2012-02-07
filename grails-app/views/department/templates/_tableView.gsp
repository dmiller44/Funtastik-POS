<table class="table table-striped table-bordered table-condensed">
  <thead>
    <tr>
      <th>Name</th>
    </tr>
  </thead>
  <tbody>
    <g:each in="${departmentInstanceList}" status="i" var="departmentInstance">
        <tr>
            <td><g:link action="show"
                        id="${departmentInstance.id}">${fieldValue(bean: departmentInstance, field: "name")}</g:link></td>
        </tr>
    </g:each>
  </tbody>
</table>

<div class="pagination pagination-centered">
    <bootstrap:paginate total="${departmentInstanceTotal}"/>
</div>