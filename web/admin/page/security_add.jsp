<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>添加证券</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- page style -->
  <style>
  .my-input{
    width: 33.33333333% !important;
  }
  .my-input-file{
    display: inline-block !important;
    width: 0;
		position:absolute;
		clip:rect(0px,0px,0px,0px);
  }
  .datepicker{
    z-index: 9999 !important;
  }
  </style>
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="../css/bootstrap/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../css/font-awesome/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="../css/Ionicons/ionicons.min.css">
  <!-- bootstrap datepicker -->
  <link rel="stylesheet" href="../css/bootstrap-datepicker/bootstrap-datepicker.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../css/AdminLTE/AdminLTE.min.css">
  <!-- AdminLTE Skin -->
  <link rel="stylesheet" href="../css/AdminLTE/skin/skin-blue.min.css">
  <!-- Google Font -->
  <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic"> -->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
  <header class="main-header">

    <!-- Logo -->
    <a href="#" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>证券</b></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg">证券交易系统</span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">导航切换</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
          <!-- /.messages-menu -->
          <!-- User Account Menu -->
          <li class="dropdown user user-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <!-- The user image in the navbar-->
              <img src="../img/setting.png" class="user-image" alt="User Image">
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
              <span class="hidden-xs">刘铁蛋</span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
                <img src="../img/word.jpg" class="img-circle" alt="User Image">
                <p>让学习成为一种习惯</p>
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="password-change.html" class="btn btn-default btn-flat">修改密码</a>
                </div>
                <div class="pull-right">
                  <a href="login.jsp" class="btn btn-default btn-flat">退出</a>
                </div>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">

      <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar Menu -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">&nbsp;</li>
        <!-- Optionally, you can add icons to the links -->
        <li class="treeview">
          <a href="#"><i class="fa fa-link"></i> <span>证券管理</span>
            <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="<%=request.getContextPath()%>/servlet/ServletAdminFindAllSecurity">所有证券</a></li>
            <li><a href="<%=request.getContextPath()%>/servlet/ServletAdminAllDeal">交易证券</a></li>
            <li><a href="../admin/page/security_add.jsp">添加证券</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#"><i class="fa fa-link"></i> <span>用户管理</span>
            <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="<%=request.getContextPath()%>/servlet/ServletAdminAllUser">所有用户</a></li>
            <li><a href="add_user.jsp">添加用户</a></li>
          </ul>
        </li>
      </ul>
      <!-- /.sidebar-menu -->
    </section>
      <!-- /.sidebar -->
    </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1><small></small></h1>
      <ol class="breadcrumb">
        <li><i class="fa fa-dashboard">&nbsp;证券管理</i></li>
        <li class="active">添加证券</li>
      </ol>
    </section>
    <!-- Main content -->
    <section class="content container-fluid">
      <!-- Horizontal Form -->
      <div class="box box-primary">
        <div class="box-header with-border">
          <h3 class="box-title">证券信息录入</h3>
        </div>
        <!-- /.box-header -->
        <!-- form start -->
        <form class="form-horizontal"  action="<%=request.getContextPath()%>/servlet/ServletAdminAddSecurity" method="post" >
          <div class="box-body">
            <div class="form-group">
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="securitys_id" id="securitys_id" readonly placeholder="证券编号">
              </div>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="securitys_short" id="securitys_short" placeholder="证券简称">
              </div>
               <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="securitys_companyname" id="securitys_companyname" placeholder="证券公司名称">
              </div>
            </div>



            <div class="form-group">
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="securitys_phone" id="securitys_phone" placeholder="证券公司电话">
              </div>
              <div class="col-sm-10 my-input">
              <input type="text" class="form-control" name="securitys_unitprice" id="securitys_unitprice" placeholder="证券单价/股">
            </div>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="securitys_residualquantity" id="securitys_residualquantity" placeholder="证券剩余量（股）">
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="securitys_totalquantity" id="securitys_totalquantity" placeholder="证券总量（股）">
              </div>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="securitys_address" id="securitys_address" placeholder="证券公司地址">
              </div>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="securitys_appeardata" id="securitys_appeardata" placeholder="证券公司上市日期">
              </div>
            </div>
            </div>
            <div class="form-group">
            	<div class="col-sm-10">
            	<span id="info"></span>
            	</div>
            </div>

          <!-- /.box-body -->
          <div class="box-footer">
            <input type="submit" class="btn btn-primary pull-right" value="提交">
          </div>
          <!-- /.box-footer -->
        </form>
      </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="pull-right hidden-xs">
      缔造年轻人的中国梦
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2021 <span>gues</span>.</strong> All rights reserved.
  </footer>

  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="../js/jquery/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../js/bootstrap/bootstrap.min.js"></script>
<!-- bootstrap datepicker -->
<script src="../js/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
<script src="../js/bootstrap-datepicker/bootstrap-datepicker.zh-CN.min.js"></script>
<!-- AdminLTE App -->
<script src="../js/AdminLTE/adminlte.min.js"></script>
<!-- page script -->
<script>
//Date picker
$('#securitys_appeardata').datepicker({
  language: 'zh-CN',
  todayHighlight: true,
  format: 'yyyy-mm-dd',
  autoclose: true
});

$('#isbn').blur(function(){
	var isbn = $("#isbn").val();
    if (isbn == null || isbn == "") {
        $("#info").text("isbn不能为空！");
        $("#info").css("color","red");
        return false;
    }

});

</script>
</body>
</html>
