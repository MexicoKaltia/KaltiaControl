<%@ include file="/layout/head.jsp" %>

  <!-- ################################################################################################ -->
  <div class="wrapper row1">
    <header id="header" class="hoc clear"> 
      <div id="logo" class="fl_left">
        <h1><a href="#">K A L T I A Control</a></h1>
      </div>
      <nav id="mainav" class="fl_right">
        <ul class="clear">
          <li><a href="inicio.htm">Inicio</a></li>
          <li class="active"><a  href="#">Alta Empresa</a></li>
<%--           <li><a  href="${pageContext.request.contextPath}/estadistica.htm">Estadistica</a></li> --%>
           <%--           <li><a  href="<c:url value="edicion.htm?action=${model.get(requestLoginVO.getEmpresaEntity().getIdAction())}"/>">Edicion</a> --%>
<!--           <li  class="active"><a href="../index.html">Inicio</a></li> -->
<%--           <li><a class="drop" href="<c:url value="edicion.htm"/>">Edicion</a> --%>
<%--           <li><a class="drop" href="${pageContext.request.contextPath}/edicion.htm">Estadistica</a></li> --%>
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
    <h1 class="text-rigth">ALTA Productos Empresa</h1>
    
    <c:if test='${error}'>
    <span> 
		<div class="alert alert-danger" role="alert" id="dataError">
		<b>Revisi�n : </b><u>IdAction ya Existe</u>
		</div>
	</span>
	</c:if>
<!--     <div id="big-form" class="well auth-box"> -->
<!--      <form> -->
<!--         <fieldset> -->
<!--           <div class="btn-group"> -->
<!--             <a href="#general" class="btn btn-default">General</a> -->
<!--             <a href="#status" class="btn btn-default">Status</a> -->
<!--             <a href="#productos" class="btn btn-default">Productos</a> -->
<!--           </div> -->
<!--            </fieldset> -->
<!--         </form> -->
<!--         </div> -->
          <!-- Text input-->
          <div id="general">
          <div id="big-form" class="well auth-box"><form><fieldset>
            	<a  id="general"></a>
            <label class=" control-label" for="textinput">Productos</label>
            </fieldset></form></div>
            
            <!-- tabs Productos -->
            <form  class="" action="altaProductos.htm" method="post" modelAttribute="productosVO">
         	
         	<a  id="productos"><input  name="empresaNombreCorto" type="text" value='<c:out value="${empresaEntity.getEmpresaNombreCorto()}"/>' placeholder ="Empresa" disabled/></a>
         	<input id="idProducto" name="idProducto" type="hidden" value='<c:out value="${empresaEntity.getIdEmpresa()}"/>'/>
         	<input id="idEmpresa" name="idEmpresa" type="hidden" value='<c:out value="${empresaEntity.getIdEmpresa()}"/>'/>
         	<input id="idAction" name="idAction" type="hidden" value='<c:out value="${empresaEntity.getIdAction()}"/>'/>
         	
             <div id="big-form" class="well auth-box"><fieldset>
            <ul class="nav nav-tabs" id="myTab" role="tablist">
			  <li class="nav-item">
			    <a class="nav-link active" id="pagina-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Configuracion Productos</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" id="qrrestaurante-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false"></a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" id="qrestacionamiento-tab" data-toggle="tab" href="#contact" role="tab" aria-controls="contact" aria-selected="false"></a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" id="puntoVenta-tab" data-toggle="tab" href="#contact" role="tab" aria-controls="contact" aria-selected="false"></a>
			  </li>
			</ul>
			<div class="tab-content" id="myTabContent">
