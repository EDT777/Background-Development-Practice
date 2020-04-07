<%@page import="com.octopus.dao.impl.UserInfoDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>演示jsp也没的组成</title>
<%@ include file="head.jsp"  %>
</head>
<body>
<%//内嵌小脚本
int num=10;//局部变量
UserInfoDAOImpl userDao = new UserInfoDAOImpl();

%>
<%=num %><!-- 将num的值输出到页面中 -->
<%! /*  声明属性和方法 */
public int num1 =100;
%>
</body>
</html>