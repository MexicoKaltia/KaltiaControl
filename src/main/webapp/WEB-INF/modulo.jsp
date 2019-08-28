<%@ include file="/layout/head.jsp"%>
<!-- ################################################################################################ -->
<link href="<%=request.getContextPath()%>/css/jquery.skeduler.min.css"
	rel="stylesheet" type="text/css" media="all">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/modulos.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

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
				<li><a href="inicio.htm">Inicio</a></li>
				<li class="active"><a href="#">Modulos</a>
				<li><a
					href="<c:url value="edicion.htm?action=${model.requestLoginVO.getEmpresaEntity().getIdAction()}"/>">Edicion</a>
					<%--           <li><a  href="${pageContext.request.contextPath}/estadistica.htm">Estadistica</a></li> --%>
					<%--           <li><a  href="<c:url value="edicion.htm?action=${model.get(requestLoginVO.getEmpresaEntity().getIdAction())}"/>">Edicion</a> --%>
					<!--           <li  class="active"><a href="../index.html">Inicio</a></li> -->
					<%--           <li><a class="drop" href="<c:url value="edicion.htm"/>">Edicion</a> --%>
					<%--           <li><a class="drop" href="${pageContext.request.contextPath}/edicion.htm">Estadistica</a></li> --%>
			</ul>
		</nav>
	</header>
</div>
<!-- ################################################################################################ -->
<div id="breadcrumb" class="hoc clear">
	<ul>
		<li><a href="#">KaltiaControl</a></li>
		<li><a href="#"><c:out
					value="${model.requestLoginVO.empresaEntity.getIdEmpresa()}" /></a></li>
		<li><a href="#"><c:out
					value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlNombre()}" /></a></li>
		<li><a href="#">Modulos</a></li>
	</ul>
</div>

