<%@ include file="/layout/head.jsp" %>

  <!-- ################################################################################################ -->
<%--   <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-table.css"> --%>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.18.2/dist/bootstrap-table.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/font-awesome.min.css">

    <div class="wrapper row1">
    <header id="header" class="hoc clear"> 
      <div id="logo" class="fl_left">
        <h1><a href="#">K A L T I A Control</a></h1>
      </div>
      <nav id="mainav" class="fl_right">
        <ul class="clear">
          <li  class="active"><a href="#">Inicio</a></li>  
          <li><a href="<c:url value="alta.htm"/>">Alta Empresa</a></li>
          <li><a href="<c:url value="usuarios.htm"/>">Usuarios</a></li>
<%--           <li><a  href="<c:url value="edicion.htm?action=${model.requestLoginVO.empresaEntity.getIdAction()}"/>">Consulta</a> --%>
<%--           <li><a  href="${pageContext.request.contextPath}/estadistica.htm">Estadistica</a></li> --%>
        </ul>
      </nav>
    </header>
  </div>
  <!-- ################################################################################################ -->
  <!-- ################################################################################################ -->
  <div id="breadcrumb" class="hoc clear"> 
    <ul>
        <li><a href="#">KaltiaControl</a></li>
    	<li><a href="#"><c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlNombre()}"/></a></li>
        <li><a href="#">Inicio</a></li>
    </ul>
  </div>
    <c:if test='${actualiza}'>
    <span> 
		<div class="alert alert-success" role="alert" id="dataError">
		<b>Revisión : </b><u>Cliente Actualizó con Exito</u>
		</div>
	</span>
	</c:if>
    <c:if test='${errorActualiza}'>
    <span> 
		<div class="alert alert-danger" role="alert" id="dataError">
		<b>Revisión : </b><u>Error en Actualizacion de Cliente</u>
		</div>
	</span>
	</c:if>
	<c:if test='${delete}'>
    <span> 
		<div class="alert alert-success" role="alert" id="dataError">
		<b>Revisión : </b><u>Clientes Actualizados con Exito</u>
		</div>
		<script>
		windows.location.reload();
		</script>
	</span>
	</c:if>

<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="container auth" class="clear">
    <h1 class="text-rigth">Datos Generales Usuario</h1>
    <div  class="well auth-box">
      <form>
        <fieldset>
          <div class="btn-group">
            <a href="#usuario" class="btn btn-default">Usuario</a>
            <a href="#infoEmpresa" class="btn btn-default">Informacion Empresa</a>
          </div>
           </fieldset>
     	 </form>
		</div>
    
    <div  class="well auth-box">
      <form>
        <fieldset>
          <!-- Text input-->
          <div class="form-group">
            <a  id="usuario"></a>
            <label class=" control-label" for="textinput"><c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlNombre()}"/></label>
            <hr><br>
              <input  name="idUser" placeholder="Id User" class="form-control input-md" type="text" readonly value="<c:out value="${model.requestLoginVO.userKaltiaControlEntity.getIdUserKaltiaControlUser()}"/>">
              <input  name="perfil" placeholder="Perfil" class="form-control input-md" type="text"  readonly value="<c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlPerfil()}"/>">
              <input  name="descripcion" placeholder="Descripcion" class="form-control input-md" type="text"  readonly value="<c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlDescr()}"/>">
              <input  name="domicilio" placeholder="Domicilio" class="form-control input-md" type="text"  readonly value="<c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlDomicilio()}"/>">
              <input  name="correo" placeholder="Correo" class="form-control input-md" type="text"  readonly value="<c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlCorreo()}"/>">
              <input  name="contacto" placeholder="Contacto" class="form-control input-md" type="text"  readonly value="<c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlContacto()}"/>">
              <br>
              </div>
     	   </fieldset>
     	 </form>
		</div>
		
	<div  class="well auth-box">
      <form>
        <fieldset>
          <div class="form-group">
             <a id="infoEmpresa"></a>
             	<label class=" control-label" for="textinput">Relacion de Empresas</label>
             </div>
     	   </fieldset>
     	 </form>
		</div>
		<hr>
		<div id="divClientes">
			
								<!--  
                    	SECCION DE EDICION  
                    -->
					<!-- 
                     			iNICIO DE SECCION TABLA
                  			-->
								<div class="form-row">
						<div class="col-md-12 mb-3">
							<div class="main-card mb-3 card">
								<div class="card-body">
									<h5 class="card-title">Kaltia Control - CLIENTES </h5>

									<table id='clientesTable' class="mb-0 table table-striped table-sm bg-blue"
										data-locale="es-MX" 
										data-toggle='table' 
										data-sort-name='empresaStatus'
										data-search='true' 
										data-sort-order='asc'
										data-pagination='true'
										data-page-list='[10, 25, 50, 100, 200, Todos]'
										data-detail-view="true"
  										data-detail-formatter="detailFormatter">
										<thead class='thead-dark'>
											<tr>
												<th data-width="30" data-width-unit="%" data-halign="center" data-align="center" data-field='empresaNombreCorto' data-sortable='true'>Nombre Corto</th>
												<th data-width="10" data-width-unit="%" data-halign="center" data-align="center" data-field='idAction' data-sortable='true'>Id Action</th>
												<th data-width="10" data-width-unit="%" data-halign="center" data-align="center" data-field='empresaIdPerfilI' data-sortable='true'>Integrador</th>
												<th data-width="10" data-width-unit="%" data-halign="center" data-align="center" data-field='empresaStatus' data-sortable='true'>Status</th>
												<th data-width="10" data-width-unit="%" data-halign="center" data-align="center" data-field="operateUpdateCliente" data-formatter="operateFormatterUpdateCliente" data-events="window.operateEventsUpdateCliente"> Cliente</th>
												<th data-width="10" data-width-unit="%" data-halign="center" data-align="center" data-field="operateUpdateModulos" data-formatter="operateFormatterUpdateModulos" data-events="window.operateEventsUpdateModulos"> Modulos</th>
												<th data-width="10" data-width-unit="%" data-halign="center" data-align="center" data-field="operateUpdateSitioWeb" data-formatter="operateFormatterUpdateSitioWeb" data-events="window.operateEventsUpdateSitioWeb"> Sitio Web</th>
												<th data-width="10" data-width-unit="%" data-halign="center" data-align="center" data-field="operateUpdateMenuQR" data-formatter="operateFormatterUpdateMenuQR" data-events="window.operateEventsUpdateMenuQR"> Menu QR</th>
												<th data-width="10" data-width-unit="%" data-halign="center" data-align="center" data-field="operateDelete" data-formatter="operateFormatterDelete" data-events="window.operateEventsDelete">Eliminar</th>
