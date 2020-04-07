<%@page import="com.octopus.entity.*" %>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<h2>你好！，${user.userName}
<%-- 
UserInfo user =(UserInfo)session.getAttribute("user");
out.print(user.getUserName());
 --%>
</h2>
</body>
</html>