<!-- ################################################################################################ -->
<div class="container auth" class="clear">
	<h1 class="text-rigth">Datos Generales Modulos</h1>
	<div id="big-form" class="well auth-box">
		<form>
			<fieldset>
				<div class="btn-group">
					<a href="#userEmpresa" class="btn btn-default">Usuarios <c:out
							value="${model.requestLoginVO.empresaEntity.getIdEmpresa()}" /></a> <a
						href="#citas" class="btn btn-default">Citas</a> <a href="#usuario"
						class="btn btn-default">Otros Modulos</a>
				</div>
			</fieldset>
		</form>
	</div>

	<!-- UserEmpresa -->
	<div class="animated rollIn slow">
		<div id="big-form" class="well auth-box">
			<form>
				<fieldset>
					<a id="userEmpresa"></a> <label class=" control-label"
						for="textinput">Usuarios Activos</label>
				</fieldset>
			</form>
		</div>
		<c:set var="count" value="${0}" />
		<c:forEach items="${model.requestLoginVO.userEmpresaEntity}"
			var="userEmpresaEntity">
			<div id="big-form" class="well auth-box">
				<form>
					<fieldset>
						<div class="form-group">
							<input id="textinput" name="nombreRegistro"
								placeholder="Nombre Completo" class="form-control input-md"
								type="text" readonly
								value="<c:out value="${userEmpresaEntity.getNombreRegistro()}"/> <c:out value="${userEmpresaEntity.getApellidoRegistro()}"/>">
							<input id="usuarioRegistro<c:out value = "${count}"/>"
								name="usuarioRegistro" placeholder="Usuario"
								class="form-control input-md" type="hidden" readonly
								value="<c:out value="${userEmpresaEntity.getUsuarioRegistro()}"/>">
							<input id="nombreRegistro<c:out value = "${count}"/>"
								name="nombreRegistro" placeholder="Nombre de Usuario"
								class="form-control input-md" type="hidden" readonly
								value="<c:out value="${userEmpresaEntity.getNombreRegistro()}"/>">
							<input id="apellidoRegistro<c:out value = "${count}"/>"
								name="apellidoRegistro" placeholder="Apelllido de Usuario"
								class="form-control input-md" type="hidden" readonly
								value="<c:out value="${userEmpresaEntity.getApellidoRegistro()}"/>">
							<input id="emailRegistro<c:out value = "${count}"/>"
								name="emailRegistro" placeholder="Email de Usuario"
								class="form-control input-md" type="hidden" readonly
								value="<c:out value="${userEmpresaEntity.getEmailRegistro()}"/>">
							<input id="telefonoRegistro<c:out value = "${count}"/>"
								name="telefonoRegistro" placeholder="Numero telefono de Usuario"
								class="form-control input-md" type="hidden" readonly
								value="<c:out value="${userEmpresaEntity.getTelefonoRegistro()}"/>">
							<a id="${count}" data-toggle="modal" data-target="#modalUser"
								class="btn btn-default userEmpresa">Ver Datos Completos</a>
						</div>
					</fieldset>
				</form>
			</div>
			<c:set var="count" value="${count+1}" />
		</c:forEach>
	</div>

	<div class="animated slideInLeft slow">
		<div id="big-form" class="well auth-box">
			<form>
				<fieldset>
					<a id="citas"></a> <label class=" control-label" for="textinput">Citas</label>
				</fieldset>
			</form>
		</div>
		<!--               <h1 style="margin:150px auto 30px auto; color:#fff;">jQuery Skeduler Plugin Example</h1> -->
		<button onclick="generate()">Presente Semana</button>
		<div id="skeduler-container">
			<input id="condiciones" name="condiciones"
				class="form-control input-md" type="hidden" readonly
				value="<c:out value="${model.requestLoginVO.datosCitasVO.getCondiciones()}"/>">
			<input id="mesActual" name="mesActual" class="form-control input-md"
				type="hidden" readonly
				value="<c:out value="${model.requestLoginVO.datosCitasVO.getMesActual()}"/>">
			<input id="mesPost" name="mesPost" class="form-control input-md"
				type="hidden" readonly
				value="<c:out value="${model.requestLoginVO.datosCitasVO.getMesPost()}"/>">
			<input id="idEmpresa" name="mesPost" class="form-control input-md"
				type="hidden" readonly
				value="<c:out value="${model.requestLoginVO.empresaEntity.getIdEmpresa()}"/>">
		</div>

	</div>
	<!-- fin de animated -->


	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div id="accordion" class="transparente">
