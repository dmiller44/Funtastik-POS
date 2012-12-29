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
    ${render(template: 'templates/searchForm', model: [templateName: templateName])}
</div>

<script type="text/javascript">
    $("li#itemList").attr("class", "active");
</script>
</body>
</html>