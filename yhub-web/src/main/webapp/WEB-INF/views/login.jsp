<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
            + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎登录Yhub后台管理系统</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>

<body style="background: #1c77ac url(/images/light.png) no-repeat center top;
    overflow:hidden;">

<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>

<div class="logintop">
    <span>欢迎登录后台管理界面平台</span>
    <ul>
        <li><a href="#">回首页</a></li>
        <li><a href="#">帮助</a></li>
        <li><a href="#">关于</a></li>
    </ul>
</div>

<div class="loginbody">
    <span class="systemlogo"></span>
    <div class="loginbox">
        <form class="login-form" id="loginForm" method="post">
        <ul>
            <li><input name="username" id="username" size="25" type="text" class="loginuser" placeholder="用户名"/></li>
            <li><input name="password" id="password" size="25" type="password" class="loginpwd"  autocomplete="off" placeholder="密码"/></li>
            <li><input type="button" class="loginbtn" id="loginButton" onclick="javascript:loginForm();" value="登录"></li>
            <label><input type="checkbox" value="" checked="checked"/>记住密码</label>
            <label><a href="#">忘记密码？</a></label></li>
        </ul>
        </form>
    </div>
</div>

<div class="loginbm">2014 &copy; Yhub.</div>

<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>
<script src="js/app.js" type="text/javascript"></script>
</body>
</html>
