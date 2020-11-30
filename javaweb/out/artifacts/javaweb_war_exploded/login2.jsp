<%--
  Created by IntelliJ IDEA.
  User: EDT灬谭泽豪
  Date: 2020/11/12
  Time: 下午 8:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<span style="color:red;">${errorMsg}</span>
<form action="/login2" method="post">
    <p>用户名:<input type="text" name="username"></p>
    <p>密码:<input type="text" name="password"></p>
    <input type="submit" value="登陆">
</form>
</body>
</html>
