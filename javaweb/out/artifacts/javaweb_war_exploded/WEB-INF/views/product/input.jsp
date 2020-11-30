<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>product录入数据</title>
</head>
<body>
<h3>请录入商品数据</h3>
<form action="/product?cmd=saveOrUpdate" method="post">
    <input type="hidden" name="id" value="${product.id}" />
    <p>货品名:<input type="text" name="productName" value="${product.productName}"></p>
    <p>分类:
        <select name="dir_id">
            <option value="2" ${product.dir_id == 2? "selected": ""}>无线鼠标</option>
            <option value="3" ${product.dir_id == 3? "selected": ""}>有线鼠标</option>
            <option value="4" ${product.dir_id == 4? "selected": ""}>游戏鼠标</option>
        </select>
    </p>
    <p>零售价:<input type="number" name="salePrice" step="0.01" value="${product.salePrice}"></p>
    <p>供应商:<input type="text" name="supplier" value="${product.supplier}"/></p>
    <p>品牌:<input type="text" name="brand" value="${product.brand}"></p>
    <p>折扣:<input type="number" name="cutoff" step="0.1" value="${product.cutoff}"></p>
    <p>进货价:<input type="number" name="costPrice" value="${product.costPrice}"></p>
    <input type="submit" value="上架商品/修改商品">
</form>
</body>
</html>
