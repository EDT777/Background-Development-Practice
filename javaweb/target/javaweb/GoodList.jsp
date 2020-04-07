<%@page import="com.octopus.entity.*" %>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*" %>
<!doctype html>
<html>
<head>
<title>商品列表</title>
<meta charset="UTF-8">
</head>
<body>
<h2>商品列表
<ul>
<%
List<Goods> goods=(List<Goods>)request.getAttribute("data");
for(Goods g:goods){
%>
<li><%=g.getName() %></li>
<% }%>
</ul>
</h2>
</body>
</html>
