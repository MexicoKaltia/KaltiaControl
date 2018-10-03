<%@ include file="/layout/head.jsp" %>
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
<body id="top">
	<!-- ################################################################################################ -->
	<!-- Top Background Image Wrapper -->
	<div class="bgded overlay light"
		style="background-image:url('<%=request.getContextPath()%>/images/imagen.jpg');">
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
						<li><a href="#" title="Help Centre"><i
								class="fa fa-life-bouy"></i></a></li>
						<li><a href="#" title="Login"><i
								class="fa fa-lg fa-sign-in"></i></a></li>
						<li><a href="#" title="Sign Up"><i
								class="fa fa-lg fa-edit"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- ################################################################################################ -->
		<div class="wrapper row1">
			<header id="header" class="hoc clear">
				<div id="logo" class="fl_left">
					<h1>
						<a href="#">K A L T I A Control</a>
					</h1>
				</div>
				<nav id="mainav" class="fl_right">
					<ul class="clear">
						<li ><a href="<c:url value="/login.htm"/>">Inicio</a></li>
						<li class="active"><a href="#">Edicion</a>
						<li><a href="${pageContext.request.contextPath}/estadistica.htm">Estadistica</a></li>
							
					</ul>
				</nav>
			</header>
		</div>
		<!-- ################################################################################################ -->
		<div id="breadcrumb" class="hoc clear">
			<ul>
				<li><a href="#">KaltiaControl</a></li>
				<li><a href="#"><c:out value="${modelEdicion.requestLoginVO.getEmpresaEntity().getIdEmpresa()}"/></a></li>
				<li><a href="#"><c:out value="${modelEdicion.requestLoginVO.getUserKaltiaControlEntity().getIdUserKaltiaControlUser().toString()}"/></a></li>
				<li><a href="#">Edicion</a></li>
			</ul>
		</div>
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<div>
							<iframe src="http://www.kaltia.xyz/<c:out value="${modelEdicion.requestLoginVO.getEmpresaEntity().getIdAction()}"/>?tipo=AAA"
								onload="autofitIframe(this);"></iframe>
		</div>
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<div class="clearfix"></div>
	</div>

	<!-- JAVASCRIPTS -->
	<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.mobilemenu.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	
</body>
</html>