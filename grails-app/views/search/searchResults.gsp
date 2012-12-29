<!doctype html>
<html>
<head>
    <meta name="layout" content="funtastik-bootstap"/>
    <title>Funtastik | POS System</title>

</head>

<body>
<div class="span3">
    ${render(template: templateName)}
</div>

<div class="span9">
    <table class="table table-striped table-bordered table-condensed">
        <thead>
        <tr>
            <th>SKU Code</th>
            <th>Name</th>
            <th>Description</th>
            <th>Retail Price</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${results}" status="i" var="result">
            <tr>
                <td>
                    <sec:ifAllGranted roles="ROLE_ADMIN">
                        <a href="${createLink(controller: 'inventoryItem', action: 'edit', id: result.id)}">${result.skuCode}</a>
                    </sec:ifAllGranted>
                    <sec:ifNotGranted roles="ROLE_ADMIN">
                        ${result.skuCode}
                    </sec:ifNotGranted>
                </td>
                <td>${result.name}</td>
                <td>${result.description}</td>
                <td>${formatNumber(number: result?.retailPrice, type: 'currency')}</td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>

<script type="text/javascript">
    $("li#itemList").attr("class", "active");
</script>
</body>
</html>