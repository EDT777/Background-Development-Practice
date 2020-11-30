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
    <title>Product</title>
    <script type="text/javascript">
        window.onload = function () {
            //    获取所有的数据行
            var trEls = document.getElementsByClassName("trClass");
            //    给所有的tr绑定鼠标移入和移出的时间
            for (var i = 0; i < trEls.length; i++) {
                var trEl = trEls[i];
                //    把背景改为灰色
                //    移入
                trEl.onmouseover = function () {
                    this.style.backgroundColor = "gray";
                }
                //移出
                trEl.onmouseout = function () {
                    this.style.backgroundColor = "";
                }
            }
        }

        function deleteTr(productId) {//删除行数据
            var flag = window.confirm("亲,你确定要删除吗");
            if (flag) {
                window.location.href = "/product?cmd=delete&id=" + productId;
            }
        }

        function changePageSize() {
            document.forms[0].submit();
        }
        function goPage(page) {
            document.getElementById("currentPage").value = page;
            document.forms[0].submit();
        }
    </script>

</head>
<body>
<a href="/replaceHeadImg.jsp"><img src="${USER_IN_SESSION.headImg}" style="width: 50px;height: 50px"
                                   title="修改"/> ${USER_IN_SESSION.username}</a>

<p>${USER_IN_SESSION.username} <a href="/logout">用户登出</a></p>
<a href="/product?cmd=input">增加商品</a>
<form action="/product">
    产品名: <input type="text" name="productName" value="${qb.productName}"/> 零售价:
    <input type="text" name="minSalePrice" value="${qb.minSalePrice}"/>
    - <input type="text" name="maxSalePrice" value="${qb.maxSalePrice}"/>
    <input type="submit" value="查询">
    <table border="1" cellpadding="0" cellspacing="0" width="80%">
        <tr style="background-color: green">
            <th>编号</th>
            <th>货品名</th>
            <th>分类编号</th>
            <th>零售价</th>
            <th>供应商</th>
            <th>品牌名</th>
            <th>折扣</th>
            <th>进货价</th>
            <th>操作</th>
        </tr>
        <%--    遍历list--%>
        <c:forEach var="p" items="${pageResult.data}" varStatus="vs">
            <tr class="trClass">
                <td>${p.id}</td>
                <td>${p.productName}</td>
                <td>${p.dir_id}</td>
                <td>${p.salePrice}</td>
                <td>${p.supplier}</td>
                <td>${p.brand}</td>
                <td>${p.cutoff}</td>
                <td>${p.costPrice}</td>
                <td>
                    <a href="#" onclick="deleteTr(${p.id})">删除</a>
                    <a href="/product?cmd=input&id=${p.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="9">
                <a href="#" onclick="goPage(1)">首页</a>
                <a href="#" onclick="goPage(${pageResult.prePage})">上一页</a>
                <a href="#" onclick="goPage(${pageResult.nextPage})">下一页</a>
                <a href="#" onclick="goPage(${pageResult.totalPage})">尾页</a>
                当前页 ${pageResult.currentPage} / ${pageResult.totalPage}
                一共 ${pageResult.totalCount}条数据
                跳转到第 <input type="number" name="currentPage" id="currentPage" value="${pageResult.currentPage}"
                            onchange="changePageSize()"> 页
                每页 <select name="pageSize" onchange="changePageSize()">
                <option value="3" ${pageResult.pageSize ==3 ? 'selected' : '' }>3</option>
                <option value="5" ${pageResult.pageSize ==5 ? 'selected' : ''}>5</option>
                <option value="10" ${pageResult.pageSize ==10 ? 'selected' : ''}>10</option>
            </select>条数据
            </td>
        </tr>
    </table>
</form>
</body>
</html>
