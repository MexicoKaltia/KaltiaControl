<%@ include file="/layout/head.jsp"%>
<!-- ################################################################################################ -->
<link href="<%=request.getContextPath()%>/css/jquery.skeduler.min.css" rel="stylesheet" type="text/css" media="all">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/modulos.css">
<link rel="stylesheet"	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-table.css">
<!-- <link href="https://unpkg.com/bootstrap-table@1.15.4/dist/bootstrap-table.min.css" rel="stylesheet"> -->

<body>
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
					<%--    		<li>	<a href="<c:url value="edicion.htm?action=${model.requestLoginVO.getEmpresaEntity().getIdAction()}"/>">Edicion</a> --%>
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
		<li><a href="#"><c:out value="${model.requestLoginVO.empresaEntity.getEmpresaNombreCorto()}" /></a></li>
		<li><a href="#"><c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlNombre()}" /></a></li>
		<li><a href="#">Modulos</a></li>
	</ul>
</div>

<!-- ################################################################################################ -->
<div class="container auth" class="clear">
	<h1 class="text-rigth">Datos Generales Modulos - <strong><c:out value="${model.requestLoginVO.empresaEntity.getEmpresaNombreCorto()}" /></strong></h1>
<!-- 	<div id="big-form" class="well auth-box"> -->
<!-- 		<form> -->
<!-- 			<fieldset> -->
<!-- 				<div class="btn-group"> -->
<%-- 					<a href="#userEmpresa" class="btn btn-default">Usuarios <c:out --%>
<%-- 							value="${model.requestLoginVO.empresaEntity.getIdEmpresa()}" /></a> <a --%>
<!-- 						href="#citas" class="btn btn-default">Citas</a> <a href="#usuario" -->
<!-- 						class="btn btn-default">Otros Modulos</a> -->
<!-- 				</div> -->
<!-- 			</fieldset> -->
<!-- 		</form> -->
<!-- 	</div> -->
 <c:if test='${error}'>
    <span> 
		<div class="alert alert-danger" role="alert" id="dataError">
		<b>Revisión : </b><u>Error al Actualizar Modulo</u>
		</div>
	</span>
	</c:if>
	 <c:if test='${exito}'>
    <span> 
		<div class="alert alert-success" role="alert" id="dataExito">
		<b>Exito : </b><u>Modulos Actualizados </u>
		</div>
	</span>
	</c:if>
	<!-- ################################################################################################ -->
			<div id="accordionProductos" class="animated rollIn slow">
				<h1>Productos</h1>
		   	</div> <!-- fin de div accordion -->
		   	<hr>
		   	<div id="accordionModulosS" class="animated slideInLeft slow">
		   		<h1>Modulos Sencillo</h1>
		   	</div> <!-- fin de div accordion -->
		   	<hr>
		   	<div id="accordionModulosC" class="animated slideInRight slow">
		   		<h1>Modulo Compuesto</h1>
		   	</div> <!-- fin de div accordion -->
		   	<hr>
	<!-- ################################################################################################ -->
   	<!-- ################################################################################################ -->
	
</div><!-- fin de div body -->


<!-- modalRegistro -->
<div class="modal fade" id="modalEdicionUsuariosEmpresa" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content" style="background-image:url('http://kaltiaservicios.com/store/kaltia/modelo/modal/imagen.jpg?v=1');">
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
		                <form class="form-horizontal" method="post" action="">
		                	<fieldset>
							<div class="form-group row">
		                      <span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-user bigicon"></i></span>
		                      <div class="col-7">
		                        <input id="nombreRegistro"  name="name" type="text" placeholder="Nombre(s) Apellido" class="form-control" maxlength="40">
		                      </div>
		                    </div>
<!-- 		                    <div class="form-group row"> -->
<%-- 		                      <span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-user bigicon"></i></span> --%>
<!-- 		                      <div class="col-7"> -->
<!-- 		                        <input id="apellidoRegistro" name="name" type="text" placeholder="Apellidos" class="form-control" maxlength="40"> -->
<!-- 		                      </div> -->
<!-- 		                    </div> -->
		
		                    <div class="form-group row">
		                      <span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-envelope bigicon"></i></span>
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
	<input id="productos" name="productos"  type="hidden"  value="<c:out value="${model.requestLoginVO.getProductos()}"/>">
	<input id="categorias" name="categorias"  type="hidden"  value="<c:out value="${model.categorias}"/>">
	<input id="usuariosEmpresa" name="usuariosEmpresa"  type="hidden"  value="<c:out value="${model.usuariosEmpresa}"/>">
	<input id="usuarioKC" name="usuarioKC"  type="hidden"  value="<c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlNombre()}" />">
	<input id="nombreCorto" name="nombreCorto"  type="hidden"  value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaNombreCorto()}" />">
	
</div>
<script >
var idAction = document.getElementById("idAction").value;
var idEmpresa = document.getElementById("idEmpresa").value;
var productos = document.getElementById("productos").value; 
	productos = JSON.parse(productos);
var usuariosEmpresa = document.getElementById("usuariosEmpresa").value;
	usuariosEmpresa = JSON.parse(usuariosEmpresa);
var usuarioKC = document.getElementById("usuarioKC").value;
var nombreCorto = document.getElementById("nombreCorto").value;

</script>


