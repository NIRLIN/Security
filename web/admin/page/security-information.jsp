<%@ page import="po.Securitys" %>
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
  <link rel="stylesheet" href="<%=request.getContextPath()%>/admin/css/bootstrap/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/admin/css/font-awesome/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/admin/css/Ionicons/ionicons.min.css">
  <!-- bootstrap datepicker -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/admin/css/bootstrap-datepicker/bootstrap-datepicker.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/admin/css/AdminLTE/AdminLTE.min.css">
  <!-- AdminLTE Skin -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/admin/css/AdminLTE/skin/skin-blue.min.css">
  <!-- Google Font -->
  <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic"> -->
</head>
<body class="hold-transition skin-blue sidebar-mini">

<%
  String name = (String) request.getSession().getAttribute("admin_name");
  if (name == null) {
    response.getWriter().write("<script>alert('警告！请登录，点击返回返回登录页面！')</script>");
    response.setHeader("refresh", "0.1;url=" + request.getContextPath() + "/admin/page/login.jsp");
  }
%>

<div class="wrapper">

  <!-- Main Header -->
  <header class="main-header">

    <!-- Logo -->
    <a href="<%=request.getContextPath()%>/admin/page/index.jsp" class="logo">
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
              <img src="<%=request.getContextPath()%>/admin/img/setting.png" class="user-image" alt="User Image">
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
              <span class="hidden-xs"><%= name%></span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
                <img src="<%=request.getContextPath()%>/admin/img/word.jpg" class="img-circle" alt="User Image">
                <p>让学习成为一种习惯</p>
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="<%=request.getContextPath()%>/admin/admin/page/password-change.html" class="btn btn-default btn-flat">修改密码</a>
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
            <li><a href="../admin/page/add_user.jsp">添加用户</a></li>

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
        <li><i class="fa fa-dashboard">&nbsp;证券查看</i></li>
        <li>所有证券</li>
        <li class="active">证券详情</li>
      </ol>
    </section>
    <%
      Securitys securitys= (Securitys) request.getAttribute("securitys");
      //out.print("<script>alert('+securitys.getSecuritys_id()+')</script>");
    %>

    <!-- Main content -->
    <section class="content container-fluid" style="margin-top: 20px;">
      <!-- Horizontal Form -->
      <div class="box box-primary">
        <div class="box-header with-border">
          <h3 class="box-title">证券详细信息</h3>
        </div>

        <!-- /.box-header -->
        <!-- form start -->
        <form class="form-horizontal" id="fm-add" name="fm-add" role="form" action="<%=request.getContextPath()%>/servlet/ServletAdminAUpdateSecurity" method="post" >
          <div class="box-body">
            <div class="form-group">
              <div class="col-sm-10 my-input">
                  <span style="float: left; width: 35%;font-size: 20px;">证券id:</span>
                  <input type="text" style="width: 65%;" class="form-control" name="securitys_id" id="securitys_id" readonly placeholder="证券编号"  value="<%=securitys.getSecuritys_id() %>">
              </div>
              <div class="col-sm-10 my-input">
                  <span style="float: left; width: 35%;font-size: 20px;">证券简称:</span>
                  <input type="text" style="width: 65%;" class="form-control" name="securitys_short" id="securitys_short"   placeholder="证券简称" value="<%=securitys.getSecuritys_short()%>">
              </div>
               <div class="col-sm-10 my-input">
                   <span style="float: left; width: 35%;font-size: 20px;">证券公司名称:</span>
                   <input type="text" style="width: 65%;" class="form-control" name="securitys_companyname" id="securitys_companyname"  placeholder="证券公司名称" value="<%=securitys.getSecuritys_companyname()%>">
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-10 my-input">
                  <span style="float: left; width: 35%;font-size: 20px;">证券单价/股:</span>
                  <input type="text" style="width: 65%;" class="form-control" name="securitys_unitprice" id="securitys_unitprice"  placeholder="证券单价/股" value="<%=securitys.getSecuritys_unitprice()%>">
            </div>
              <div class="col-sm-10 my-input">
                  <span style="float:  left; width: 35%;font-size: 20px;">证券剩余量（股）:</span>

                  <input type="text"  style="width: 65%;" class="form-control" name="securitys_residualquantity" id="securitys_residualquantity"  placeholder="证券剩余量（股）" value="<%=securitys.getSecuritys_residualquantity()%>">
              </div>
                <div class="col-sm-10 my-input">
                    <span style="float: left; width: 35%;font-size: 20px;">证券总量（股）:</span>
                    <input type="text" style="width: 65%;" class="form-control" name="securitys_totalquantity" id="securitys_totalquantity"  placeholder="证券总量（股）" value="<%=securitys.getSecuritys_totalquantity()%>">
                </div>

            </div>
            <div class="form-group">
                <div class="col-sm-10 my-input">
                    <span style="float: left; width: 35%;font-size: 20px;">证券公司电话:</span>
                    <input type="text"  style="width: 65%;" class="form-control" name="securitys_phone" id="securitys_phone"  placeholder="证券公司电话" value="<%=securitys.getSecuritys_phone()%>">
                </div>
              <div class="col-sm-10 my-input">
                  <span style="float: left; width: 35%;font-size: 20px;">证券公司地址:</span>
                  <input type="text" style="width: 65%;" class="form-control" name="securitys_address" id="securitys_address"  placeholder="证券公司地址" value="<%=securitys.getSecuritys_address()%>">
              </div>
              <div class="col-sm-10 my-input">
                  <span style="float: left; width: 35%;font-size: 20px;">证券上市日期:</span>
                  <input type="text"style="width: 65%;" class="form-control" name="securitys_appeardata" id="securitys_appeardata"  placeholder="证券上市日期" value="<%=securitys.getSecuritys_appeardata()%>">
              </div>

            </div>

            <div class="form-group">
            	<div class="col-sm-10">
            	<span id="info"></span>
            	</div>
            </div>

          <!-- /.box-body -->
          <div class="box-footer">
            <input type="button" class="btn btn-primary pull-right"  id="but" onclick="button_panduan()" value="保存">
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
<script src="<%=request.getContextPath()%>/admin/js/jquery/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="<%=request.getContextPath()%>/admin/js/bootstrap/bootstrap.min.js"></script>
<!-- bootstrap datepicker -->
<script src="<%=request.getContextPath()%>/admin/js/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
<script src="<%=request.getContextPath()%>/admin/js/bootstrap-datepicker/bootstrap-datepicker.zh-CN.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/admin/js/AdminLTE/adminlte.min.js"></script>
<!-- page script -->
<script>
    function button_panduan() {

        var securitys_id=document.getElementById("securitys_id");
        var securitys_short=document.getElementById("securitys_short");


        var securitys_companyname=document.getElementById("securitys_companyname");
        var securitys_unitprice=document.getElementById("securitys_unitprice");
        var securitys_residualquantity=document.getElementById("securitys_residualquantity");
        var securitys_totalquantity=document.getElementById("securitys_totalquantity");
        var securitys_address=document.getElementById("securitys_address");
        var securitys_phone=document.getElementById("securitys_phone");
        var securitys_appeardata=document.getElementById("securitys_appeardata");
        if (securitys_id.value===""||securitys_short.value===""||securitys_companyname.value===""||securitys_unitprice.value===""||securitys_residualquantity.value===""||securitys_totalquantity.value===""||securitys_address.value===""||securitys_phone.value===""||securitys_appeardata.value===""){
            alert("信息不可为空！");
            return
        }

        document.getElementById("fm-add").submit();

    }

