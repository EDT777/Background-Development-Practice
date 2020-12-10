<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function goPage(pageNo){
		//1:获取表单对象
		var form = document.forms[0];
		form.currentPage.value = pageNo;
		form.submit();
	}

</script>

</head>
<body>
<h1>员工列表</h1>
<a href="/employee/input">添加</a>
<form action="/employee/list" method="post">
<table border="1" cellpadding="0" cellspacing="0" width="60%">
	<tr>
		<td colspan="7">
			关键字:<input type="text" name="keyword" value="${qo.keyword}">
			部门:<select name="deptId">
				<option value="">全部</option>
				<c:forEach items="${departments}" var="department">
					<option value="${department.id}" ${department.id == qo.deptId ? 'selected' : ''} >${department.name}</option>
				</c:forEach>
			</select>
			<input type="submit" value="查询"/>
		</td>
	</tr>
	<tr>
		<td>编号</td>
		<td>名称</td>
		<td>email</td>
		<td>年龄</td>
		<td>是否管理员</td>
		<td>部门名称</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${pageResult.data}" var="employee" varStatus="vs">
		<tr>
			<td>${vs.count}</td>
			<td>${employee.name}</td>
			<td>${employee.email}</td>
			<td>${employee.age}</td>
			<td>${employee.admin ? '是':'否'}</td>
			<td>${employee.dept.name}</td>
			<td><a href="/employee/input?id=${employee.id}">编辑</a>
			<a href="/employee/delete?id=${employee.id}">删除</a> </td>
		</tr>
	</c:forEach>
	
	<tr>
		<td colspan="7" align="center">   
			<a href="javascript:;" onclick="goPage(1)">首页</a>
			<a href="javascript:;" onclick="goPage(${pageResult.prePage})">上一页</a>
			<a href="javascript:;" onclick="goPage(${pageResult.nextPage})">下一页</a>
			<a href="javascript:;" onclick="goPage(${pageResult.totalPage})">末页</a>
			每页显示:<select name="pageSize" onchange="goPage(1)">
				<option value ="3" ${pageResult.pageSize == 3 ? 'selected' : '' }>3</option>
				<option value ="5" ${pageResult.pageSize == 5 ? 'selected' : '' }>5</option>
				<option value ="10" ${pageResult.pageSize == 10 ? 'selected' : '' }>10</option>
			</select>
			 ${pageResult.currentPage }/${pageResult.totalPage } 页
			跳转:<input type="text" name="currentPage" style="width: 30px" value="${pageResult.currentPage }">
			<input type="submit" value="GO"/>
		</td>
	</tr>
</table>

</form>



</body>
</html>