<!--  -->	<h3>Usuarios / Clientes</h3>
		<div class="report">
			<div class="report-head ">
				<div class="marco">
					<h3>Status Usuarios</h3>
				</div>
				<div class="input-group marco report-head" style="width: 250px;">
					<input type="text" name="table_search" class="form-control" placeholder="Busqueda">
					<div class="input-group-append ">
						<button type="submit" class="btn btn-default">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
			</div>
						<!--report-head end-->
			<div class="report-body" data-spy="scroll" data-target="fijo" data-offset="50">
			  <div class="table-responsive">
				<table class="table table-striped table-hover table-fixed" >
					<thead class="thead-dark" style="width: 100%">
						<tr style="width: 100%">
							<th style="width: 20%">Id Usuario</th>
							<th style="width: 60%">Usuario</th>
							<th style="width: 10%">Status</th>
							<th style="width: 10%">Edicion</th>
							<th style="width: 10%">Eliminar</th>
						</tr>
					</thead>
					<tbody>					
					     <c:set var="count" value="${0}" />
						   <c:forEach items="${model.requestLoginVO.userEmpresaEntity}" var="userEmpresaEntity">
							<tr>
								<td><c:out value="${userEmpresaEntity.getUsuarioRegistro()}"/></td>
								<td><c:out value="${userEmpresaEntity.getNombreRegistro()}"/> <c:out value="${userEmpresaEntity.getApellidoRegistro()}"/></td>
								<td><a id="${count}" data-toggle="modal" data-target="#modalUser"class="btn btn-default userEmpresa"><i class="fa fa-cogs" aria-hidden="true"></i></a></td>
								<td><a id="${count}" data-toggle="modal" data-target="#modalUser"class="btn btn-default userEmpresa"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></td>
								<td><a id="${count}" data-toggle="modal" data-target="#modalUser"class="btn btn-default userEmpresa"><i class="fa fa-user-times" aria-hidden="true"></i></a></td>
							</tr>
						   <c:set var="count" value="${count+1}" />
						</c:forEach>
					</tbody>
				</table>
			</div>
			</div>
			<div>  
				  <div class="report-footer">
				    <span >
				    	<a id="" data-toggle="modal" data-target="#modalRegistro"class="btn btn-default"><i class="fa fa-user-plus" aria-hidden="true"></i></a>
				    </span>
				  </div>
			</div>
		</div>
		<h3>Section 2</h3>
		<div>
			<p>Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum
				sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris
				turpis porttitor velit, faucibus interdum tellus libero ac justo.
				Vivamus non quam. In suscipit faucibus urna.</p>
		</div>
		<h3>Section 3</h3>
		<div>
			<p>Nam enim risus, molestie et, porta ac, aliquam ac, risus.
				Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in
				pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac
				felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam
				nisi, eu iaculis leo purus venenatis dui.</p>
			<ul>
				<li>List item one</li>
				<li>List item two</li>
				<li>List item three</li>
			</ul>
		</div>
		<h3>Section 4</h3>
		<div>
			<p>Cras dictum. Pellentesque habitant morbi tristique senectus et
				netus et malesuada fames ac turpis egestas. Vestibulum ante ipsum
				primis in faucibus orci luctus et ultrices posuere cubilia Curae;
				Aenean lacinia mauris vel est.</p>
			<p>Suspendisse eu nisl. Nullam ut libero. Integer dignissim
				consequat lectus. Class aptent taciti sociosqu ad litora torquent
				per conubia nostra, per inceptos himenaeos.</p>
		</div>
	</div>
</div>
<!-- fin de div body -->






















<!-- MODAL   modalUserEmpresa -->
<div class="modal fade" id="modalUser" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content"
			style="background-image: url('http://kaltia-store.xyz/kaltia/modelo/modal/modalImagenFondo.jpg?v=1');">
			<div class="modal-header">
				<h5 class="modal-title" id="modalTitle">modalUser</h5>
				
				<button type="button" class="close" data-dismiss="modal" aria-label="Close" id="modal_btnClose">
					<span aria-hidden="true">&times;</span>
				</button>
				<div class="alerta">
					<hiden class="alerta_in"></hiden>
				</div>
			</div>
			<!--**********************************************************************************-->
			<div class="modal-body">
				<div class="container auth" class="clear">
					<div id="big-form" class="well auth-box">
						<form>
							<fieldset>
								<input id="usuarioRegistro" name="usuarioRegistro"
									placeholder="Nombre de Usuario" class="form-control input-md"
									type="text" readonly> <input id="nombreRegistro"
									name="nombreRegistro" placeholder="Nombre "
									class="form-control input-md" type="text"> <input
									id="apellidoRegistro" name="apellidoRegistro"
									placeholder="Apellido " class="form-control input-md"
									type="text"> <input id="emailRegistro"
									name="emailRegistro" placeholder="email "
									class="form-control input-md" type="email" value=""> <input
									id="telefonoRegistro" name="telefonoRegistro"
									placeholder="num telefono " class="form-control input-md"
									type="text" value="">
							</fieldset>
						</form>
					</div>
				</div>
			</div>
			<!--**********************************************************************************-->
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal"
					id="modalEdicionBody_btnClose">Cerrar</button>
				<button type="submit" class="btn btn-primary"
					id="modalEdicionHeaderSeccion2_btnSave">Guardar Cambios</button>
			</div>
		</div>
	</div>
