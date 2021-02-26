<%@ include file="/layout/head.jsp"%>
<!-- ################################################################################################ -->
<link href="<%=request.getContextPath()%>/css/jquery.skeduler.min.css" rel="stylesheet" type="text/css" media="all">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/modulos.css">
<link rel="stylesheet"	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-table.css">
<!-- <link href="https://unpkg.com/bootstrap-table@1.15.4/dist/bootstrap-table.min.css" rel="stylesheet"> -->


<!-- ################################################################################################ -->
<div class="wrapper row1">
<div class="alerta"><hiden class="alerta_in"></hiden></div>
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
		<li><a href="#"><c:out value="${model.requestLoginVO.empresaEntity.getIdEmpresa()}" /></a></li>
		<li><a href="#"><c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlNombre()}" /></a></li>
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
	</div>

	<div class="animated slideInLeft slow">
<!-- 		<div id="big-form" class="well auth-box"> -->
<!-- 			<form> -->
<!-- 				<fieldset> -->
<!-- 					<a id="citas"></a> <label class=" control-label" for="textinput">Citas</label> -->
<!-- 				</fieldset> -->
<!-- 			</form> -->
<!-- 		</div> -->
<!-- 		<!--               <h1 style="margin:150px auto 30px auto; color:#fff;">jQuery Skeduler Plugin Example</h1> --> -->
<!-- 		<button onclick="generate()">Presente Semana</button> -->
<!-- 		<div id="skeduler-container"> -->
<!-- 			<input id="condiciones" name="condiciones" -->
<!-- 				class="form-control input-md" type="hidden" readonly -->
<%-- 				value="<c:out value="${model.requestLoginVO.datosCitasVO.getCondiciones()}"/>"> --%>
<!-- 			<input id="mesActual" name="mesActual" class="form-control input-md" -->
<!-- 				type="hidden" readonly -->
<%-- 				value="<c:out value="${model.requestLoginVO.datosCitasVO.getMesActual()}"/>"> --%>
<!-- 			<input id="mesPost" name="mesPost" class="form-control input-md" -->
<!-- 				type="hidden" readonly -->
<%-- 				value="<c:out value="${model.requestLoginVO.datosCitasVO.getMesPost()}"/>"> --%>
<!-- 			<input id="idEmpresa" name="mesPost" class="form-control input-md" -->
<!-- 				type="hidden" readonly -->
<%-- 				value="<c:out value="${model.requestLoginVO.empresaEntity.getIdEmpresa()}"/>"> --%>
<!-- 		</div> -->

	</div>
	<!-- fin de animated -->


	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div id="accordion" class="transparente">
	<h3 class="modulo">Usuarios / Clientes</h3>
		<div class="report">
			<div class="report-head ">
				<div class="marco">
					<h2 class="modulo">Status Usuarios</h2>
				</div>
			</div>
						<!--report-head end-->
						<!-- data-url='http://localhost:8010/readUserEmpresa/modelo/0' -->
			<div class="report-body" data-offset="50">
			  <div class="table-responsive">
				<table id='userEmpresaTable'
  						data-locale="es-MX"
						data-toggle='table' 
						data-height='460' 
						data-sort-name='statusRegistro' 
						data-sort-order='asc' 
						data-pagination='true'
  						data-page-list='[10, 25, 50, 100, 200, Todos]'
  						data-search='true'
  						data-click-to-select='true'
  						data-checkbox-header="false"
  						>
					<thead class='thead-dark'>
						<tr>
<!-- 							<th data-width="10" data-width-unit="%" data-field="state" data-checkbox="true"></th> -->
							<th data-width="30" data-width-unit="%" data-halign="center" data-align="left" data-field='nombreRegistro' data-sortable='true'>Nombre</th>
							<th data-width="30" data-width-unit="%" data-halign="center" data-align="left" data-field='apellidoRegistro' data-sortable='true'>Apellidos</th>
							<th data-width="20" data-width-unit="%" data-halign="center" data-align="left" data-field='statusRegistro' data-sortable='true'>Status</th>
							<th data-width="10" data-width-unit="%" data-halign="center" data-align="left" data-field="operateUpdate" data-formatter="operateFormatterUpdate" data-events="window.operateEventsUpdate">Editar</th>
							<th data-width="10" data-width-unit="%" data-halign="center" data-align="left" data-field="operateDelete" data-formatter="operateFormatterDelete" data-events="operateEventsDelete">Eliminar</th>
						</tr>
					</thead>
