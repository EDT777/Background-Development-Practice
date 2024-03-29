<%@ page pageEncoding="UTF-8" contentType="text/html;charset-UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title  -->
<title>章鱼教育 - 商品</title>

<!-- Favicon  -->
<link rel="icon" href="img/core-img/favicon.ico">

<!-- Core Style CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/core-style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">

</head>

<body>
	<%@ include file="header.jsp"%>
	<%@ include file="cart.jsp"%>

	<!-- ##### Breadcumb Area Start ##### -->
	<div class="breadcumb_area bg-img"
		style="background-image: url(<%=request.getContextPath()%>/img/bg-img/breadcumb.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="page-title text-center">
						<h2>裙装</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ##### Breadcumb Area End ##### -->

	<!-- ##### Shop Grid Area Start ##### -->
	<section class="shop_grid_area section-padding-80">
		<div class="container">
			<div class="row">
				<div class="col-12 col-md-4 col-lg-3">
					<div class="shop_sidebar_area">

						<!-- ##### Single Widget ##### -->
						<div class="widget catagory mb-50">
							<!-- Widget Title -->
							<h6 class="widget-title mb-30">分类</h6>

							<!--  Catagories  -->
							<div class="catagories-menu">
								<ul id="menu-content2" class="menu-content collapse show">
									<!-- Single Item -->
									<li data-toggle="collapse" data-target="#clothing"><a
										href="#">服装</a>
										<ul class="sub-menu collapse show" id="clothing">
											<li><a href="#">全部</a></li>
											<li><a href="#">外套</a></li>
											<li><a href="#">裙子</a></li>
											<li><a href="#">套装</a></li>
											<li><a href="#">夹克</a></li>
											<li><a href="#">牛仔</a></li>
											<li><a href="#">毛衣</a></li>
										</ul></li>
									<!-- Single Item -->
									<li data-toggle="collapse" data-target="#shoes"
										class="collapsed"><a href="#">鞋帽</a>
										<ul class="sub-menu collapse" id="shoes">
											<li><a href="#">全部</a></li>
											<li><a href="#">运动</a></li>
											<li><a href="#">休闲</a></li>
											<li><a href="#">绅士</a></li>
											<li><a href="#">商务</a></li>
											<li><a href="#">女鞋</a></li>
											<li><a href="#">男鞋</a></li>
											<li><a href="#">凉鞋</a></li>
										</ul></li>
									<!-- Single Item -->
									<li data-toggle="collapse" data-target="#accessories"
										class="collapsed"><a href="#">童装</a>
										<ul class="sub-menu collapse" id="accessories">
											<li><a href="#">全部</a></li>
											<li><a href="#">裙装</a></li>
											<li><a href="#">西装</a></li>
											<li><a href="#">卫衣</a></li>
											<li><a href="#">夹克</a></li>
											<li><a href="#">牛仔</a></li>

										</ul></li>
								</ul>
							</div>
						</div>

						<!-- ##### Single Widget ##### -->
						<div class="widget price mb-50">
							<!-- Widget Title -->
							<h6 class="widget-title mb-30">过滤</h6>
							<!-- Widget Title 2 -->
							<p class="widget-title2 mb-30">价格</p>

							<div class="widget-desc">
								<div class="slider-range">
									<div data-min="19" data-max="1800" data-unit="￥"
										class="slider-range-price ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all"
										data-value-min="19" data-value-max="1800"
										data-label-result="Range:">
										<div class="ui-slider-range ui-widget-header ui-corner-all"></div>
										<span class="ui-slider-handle ui-state-default ui-corner-all"
											tabindex="0"></span> <span
											class="ui-slider-handle ui-state-default ui-corner-all"
											tabindex="0"></span>
									</div>
									<div class="range-price">范围: ￥19.00 - ￥18360.00</div>
								</div>
							</div>
						</div>

						<!-- ##### Single Widget ##### -->
						<div class="widget color mb-50">
							<!-- Widget Title 2 -->
							<p class="widget-title2 mb-30">颜色</p>
							<div class="widget-desc">
								<ul class="d-flex">
									<li><a href="#" class="color1"></a></li>
									<li><a href="#" class="color2"></a></li>
									<li><a href="#" class="color3"></a></li>
									<li><a href="#" class="color4"></a></li>
									<li><a href="#" class="color5"></a></li>
									<li><a href="#" class="color6"></a></li>
									<li><a href="#" class="color7"></a></li>
									<li><a href="#" class="color8"></a></li>
									<li><a href="#" class="color9"></a></li>
									<li><a href="#" class="color10"></a></li>
								</ul>
							</div>
						</div>

						<!-- ##### Single Widget ##### -->
						<div class="widget brands mb-50">
							<!-- Widget Title 2 -->
							<p class="widget-title2 mb-30">品牌</p>
							<div class="widget-desc">
								<ul>
									<li><a href="#">杰克琼斯</a></li>
									<li><a href="#">NIKE</a></li>
									<li><a href="#">Adidas</a></li>
									<li><a href="#">圣得西</a></li>
									<li><a href="#">斑马</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<div class="col-12 col-md-8 col-lg-9">
					<div class="shop_grid_product_area">
						<div class="row">
							<div class="col-12">
								<div
									class="product-topbar d-flex align-items-center justify-content-between">
									<!-- Total Products -->
									<div class="total-products">
										<p>
											<span>186</span> 个商品
										</p>
									</div>
									<!-- Sorting -->
									<div class="product-sorting d-flex">
										<p>排序:</p>
										<form action="#" method="get">
											<select name="select" id="sortByselect">
												<option value="value">最好评价</option>
												<option value="value">最近伤心</option>
												<option value="value">价格: ￥￥ - ￥</option>
												<option value="value">价格: ￥ - ￥￥</option>
											</select> <input type="submit" class="d-none" value="">
										</form>
									</div>
								</div>
							</div>
						</div>

						<div class="row">

							<c:forEach items="${list}" var="p">
								<!-- Single Product -->
								<div class="col-12 col-sm-6 col-lg-4">
									<div class="single-product-wrapper">
										<!-- Product Image -->
										<div class="product-img">
											<img
												src="<%=request.getContextPath()%>/img/product-img/product-9.jpg"
												alt="">
											<!-- Hover Thumb -->
											<img class="hover-img"
												src="<%=request.getContextPath()%>/img/product-img/product-1.jpg"
												alt="">

											<!-- Favourite -->
											<div class="product-favourite">
												<a href="#" class="favme fa fa-heart"></a>
											</div>
										</div>

										<!-- Product Description -->
										<div class="product-description">
											<span>topshop</span> <a href="single-product-details.html">
												<h6>${p.name}</h6>
											</a>
											<p class="product-price">￥${p.price}</p>

											<!-- Hover Content -->
											<div class="hover-content">
												<!-- 加入购物车 -->
												<div class="add-to-cart-btn">
													<a href="javascript:addToCart(${p.id})"
														class="btn essence-btn">加入购物车</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
					<!-- Pagination -->
					<nav aria-label="navigation">
						<ul class="pagination mt-50 mb-70">
							<li class="page-item"><a class="page-link" href="#"><i
									class="fa fa-angle-left"></i></a></li>
							<li class="page-item"><a class="page-link" href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item"><a class="page-link" href="#">...</a></li>
							<li class="page-item"><a class="page-link" href="#">21</a></li>
							<li class="page-item"><a class="page-link" href="#"><i
									class="fa fa-angle-right"></i></a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- ##### Shop Grid Area End ##### -->

	<%@ include file="foot.jsp"%>


	<!-- jQuery (Necessary for All JavaScript Plugins) -->
	<script
		src="<%=request.getContextPath()%>/js/jquery/jquery-2.2.4.min.js"></script>
	<!-- Popper js -->
	<script src="<%=request.getContextPath()%>/js/popper.min.js"></script>
	<!-- Bootstrap js -->
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<!-- Plugins js -->
	<script src="<%=request.getContextPath()%>/js/plugins.js"></script>
	<!-- Classy Nav js -->
	<script src="<%=request.getContextPath()%>/js/classy-nav.min.js"></script>
	<!-- Active js -->
	<script src="<%=request.getContextPath()%>/js/active.js"></script>
	<script type="text/javascript">
	function addToCart(pid){
		$.ajax({
			
			url:'<%=request.getContextPath() %>/cart?action=add&pid='+ pid,
				success : function(data) {
					alert("添加成功");
				}
			});
		}
	</script>
</body>

</html>