<!-- 			  ------------------------------------------------------------------------------------------------               -->
			  <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="pagina-tab">
			  		<input id="moduloContactoValue" name="moduloContactoValue" type="hidden" value="11"/>
		            <input id="moduloIngresaValue" name="moduloIngresaValue" type="hidden" value="21,22" />
		            <input id="moduloRegistroValue" name="moduloRegistroValue" type="hidden" value="22"/>
		            <input id="moduloCitaValue" name="moduloCitaValue" type="hidden" value="31"/>
		            <input id="moduloCarpetaValue" name="moduloCarpetaValue" type="hidden" value="41"/>
		            
		            <input id="empresaModulos" name="empresaModulos" type="hidden" />
		            <input id="empresaClientes" name="empresaClientes" type="hidden" />
		            <input id="empresaCitas" name="empresaCitas" type="hidden" />
		            <input id="empresaCarpetas" name="empresaCarpetas" type="hidden" />
		            
		            
		            <input id="idEmpresaPagina" name="paginaEntity.idEmpresa" type="hidden" />
		            <input id="idActionPagina" name="paginaEntity.idAction" type="hidden" />
		            <input id="idEmpresaQRR" name="qRREstaurante.idEmpresa" type="hidden" />
		            <input id="idActionQRR" name="qRREstaurante.idAction" type="hidden" />
		            <input id="modeloQRR" name="qRREstaurante.modeloQRR" type="hidden" />
		            <input id="tipoQRR" name="qRREstaurante.tipoQRR" type="hidden" />
		            
			  		<label class=" control-label" for="selectbasic">Modelo</label>
		            <div class="">
		              <select id="modeloProducto" name="modeloProducto" class="form-control" >
		                <option value="">Selecciona Modelo</option>
		                <option value="bronea">Bronea</option>
		                <option value="aerogem">Aerogem</option>
		                <option value="algenius">Algenius</option>
		                <option value="besloor">Besloor</option>
		              </select>
		            </div>
		            	       	        <hr>
	       	        <!-- ---------------------------------------------------------------------------------- -->
					<div class="form-check">
		            		<input class="form-check-input moduloPagina" type="checkbox" name="checkPagina" id="checkPagina"  disabled>
		                	<label class="form-check-label" for="paginaEntity.idPagina">Edici�n de Pagina</label>
						  	<div id="moduloPagina" class="collapse">
								<div id='limpiaAlerta' class='alert alert-success' role='alert'>Modulo Edicion de Pagina Activado</div>
						  	</div>
	       	        </div>
	       	        <hr>
	       	        <!-- ---------------------------------------------------------------------------------- -->
	       	        <div class="form-check">
		            		<input class="form-check-input moduloQRR" type="checkbox" name="checkQRR" id="checkQRR"  disabled>
		                	<label class="form-check-label" for="moduloQRR">Activar QR Restaurante</label>
						  	<div id="moduloQRR" class="collapse">
							  	<div id="moduloQRRActivo" class="collapse">
									<div id='limpiaAlerta' class='alert alert-success' role='alert'>Modulo QR Restaurante Activado</div>
							  	</div>
								<div class="row">
								    <div class="col">
									  <label class="radio-inline">
									  	<input  type="radio" name="radioQRR" id="modeloEstaticoQRR" value="QRE" disabled>
									  	Formato Men� Est�tico
									  	</label>
								    </div>
								    <div class="col" >
										<label class="radio-inline">
											<input  type="radio" name="radioQRR" id="modeloDinamicoQRR" value="QRD" disabled>
										Formato Men� Din�mico
										</label>
								    </div>
								 </div>
								 <button class="btn btn-lg btn-primary btn-block" type="button" id="guardarQRR" disabled>Guardar QR Restaurante</button>
						  	</div>
	       	        </div>
	       	        <hr>
	       	        <!-- ---------------------------------------------------------------------------------- -->
	       	        <div class="form-check">
							<input type="checkbox" class="form-check-input moduloCliente" name ="clientePagina" id="clientePagina" disabled>
		         	   		<label class="form-check-label" for="moduloCliente">Gesti�n Clientes</label>
		         	   		<div id="moduloCliente" class="collapse">
								<div id='limpiaAlerta' class='alert alert-success' role='alert'>Modulo Edicion de Pagina Activado</div>
						  	</div>
					</div>
						       	        <hr>
	       	        <!-- ---------------------------------------------------------------------------------- -->
					<div class="form-check">
		         	   <input class="form-check-input moduloCita" type="checkbox" name="citaPagina" id="citaPagina"  disabled>
		         	   <label class="form-check-label" for="moduloCita" id="moduloCitalabel">Gesti�n Citas</label>
		         	   	  	<div id="moduloCita" class="collapse">
								<div class="row">
								    <div class="col">
								    <label class="form-check-label" for="cita11">Horario Inicial</label>
								      <select id="cita11" name="cita11" class="form-control">
	
						              </select>
								    </div>
								    <div class="col" >
										<label class="form-check-label" for="cita12">Horario Matutino</label>
										<select id="cita12" name="cita12" class="form-control"></select>
								    </div>
								    <div class="col">
								    <label class="form-check-label" for="cita21">Horario Vespertino</label>
								    <select id="cita21" name="cita21" class="form-control"></select>
						              </div>
						              <div class="col">
						              <label class="form-check-label" for="cita12">Horario FinDia</label>
								    <select id="cita22" name="cita22" class="form-control"></select>
						              </div>
								 </div>
								 <div class="row">
								    <div class="col">
								    <label class="form-check-label" for="cita12">Horario Inicio Sabado</label>
								    <select id="citaS21" name="citaS21" class="form-control">
						              </select>
						              </div>
						              <div class="col">
						              <label class="form-check-label" for="cita12">Horario Fin Sabado</label>
								    <select id="citaS22" name="citaS22" class="form-control"></select>
						              </div>
						             <div class="col">
								    </div>
								    <div class="col">
								    </div>			              
								 </div>
								 <label  id="saveCita" class="btn">Guardar Horario</label>
						  	</div>
					</div>
						       	        <hr>
	       	        <!-- ---------------------------------------------------------------------------------- -->
					<div class="form-check">
		         	   <input class="form-check-input moduloCarpeta" type="checkbox" name="carpetaPagina" id="carpetaPagina" disabled>
		         	   <label class="form-check-label" for="moduloCarpeta" >Carpeta Clientes</label>
		         	   	<div id="moduloCarpeta" class="collapse">
								<div id='limpiaAlerta' class='alert alert-success' role='alert'>Modulo Carpeta Cliente Activado</div>
						</div>
							       	        <hr>
	       	        <!-- ---------------------------------------------------------------------------------- -->
		         	</div>
		         	<div class="form-check">
		         	   <input class="form-check-input moduloRetroAlimentacion" type="checkbox" name="retroalimentacionPagina" id="retroalimentacionPagina" disabled>
		         	   <label class="form-check-label" for="moduloRetroAlimentacion" >RetroAlimentacion</label>
		         	   	<div id="moduloRetroAlimentacion" class="collapse">
								<div id='limpiaAlerta' class='alert alert-success' role='alert'>Modulo RetroAlimentacion Activado</div>
						</div>
		         	</div>
		         		       	        <hr>
	       	        <!-- ---------------------------------------------------------------------------------- -->
		         	<div class="form-check">
		         	   <input class="form-check-input moduloNotificacion" type="checkbox" name="notificacionPagina" id="notificacionPagina"  disabled>
		         	   <label class="form-check-label" for="moduloNotificacion" >Notificaciones</label>
		         	   	<div id="moduloNotificacion" class="collapse">
								<div id='limpiaAlerta' class='alert alert-success' role='alert'>Modulo Notificaciones Activado</div>
						</div>
		         	</div>
		         		       	        <hr>
	       	        <!-- ---------------------------------------------------------------------------------- -->
		         	<div class="form-check">
		         	   <input class="form-check-input moduloChat" type="checkbox" name="chatPagina" id="chatPagina" disabled>
		         	   <label class="form-check-label" for="moduloChat" >Chat</label>
		         	   	<div id="moduloChat" class="collapse">
								<div id='limpiaAlerta' class='alert alert-success' role='alert'>Modulo Chat Activado</div>
						</div>
		         	</div>
		         		       	        <hr>
	       	        <!-- ---------------------------------------------------------------------------------- -->
		         	<div class="form-check">
		         	   <input class="form-check-input moduloVideo" type="checkbox" name="videoPagina" id="videoPagina"  disabled>
		         	   <label class="form-check-label" for="moduloVideo" >Videos</label>
		         	   	<div id="moduloVideo" class="collapse">
								<div id='limpiaAlerta' class='alert alert-success' role='alert'>Modulo Videos Activado</div>
						</div>
		         	</div>
		         		       	        <hr>
	       	        <!-- ---------------------------------------------------------------------------------- -->
		         	<div class="form-check">
		         	   <input class="form-check-input moduloTarjeta" type="checkbox" name="tarjetaPagina" id="tarjetaPagina"  disabled>
		         	   <label class="form-check-label" for="moduloTarjeta" >Tarjeta de Productos</label>
		         	   	<div id="moduloTarjeta" class="collapse">
								<div id='limpiaAlerta' class='alert alert-success' role='alert'>Modulo Tarjeta de Productos Activado</div>
						</div>
		         	</div>
		         		       	        <hr>
	       	        <!-- ---------------------------------------------------------------------------------- -->
		         	<button class="btn btn-lg btn-primary btn-block" type="button" id="guardarPagina" disabled>Guardar Producto Pagina</button>
