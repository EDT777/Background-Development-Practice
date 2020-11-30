<%@ page import="com.edt.Servlet.demo.domain.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.edt.Servlet.demo.dao.IStudentDao" %>
<%@ page import="com.edt.Servlet.demo.dao.impl.StudentDaoImpl" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EDT灬谭泽豪
  Date: 2020/11/10
  Time: 下午 5:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang=\"en\">
<head>
    <meta charset=\"UTF-8\">
    <title>Title</title>

</head>
<body>
<%
    IStudentDao studentDao = new StudentDaoImpl();
    List<Student> list =studentDao.selectAll();
    request.setAttribute("list",list);
%>
<h3>请录入个人信息</h3>
<form action="/jspRegister" method="get">
    <p>编号: <input type="text" name="number"></p>
    <p>姓名：<input type="text" name="name"></p>
    <p>分数：<input type="text" name="score"></p>
    <p>性别: <input type="radio" name="sex" value="男">男
        <input type="radio" name="sex" value="女">女
    </p>
    <input type="submit" value="注册并查询所有学生信息">
</form>
<c:choose>
    <c:when test="${msg==true}">
        注册成功!!
    </c:when>
    <c:when test="${msg==false}">
        注册失败!!
    </c:when>
    <c:otherwise>
            请输入你的个人信息完成注册!
    </c:otherwise>
</c:choose>
<br/>
<c:if test="${listMsg==true}">
    ${list}
</c:if>
<br/>

</body>
</html>