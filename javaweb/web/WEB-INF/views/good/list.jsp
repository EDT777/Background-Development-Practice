<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EDT灬谭泽豪
  Date: 2020/11/10
  Time: 下午 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>good</title>
    <script type="text/javascript">
        window.onload =function () {
        //    获取所有的数据行
            var trEls = document.getElementsByClassName("trClass");
        //    给所有的tr绑定鼠标移入和移出的时间
             for (var i=0;i<trEls.length;i++){
                 var trEl = trEls[i];
             //    把背景改为灰色
             //    移入
                 trEl.onmouseover =function () {
                        this.style.backgroundColor = "gray";
                 }
                 //移出
                 trEl.onmouseout =function () {
                     this.style.backgroundColor = "";
                 }
             }
        }
        function deleteTr(goodId) {//删除行数据
                var flag = window.confirm("亲,你确定要删除吗");
                if (flag){
                    window.location.href="/good?cmd=delete&id="+goodId;
                }
        }
    </script>
</head>
<body>
<a href="/good?cmd=input">增加商品</a>
<table border="1" cellpadding="0" cellspacing="0" width="80%">
    <tr style="background-color: green">
        <th>编号</th>
        <th>商品名</th>
        <th>零售价</th>
        <th>详细介绍</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
        <%--    遍历list--%>
        <c:forEach var="g" items="${list}" varStatus="vs">
    <tr class="trClass" >
        <td>${vs.count}</td>
        <td>${g.name}</td>
        <td>${g.price}</td>
        <td>${g.detail}</td>
        <td>${g.createTime.toLocaleString()}</td>
    <td>
       <a href="#" onclick="deleteTr(${g.id})">删除</a>
        <a href="/good?cmd=input&id=${g.id}">修改</a>
    </td>
    </tr>
    </c:forEach>

</table>
</body>
</html>
