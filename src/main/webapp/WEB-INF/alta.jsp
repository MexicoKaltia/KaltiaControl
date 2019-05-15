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
    <h1 class="text-rigth">ALTA Datos Generales Empresa</h1>
    <div id="big-form" class="well auth-box">
     <form>
        <fieldset>
          <div class="btn-group">
            <a href="#general" class="btn btn-default">General</a>
            <a href="#modulo" class="btn btn-default">Modulos</a>
            <a href="#status" class="btn btn-default">Status</a>
            <a href="#usuario" class="btn btn-default">Usuarios</a>
          </div>
           </fieldset>
        </form>
        </div>
          <!-- Text input-->
          
          <div id="big-form" class="well auth-box"><form><fieldset>
            	<a  id="general"></a>
            <label class=" control-label" for="textinput">General</label>
            </fieldset></form></div>
            
            <form  class="" action="empresaAlta.htm" method="post" modelAttribute="empresaEntity">
            <div id="big-form" class="well auth-box"><fieldset>
              <input id="empresaNombreCompleto" name="empresaNombreCompleto" placeholder="Nombre de Empresa Completo" class="form-control input-md" type="text" required>
              <input id="idEmpresa" name="idEmpresa" placeholder="Nombre Corto" class="form-control input-md" type="text"   required>
              <input id="IdAction" name="IdAction" placeholder="IdAction" class="form-control input-md" type="text"  required>
              <input id="empresaRFC" name="empresaRFC" placeholder="RFC" class="form-control input-md" type="text"  required>
              <input id="empresaDireccion" name="empresaDireccion" placeholder="Direccion" class="form-control input-md" type="text"  required>
              <input id="empresaEmail" name="empresaEmail" placeholder="Email" class="form-control input-md" type="email"  required>
              <input id="empresaContacto" name="empresaContacto" placeholder="Contacto" class="form-control input-md" type="text"  required>
              <input id="empresaIdPerfilI" name="empresaIdPerfilI" placeholder="Integrador Kaltia" class="form-control input-md" type="text" readonly value="<c:out value="${modelAlta.requestLoginVO.getUserKaltiaControlEntity().getUserKaltiaControlDescr().toString()}"/>">
<%--               <input id="empresaIdPerfilI" name="empresaIdPerfilI" placeholder="Integrador Kaltia" class="form-control input-md" type="hidden" readonly value="<c:out value="${modelAlta.requestLoginVO.getUserKaltiaControlEntity().getIdUserKaltiaControlUser().toString()}"/>"> --%>
<!--               <input id="empresaModelo" name="empresaModelo" placeholder="Modelo" class="form-control input-md" type="text"  > -->
              <label class=" control-label" for="selectbasic">Modelo</label>
	            <div class="">
	              <select id="empresaModelo" name="empresaModelo" class="form-control">
	                <option value="bronea">Bronea</option>
	                <option value="pendiente">Pendiente</option>
	              </select>
	            </div>
              <br>
              </fieldset></div>
              
            <div id="big-form" class="well auth-box"><fieldset>
	            <a  id="modulo"></a>
	            <label class=" control-label" for="textinput">Modulos</label>
	            <input id="empresaClientes" name="empresaClientes" type="hidden" />
	            <input id="empresaCitas" name="empresaCitas" type="hidden" />
	            <input id="empresaCarpetas" name="empresaCarpetas" type="hidden" />
	            </fieldset></div>
	            <div id="big-form" class="well auth-box"><fieldset>
	            <div class="form-check">
	            		<input class="form-check-input" type="checkbox" name="moduloEdicion" id ="moduloEdicionCheck" checked disabled>
	                	<label class="form-check-label" for="moduloEdicion">Edición de Pagina</label>
					  	<div id="moduloEdicion" class="collapse.show">
							<div id='limpiaAlerta' class='alert alert-success' role='alert'>moduloEdicion Activado</div>
					  	</div>
       	        </div>
       	        <div class="form-check">
						<input type="checkbox" class="form-check-input" id="moduloClienteCheck">
	         	   		<label class="form-check-label" for="moduloClientes">Gestión Clientes</label>
	         	   		<div id="moduloCliente" class="collapse">
							<div id='limpiaAlerta' class='alert alert-success' role='alert'>Modulo Cliente Activado</div>
					  	</div>
				</div>
				<div class="form-check">
	         	   <input class="form-check-input" type="checkbox" name="moduloCita" id="moduloCitaCheck">
