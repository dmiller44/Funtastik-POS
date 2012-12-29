<!doctype html>
<html>
<head>
    <meta name="layout" content="funtastik-bootstap"/>
    <title>Funtastik | POS System</title>

</head>

<body>
<div class="span3">
    ${render(template: '/inventory/side-navigation-admin')}
</div>

<div class="span9">
    <table class="table table-striped table-bordered table-condensed">
        <thead>
        <tr>
            <th>SKU Code</th>
            <th>Name</th>
            <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${results}" status="i" var="result">
            <tr>
                <td><a href="${createLink(controller: 'inventoryItem', action: 'edit', id: result.id)}">${result.skuCode}</a>
                </td>
                <td>${result.name}</td>
                <td>${result.description}</td>
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