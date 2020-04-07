<%@ page pageEncoding="UTF-8" %>
 <!-- ##### Header Area Start ##### -->
    <header class="header_area">
        <div class="classy-nav-container breakpoint-off d-flex align-items-center justify-content-between">
            <!-- Classy Menu -->
            <nav class="classy-navbar" id="essenceNav">
                <!-- Logo -->
                <a class="nav-brand" href="index.jsp"><img src="img/core-img/logo.png" width="100" alt=""></a>
                <!-- Navbar Toggler -->
                <div class="classy-navbar-toggler">
                    <span class="navbarToggler"><span></span><span></span><span></span></span>
                </div>
                <!-- Menu -->
                <div class="classy-menu">
                    <!-- close btn -->
                    <div class="classycloseIcon">
                        <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                    </div>
                    <!-- Nav Start -->
                    <div class="classynav">
                        <ul>
                            <li><a href="#">店铺</a>
                                <div class="megamenu">
                                    <ul class="single-mega cn-col-4">
                                        <li class="title">女装</li>
                                        <li><a href="shop.jsp">Dresses</a></li>
                                        <li><a href="shop.jsp">Blouses &amp; Shirts</a></li>
                                        <li><a href="shop.jsp">T-shirts</a></li>
                                        <li><a href="shop.jsp">Rompers</a></li>
                                        <li><a href="shop.jsp">Bras &amp; Panties</a></li>
                                    </ul>
                                    <ul class="single-mega cn-col-4">
                                        <li class="title">男装</li>
                                        <li><a href="shop.jsp">T-Shirts</a></li>
                                        <li><a href="shop.jsp">Polo</a></li>
                                        <li><a href="shop.jsp">Shirts</a></li>
                                        <li><a href="shop.jsp">Jackets</a></li>
                                        <li><a href="shop.jsp">Trench</a></li>
                                    </ul>
                                    <ul class="single-mega cn-col-4">
                                        <li class="title">童装</li>
                                        <li><a href="shop.jsp">Dresses</a></li>
                                        <li><a href="shop.jsp">Shirts</a></li>
                                        <li><a href="shop.jsp">T-shirts</a></li>
                                        <li><a href="shop.jsp">Jackets</a></li>
                                        <li><a href="shop.jsp">Trench</a></li>
                                    </ul>
                                    <div class="single-mega cn-col-4">
                                        <img src="img/bg-img/bg-6.jpg" alt="">
                                    </div>
                                </div>
                            </li>
                            <li><a href="#">导航</a>
                                <ul class="dropdown">
                                    <li><a href="index.jsp">首页</a></li>
                                    <li><a href="shop.jsp">商品</a></li>
                                    <li><a href="checkout.jsp">结算</a></li>
                                    <li><a href="contact.jsp">联系我们</a></li>
                                </ul>
                            </li>
                            <li><a href="contact.jsp">联系我们</a></li>
                        </ul>
                    </div>
                    <!-- Nav End -->
                </div>
            </nav>

            <!-- Header Meta Data -->
            <div class="header-meta d-flex clearfix justify-content-end">
                <!-- Search Area -->
                <div class="search-area">
                    <form action="<%=request.getContextPath() %>/product/find" method="post">
                        <input type="search" name="keyword" id="headerSearch" placeholder="输入搜索">
                        <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
                    </form>
                </div>
                <!-- Favourite Area -->
                <div class="favourite-area">
                    <a href="#"><img src="<%=request.getContextPath() %>img/core-img/heart.svg" alt=""></a>
                </div>
                <!-- User Login Info -->
                <div class="user-login-info">
                    <a href="#"><img src="<%=request.getContextPath() %>img/core-img/user.svg" alt=""></a>
                </div>
                <!-- Cart Area -->
                <div class="cart-area">
                    <a href="#" id="essenceCartBtn"><img src="<%=request.getContextPath() %>img/core-img/bag.svg" alt=""> <span>3</span></a>
                </div>
            </div>

        </div>
    </header>
    <!-- ##### Header Area End ##### -->