<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
    <title>Funtastik | POS System</title>

    <g:javascript src="jquery-1.7.1.min.js"/>

    <style type="text/css">
    * {
        font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
    }

    body {
        margin: 0;
        pading: 0;
        color: #fff;
        background: url('<g:resource dir="images/login-images" file="bg-login.png"/>') repeat #1b1b1b;
        font-size: 14px;
        text-shadow: #050505 0 -1px 0;
        font-weight: bold;
    }

    li {
        list-style: none;
    }

    #dummy {
        position: absolute;
        top: 0;
        left: 0;
        border-bottom: solid 3px #777973;
        height: 250px;
        width: 100%;
        background: url('<g:resource dir="images/login-images" file="bg-login-top.png"/>') repeat #fff;
        z-index: 1;
    }

    #dummy2 {
        position: absolute;
        top: 0;
        left: 0;
        border-bottom: solid 2px #545551;
        height: 252px;
        width: 100%;
        background: transparent;
        z-index: 2;
    }

    #login-wrapper {
        margin: 0 0 0 -160px;
        width: 320px;
        text-align: center;
        z-index: 99;
        position: absolute;
        top: 0;
        left: 50%;
    }

    .funtastik-logo {
        position: absolute;
        left: 30%;
        top: 20px;
        z-index: 100;
    }

    #login-top {
        height: 120px;
        padding-top: 140px;
        text-align: center;
    }

    label {
        width: 70px;
        float: left;
        padding: 8px;
        line-height: 14px;
        margin-top: -4px;
    }

    input.text-input {
        width: 200px;
        float: right;
        -moz-border-radius: 4px;
        -webkit-border-radius: 4px;
        border-radius: 4px;
        background: #fff;
        border: solid 1px transparent;
        color: #555;
        padding: 8px;
        font-size: 13px;
    }

    input.button {
        float: right;
        padding: 6px 10px;
        color: #fff;
        font-size: 14px;
        background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#3399cc), to(#3333cc));
        text-shadow: #050505 0 -1px 0;
        background-color: #253b91;
        -moz-border-radius: 4px;
        -webkit-border-radius: 4px;
        border-radius: 4px;
        border: solid 1px transparent;
        font-weight: bold;
        cursor: pointer;
        letter-spacing: 1px;
    }

    input.button:hover {
        background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#3399cc), to(#3399cc), color-stop(80%, #336699));
        text-shadow: #050505 0 -1px 2px;
        background-color: #258ccf;
        color: #fff;
    }

    div.error {
        padding: 8px;
        background: rgba(52, 4, 0, 0.4);
        -moz-border-radius: 8px;
        -webkit-border-radius: 8px;
        border-radius: 8px;
        border: solid 1px transparent;
        margin: 6px 0;
    }
    </style>
</head>

<body id="login">

<img class="funtastik-logo" src="<g:resource dir='images/funtastik-logos' file='old-funtastik-logo.gif'/>"
     alt="Funtastik Login Form" title="Powered By AngryGiant.com"/>

<div id="login-wrapper" class="png_bg">
    <div id="login-top">
    </div>

    <div id="login-content">
        <form method="post">
            <p>
                <label>Username</label>
                <input value="" name="username" class="text-input" type="text"/>
            </p>
            <br style="clear: both;"/>

            <p>
                <label>Password</label>
                <input name="password" class="text-input" type="password"/>
            </p>
            <br style="clear: both;"/>

            <p>
                <input class="button" type="submit" value="Sign In"/>
            </p>

        </form>
    </div>
</div>

<div id="dummy"></div>

<div id="dummy2"></div>
</body>
</html>
