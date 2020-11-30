<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>叩丁狼客户关系管理系统-登录</title>
  <link rel="stylesheet" href="/js/bootstrap/css/bootstrap.css">
  <link rel="stylesheet" href="/js/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="/js/Ionicons/css/ionicons.min.css">
  <link rel="stylesheet" href="/js/adminlte/css/AdminLTE.min.css">
  <link rel="stylesheet" href="/js/adminlte/css/skins/_all-skins.min.css">
  <link rel="stylesheet" href="/js/adminlte/css/fonts.googleapis.com.css">

  <script src="/js/jquery/jquery.min.js"></script>
  <script src="/js/bootstrap/js/bootstrap.js"></script>
  <script src="/js/adminlte/js/adminlte.min.js"></script>
  <script src="/js/plugins/twbsPagination/jquery.twbsPagination.min.js"></script>
  <script src="/js/plugins/messager/jquery.bootstrap.min.js"></script>
  <script src="/js/system/commonAll.js"></script>

  <link rel="stylesheet" href="/js/plugins/iCheck/square/blue.css">
  <script src="/js/plugins/iCheck/icheck.js"></script>
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="http://www.wolfcode.cn"><b>叩丁狼</b>CRM</a>
  </div>
  <span style="color: red">${errorMsg}</span>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">请输入账号密码</p>

    <form action="/login" method="post">
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="请输入账号" name="username" value="${cookie.name.value}">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="请输入密码" name="password">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      
      <div class="row">
        <div class="col-xs-8">
          	<input type="text" class="form-control"  placeholder="请输入验证码" name="randomCode">
        </div>
        <div class="col-xs-4">
          <script>
            function changeImg() {
                document.getElementById("randomCode").src = '/randomCode?'+ new Date();
            }
          </script>
          <img alt="验证码" id="randomCode" src="/randomCode" title="看不清换一张" onclick="changeImg()">
        </div>
      </div>
      
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox" name="remeberMe" value="true" ${cookie.name.value!=null?'checked':''}> 记住我
            </label>
          </div>
        </div>
        <div class="col-xs-4">
          	<input type="submit" class="btn btn-primary btn-block btn-flat submitBtn" value="登录">
        </div>
      </div>
    </form>


  </div>
</div>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' /* optional */
    });
  });
</script>
</body>
</html>
