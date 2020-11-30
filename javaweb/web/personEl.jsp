<%--
  Created by IntelliJ IDEA.
  User: EDT灬谭泽豪
  Date: 2020/11/10
  Time: 上午 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>person</title>
</head>
<body>
${p}
<br> id: ${p.id}
<br> username: ${p.username} -> ${p.getUsername()} -> ${p["username"]}
<br> age:${p.age}
<br>hobby:${p.hobby[0]}
<br>list:${p.list[0]}
<br>map: ${p.map}
<br>map.host: ${p.map.host}
<br>map.com.edt: ${p.map["com.edt"]}
</body>
</html>