<!-- JAVASCRIPTS -->

<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.backtotop.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.mobilemenu.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<%-- <script src="<%=request.getContextPath()%>/js/jquery.skeduler.js"></script> --%>
<%-- <script src="<%=request.getContextPath()%>/js/skeduler-container.js"></script> --%>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script src="<%=request.getContextPath()%>/js/bootstrap-table.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap-table-es-MX.min.js"></script>

<script src="<%=request.getContextPath()%>/js/complementoBody2.js"></script>
<script src="<%=request.getContextPath()%>/js/moduloOperacion.js"></script>
<script src="<%=request.getContextPath()%>/js/tableUsuariosEmpresa.js"></script>
<script src="<%=request.getContextPath()%>/js/moduloVideoOperacion.js"></script>
<script src="<%=request.getContextPath()%>/js/moduloChat.js"></script>
<script src="<%=request.getContextPath()%>/js/moduloTarjetaProducto.js"></script>

<!-- ValidateForm -->
<script src="<%=request.getContextPath()%>/js/validateForm/jquery.validate.js"></script>
<script src="<%=request.getContextPath()%>/js/validateForm/messages_es.js"></script>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/additional-methods.js"></script> -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/additional-methods.min.js"></script>

<script>
    $( function() {
      $( "#accordion" ).accordion({
        collapsible: true
      });
    } );        	
</script>


</body>
<!--**********************************************************************************-->
<!-- modalVideo -->
<div class="modal fade" id="modalVerVideo" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content"
			style="background-image:url('http://kaltiaservicios.com/store/kaltia/modelo/modal/imagen.jpg?v=1');">
			
			<!--**********************************************************************************-->
			<div class="modal-body">
				<div>
					<div class="embed-responsive embed-responsive-16by9">
<!-- 					  <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/v64KOxKVLVg" allowfullscreen></iframe> -->
<!-- 						<iframe class="embed-responsive-item" src="https://www.youtube.com/embed/watch?v=4jZBwyG7HPs&list=RD7qFfFVSerQo&index=9" allowfullscreen></iframe> -->
						<iframe id="modalEnlaceVideo" class="embed-responsive-item" src="https://www.youtube.com/embed/4jZBwyG7HPs" allowfullscreen></iframe>
					</div>
				</div>		    
		      </div>
		      <!--**********************************************************************************-->
			
		</div>
	</div>
</div>
<!-- FIN modalVideo -->
<!--**********************************************************************************-->
    <!-- modalRegistroTarjetaProducto -->
<div class="modal fade" id="modalRegistroTarjetaProducto" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content" style="background-image:url('http://kaltiaservicios.com/store/kaltia/modelo/modal/imagen.jpg?v=1');">
			<div class="modal-header">
				<label class="sizeEtiqueta colorLabel"><span id="spanCategoria"></span> - Elemento -</label>
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
<!-- 		                <form id="formAddTarjetaProducto" action="addVideo.htm" method="post" modelAttribute="tarjetaProductoEntity"> -->
							<form id="imagenObjetoQRDForm" class="imagenArrayForm">
		                	<fieldset>
							<div class="form-group row">
		                      <span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-user bigicon"></i></span>
		                      <div class="col-7">
		                        <input id="elementoNombre"  name="elementoNombre" type="text" placeholder="Nombre Producto" class="form-control" maxlength="100">
		                      </div>
		                    </div>
		                    <div class="form-group row">
		                      <span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-envelope bigicon"></i></span>
		                      <div class="col-7">
		                        <textarea class="form-control" id="elementoDescripcion" name="message" placeholder="Descripcion Producto" rows="4"></textarea>
		                      </div>
		                    </div>
		                    <div class="form-group row">
		                      <span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-phone-square bigicon"></i></span>
		                      <div class="col-7">
		                        <input id="elementoCosto" name="elementoCosto" type="text" placeholder="Costo Producto" class="form-control" maxlength="20">
		                      </div>
		                    </div>
                            <div class="form-group row">
                                <span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-phone-square bigicon"></i></span>
                                <div class="col-7">
                                    <img class="inspace-10 borderedbox" src="" >
                                    <div class="alerta"><hiden class="alerta_in"></hiden></div>
                                    
                                        <hiden class="imagenObjetoQRDForm"></hiden>
                                        <label for="imagenObjetoQRD" class="nombre">Actualiza imagen:</label>
                                        <input id="imagenObjetoQRD" type="file" name="uploadfile" accept="image/jpeg" />
<!--                                     </form> -->
                                    <small class="form-text bienvenido">Adjuntar imagen formato *.jpg ,  *.png  *.gif  *.bmp  no mayor a un 1MB.</small>
                                </div>
                            </div>
                            <div class="container" style="text-align: right;">
								<button class="btn btn-success btnAddElemento" type="button" id="btnAddElemento">Agregar</button>
							</div>
        	              </fieldset>
		              </form>
		           </div>
		      </div>
		      <!--**********************************************************************************-->
			<div class="modal-footer">
				<a href="#" data-dismiss="modal" class="btn" id="modal_btnClose">Cerrar</a>
				<!-- <a  class="btn btn-primary" id="btnSaveRegistro">Guardar</a>-->
			</div>
		</div>
	</div>
</div>
<!-- FIN modalRegistroTarjetaProducto -->

</html>