<!-- 				   <button type="button" class="btn btn-success" data-toggle="collapse" data-target="#moduloCita">Activar Modulo Citas</button> -->
	         	   <label class="form-check-label" for="moduloCita" id="moduloCitalabel">Gestión Citas</label>
	         	   	  	<div id="moduloCita" class="collapse">
<!-- 							<div id='limpiaAlerta' class='alert alert-success' role='alert'>Modulo Citas Activado</div> -->
							<div class="row">
							    <div class="col">
							    <label class="form-check-label" for="cita11">Horario Inicial</label>
							      <select id="cita11" name="cita11" class="form-control">
					                <option value="100">1:00</option>
									<option value="200">2:00</option>
									<option value="300">3:00</option>
									<option value="400">4:00</option>
									<option value="500">5:00</option>
									<option value="600">6:00</option>
									<option value="700">7:00</option>
									<option value="800">8:00</option>
									<option value="900">9:00</option>
									<option value="1000">10:00</option>
									<option value="1100">11:00</option>
									<option value="1200">12:00</option>
									<option value="1300">13:00</option>
									<option value="1400">14:00</option>
									<option value="1500">15:00</option>
									<option value="1600">16:00</option>
									<option value="1700">17:00</option>
									<option value="1800">18:00</option>
									<option value="1900">19:00</option>
									<option value="2000">20:00</option>
									<option value="2100">21:00</option>
									<option value="2200">22:00</option>
									<option value="2300">23:00</option>
									<option value="2400">24:00</option>
					              </select>
							    </div>
							    <div class="col" >
<!-- 							      <input type="text" class="form-control" placeholder="Horario S (10:00-14:00)" id="horCitaS"> -->
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
					                <option value="100">1:00</option>
									<option value="200">2:00</option>
									<option value="300">3:00</option>
									<option value="400">4:00</option>
									<option value="500">5:00</option>
									<option value="600">6:00</option>
									<option value="700">7:00</option>
									<option value="800">8:00</option>
									<option value="900">9:00</option>
									<option value="1000">10:00</option>
									<option value="1100">11:00</option>
									<option value="1200">12:00</option>
									<option value="1300">13:00</option>
									<option value="1400">14:00</option>
									<option value="1500">15:00</option>
									<option value="1600">16:00</option>
									<option value="1700">17:00</option>
									<option value="1800">18:00</option>
									<option value="1900">19:00</option>
									<option value="2000">20:00</option>
									<option value="2100">21:00</option>
									<option value="2200">22:00</option>
									<option value="2300">23:00</option>
									<option value="2400">24:00</option>
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
				<div class="form-check">
	         	   <input class="form-check-input" type="checkbox" name="moduloCarpeta" id="moduloCarpetaCheck">
	         	   <label class="form-check-label" for="moduloCarpeta" >Carpeta Clientes</label>
	         	   	<div id="moduloCarpeta" class="collapse">
							<div id='limpiaAlerta' class='alert alert-success' role='alert'>Modulo Carpeta Cliente Activado</div>
					</div>
	         	</div>
            </fieldset></div>
              
              <div id="big-form" class="well auth-box"><fieldset>
              <a id="status"></a>
             	<label class=" control-label" for="textinput">Status</label>
              	<br></fieldset></div>	
              	<div id="big-form" class="well auth-box"><fieldset>
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
	              <input id="empresaIdPerfilE" name="empresaIdPerfilE" placeholder="Usuario Kaltia Control" class="form-control input-md" type="text" readonly>
<!-- 	              <input id="userKaltiaControlPass" name="userKaltiaControlPass" placeholder="Password" class="form-control input-md" type="password"> -->
<!-- 	              <input id="userKaltiaControlPass1" name="userKaltiaControlPass1" placeholder="Confirma Password" class="form-control input-md" type="password"> -->
	          </fieldset></div>	
			  <div id="big-form" class="well auth-box"><fieldset>
	            <label class=" control-label" for="singlebutton">Datos Correctos</label>
	              <button class="btn btn-lg btn-primary btn-block" type="submit">Guardar</button>
				</fieldset></div>	
				</form>
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

</body>
</html>