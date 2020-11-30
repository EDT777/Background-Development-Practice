<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EDT灬谭泽豪
  Date: 2020/11/11
  Time: 下午 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>邮件列表</title>
</head>
<body>
<p>${USERNAME_IN_SESSION}</p>
<%--<p>${cookie.username.value}</p>--%>

<c:forEach var="email" items="${list}">
    <p><a href="/session/content">${email}</a></p>
</c:forEach>
</body>
</html>
