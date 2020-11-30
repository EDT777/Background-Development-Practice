<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: EDT灬谭泽豪
  Date: 2020/11/10
  Time: 上午 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>El</title>
</head>
<body>
<%--     演示EL的表达式--%>
${1+1} <br>
${1==1} <br>
${1 eq 1} <br>
${true && true } <br>
${true || false } <br>
${!false} <br>
${1 == 1?"等于":"不等于"} <br>
<%
    List<String> list =new ArrayList<>();
    //EL表达式获取的数是从作用域中获取
    // 所以要使用EL来判断list 是否为空,需要把list存入作用域中
    request.setAttribute("list",list);
%>
<%--判断内容是否为空 而不是对象是否为null--%>
${empty list}
</body>
</html>