//Date picker
$('#appeardata').datepicker({
  language: 'zh-CN',
  todayHighlight: true,
  format: 'yyyy-mm-dd',
  autoclose: true
});

$('#index').change(function () {
    var str = $(this).val();
    var fileName = str.substring(str.lastIndexOf("\\") + 1);
    // var fileExt = str.substring(str.lastIndexOf('.') + 1);
    // alert(fileName);
    $('#indexfile').html(fileName);
});

$('#intro').change(function () {
    var str = $(this).val();
    var fileName = str.substring(str.lastIndexOf("\\") + 1);
    $('#introfile').html(fileName);
});

$('#collect').change(function () {
    var str = $(this).val();
    var fileName = str.substring(str.lastIndexOf("\\") + 1);
    $('#collectfile').html(fileName);
});

$('#detail1').change(function () {
    var str = $(this).val();
    var fileName = str.substring(str.lastIndexOf("\\") + 1);
    $('#detail1file').html(fileName);
});

$('#detail2').change(function () {
    var str = $(this).val();
    var fileName = str.substring(str.lastIndexOf("\\") + 1);
    $('#detail2file').html(fileName);
});

$('#detail3').change(function () {
    var str = $(this).val();
    var fileName = str.substring(str.lastIndexOf("\\") + 1);
    $('#detail3file').html(fileName);
});

$('#detail1big').change(function () {
    var str = $(this).val();
    var fileName = str.substring(str.lastIndexOf("\\") + 1);
    $('#detail1bigfile').html(fileName);
});

$('#detail2big').change(function () {
    var str = $(this).val();
    var fileName = str.substring(str.lastIndexOf("\\") + 1);
    $('#detail2bigfile').html(fileName);
});

$('#detail3big').change(function () {
    var str = $(this).val();
    var fileName = str.substring(str.lastIndexOf("\\") + 1);
    $('#detail3bigfile').html(fileName);
});

$('#isbn').focus(function(){
	$('#info').html('&nbsp;');
});



$('#bt-submit').click(function(){
    //读取用户的输入——表单序列化
    var formData = new FormData($('#fm-add').get(0));
    console.log(formData);
    //异步提交请求，进行验证
    $.ajax({
    	async: true,
        type: 'POST',
        url: 'productAdd.action',
        data: formData,
        processData: false,// 不对数据进行转换
        contentType: false,// 避免jQuery对contentType操作，失去请求头分界符，使服务器不能正常解析文件
        success: function(txt, msg, xhr){
            if(txt=='yes'){  //成功
            	alert("添加成功！");
                window.location.href =  "<%=request.getContextPath()%>/admin/page/product-add.html";
            }else{ //失败
                $('#info').html('添加失败！');
                $("#info").css("color","red");
                $('#bt-submit').attr("disabled",false);
            }
        }
    });
    $('#bt-submit').attr("disabled",true);
});
</script>
</body>
</html>
