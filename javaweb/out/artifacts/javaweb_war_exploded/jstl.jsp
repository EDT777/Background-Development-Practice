<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL</title>
</head>
<body>
<%--单个判断与--%>
<c:if test="${p.age>=18 && p.age<80}">
    大于或者等于18岁,可以看
</c:if>
<c:if test="${p.age<18}">
    少儿不宜
</c:if>
<br/>
<%--多个判断语句,即相当于有else--%>
<c:choose>
    <c:when test="${p.age>30}">
        大于30岁,不能观看
    </c:when>
    <c:otherwise>
        少儿不宜
    </c:otherwise>

</c:choose>
<br/>
<%--遍历语句--%>
<c:forEach var="t" items="${p.list}" varStatus="vs" >
   ${vs.index}  --> ${t} |
</c:forEach>
<br/>
<%--时间格式 输出--%>
<fmt:formatDate value="${p.date}" pattern="yyyy-MM-dd"/>

</table>
</body>
</html>
