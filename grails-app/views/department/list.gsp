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
		${render(template: 'templates/tableView', model: '${[departmentInstanceList: departmentInstanceList, departmentInstanceTotal: departmentInstanceTotal]}')}
	</div>
	
	<script type="text/javascript">
		$("li#department").attr("class","active");
	</script>
</body>
</html>
