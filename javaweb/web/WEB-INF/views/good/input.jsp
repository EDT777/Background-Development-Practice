<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>good录入数据</title>
</head>
<body>
<h3>请录入商品数据</h3>
<%!  Date d =new Date();
    %>
<form action="/good?cmd=saveOrUpdate" method="post">
    <input type="hidden" name="id" value="${good.id}" />
    <p>商品名:<input type="text" name="name" value="${good.name}"></p>
    <p>零售价:<input type="text" name="price"  value="${good.price}"></p>
    <p>详情介绍:<input type="text" name="detail" value="${good.detail}"/></p>
    <p>创建时间: <input type="text" name="createTime" value="${good.createTime.toLocaleString()!=null?good.createTime.toLocaleString():date}"/> (yyyy-MM-dd HH:mm:ss  格式)</p>
        当前时间为:<%=d.toLocaleString()%>
    </br> <input type="submit" value="上架商品/修改商品">
</form>
</body>
</html>
