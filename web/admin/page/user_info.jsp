<%@ page import="po.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <meta charset="utf-8">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <title>商品详情</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- page style -->
    <style>
        .my-input {
            width: 22.77777778% !important;
        }

        .my-label {
            width: 10.55555555% !important;
        }

        .my-img {
            padding-right: 2.0% !important;
            padding-left: 8.0% !important;
        }

        .datepicker {
            z-index: 9999 !important;
        }
    </style>
    <!-- Bootstrap 3.3.7 -->
    <link href="${pageContext.request.contextPath}/user/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath}/user/css/font-awesome/font-awesome.min.css" rel="stylesheet">
    <!-- Ionicons -->
    <link href="${pageContext.request.contextPath}/user/css/Ionicons/ionicons.min.css" rel="stylesheet">
    <!-- Theme style -->
    <link href="${pageContext.request.contextPath}/user/css/AdminLTE/AdminLTE.min.css" rel="stylesheet">
    <!-- AdminLTE Skin -->
    <link href="${pageContext.request.contextPath}/user/css/AdminLTE/skin/skin-blue.min.css" rel="stylesheet">
    <!-- Google Font -->
    <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic"> -->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<%
    String name = (String) request.getSession().getAttribute("admin_name");
    if (name == null) {
        response.getWriter().write("<script>alert('警告！请登录，点击返回返回登录页面！')</script>");
        response.setHeader("refresh", "0.1;url=" + request.getContextPath() + "/user/page/login.jsp");
    }
%>
<div class="wrapper">

    <!-- Main Header -->
    <header class="main-header">

        <!-- Logo -->
        <a class="logo" href="../user/page/index.jsp">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>证券</b></span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg">证券交易系统</span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a class="sidebar-toggle" data-toggle="push-menu" href="#" role="button">
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
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <!-- The user image in the navbar-->
                            <img alt="User Image" class="user-image" src="${pageContext.request.contextPath}/user/img/setting.png">
                            <!-- hidden-xs hides the username on small devices so only the image appears. -->
                            <span class="hidden-xs"><%= name%></span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- The user image in the menu -->
                            <li class="user-header">
                                <img alt="User Image" class="img-circle" src="${pageContext.request.contextPath}/user/img/word.jpg">
                                <p>让学习成为一种习惯</p>
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="../user/page/password-change.html" class="btn btn-default btn-flat">修改密码</a>
                                </div>
                                <div class="pull-right">
                                    <a class="btn btn-default btn-flat" href="<%=request.getContextPath()%>/servlet/ServletDestroyLogin">退出</a>
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
                        <li><a href="security_add.jsp">添加证券</a></li>
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
                <li><i class="fa fa-dashboard">&nbsp;个人信息</i></li>
                <li><i class="fa"></i>信息查看</li>

            </ol>
        </section>
        <!-- Main content -->
        <section class="content container-fluid" style="margin-top: 30px;">
            <%
                Users user=(Users)request.getAttribute("user");
//                out.print("<script>alert('"+user.getUser_id()+"')</script>");
            %>
            <!-- Horizontal Form -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">详细信息</h3>
                </div>
                <!-- /.box-header -->
                <!-- form start -->
                <form class="form-horizontal" role="form" method="post" action="<%=request.getContextPath()%>/servlet/ServletAdminUpdateUser">
                    <div class="box-body">
                        <div class="form-group">
                            <label class="col-sm-2 control-label my-label" for="user_id">用户id</label>
                            <div class="col-sm-10 my-input">
                                <input class="form-control" id="user_id" name="user_id" readonly  type="text" value="<%=user.getUser_id()%>">
                            </div>
                            <label class="col-sm-2 control-label my-label" for="user_name">用户姓名</label>
                            <div class="col-sm-10 my-input">
                                <input class="form-control" id="user_name" name="user_name"   type="text" value="<%=user.getUser_name()%>">
                            </div>
                            <label class="col-sm-2 control-label my-label" for="user_sex">用户性别</label>
                            <div class="col-sm-10 my-input">
                                <input class="form-control" id="user_sex" name="user_sex"   type="text" value="<%=user.getUser_sex()%>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label my-label" for="user_nationality">用户国籍</label>
                            <div class="col-sm-10 my-input">
                                <input class="form-control" id="user_nationality" name="user_nationality"   type="text" value="<%=user.getUser_nationality()%>">
                            </div>
                            <label class="col-sm-2 control-label my-label" for="user_balance">用户余额</label>
                            <div class="col-sm-10 my-input">
                                <input class="form-control" id="user_balance" name="user_balance"  readonly  type="text" value="<%=user.getUser_balance()%>">
                            </div>
                            <label class="col-sm-2 control-label my-label" for="user_profession">用户职业</label>
                            <div class="col-sm-10 my-input">
                                <input class="form-control" id="user_profession" name="user_profession"   type="text" value="<%=user.getUser_profession()%>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label my-label" for="user_workunit">工作单位</label>
                            <div class="col-sm-10 my-input">
                                <input class="form-control" id="user_workunit" name="user_workunit"   type="text" value="<%=user.getUser_workunit()%>">
                            </div>
                            <label class="col-sm-2 control-label my-label" for="user_phone">联系电话</label>
                            <div class="col-sm-10 my-input">
                                <input class="form-control" id="user_phone" name="user_phone"   type="text" value="<%=user.getUser_phone()%>">
                            </div>
                            <label class="col-sm-2 control-label my-label" for="user_idcard">身份证号</label>
                            <div class="col-sm-10 my-input">
                                <input class="form-control" id="user_idcard" name="user_idcard"   type="text" value="<%=user.getUser_idcard()%>">
                            </div>

                        </div>

                    </div>
                    <!-- /.box-body -->
                    <div class="box-footer">
                        <input type="submit" class="btn btn-primary pull-right"  value="修改">
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
<script src="${pageContext.request.contextPath}/user/js/jquery/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${pageContext.request.contextPath}/user/js/bootstrap/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/user/js/AdminLTE/adminlte.min.js"></script>
<!-- page script -->
<script>

</script>
</body>
</html>
