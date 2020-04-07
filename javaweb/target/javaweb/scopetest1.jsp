<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>演示作用域概念</title>
</head>
<body>
<%

//分别在page,request,session,application四个作用域存放数据
pageContext.setAttribute("pageData", "在page作用域中的值");
session.setAttribute("sessionData", "在session作用域中的值");
request.setAttribute("requestData", "在request作用域中的值");
application.setAttribute("applicationData", "在application作用域中的值");
//请求转发：将当前页面的处理流程交给后续页面
request.getRequestDispatcher("scopetest2.jsp").forward(request, response);
%>
</body>
</html>