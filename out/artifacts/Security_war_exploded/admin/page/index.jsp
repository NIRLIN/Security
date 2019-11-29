<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <title>主页</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- page style -->
    <style>
        .my_content {
            padding-top: 18%;
            text-align: center;
            font-size: 28px;
            /*background: #f00;*/
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
        response.setHeader("refresh", "0.1;url=" + request.getContextPath() + "/admin/page/login.html");
    }
%>
<div class="wrapper">

    <!-- Main Header -->
    <header class="main-header">

        <!-- Logo -->
        <a class="logo" href="index.jsp">
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
                                    <a class="btn btn-default btn-flat" href="password-change.html">修改密码</a>
                                </div>
                                <div class="pull-right">
                                    <a class="btn btn-default btn-flat" href="/Security_war_exploded/servlet/ServletDestroyLogin">退出</a>
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
                        <li><a href="/Security_war_exploded/servlet/ServletAdminFindAllSecurity">所有证券</a></li>
                        <li><a href="/Security_war_exploded/servlet/ServletAdminAllDeal">交易证券</a></li>
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
                        <li><a href="/Security_war_exploded/servlet/ServletAdminAllUser">所有用户</a></li>
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

        </section>

        <!-- Main content -->
        <section class="content container-fluid" style="margin-top: 20px;">
            <div class="my_content">
                欢迎使用！
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
