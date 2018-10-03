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
        <h1><a href="#">K A L T I A Control</a></h1>
      </div>
      <nav id="mainav" class="fl_right">
        <ul class="clear">
          <li  class="active"><a href="<c:url value="login.htm"/>">Inicio</a></li>
          <li><a  href="#">Alta</a>
          <li><a  href="${pageContext.request.contextPath}/estadistica.htm">Estadistica</a></li>
           <%--           <li><a  href="<c:url value="edicion.htm?action=${model.get(requestLoginVO.getEmpresaEntity().getIdAction())}"/>">Edicion</a> --%>
          <li  class="active"><a href="../index.html">Inicio</a></li>
          <li><a class="drop" href="<c:url value="edicion.htm"/>">Edicion</a>
          <li><a class="drop" href="${pageContext.request.contextPath}/edicion.htm">Estadistica</a></li>
        </ul>
        </ul>
      </nav>
    </header>
  </div>
  <!-- ################################################################################################ -->
  <div id="breadcrumb" class="hoc clear"> 
    <ul>
    		    <li><a href="#">KaltiaControl</a></li>
				<li><a href="#"><c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlNombre()}"/></a></li>
    		    <li><a href="#">Alta Empresa</a></li>
    </ul>
  </div>

<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="container auth" class="clear">
    <h1 class="text-rigth">ALTA Datos Generales Empresa</h1>
    <div id="big-form" class="well auth-box">
      <form  class="" action="empresaAlta.htm" method="post" modelAttribute="empresaEntity">
        <fieldset>
          <div class="btn-group">
            <a href="#general" class="btn btn-default">General</a>
            <a href="#status" class="btn btn-default">Status</a>
            <a href="#usuario" class="btn btn-default">Usuarios</a>
          </div>
          <!-- Text input-->
          <div class="form-group">
			
            <a  id="general"></a>
            <label class=" control-label" for="textinput">General</label>
              <input id="empresaNombreCompleto" name="empresaNombreCompleto" placeholder="Nombre de Empresa Completo" class="form-control input-md" type="text" >
              <input id="idEmpresa" name="idEmpresa" placeholder="Nombre Corto" class="form-control input-md" type="text"   >
              <input id="IdAction" name="IdAction" placeholder="IdAction" class="form-control input-md" type="text"  >
              <input id="empresaRFC" name="empresaRFC" placeholder="RFC" class="form-control input-md" type="text"  >
              <input id="empresaDireccion" name="empresaDireccion" placeholder="Direccion" class="form-control input-md" type="text"  >
              <input id="empresaEmail" name="empresaEmail" placeholder="Email" class="form-control input-md" type="text"  >
              <input id="empresaContacto" name="empresaContacto" placeholder="Contacto" class="form-control input-md" type="text"  >
              <input id="empresaIdPerfilI" name="empresaIdPerfilI" placeholder="Representante Kaltia" class="form-control input-md" type="text" readonly value="<c:out value="${modelAlta.requestLoginVO.getUserKaltiaControlEntity().getIdUserKaltiaControlUser().toString()}"/>">
<!--               <input id="empresaModelo" name="empresaModelo" placeholder="Modelo" class="form-control input-md" type="text"  > -->
              <label class=" control-label" for="selectbasic">Modelo</label>
	            <div class="">
	              <select id="empresaModelo" name="empresaModelo" class="form-control">
	                <option value="bronea">Bronea</option>
	                <option value="pendiente">Pendiente</option>
	              </select>
	            </div>
              <br>
              
              <a id="status"></a>
             	<label class=" control-label" for="textinput">Status</label>
              	<br>	
              <input id="empresaStatus" name="empresaStatus" placeholder="Status" class="form-control input-md" type="text" readonly value="Inicio" >
              <input id="empresaFechaCorte" name="empresaFechaCorte" placeholder="Fecha de Corte" class="form-control input-md" type="text"  readonly> 
<%--               readonly value="<c:out value="${modelAlta.requestLoginVO.empresaEntity.getEmpresaFechaCorte()}"/>"> --%>
<!--               <input id="empresaModoPago" name="empresaModoPago" placeholder="Modo de Pago" class="form-control input-md" type="text"  > -->
              <label class=" control-label" for="selectbasic">Modo de Pago</label>
	            <div class="">
	              <select id="empresaModoPago" name="empresaModoPago" class="form-control">
	                <option value="efectivo">Deposito a Cuenta / Efectivo</option>
	                <option value="transaccion">Transaccion Interbancaria</option>
	              </select>
	            </div>
              <input id="empresaFactura" name="empresaFactura" placeholder="Factura" class="form-control input-md" type="text"  readonly>
<!--               <input id="empresaVarios" name="empresaVarios" placeholder="Varios" class="form-control input-md" type="text"  > -->
               <label class=" control-label" for="textarea">Varios</label>
	            <div class="">                     
	              <textarea class="form-control" id="empresaVarios" name="empresaVarios">Separar los campos con el caracter '|' .</textarea>
	            </div>
              <br>
              
              <a id="usuario"></a>
	             <label class=" control-label" for="textinput">Usuario</label>
	              <input id="empresaIdPerfilE" name="empresaIdPerfilE" placeholder="Usuario Kaltia Control" class="form-control input-md" type="text">
	              <input id="userKaltiaControlPass" name="userKaltiaControlPass" placeholder="Password" class="form-control input-md" type="password">
	              <input id="userKaltiaControlPass1" name="userKaltiaControlPass1" placeholder="Confirma Password" class="form-control input-md" type="password">
	              <br>

              <br>
			  <br>
			  <br>
			  
	            <label class=" control-label" for="singlebutton">Datos Correctos</label>
	            <div class="">
	              <button class="btn btn-lg btn-primary btn-block" type="submit">Guardar</button>
<!-- 	          </form:form> -->
	          </div>
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
<script src="<%=request.getContextPath()%>/js/complemento.js"></script>

</body>
</html>