<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.octopus.entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>测试El表达式</title>
</head>
<body>
	<%
		int num = 199;
		pageContext.setAttribute("num1", num);

		Map<String, Object> data = new HashMap<>();
		UserInfo user = new UserInfo();
		user.setUserName("张三");
		data.put("user", user);

		pageContext.setAttribute("data", data);
		
		String[] arr = new String[]{"string1","string2","string3"};
		pageContext.setAttribute("arr1", arr);
	%>
	<h2>
		直接取变量的值:${num1}<br /> 取值+计算：${num1+1}<br /> 取值+比较:${num1 lt 1} gt是大于
		lt是小于 ge是大于等于 le是小于等于 ne是不等于 eq是等于<br /> 条件运算符：${num>100?"大于":"小于" }<br />
		访问对象的属性:${data.user.userName}<br /> 访问对象的属性:${data["user"].userName}<br />
	</h2>
	<!-- JSTL标签的使用 -->
	<ul>
	<c:forEach items="${arr1}" var="s">
	<li>${s}</li>
	</c:forEach>
	</ul>
</body>
</html>