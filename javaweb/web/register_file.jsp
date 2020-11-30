<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<span style="color: red">${errorMsg}</span>
<form action="/fileUpload" method="post" enctype="multipart/form-data"><!--文件格式必须这样写enctype -->
      <p>用户名:<input type="text" name="username"/></p>
    <p>头像:<input type="file" name="headImg"/></p>
    <p>头像2:<input type="file" name="headImg2"/></p>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
