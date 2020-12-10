<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>员工编辑</h1>
<form action="/employee/saveOrUpdate" method="POST">
	<input type="hidden" name="id" value="${employee.id}">
	员工名称:<input type="text" name="name" value="${employee.name}"><br>
	<c:if test="${ empty employee}">
		员工密码:<input type="text" name="password" value="${employee.password}"><br>
	</c:if>
	员工邮箱:<input type="text" name="email" value="${employee.email}"><br>
	员工年龄:<input type="text" name="age" value="${employee.age}"><br>
	员工部门:<select name="dept.id">
			<c:forEach items="${departments}" var="department">
				<option value="${department.id}" ${department.id == employee.dept.id ? 'selected' : ''}>${department.name }</option>
			</c:forEach>
		</select><br/>
	是否管理员:<input type="checkbox" name="admin" value="1" ${employee.admin?'checked':''}><br>
	<input type="submit" value="提交">
</form>
</body>
</html>