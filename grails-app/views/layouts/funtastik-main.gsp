<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <sec:ifNotLoggedIn>
        <script type="text/javascript">
            window.location = '<g:createLink controller="login" action="auth" />';
        </script>
    </sec:ifNotLoggedIn>
    <title>Funtastik | POS System</title>
    <link rel="stylesheet" href="<g:resource dir='css/funtastik' file='style.css'/>" type="text/css" charset="utf-8"/>

    <script type="text/javascript" src="<g:resource dir='js' file='jquery-1.7.1.min.js'/>"></script>
    <script type="text/javascript">
        $(function () {
            $('#navigation').fadeIn(1000);

            var d = 300;
            $('#navigation a').each(function () {
                $(this).stop().animate({
                    'marginTop':'-80px'
                }, d += 150);
            });

            $('#navigation > li').hover(
                    function () {
                        $('a', $(this)).stop().animate({
                            'marginTop':'-2px'
                        }, 200);
                    },
                    function () {
                        $('a', $(this)).stop().animate({
                            'marginTop':'-80px'
                        }, 200);
                    }
            );
        });

        function handleMenuClick(linkUri) {
            $('body').fadeOut(function () {
                window.location = linkUri;
            });
        }
    </script>

    <g:layoutHead/>
</head>

<body>
<ul id="navigation">
    <li class="home"><a href="<g:createLink uri='/'/>" onclick="handleMenuClick(this.href);
    return false;"><span>Home</span></a></li>
    <li class="register"><a href=""><span>Cash Register</span></a></li>
    <li class="search"><a href=""><span>Search</span></a></li>
    <li class="settings"><a href="<g:createLink controller='settings'/>"><span>Settings</span></a></li>
    <li class="logout"><a href="<g:createLink controller='logout'/>" onclick="handleMenuClick(this.href);
    return false;"><span>Logout</span></a></li>
</ul>
<g:layoutBody/>
</body>
</html>