<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
            + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>403 未授权错误</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery.js"></script>

    <script language="javascript">
        $(function () {
            $('.error').css({'position': 'absolute', 'left': ($(window).width() - 490) / 2});
            $(window).resize(function () {
                $('.error').css({'position': 'absolute', 'left': ($(window).width() - 490) / 2});
            })
        });
    </script>


</head>


<body style="background:#edf6fa;">

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">403未授权错误</a></li>
    </ul>
</div>

<div class="error">
    <h2>非常遗憾，您未被授权！</h2>
</div>
</body>
</html>
