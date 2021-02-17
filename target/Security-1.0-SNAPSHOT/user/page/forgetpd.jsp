<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <title>登录</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- page style -->
    <style>

    </style>
    <!-- Bootstrap 3.3.7 -->
    <link href="../css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../css/font-awesome/font-awesome.min.css" rel="stylesheet">
    <!-- Ionicons -->
    <link href="../css/Ionicons/ionicons.min.css" rel="stylesheet">
    <!-- Theme style -->
    <link href="../css/AdminLTE/AdminLTE.min.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../css/iCheck/square/blue.css" rel="stylesheet">
    <!-- Google Font -->
    <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic"> -->
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="login.jsp"><b>证券交易系统</b></a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">用户忘记密码</p>

        <form action="<%=request.getContextPath()%>/servlet/ServletUserForgetPassdWord" method="post" id="forgetpd" name="forgetpd">

            <div class="form-group has-feedback">
                <input class="form-control"  id="Name" name="Name" type="text">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input class="form-control" id="phone" name="phone" type="text">
                <span class="glyphicon glyphicon-phone-alt form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input class="form-control" style="width: 70%;float: left;" id="code" name="code" type="text">
                &nbsp;
                <label class="glyphicon glyphicon-comment " id="auth_code" >获取验证码</label><br>
            </div><br>
            <div class="row">
                <!-- /.col -->
                <div class="col-xs-4">
                    <input class="btn btn-primary btn-block btn-flat" type="button" value="修改" onclick="button_login()">
                </div>
                <!-- /.col -->
            </div>
        </form>

        <!-- /.social-auth-links -->

    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 3 -->
<script src="../js/jquery/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../js/bootstrap/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="../js/iCheck/icheck.min.js"></script>
<!-- page script -->

<script>

    function button_login(){
        var Name=document.getElementById("Name");
        var Phone=document.getElementById("phone");
        var code=document.getElementById("code");


        $("#forgetpd").submit();
    }

    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });
</script>
</body>
</html>
