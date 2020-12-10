<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门新增或者修改</title>
</head>
<body>
    <form action="/department/saveOrUpdate" method="post">
        <input type="hidden" name="id" value="${department.id}">
        <input type="text" name="name" placeholder="名称" value="${department.name}"><br/>
        <input type="text" name="sn" placeholder="缩写" value="${department.sn}"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
