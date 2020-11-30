<%--
  Created by IntelliJ IDEA.
  User: EDT灬谭泽豪
  Date: 2020/11/12
  Time: 下午 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改头像</title>
</head>
<body>
<form action="/replaceImg" method="post" enctype="multipart/form-data">
    更换头像:<input type="file" name="headImg">
    <input type="submit" value="提交">
</form>
</body>
</html>