<!-- 					<tbody>					 -->
					    
<!-- 					</tbody> -->
				</table>
			</div>
			</div>
			<div>  
				  <div class="report-footer">
				    <span >
				    	<a id="addUser" data-toggle="modal" data-target="#modalRegistro"class="btn btn-default addUserEmpresaBtn"><i class="fa fa-2x fa-user-plus" aria-hidden="true"></i></a>
				    </span>
				  </div>
			</div>
		</div>
		<h3>Section 2</h3>
		<div>
			<p><iframe src="http://www.kaltia.xyz/seguros" onload="autofitIframe(this);"></iframe></p>
		</div>
		<h3>Section 3</h3>
		<div>
			<div class="embed-responsive embed-responsive-16by9">
			  <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/v64KOxKVLVg" allowfullscreen></iframe>
			</div>
		</div>
		<h3>Calendario</h3>
		<div>
			<div class="embed-responsive embed-responsive-16by9">
			  <iframe class="embed-responsive-item" src="<%=request.getContextPath()%>/layout/calendario.html" allowfullscreen></iframe>
			</div>
		</div>
		
   	</div> <!-- fin de div accordion -->
</div><!-- fin de div body -->


<!-- modalRegistro -->
<div class="modal fade" id="modalRegistro" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content" style="background-image:url('http://kaltiastore.xyz/kaltia/modelo/modal/imagen.jpg?v=1');">
			<div class="modal-header">
				<label class="sizeEtiqueta colorLabel">- Registro Cliente -</label>
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
<!-- 				<div id="big-form" class="well auth-box"> -->
		                <form class="form-horizontal" method="post">
		                	<fieldset>
							<div class="form-group row">
		                      <span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-user-plus bigicon"></i></span>
		                      <div class="col-7">
		                        <input id="idUserEmpresa" name="name" type="text" placeholder="id User" class="form-control input-md" maxlength="40" readonly >
		                      </div>
		                    </div>
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
		                        <input id="telefonoRegistro" name="phone" type="text" placeholder="Num Telefono" class="form-control" maxlength="20">
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
<!-- 		            </div> -->
		           </div>
		      </div>
		      <!--**********************************************************************************-->
			<div class="modal-footer">
				<a href="#" data-dismiss="modal" class="btn" id="modal_btnClose">Cerrar</a>
				<a href="#modalRegistro" class="btn btn-primary" id="btnSaveRegistro">Guardar</a>
			</div>
		</div>
	</div>
</div>
<!-- FIN modalREGISTRO -->











<div>
	<input type="hidden" id="idEmpresa" value="<c:out value="${model.requestLoginVO.empresaEntity.getIdEmpresa()}" />" />
	<input type="hidden" id="idAction" value="<c:out value="${model.requestLoginVO.empresaEntity.getIdAction()}" />" />
</div>

<!-- JAVASCRIPTS -->

<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.backtotop.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.mobilemenu.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.skeduler.js"></script>
<script src="<%=request.getContextPath()%>/js/skeduler-container.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script src="<%=request.getContextPath()%>/js/complementoBody2.js"></script>
<%-- <script src="<%=request.getContextPath()%>/js/modalPerfilE.js"></script> --%>
<script src="<%=request.getContextPath()%>/js/modulo.js"></script>

<script src="<%=request.getContextPath()%>/js/bootstrap-table.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap-table-locale-all.js"></script>
<!-- <script src="https://unpkg.com/bootstrap-table@1.15.4/dist/bootstrap-table.min.js"></script> -->
<!-- <script src="https://unpkg.com/bootstrap-table@1.15.4/dist/bootstrap-table-locale-all.min.js"></script> -->



<script type="text/javascript">
</script>


<script>
    $( function() {
      $( "#accordion" ).accordion({
        collapsible: true
      });
    } );        	
</script>


</body>
</html>