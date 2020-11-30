<%--
  Created by IntelliJ IDEA.
  User: XMG
  Date: 2020/11/6
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--执行java代码--%>
    <%
            String username ="小狼";
            Integer age =18;
    %>
<%--    输出变量值或表达式结果--%>
    <%=2*3%>
<%--    声明全局变量和方法--%>
<%!
  private String name="小码";
  public  void doWork(){

  }
%>
<%=name%>
</body>
</html>
