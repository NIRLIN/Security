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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/user/css/bootstrap/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/user/css/font-awesome/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/user/css/Ionicons/ionicons.min.css">
  <!-- bootstrap datepicker -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/user/css/bootstrap-datepicker/bootstrap-datepicker.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/user/css/AdminLTE/AdminLTE.min.css">
  <!-- AdminLTE Skin -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/user/css/AdminLTE/skin/skin-blue.min.css">
  <!-- Google Font -->
  <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic"> -->
</head>
<body class="hold-transition skin-blue sidebar-mini">

<%
  String name = (String) request.getSession().getAttribute("name");
  if (name == null) {
    response.getWriter().write("<script>alert('警告！请登录，点击返回返回登录页面！')</script>");
    response.setHeader("refresh", "0.1;url=" + request.getContextPath() + "/user/page/login.jsp");
  }
%>

<div class="wrapper">

  <!-- Main Header -->
  <header class="main-header">

    <!-- Logo -->
    <a href="../user/page/index.jsp" class="logo">
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
              <img src="${pageContext.request.contextPath}/user/img/setting.png" class="user-image" alt="User Image">
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
              <span class="hidden-xs"><%= name%></span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
                <img src="${pageContext.request.contextPath}/user/img/word.jpg" class="img-circle" alt="User Image">
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
          <a href="#"><i class="fa fa-link"></i> <span>证券查看</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="<%=request.getContextPath()%>/servlet/ServletAllFind">所有证券</a></li>
            <li><a href="<%=request.getContextPath()%>/servlet/ServletHaveSecurity">已购证券</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#"><i class="fa fa-link"></i> <span>个人信息</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="<%=request.getContextPath()%>/servlet/ServletFindOneUserInfo">信息查看</a></li>
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
      int HaveSecurity= (int) request.getAttribute("HaveSecurity");
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
        <form class="form-horizontal" id="fm-add" role="form" action="" method="post" enctype="multipart/form-data">
          <div class="box-body">
            <div class="form-group">
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="securitys_id" id="securitys_id" readonly placeholder="证券编号"  value="证券id：<%=securitys.getSecuritys_id() %>">
              </div>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="securitys_short" id="securitys_short" readonly  placeholder="证券简称" value="证券简称：<%=securitys.getSecuritys_short()%>">
              </div>
               <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="securitys_companyname" id="securitys_companyname" readonly placeholder="证券公司名称" value="证券公司名称：<%=securitys.getSecuritys_companyname()%>">
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-10 my-input">
              <input type="text" class="form-control" name="securitys_unitprice" id="securitys_unitprice" readonly placeholder="证券单价/股" value="证券单价/股：<%=securitys.getSecuritys_unitprice()%>">
            </div>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="securitys_residualquantity" id="securitys_residualquantity" readonly placeholder="证券剩余量（股）" value="证券剩余量（股）：<%=securitys.getSecuritys_residualquantity()%>">
              </div>
                <div class="col-sm-10 my-input">
                    <input type="text" class="form-control" name="securitys_totalquantity" id="securitys_totalquantity" readonly placeholder="证券总量（股）" value="证券总量（股）：<%=securitys.getSecuritys_totalquantity()%>">
                </div>

            </div>
            <div class="form-group">
                <div class="col-sm-10 my-input">
                    <input type="text" class="form-control" name="phone" id="phone" readonly placeholder="证券公司电话" value="证券公司电话：<%=securitys.getSecuritys_phone()%>">
                </div>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="address" id="address" readonly placeholder="证券公司地址" value="证券公司地址：<%=securitys.getSecuritys_address()%>">
              </div>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="appeardata" id="appeardata" readonly placeholder="证券公司上市日期" value="证券公司上市日期：<%=securitys.getSecuritys_appeardata()%>">
              </div>

            </div>
              <div class="form-group">
                  <div class="col-sm-10 my-input">
                      <input type="text" class="form-control" name="havesecuritys" id="havesecuritys" readonly placeholder="持有证券数量" value="个人持有量：<%=HaveSecurity%>">
                  </div>
                  <div class="col-sm-10 my-input">
                      <input type="text" class="form-control" name="intent" id="intent" readonly value="请选择是否进行购入（为0则不购入）:">
                  </div>
                  <div class="col-sm-10 my-input">
                      <li style="list-style: none;">
                          <ul class="count" style="list-style: none;margin-top: -5px;margin-left: -30px;">
                              <li><span id="num-jian" class="num-jian"  style="float: left; border: solid 1px #9bd2ed;background-color: #9bd2ed;width: 25px;height: 26px;">-</span></li>
                              <li><input type="text" class="input-num" id="input-num" name="input-num" value="0" style="float: left;width: 40px;height: 26px;"/></li>
                              <li><span id="num-jia" class="num-jia" style="float: left; border: solid 1px #9bd2ed;background-color: #9bd2ed;width: 25px;height: 26px;">+</span></li>
                          </ul>
                      </li>
                  </div>
              </div>

                <script>

                    var num_jia = document.getElementById("num-jia");
                    var num_jian = document.getElementById("num-jian");
                    var input_num = document.getElementById("input-num");
                    var securitys_residualquantity1 = document.getElementById("securitys_residualquantity");
                    var securitys_residualquantity=securitys_residualquantity1.value.split("：")[1];

                    num_jia.onclick = function() {
                        if (parseInt(securitys_residualquantity)<0){
                            input_num.value=0;
                        }
                        else if (parseInt(input_num.value)>=parseInt(securitys_residualquantity)){
                            input_num.value=securitys_residualquantity;

                        }else {
                            input_num.value = parseInt(input_num.value) + 1;
                        }
                    }

                    num_jian.onclick = function() {

                        if(input_num.value <= 0) {
                            input_num.value = 0;
                        } else {

                            input_num.value = parseInt(input_num.value) - 1;
                        }

                    }
                </script>

            </div>
            <div class="form-group">
            	<div class="col-sm-10">
            	<span id="info"></span>
            	</div>
            </div>

          <!-- /.box-body -->
          <div class="box-footer">
            <input type="button" class="btn btn-primary pull-right" onclick="button_panduan()" value="购入/返回">
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
<!-- bootstrap datepicker -->
<script src="${pageContext.request.contextPath}/user/js/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/user/js/bootstrap-datepicker/bootstrap-datepicker.zh-CN.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/user/js/AdminLTE/adminlte.min.js"></script>
<!-- page script -->
<script>
    function button_panduan() {
        var deal_count = parseInt(document.getElementsByName("input-num")[0].value);
        var securitys_id1 = (document.getElementsByName("securitys_id")[0].value).split("：");
        var securitys_id =securitys_id1[1];

        var securitys_residualquantity2 = document.getElementById("securitys_residualquantity");
        var securitys_residualquantity3=securitys_residualquantity2.value.split("：")[1];

        var link="?securitys_id="+securitys_id+"&deal_count="+deal_count;
        if (deal_count==0||parseInt(securitys_residualquantity3)<parseInt(deal_count)){
            alert("操作错误！");
             window.location.href = 'http://localhost:8080<%=request.getContextPath()%>/servlet/ServletAllFind';
        }else {
            window.location.href = 'http://localhost:8080<%=request.getContextPath()%>/servlet/ServletUserBuySecurity'+link;
        }
    }

//Date picker
$('#published').datepicker({
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
                window.location.href =  "${pageContext.request.contextPath}/user/page/product-add.html";
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
