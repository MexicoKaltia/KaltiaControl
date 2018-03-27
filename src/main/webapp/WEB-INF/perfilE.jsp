<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="">
<head>
<title>KaltiaControl</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="<%=request.getContextPath()%>/css/layout.css" rel="stylesheet" type="text/css" media="all">
</head>
<body id="top">
<!-- ################################################################################################ -->
<!-- Top Background Image Wrapper -->
<div class="bgded overlay light" style="background-image:url('<%=request.getContextPath()%>/images/imagen.jpg');"> 
  <div class="wrapper row0">
    <div id="topbar" class="hoc clear"> 
      <div class="fl_left"> 
        <ul class="nospace">
          <li><i class="fa fa-phone"></i> +00 (123) 456 7890</li>
          <li><i class="fa fa-envelope-o"></i> info@domain.com</li>
        </ul>
      </div>
      <div class="fl_right"> 
        <ul class="nospace">
          <li><a href="../index.html"><i class="fa fa-lg fa-home"></i></a></li>
          <li><a href="#" title="Help Centre"><i class="fa fa-life-bouy"></i></a></li>
          <li><a href="#" title="Login"><i class="fa fa-lg fa-sign-in"></i></a></li>
          <li><a href="#" title="Sign Up"><i class="fa fa-lg fa-edit"></i></a></li>
        </ul>
      </div>
    </div>
  </div>
  <!-- ################################################################################################ -->
  <div class="wrapper row1">
    <header id="header" class="hoc clear"> 
      <div id="logo" class="fl_left">
        <h1><a href="../index.html">K A L T I A Control</a></h1>
      </div>
      <nav id="mainav" class="fl_right">
        <ul class="clear">
          <li  class="active"><a href="../index.html">Inicio</a></li>
          <li><a class="drop" href="#">Edicion</a>
          <li><a class="drop" href="#">Estadistica</a></li>
        </ul>
      </nav>
    </header>
  </div>
  <!-- ################################################################################################ -->
  <div id="breadcrumb" class="hoc clear"> 
    <ul>
      <li><a href="#">KaltiaControl</a></li>
      <li><a href="#">IdEmpresa</a></li>
      <li><a href="#">User</a></li>
      <li><a href="#">Inicio</a></li>
    </ul>
  </div>
</div>
  <!-- ################################################################################################ -->
<!-- JAVASCRIPTS -->
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.backtotop.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.mobilemenu.js"></script>
</body>
</html>