<!-- 												<th data-width="20" data-width-unit="%" data-halign="center" data-align="center" data-field="operateDelete" data-formatter="operateFormatterDelete" data-events="window.operateEventsDelete">Eliminar</th> -->
											</tr>
										</thead>					
									</table>
									<script>
									  function detailFormatter(index, row) {
									    var html = []
									    $.each(row, function (key, value) {
									      html.push('<p><b>' + key + ':</b> ' + value + '</p>')
									    })
									    return html.join('')
									  }
									</script>
								
								</div>
								<!-- FIN DE SECCION TABLA                  			-->
							</div>
						</div>
					</div>
					
				<!--  FIN DE SECCION DE EDICION     -->
		</div>
             <hr>


     
   </div>
<!--  </div> -->
<input id="empresas" name="empresas"  type="hidden"  value="<c:out value="${model.requestLoginVO.jsonArray.clientes}"/>">
<input id="productos" name="productos"  type="hidden"  value="<c:out value="${model.requestLoginVO.jsonArray.productos}"/>">
<script >
var productos = document.getElementById("productos").value; 
	productos = JSON.parse(productos);
var $data = document.getElementById("empresas").value;
 	$data = JSON.parse($data);
</script>

<!-- JAVASCRIPTS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.backtotop.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.mobilemenu.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>


<script type="text/javascript" src="<%=request.getContextPath()%>/js/tableClientes.js"></script>

<script src="<%=request.getContextPath()%>/js/bootstrap-table.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap-table-es-MX.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<!-- <script src="https://unpkg.com/bootstrap-table@1.18.2/dist/bootstrap-table.min.js"></script> -->
<!-- Latest compiled and minified Locales -->
<!-- <script src="https://unpkg.com/bootstrap-table@1.18.2/dist/locale/bootstrap-table-zh-CN.min.js"></script> -->
    
<%-- <script src="<%=request.getContextPath()%>/js/complementoBody2.js"></script> --%>

</body>
</html>



