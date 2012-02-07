<table class="table table-striped table-bordered table-condensed">
  <thead>
    <tr>
      <th>Name</th>
    </tr>
  </thead>
  <tbody>
    <g:each in="${colorInstanceList}" status="i" var="colorInstance">
        <tr>
            <td><g:link action="show"
                        id="${colorInstance.id}">${fieldValue(bean: colorInstance, field: "name")}</g:link></td>
        </tr>
    </g:each>
  </tbody>
</table>

<div class="pagination pagination-centered">
    <bootstrap:paginate total="${colorInstanceTotal}"/>
</div>