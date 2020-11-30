<%--
  Created by IntelliJ IDEA.
  User: XMG
  Date: 2020/11/6
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <table border="1" cellpadding="0" cellspacing="0">
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>邮箱</th>
            </tr>
            <c:forEach var="person" items="${list}">
            <tr>
                <th>${person.id}</th>
                <th>${person.name}</th>
                <th>${person.age}</th>
                <th>${person.email}</th>
            </tr>
            </c:forEach>
        </table>
</body>
</html>
