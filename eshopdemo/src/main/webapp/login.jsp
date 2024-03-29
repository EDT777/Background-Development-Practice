
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
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
<title>章鱼教育 -登陆</title>

<!-- Favicon  -->
<link rel="icon" href="img/core-img/favicon.ico">

<!-- Core Style CSS -->
<link rel="stylesheet" href="css/core-style.css">
<link rel="stylesheet" href="style.css">

</head>

<body>
	<%@ include file="header.jsp"%>
	<%@ include file="cart.jsp"%>

	<!-- ##### Breadcumb Area Start ##### -->
	<div class="breadcumb_area bg-img"
		style="background-image: url(img/bg-img/breadcumb.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="page-title text-center">
						<h2>登陆</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ##### Breadcumb Area End ##### -->

	<!-- ##### Checkout Area Start ##### -->
	<div class="checkout_area section-padding-80">
		<div class="container">
			<div class="row">

				<div class="col-12 col-md-6">
					<div class="checkout_details_area mt-50 clearfix">

						<div class="cart-page-heading mb-30">
							<h5>请输入登陆信息</h5>
						</div>

						<form action="login" method="post" id="loginForm">
							<div class="row">
								<div class="col-12 mb-3">
									<label for="first_name">用户名 <span>*</span></label> <input
										type="text" class="form-control" name="username" id="username" value=""
										required>
								</div>


								<div class="col-12 mb-3">
									<label for="street_address">密码 <span>*</span></label> <input
										type="password" name="password" class="form-control mb-3" id="password"
										value="">
								</div>


								<div class="col-12 mb-3">
									<a href="javascript:login()" class="btn essence-btn">登陆</a>
								</div>
							</div>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- ##### Checkout Area End ##### -->

	<%@ include file="foot.jsp"%>

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
	
	<script type="text/javascript">
		function login(){
		// $("#loginForm").submit();
		//ajax方式登陆
		var user=$("#username").val();
		var pass=$("#password").val();
		$.ajax({
			url:"login",
			type:"post",
			data:{usernamee:user,passwordd:pass},
			dataType:"json",
			success:function(data){
				if(data.code==0){
					//登陆成功
					location.href="index.jsp";
				}else{
					alert(data.msg);
				}
				console.log(data);
			},error:function(e,m){
				alert("错误:"+m);
			}
		});
		}
	</script>
</body>

</html>