<!-- 			  ------------------------------------------------------------------------------------------------               -->		         	
	         	</div>
	         		       	        <br>
	       	        <!-- ---------------------------------------------------------------------------------- -->	 
	       	              	        <br>
	       	        <!-- ---------------------------------------------------------------------------------- -->
			  <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="qrrestaurante-tab">
			  <label class=" control-label" for="selectbasic">Modelo QR Restaurante</label>
				 <div class="">
		              <select id="modeloQRR" name="paginaEntity.modeloPagina" class="form-control" >
		                <option value="">Selecciona Modelo</option>
		                <option value="bronea">Bronea</option>
		                <option value="aerogem">Aerogem</option>
		                <option value="algenius">Algenius</option>
		                <option value="besloor">Besloor</option>
		              </select>
		            </div>
					<div class="form-group row">
	
	       	        </div>
	       	      
	         	
				<br>
				
	         	</div>
<!-- 			  ------------------------------------------------------------------------------------------------               -->
			  <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="qrestacionamiento-tab">
		         	<div class="form-check">
		         	   <input class="form-check-input" type="checkbox" name="moduloQREstacionamiento" id="moduloQREstacionamientoCheck">
		         	   <label class="form-check-label" for="moduloQREstacionamiento" >QR Estacionamiento</label>
		         	   	<div id="moduloQREstacionamiento" class="collapse">
								<div id='limpiaAlerta' class='alert alert-success' role='alert'>Modulo QR Estacionamiento Activado</div>
						</div>
		         	</div>
					<label  id="guardarQREstacionamiento" class="btn">Guardar Producto QR Estacionamiento</label>
	         	</div>
