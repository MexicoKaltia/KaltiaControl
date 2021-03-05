<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix ="fn" uri = "http://java.sun.com/jsp/jstl/functions"  %>
<html>
<head>
<title>KaltiaControl</title>
<meta charset="utf-8">
<meta name="viewport"	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="<%=request.getContextPath()%>/css/bootstrap.css"	rel="stylesheet" type="text/css" media="all">
<link href="<%=request.getContextPath()%>/css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="<%=request.getContextPath()%>/css/complementoBody2.css" rel="stylesheet" type="text/css" media="all">
<style type="text/css">
/*     html, body, div, iframe { margin:0; padding:0; height:100%; } */
    iframe {  width:100%; border:none; margin:0; padding:0; height:100%;}
</style>
<script language="JavaScript">
	//Ajusta el tamaño de un iframe al de su contenido interior para evitar scroll
	function autofitIframe(id) {
		if (!window.opera && document.all && document.getElementById) {
			id.style.height = id.contentWindow.document.body.scrollHeight;
		} else if (document.getElementById) {
			id.style.height = id.contentDocument.body.scrollHeight + "px";
		}
	}
</script>

</head>
		<!-- ################################################################################################ -->
		<div>
<%-- 							<iframe src="http://www.kaltia.xyz/<c:out value="${modelEdicion.requestLoginVO.getEmpresaEntity().getIdAction()}"/>?tipo=AAA"  onload="autofitIframe(this);"></iframe> --%>
							<iframe src="http://www.kaltia.xyz/<c:out value="${modelEdicion.contexto}"/>?tipo=AAA"  onload="autofitIframe(this);"></iframe>
		</div>
		<!-- ################################################################################################ -->
	<div class="nospace inline pushright">
            <a href="<c:url value="inicio.htm"/>" class="btn btn-default">Salir de Edicion</a>
            <a href="" class=""> </a>
            <a href="<c:url value="inicio.htm"/>" class="btn btn-default">Salir de Sesion</a>
            </div>
	<!-- JAVASCRIPTS -->
	<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.mobilemenu.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	
</body>
</html>