<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/layout/head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<head>
<title>KaltiaControl</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<%-- <link href="<%=request.getContextPath()%>/css/layout.css" rel="stylesheet" type="text/css" media="all"> --%>
</head>
</head>
<body>

Prueba 2
<p><c:out value="${modelEdicion.requestLoginVO.empresaEntity.getEmpresaNombreCompleto()}"/></p>
		<div class="embed-responsive embed-responsive-21by9">
			<iframe class="embed-responsive-item" src="<%=request.getContextPath()%>/layout/frame/header.jsp"  frameborder="0" width="978" allowfullscreen></iframe>
		</div>
		<div class="embed-responsive embed-responsive-21by9">
			<iframe class="embed-responsive-item" src="<%=request.getContextPath()%>/layout/frame/body2.jsp" frameborder="0" allowfullscreen></iframe>
		</div>
		<div class="embed-responsive embed-responsive-1by1">
			<iframe class="embed-responsive-item" src="<%=request.getContextPath()%>/layout/frame/footer.jsp"  frameborder="0" allowfullscreen></iframe>
		</div>

<!-- JAVASCRIPTS -->
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.backtotop.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.mobilemenu.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/complemento.js"></script>

</body>
</html>