<!-- 			  ------------------------------------------------------------------------------------------------               -->
	         	<div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="puntoVenta-tab">
		         	<div class="form-check">
		         	   <input class="form-check-input" type="checkbox" name="moduloPuntoVenta" id="moduloPuntoVentaCheck">
		         	   <label class="form-check-label" for="moduloPuntoVenta" >Punto Venta</label>
		         	   	<div id="moduloPuntoVenta" class="collapse">
								<div id='limpiaAlerta' class='alert alert-success' role='alert'>Punto de Venta</div>
						</div>
		         	</div>
					<label  id="guardarPuntoVenta" class="btn">Guardar Producto Punto Venta</label>
	         	</div>
			</div>
            <!--  end tabs -->
              
              
              </fieldset></div>
	          <br>
	          <hr>
	          <div id="activoPagina" class="collapse">
				<div id='limpiaAlerta' class='alert alert-info' role='alert'>Activo Producto Pagina Editable</div>
			  </div>
			  <div id="activoQRR" class="collapse">
				<div id='limpiaAlerta' class='alert alert-info' role='alert'>Activo Producto QR Restaurante</div>
			  </div>
			  <div id="activoQRE" class="collapse">
				<div id='limpiaAlerta' class='alert alert-info' role='alert'>Activo Producto QR Estacionamiento</div>
			  </div>
			  <div id="activoPuntoVenta" class="collapse">
				<div id='limpiaAlerta' class='alert alert-info' role='alert'>Activo Producto Punto de Venta</div>
			  </div>
	          
			  <div id="big-form" class="well auth-box"><fieldset>
	            <label class=" control-label" for="singlebutton">Datos Correctos</label>
	              <button class="btn btn-lg btn-primary btn-block" type="submit" id="guardarProducto" disabled>Guardar</button>
				</fieldset></div>	
				</form>
	          </div>
            </div>
