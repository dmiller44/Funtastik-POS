<table class="ajax">
    <thead>
    <tr>

        <g:sortableColumn property="name" title="Name"/>

    </tr>
    </thead>
    <tbody>
    <g:each in="${colorInstanceList}" status="i" var="colorInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td><g:link action="show"
                        id="${colorInstance.id}">${fieldValue(bean: colorInstance, field: "name")}</g:link></td>

        </tr>
    </g:each>
    </tbody>
</table>

<div class="pagination">
    <g:paginate total="${colorInstanceTotal}"/>
</div>