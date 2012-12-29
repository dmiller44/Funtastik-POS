<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <sec:ifNotLoggedIn>
        <script type="text/javascript">
            window.location = '<g:createLink controller="login" action="auth" />';
        </script>
    </sec:ifNotLoggedIn>
    <title>Funtastik | POS System</title>
    <link rel="stylesheet" href="<g:resource dir='css/bootstrap' file='bootstrap.css'/>" type="text/css"
          charset="utf-8"/>
    <link rel="stylesheet" href="<g:resource dir='css/funtastik' file='funtastik-bootstrap.css'/>" type="text/css"
          charset="utf-8"/>

    <script type="text/javascript" src="<g:resource dir='js' file='jquery-1.7.1.min.js'/>"></script>
    <script type="text/javascript" src="<g:resource dir='js/bootstrap' file='bootstrap.js'/>"></script>

    <g:layoutHead/>
</head>

<body>
<!-- Navbar
    ================================================== -->
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="${createLink(uri: '/')}"><img class="tiny-navigation-logo"
                                                                 src="${g.resource(dir: 'images/funtastik-logos', file: 'newFuntastikLogo-white.png')}"
                                                                 alt="funtastik-logo"/> POS System</a>

            <form class="navbar-search pull-right">
                <input type="text" class="search-query" placeholder="Search">
            </form>

            <div class="nav-collapse">
                <ul class="nav">
                    <li class="">
                        <a href="#">Overview</a>
                    </li>
                    <li class="">
                        <a href="${createLink(uri: '/cashregister/main')}">Cash Register</a>
                    </li>
                    <li class="">
                        <a href="#">Search</a>
                    </li>
                    <li class="divider-vertical"></li>
                    <li class="">
                        <a href="#">Help</a>
                    </li>
                    <li class="dropdown">
                        <a href="#"
                           class="dropdown-toggle"
                           data-toggle="dropdown">
                            Administration
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="">
                                <a href="#">Customer Management</a>
                            </li>
                            <li class="">
                                <a href="#">Transaction Management</a>
                            </li>
                            <li class="">
                                <a href="${createLink(uri: '/admin/inventory')}">Inventory Management</a>
                            </li>
                            <li class="">
                                <a href="#">Security Management</a>
                            </li>
                        </ul>
                    </li>
                    <li class="">
                        <a href="${createLink(controller: 'logout')}">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<div class="container">

    <div class="row">
        <g:layoutBody/>
    </div>
</div>
</body>
</html>