<!-- --------------------------------------------------------------------------------------------------------------- -->
  <!-- Modal EMPRESA-->
  <div class="modal fade" id="modalEdicionCliente" role="dialog">
    <div class="modal-dialog modal-lg">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="background-color: #F1FFFE">
          <div class="logo-src2" ><img width="90%"  alt=""></div>
          <h4 position: center">Edicion Cliente</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span></h4>
        </div>
        <div class="modal-body" style="padding:40px 50px; ">	
	        <div id="divEdicion">
	        	<form  class="" action="actualizaCliente.htm" method="post" modelAttribute="empresaEntity" >
	            	<div id="big-form" class="well auth-box">
	            	<fieldset>
	            	<input id="idEmpresa"  type="hidden" name="idEmpresa">
	            	<input id="empresaIdPerfilI"  type="hidden" name="empresaIdPerfilI">
	            	
								<div class="form-group row">
									<span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-user"></i>Nombre Completo</span>
									<div class="col-7">
										<input id="empresaNombreCompleto" name="empresaNombreCompleto" placeholder="Nombre de Empresa Completo" class="form-control input-md" type="text" required maxlength="200" >
									</div>
								</div>
								<div class="form-group row">
									<span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-asterisk"></i>IdAction</span>
									<div class="col-7">
										<input id="idAction" name="idAction"  class="form-control input-md" type="text"  required maxlength="20"  >
									</div>
								</div>
								<div class="form-group row">
									<span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-envelope"></i>Email</span>
									<div class="col-7">
										<input id="empresaEmail" name="empresaEmail" placeholder="Email" class="form-control input-md" type="email"   maxlength="50"  >
									</div>
								</div>
								<div class="form-group row">
									<span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-cog"></i>Status</span>
									<div class="col-7">
										<input id="empresaStatus" name="empresaStatus" placeholder="Status" class="form-control input-md" type="text"  >
									</div>
								</div>
								<div class="form-group row">
									<span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-calendar"></i>Fecha Corte</span>
									<div class="col-7">
										<input id="empresaFechaCorte" name="empresaFechaCorte" placeholder="Fecha de Corte" class="form-control input-md" type="text"  >
									</div>
								</div>
								<div class="form-group row">
									<span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-cube"></i>Factura</span>
									<div class="col-7">
										<input id="empresaFactura" name="empresaFactura" placeholder="Factura" class="form-control input-md" type="text"  >
									</div>
								</div>
								<div class="form-group row">
									<span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-plus"></i>Modo de Pago</span>
									<div class="col-7">
									<input id="empresaModoPago" name="empresaModoPago"  class="form-control input-md" type="text"  >
