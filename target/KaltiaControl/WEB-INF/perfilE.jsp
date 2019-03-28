<%@ include file="/layout/head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>KaltiaControl</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="<%=request.getContextPath()%>/css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="<%=request.getContextPath()%>/css/complementoBody2.css" rel="stylesheet" type="text/css" media="all">
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
          <li><a href="#"><i class="fa fa-lg fa-home"></i></a></li>
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
        <h1><a href="#">K A L T I A Control</a></h1>
      </div>
      <nav id="mainav" class="fl_right">
        <ul class="clear">
          <li  class="active"><a href="#">Inicio</a></li>
          <li><a  href="<c:url value="edicion.htm?action=${model.requestLoginVO.getEmpresaEntity().getIdAction()}"/>">Edicion</a>
          <li><a  href="${pageContext.request.contextPath}/estadistica.htm">Estadistica</a></li>
        </ul>
      </nav>
    </header>
  </div>
  <!-- ################################################################################################ -->
  <div id="breadcrumb" class="hoc clear"> 
    <ul>
    		    <li><a href="#">KaltiaControl</a></li>
				<li><a href="#"><c:out value="${model.requestLoginVO.empresaEntity.getIdEmpresa()}"/></a></li>
				<li><a href="#"><c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlNombre()}"/></a></li>
    		    <li><a href="#">Inicio</a></li>
    </ul>
  </div>

<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="container auth" class="clear">
    <h1 class="text-rigth">Datos Generales Empresa</h1>
    <div id="big-form" class="well auth-box">
      <form>
        <fieldset>
          <div class="btn-group">
            <a href="#general" class="btn btn-default">General</a>
            <a href="#usuarios" class="btn btn-default">Usuarios</a>
            <a href="#status" class="btn btn-default">Status</a>
          </div>
          <!-- Text input-->
          <div class="form-group">

            <a  id="general"></a>
            <label class=" control-label" for="textinput">General</label>
              <input id="textinput" name="empresaNombreCompleto" placeholder="Nombre de Empresa Completo" class="form-control input-md" type="text" readonly value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaNombreCompleto()}"/>">
              <input id="textinput" name="Nombre Corto" placeholder="Nombre Corto" class="form-control input-md" type="text"  readonly value="<c:out value="${model.requestLoginVO.empresaEntity.getIdEmpresa()}"/>">
              <input id="textinput" name="IdAction" placeholder="IdAction" class="form-control input-md" type="text" readonly value="<c:out value="${model.requestLoginVO.empresaEntity.getIdAction()}"/>">
              <input id="textinput" name="RFC" placeholder="RFC" class="form-control input-md" type="text" readonly value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaRFC()}"/>">
              <input id="textinput" name="Direccion" placeholder="Direccion" class="form-control input-md" type="text" readonly value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaDireccion()}"/>">
              <input id="textinput" name="email" placeholder="email" class="form-control input-md" type="text" readonly value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaEmail()}"/>">
              <input id="textinput" name="contacto" placeholder="contacto" class="form-control input-md" type="text" readonly value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaContacto()}"/>">
              <input id="textinput" name="representante" placeholder="representante" class="form-control input-md" type="text" readonly value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaIdPerfilI()}"/>">
              <input id="textinput" name="modelo" placeholder="Modelo" class="form-control input-md" type="text" readonly value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaModelo()}"/>">
              <input id="textinput" name="status" placeholder="Status" class="form-control input-md" type="text" readonly value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaStatus()}"/>">
              <input id="textinput" name="fechaCorte" placeholder="Fecha de Corte" class="form-control input-md" type="text" readonly value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaFechaCorte()}"/>">
              <input id="textinput" name="modoPago" placeholder="Modo de Pago" class="form-control input-md" type="text" readonly value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaModoPago()}"/>">
              <input id="textinput" name="factura" placeholder="Factura" class="form-control input-md" type="text" readonly value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaFactura()}"/>">
              
              
              <br>
             
             <a id="usuarios"></a>
             	<label class=" control-label" for="textinput">Usuarios</label>
              	<br>
              
              <a id="status"></a>
	             <label class=" control-label" for="textinput">Status</label>
	              <input id="textinput" name="status" placeholder="status" class="form-control input-md" type="text">
	              <input id="textinput" name="modo de pago" placeholder="modo de pago" class="form-control input-md" type="text">
	              <input id="textinput" name="fecha de corte" placeholder="fecha de corte" class="form-control input-md" type="text">
	              <br>
              
              <label class=" control-label" for="textinput">Factura</label> 
              <input id="textinput" name="link Factura" placeholder="link Factura" class="form-control input-md" type="text">
              
			  <br>
			  <br>
			  <br>
			  
	          </div>
<!--     section     -->
     	   </fieldset>
     	 </form>
		</div>
     <div class="clearfix"></div>
   </div>
   </div>
<!-- JAVASCRIPTS -->
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.backtotop.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.mobilemenu.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/complementoBody2.js"></script>

</body>
</html>