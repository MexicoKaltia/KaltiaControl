<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix ="fn" uri = "http://java.sun.com/jsp/jstl/functions"  %>
<%-- <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> --%>
<%-- <%@ taglib prefix="s" uri="/struts-tags"%> --%>



<html lang="es">
<head>
<title>KaltiaControl</title>
<meta charset="UTF-8" http-equiv="Content-Type" content="text/html">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="<%=request.getContextPath()%>/css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="<%=request.getContextPath()%>/css/complementoBody2.css" rel="stylesheet" type="text/css" media="all">
<link href="<%=request.getContextPath()%>/css/animate.css" rel="stylesheet" type="text/css" media="all">
<%-- <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" media="all"> --%>
</head>
<body id="top" style="background-image:url('<%=request.getContextPath()%>/images/imagen.jpg');">
<!-- ################################################################################################ -->
<!-- Top Background Image Wrapper -->
<!-- <div class="bgded overlay light" > -->
  <div class="wrapper row0">
    <div id="topbar" class="hoc clear"> 
      <div class="fl_left"> 
        <ul class="nospace">
          <li><i class="fa fa-phone"></i>55 1030 2411</li>
          <li><i class="fa fa-envelope-o"></i>bienvenido@kaltiaservicios.com</li>
        </ul>
      </div>
      <div class="fl_right"> 
        <ul class="nospace">
          <li><a href="#"><i class="fa fa-lg fa-home"></i></a></li>
          <li><a href="#" title="Centro de Ayuda"><i class="fa fa-life-bouy"></i></a></li>
          <li><a href="#" title="Escribir Comentario"><i class="fa fa-lg fa-sign-in"></i></a></li>
          <li><a href="#" title="Cerrar Sesion"><i class="fa fa-lg fa-edit"></i></a></li>
        </ul>
      </div>
    </div>
  </div>