<!-- 										<select id="empresaModoPago" name="empresaModoPago" class="form-control" disabled> -->
<!-- 							                <option value="efectivo">Deposito a Cuenta / Efectivo</option> -->
<!-- 							                <option value="transaccion">Transaccion Interbancaria</option> -->
<!-- 							              </select> -->
									</div>
								</div>
								<div class="form-group row">
									<span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-user-o"></i>Usuario Acceso</span>
									<div class="col-7">
										<input id="empresaIdPerfilE" name="empresaIdPerfilE" placeholder="Usuario Kaltia Control" class="form-control input-md" type="text" >
									</div>
								</div>
								<div class="form-group row">
									<span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-eye"></i>Nombre Corto</span>
									<div class="col-7">
										<input id="empresaNombreCorto" name="empresaNombreCorto" placeholder="Nombre Corto" class="form-control input-md" type="text"   required maxlength="50" >
									</div>
								</div>
								<div class="form-group row">
									<span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-fire"></i>RFC</span>
									<div class="col-7">
										<input id="empresaRFC" name="empresaRFC" placeholder="RFC" class="form-control input-md" type="text"  required maxlength="13" >
									</div>
								</div>
								<div class="form-group row">
									<span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-build"></i>Direccion</span>
									<div class="col-7">
										<input id="empresaDireccion" name="empresaDireccion" placeholder="Direccion" class="form-control input-md" type="text"  required maxlength="900" >
									</div>
								</div>
								<div class="form-group row">
									<span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-user"></i>Contacto</span>
									<div class="col-7">
										<input id="empresaContacto" name="empresaContacto" placeholder="Contacto" class="form-control input-md" type="text"  required maxlength="200" >
									</div>
								</div>
								<div class="form-group row">
									<span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-phone"></i>Telefono</span>
									<div class="col-7">
										<input id="empresaTelefono" name="empresaTelefono" placeholder="Telefono Contacto" class="form-control input-md" type="text" required >
									</div>
								</div>
								<div class="form-group row">
									<span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-edit"></i>Varios</span>
									<div class="col-7">
										<textarea class="form-control" id="empresaVarios" rows="4" name="empresaVarios">Separar los campos con el caracter '|' .</textarea>
									</div>
								</div>
	              		<br>
	              	</fieldset>
	              </div>
		          <br>
		          <hr>
				  <div id="big-form" class="well auth-box">
				  		<fieldset>
				            <label class=" control-label" for="singlebutton">Datos Correctos</label>
				              <button class="btn btn-lg btn-primary btn-block" type="submit">Guardar</button>
						</fieldset>
				  </div>	
				</form>
	        </div>
	    </div>
        <div class="modal-footer" style=" background-color: #F1FFFE">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancelar</button>
          
        </div>
      </div>
      
    </div>
  </div> 
  <!-- --------------------------------------------------------------------------------------------------------------- -->
    <!-- Modal PRODUCTOS-->
  <div class="modal fade" id="modalEdicionProductos" role="dialog">
    <div class="modal-dialog modal-lg">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="background-color: #F1FFFE">
          <div class="logo-src2" ><img width="90%"  alt=""></div>
          <h4 position: center">Edicion Productos</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span></h4>
        </div>
        <div class="modal-body" style="padding:40px 50px; ">	
			<h2><strong>Check de productos habilitados</strong></h2>
	            	<hr>
	            	<form  class="" action="actualizaModulos.htm" method="post" modelAttribute="ProductosEntity" >
	            	<input id="idEmpresaProducto"  type="hidden" name="idEmpresa">
	            			<div class="form-group">
								    <div class="form-check">
								      <input class="form-check-input" type="checkbox" id="checkPagina" name="checkPagina">
								      <label class="form-check-label" for="gridCheck">
								        Producto Pagina Editable
								      </label>
								    </div>
								  </div>
								  <div class="form-group">
								    <div class="form-check">
								      <input class="form-check-input" type="checkbox" id="checkQRR" name="checkQRR">
								      <label class="form-check-label" for="gridCheck">
								        Producto Codigo QR Restaurante 
								      </label>
								    </div>
								  </div>
								  <div class="form-group">
								    <div class="form-check">
								      <input class="form-check-input" type="checkbox" id="checkQRE" name="checkQRE">
								      <label class="form-check-label" for="gridCheck">
								        Producto Codigo QR Estacionamiento
								      </label>
								    </div>
								  </div>
								  
								  <div class="form-group">
								    <div class="form-check">
								      <input class="form-check-input" type="checkbox" id="checkPuntoVenta" name="checkPuntoVenta">
								      <label class="form-check-label" for="gridCheck">
								        Producto Sistema PuntoVenta
								      </label>
								    </div>
								  </div>
								  <hr>
								  
								  <div class="form-group">
								    <div class="form-check">
								      <input class="form-check-input" type="checkbox" id="clientePagina" name="clientePagina">
								      <label class="form-check-label" for="gridCheck">
								        Modulo Registro de Clientes
								      </label>
								    </div>
								  </div>
								  <div class="form-group">
								    <div class="form-check">
								      <input class="form-check-input" type="checkbox" id="clienteChat" name="chatPagina">
								      <label class="form-check-label" for="gridCheck">
								        Modulo Chat WhatsApp
								      </label>
								    </div>
								  </div>
								  <div class="form-group">
								    <div class="form-check">
								      <input class="form-check-input" type="checkbox" id="videoPagina" name="videoPagina">
								      <label class="form-check-label" for="gridCheck">
								        Modulo Video en pagina
								      </label>
								    </div>
								  </div>
								  <div class="form-group">
								    <div class="form-check">
								      <input class="form-check-input" type="checkbox" id="tarjetaPagina" name="tarjetaPagina">
								      <label class="form-check-label" for="gridCheck">
								        Modulo Presentacion de Productos
								      </label>
								    </div>
								  </div>
								  <div class="form-group">
								    <div class="form-check">
								      <input class="form-check-input" type="checkbox" id="retroalimentacionPagina" name="retroalimentacionPagina">
								      <label class="form-check-label" for="gridCheck">
								        Modulo Retroalimentacion Encuesta 
								      </label>
								    </div>
								  </div>
								  <hr>
								  
								  <div class="form-group">
								    <div class="form-check">
								      <input class="form-check-input" type="checkbox" id="citaPagina" name="citaPagina">
								      <label class="form-check-label" for="gridCheck">
								        Modulo Cita Clientes 
								      </label>
								    </div>
								  </div>
								  <div class="form-group">
								    <div class="form-check">
								      <input class="form-check-input" type="checkbox" id="carpetaPagina" name="carpetaPagina">
								      <label class="form-check-label" for="gridCheck">
								        Modulo Documentos Compartidos 
								      </label>
								    </div>
								  </div>
								  <div class="form-group">
								    <div class="form-check">
								      <input class="form-check-input" type="checkbox" id="notificacionPagina" name="notificacionPagina">
								      <label class="form-check-label" for="gridCheck">
								        Modulo Notificacion Clientes
								      </label>
								    </div>
								  </div>
								  
								  
		          <br>
		          <hr>
				  <div id="big-form" class="well auth-box"><fieldset>
		            <label class=" control-label" for="singlebutton">Datos Correctos</label>
		              <button class="btn btn-lg btn-primary btn-block" type="submit">Guardar</button>
					</fieldset>
					</div>	
				</form>
	        
	    </div>
        <div class="modal-footer" style=" background-color: #F1FFFE">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancelar</button>
          
        </div>
      </div>
      
    </div>
  </div> 
  <!-- --------------------------------------------------------------------------------------------------------------- -->