</div>
<!-- fin modalUserEmpresa-->
<!-- modalRegistro -->
<div class="modal fade" id="modalRegistro" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content"
			style="background-image:url('http://kaltia-store.xyz/kaltia/modelo/modal/imagen.jpg?v=1');">
			<div class="modal-header">
				<label class="sizeEtiqueta colorLabel"><s:property value='identidadVO.empresa'/> - Registro Cliente</label>
				
				<button type="button" class="close" data-dismiss="modal" aria-label="Close" id="modal_btnClose">
					<span aria-hidden="true">&times;</span>
				</button>
					<div class="alerta">
						<hiden class="alerta_in"></hiden>
				</div>
			</div>
			<!--**********************************************************************************-->
			<div class="modal-body">
		                <form class="form-horizontal" method="post">
		                	<fieldset>
<!-- 		                    <legend class="text-center header"><label><s:property value='identidadVO.empresa'/> - Registo Cliente</label></legend> -->
		                    <div class="form-group row">
		                      <span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-user bigicon"></i></span>
		                      <div class="col-7">
		                        <input id="nombreRegistro"  name="name" type="text" placeholder="Nombre(s)" class="form-control" maxlength="40">
		                      </div>
		                    </div>
		                    <div class="form-group row">
		                      <span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-user bigicon"></i></span>
		                      <div class="col-7">
		                        <input id="apellidoRegistro" name="name" type="text" placeholder="Apellidos" class="form-control" maxlength="40">
		                      </div>
		                    </div>
		
		                    <div class="form-group row">
		                      <span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-envelope-o bigicon"></i></span>
		                      <div class="col-7">
		                        <input id="emailRegistro" name="email" type="email" placeholder="Email" class="form-control" maxlength="40">
		                      </div>
		                    </div>
		
		                    <div class="form-group row">
		                      <span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-phone-square bigicon"></i></span>
		                      <div class="col-7">
		                        <input id="telefonoRegistro" name="phone" type="tel" placeholder="Num Telefono" class="form-control" maxlength="20">
		                      </div>
		                    </div>
		                    <div class="form-group row">
					          <span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-address-book bigicon"></i></span>
					          <div class="col-7">
								<input type="text" id="usuarioRegistro" value="" placeholder="Digita Usuario" class="form-control" maxlength="11">
					          </div>
					        </div>
					        <div class="form-group row">
					          <span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-circle bigicon"></i></span>
					          <div class="col-7">
								<input type="password" id="passRegistro1" value="" placeholder="Password" class="form-control" maxlength="20">
					          </div>
					        </div>
					        <div class="form-group row">
					          <span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-circle bigicon"></i></span>
					          <div class="col-7">
								<input type="password" id="passRegistro2" value="" placeholder="Confirma Password" class="form-control" maxlength="20">
					          </div>
					        </div>
				
		                    <div class="form-group row">
		                      <span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-pencil-square-o bigicon"></i></span>
		                      <div class="col-7">
		                        <textarea class="form-control" id="messageRegistro" name="message" placeholder="Captura tu mensaje, en breve un asesor se pondrá en contacto. Gracias" rows="4"></textarea>
		                      </div>
		                    </div>		
		                </fieldset>
		                
		              </form>
		            
		      </div>
		      <!--**********************************************************************************-->
			<div class="modal-footer">
				<a href="#" data-dismiss="modal" class="btn" id="modal_btnClose">Cerrar</a>
				<a href="#" class="btn btn-primary" id="btnSaveRegistro">Guardar</a>
			</div>
		</div>
	</div>
</div>
<!-- FIN modalREGISTRO -->


<!-- JAVASCRIPTS -->
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.backtotop.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.mobilemenu.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/complementoBody2.js"></script>
<script src="<%=request.getContextPath()%>/js/modalPerfilE.js"></script>
<!-- <script src="//code.jquery.com/jquery-3.1.0.slim.min.js"></script> -->
<script src="<%=request.getContextPath()%>/js/jquery.skeduler.js"></script>
<script src="<%=request.getContextPath()%>/js/skeduler-container.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
    $( function() {
      $( "#accordion" ).accordion({
        collapsible: true
      });
    } );
    </script>


</body>
</html>