<!--     section     -->
          
     	   
		
     <div class="clearfix"></div>
   
<!--    </div> -->
<!-- JAVASCRIPTS -->
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.backtotop.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.mobilemenu.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/complementoBody2.js"></script>
<script src="<%=request.getContextPath()%>/js/complemento.js"></script>
<script src="<%=request.getContextPath()%>/js/productos.js"></script>

</body>
</html>

<!-- Modal -->
<div id="modalQRRestauranteEstatico" class="modal fade" role="dialog">
  <div class="modal-dialog modal-lg">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Configurar QR Restaurante Est�tico</h4>
        <small>Permitir cargar 5 imagenes</small>
      </div>
      	<div class="modal-body">
        	
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
			  <!-- Indicators -->
			  <ol class="carousel-indicators">
			    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			    <li data-target="#myCarousel" data-slide-to="1"></li>
			    <li data-target="#myCarousel" data-slide-to="2"></li>
			    <li data-target="#myCarousel" data-slide-to="3"></li>
			  </ol>
			
			  <!-- Wrapper for slides -->
			  <div class="carousel-inner" role="listbox">
			    <div class="item active">
			      <img src="img_chania.jpg" alt="Chania">
			      <div class="carousel-caption">
			        <h3>Chania</h3>
			        <p>The atmosphere in Chania has a touch of Florence and Venice.</p>
			      </div>
			    </div>
			
			    <div class="item">
			      <img src="img_chania2.jpg" alt="Chania">
			      <div class="carousel-caption">
			        <h3>Chania</h3>
			        <p>The atmosphere in Chania has a touch of Florence and Venice.</p>
			      </div>
			    </div>
			
			    <div class="item">
			      <img src="img_flower.jpg" alt="Flower">
			      <div class="carousel-caption">
			        <h3>Flowers</h3>
			        <p>Beautiful flowers in Kolymbari, Crete.</p>
			      </div>
			    </div>
			
			    <div class="item">
			      <img src="img_flower2.jpg" alt="Flower">
			      <div class="carousel-caption">
			        <h3>Flowers</h3>
			        <p>Beautiful flowers in Kolymbari, Crete.</p>
			      </div>
			    </div>
			  </div>
			
			  <!-- Left and right controls -->
			  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
			    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
			  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
			    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
			</div>
        	
   		</div>	<!-- end bodymodal -->	
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-success" id="guardaQRRestauranteEstatico" data-dismiss="modal">Guardar</button>
      </div>
    </div>

  </div>
</div>

<!-- Modal -->
<div id="modalQRRestauranteDinamico" class="modal fade" role="dialog">
  <div class="modal-dialog modal-lg">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Configurar QR Restaurante Din�mico</h4>
        <small>Configuracion Basica Categoria -> Producto / Paquetes Promociones</small>
      </div>
      <div class="modal-body">
        <p>Some text in the modal.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-success" id="guardaQRRestauranteDinamico" data-dismiss="modal">Guardar</button>
      </div>
    </div>

  </div>
</div>
