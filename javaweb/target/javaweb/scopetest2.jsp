<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 用el表达式从作用域中取值 -->
page作用域:${pageScope.pageData}<br/>
request作用域:${requestScope.requestData}<br/>
session作用域:${sessionScope.sessionData}<br/>
application作用域:${applicationData}<br/>

</body>
</html>