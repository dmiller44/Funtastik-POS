<!doctype html>
<html>
<head>
    <meta name="layout" content="funtastik-main"/>
    <title>Funtastik | POS System</title>

    <link rel="stylesheet" href="<g:resource dir='css/funtastik' file='side-navigation.css'/>" type="text/css"
          charset="utf-8"/>

    <script type="text/javascript" src="<g:resource dir='js' file='sliding_effect.js'/>"></script>
</head>

<body>
<!-- everything is just floated on the screen -->

<div id="side-navigation-block">
    <ul id="sliding-navigation">
        <li class="sliding-element"><h3>Administrative Options</h3></li>
        <li class="sliding-element"><a href="#">Departments</a></li>
        <li class="sliding-element"><a href="#">Manufacturers</a></li>
        <li class="sliding-element"><a href="${createLink(controller: 'color', action: 'list')}"
                                       onclick="handleSideNavClick(this.href);
                                       return false;">Colors</a></li>
        <li class="sliding-element"><a href="${createLink(controller: 'itemType', action: 'list')}"
                                       onclick="handleSideNavClick(this.href);
                                       return false;">Types/Subtypes</a></li>
        <li class="sliding-element"><a href="#">Sizes</a></li>
        <li class="sliding-element"><a href="#">Inventory Items</a></li>
        <li class="sliding-element"><a href="#">POS Security</a></li>
    </ul>
</div>

<div id="mainContent">

</div>

<script type="text/javascript">
    $(document).ready(function () {
        setupGridAjax();
    });

    // Turn all sorting and paging links into ajax requests for the grid
    function setupGridAjax() {
        $("#grid").find(".pagination a, th.sortable a").live('click', function (event) {
            event.preventDefault();
            var url = $(this).attr('href');

            var replaceableArea = $("#mainContent");

            $.ajax({
                type:'GET',
                url:url,
                success:function (data) {
                    $(replaceableArea).fadeOut('fast', function () {
                        $(replaceableArea).html(data).fadeIn('slow');
                    });
                }
            })
        });
    }
</script>

</body>
</html>
