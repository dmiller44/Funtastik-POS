<table class="ajax">
    <thead>
    <tr>

        <g:sortableColumn property="name" title="Name"/>
        <g:sortableColumn property="retired" title="Active?"/>

    </tr>
    </thead>
    <tbody>
    <g:each in="${itemTypeInstanceList}" status="i" var="itemTypeInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td><g:link action="show"
                        id="${itemTypeInstance.id}">${fieldValue(bean: itemTypeInstance, field: "name")}</g:link></td>
            <td>
                <g:if test="${itemTypeInstance.retired == true}">
                    <img src="${resource(dir: 'images/icons', file: 'cancel.png', plugin: 'famfamfam')}" alt="True"/>
                </g:if>
                <g:else>
                    <img src="${resource(dir: 'images/icons', file: 'accept.png', plugin: 'famfamfam')}" alt="True"/>
                </g:else>
            </td>

        </tr>
    </g:each>
    </tbody>
</table>

<div class="pagination">
    <g:paginate total="${itemTypeInstanceTotal}"/>
</div>