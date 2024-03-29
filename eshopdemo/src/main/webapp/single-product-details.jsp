<%@ page pageEncoding="UTF-8" contentType="text/html;charset-UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>章鱼教育 - 商品信息</title>

    <!-- Favicon  -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="css/core-style.css">
    <link rel="stylesheet" href="style.css">

</head>

<body>
     <%@ include file="header.jsp" %>
    <%@ include file="cart.jsp" %>

    <!-- ##### Single Product Details Area Start ##### -->
    <section class="single_product_details_area d-flex align-items-center">

        <!-- Single Product Thumb -->
        <div class="single_product_thumb clearfix">
            <div class="product_thumbnail_slides owl-carousel">
                <img src="img/product-img/product-big-1.jpg" alt="">
                <img src="img/product-img/product-big-2.jpg" alt="">
                <img src="img/product-img/product-big-3.jpg" alt="">
            </div>
        </div>

        <!-- Single Product Description -->
        <div class="single_product_desc clearfix">
            <span>秋天</span>
            <a href="cart.html">
                <h2>单肩深V休闲长裙</h2>
            </a>
            <p class="product-price"><span class="old-price">￥65.00</span> ￥49.00</p>
            <p class="product-desc">好漂亮的裙子好漂亮的裙子好漂亮的裙子好漂亮的裙子好漂亮的裙子好漂亮的裙子好漂亮的裙子好漂亮的裙子好漂亮的裙子好漂亮的裙子好漂亮的裙子好漂亮的裙子.</p>

            <!-- Form -->
            <form class="cart-form clearfix" method="post">
                <!-- Select Box -->
                <div class="select-box d-flex mt-50 mb-30">
                    <select name="select" id="product尺码" class="mr-5">
                        <option value="value">尺码: XL</option>
                        <option value="value">尺码: X</option>
                        <option value="value">尺码: M</option>
                        <option value="value">尺码: S</option>
                    </select>
                    <select name="select" id="product颜色">
                        <option value="value">颜色: 黑色</option>
                        <option value="value">颜色: 白色</option>
                        <option value="value">颜色: 红色</option>
                        <option value="value">颜色: 紫色</option>
                    </select>
                </div>
                <!-- Cart & Favourite Box -->
                <div class="cart-fav-box d-flex align-items-center">
                    <!-- Cart -->
                    <button type="submit" name="addtocart" value="5" class="btn essence-btn">加入购物车</button>
                    <!-- Favourite -->
                    <div class="product-favourite ml-4">
                        <a href="#" class="favme fa fa-heart"></a>
                    </div>
                </div>
            </form>
        </div>
    </section>
    <!-- ##### Single Product Details Area End ##### -->

   <%@ include file="foot.jsp" %>

    <!-- jQuery (Necessary for All JavaScript Plugins) -->
    <script src="js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="js/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Plugins js -->
    <script src="js/plugins.js"></script>
    <!-- Classy Nav js -->
    <script src="js/classy-nav.min.js"></script>
    <!-- Active js -->
    <script src="js/active.js"></script>

</body>

</html>