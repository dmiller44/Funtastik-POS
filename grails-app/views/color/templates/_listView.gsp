<div id="list-color" class="content scaffold-list" role="main">
    <h1 style="background-color: #acd1e9">Color List</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>

    <div id="grid">
        <g:render template="templates/list"
                  model="${[colorInstanceList: colorInstanceList, colorInstanceTotal: colorInstanceTotal]}"/>
    </div>
</div>