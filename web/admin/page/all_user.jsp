<%@ page import="po.Users" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>所有证券</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- page style -->
  <style>

  </style>
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="../admin/css/bootstrap/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../admin/css/font-awesome/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="../admin/css/Ionicons/ionicons.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="../admin/css/datatables.net-bs/dataTables.bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../admin/css/AdminLTE/AdminLTE.min.css">
  <!-- AdminLTE Skin -->
  <link rel="stylesheet" href="../admin/css/AdminLTE/skin/skin-blue.min.css">
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
              <img src="../admin/img/setting.png" class="user-image" alt="User Image">
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
              <span class="hidden-xs">刘铁蛋</span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
                <img src="../admin/img/word.jpg" class="img-circle" alt="User Image">
                <p>让学习成为一种习惯</p>
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="password-change.html" class="btn btn-default btn-flat">修改密码</a>
                </div>
                <div class="pull-right">
                  <a href="login.html" class="btn btn-default btn-flat">退出</a>
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
      <ol class="breadcrumb">
        <li><i class="fa fa-dashboard">&nbsp;证券管理</i></li>
        <li class="active">所有订单</li>
      </ol>
    </section>
    <!-- Main content -->
    <section class="content container-fluid">
      <div class="box box-primary">
        <div class="box-body">
          <table id="my_order" class="table table-bordered table-striped">
            <thead>
            <tr>
              <th>用户id</th>
              <th>用户名称</th>
              <th>用户性别</th>
              <th>用户国籍</th>
              <th>用户职业</th>
              <th>用户工作单位</th>
              <th>用户联系电话</th>
              <th>详情</th>
            </tr>
            </thead>

            <tbody>


            <%

              ArrayList<Users> list= (ArrayList<Users>) request.getAttribute("list");
              //out.print("<script>alert('"+list.isEmpty()+"')</script>");
              //add(ele)   get(index)
              for (int i = 0; i < list.size(); i++) {
                Users users = list.get(i);
                //out.print("<script>alert('"+securitys.getRid()+"')</script>");
                if (i % 10 == 0) {

            %>
            <tr role="row" class="odd"><!--一行的开始  -->
              <%}%>
              <td><%= users.getUser_id()%></td>
              <td><%= users.getUser_name()%></td>
              <td><%= users.getUser_sex()%></td>
              <td><%= users.getUser_nationality()%></td>
              <td><%= users.getUser_profession()%></td>
              <td><%= users.getUser_workunit()%></td>
              <td><%= users.getUser_phone()%></td>
              <td><a href="/Security_war_exploded/servlet/ServletAdminFindUserSecurityInfo?deal_id=<%= users.getUser_id()%>">详情</a></td>

              <%--                            <td><a href="${pageContext.request.contextPath}/servlet/OrderDetailServlet?order_id=<%= securitys.getOrder_id()%>&flag=a">查看</a>丨<a href="${pageContext.request.contextPath}/servlet/OrderDetailServlet?order_id=<%= securitys.getOrder_id()%>&rid=<%= securitys.getRid()%>&flag=b">处理</a></td>--%>

            </tr>

            <%
              if (i % 10 == 9) {
            %>
            <!--一行的结束  -->


            <%
                }

              }
            %>

            </tbody>
            <tfoot>
            <tr>
              <th>用户id</th>
              <th>用户名称</th>
              <th>用户性别</th>
              <th>用户国籍</th>
              <th>用户职业</th>
              <th>用户工作单位</th>
              <th>用户联系电话</th>
              <th>详情</th>

            </tr>
            </tfoot>
          </table>
        </div>
        <!-- /.box-body -->
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
<script src="../admin/js/jquery/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../admin/js/bootstrap/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="../admin/js/datatables.net/jquery.dataTables.min.js"></script>
<script src="../admin/js/datatables.net-bs/dataTables.bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="../admin/js/AdminLTE/adminlte.min.js"></script>
<script>
  $(function () {
    $('#my_order').DataTable({
      'paging'      : true,
      'lengthChange': false,
      'searching'   : false,
      'ordering'    : false,
      'info'        : true,
      'autoWidth'   : false,
      'pagingType': 'full_numbers'
    })
  })
</script>
</body>
</html>
