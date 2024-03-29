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
    
    <c:if test='${error}'>
    <span> 
		<div class="alert alert-danger" role="alert" id="dataError">
		<b>Revisi�n : </b><u>Empresa IdAction ya Existe</u>
		</div>
	</span>
	</c:if>
    <div id="big-form" class="well auth-box">
     <form>
        <fieldset>
          <div class="btn-group">
            <a href="#general" class="btn btn-default">General</a>
            <a href="#status" class="btn btn-default">Status</a>
<!--             <a href="#productos" class="btn btn-default">Productos</a> -->
          </div>
           </fieldset>
        </form>
        </div>
          <!-- Text input-->
          <div id="general">
          <div id="big-form" class="well auth-box"><form><fieldset>
            	<a  id="general"></a>
            <label class=" control-label" for="textinput">General</label>
            </fieldset></form></div>
            
            <form  class="" action="altaGenerales.htm" method="post" modelAttribute="empresaEntity">
            <div id="big-form" class="well auth-box"><fieldset>
              <input id="empresaNombreCompleto" name="empresaNombreCompleto" placeholder="Nombre de Empresa Completo" class="form-control input-md" type="text" required maxlength="200">
              <input id="empresaNombreCorto" name="empresaNombreCorto" placeholder="Nombre Corto" class="form-control input-md" type="text"   required maxlength="20">
              <input id="IdAction" name="IdAction" placeholder="IdAction" class="form-control input-md" type="text"  required maxlength="10">
              <input id="empresaRFC" name="empresaRFC" placeholder="RFC" class="form-control input-md" type="text"  required maxlength="13">
              <input id="empresaDireccion" name="empresaDireccion" placeholder="Direccion" class="form-control input-md" type="text"  required maxlength="900">
              <input id="empresaEmail" name="empresaEmail" placeholder="Email" class="form-control input-md" type="email"  required maxlength="50">
              <input id="empresaContacto" name="empresaContacto" placeholder="Contacto" class="form-control input-md" type="text"  required maxlength="200">
              <input id="empresaTelefono" name="empresaTelefono" placeholder="Telefono Contacto" class="form-control input-md" type="number"  minlength="10" maxlength="10">
<%--               <input id="empresaIdPerfilI" name="empresaIdPerfilI" placeholder="Integrador Kaltia" class="form-control input-md" type="text" readonly value="<c:out value="${modelAlta.requestLoginVO.getUserKaltiaControlEntity().getUserKaltiaControlDescr().toString()}"/>"> --%>
              <input id="empresaIdPerfilI" name="empresaIdPerfilI" placeholder="Integrador Kaltia" class="form-control input-md" type="hidden" readonly value="<c:out value="${modelAlta.requestLoginVO.getUserKaltiaControlEntity().getUserKaltiaControlNombre().toString()}"/>">
              <br>
              </fieldset></div>              
              <div id="big-form" class="well auth-box"><fieldset>
              <a id="status"></a>
             	<label class=" control-label" for="textinput">Status</label>
              	<br></fieldset></div>	
              	<div id="big-form" class="well auth-box"><fieldset>
              <input id="empresaStatus" name="empresaStatus" placeholder="Status" class="form-control input-md" type="text" readonly value="prospecto" >
              <input id="empresaFechaCorte" name="empresaFechaCorte" placeholder="Fecha de Corte" class="form-control input-md" type="text"  readonly> 
              <label class=" control-label" for="selectbasic">Modo de Pago</label>
	            <div class="">
	              <select id="empresaModoPago" name="empresaModoPago" class="form-control">
	                <option value="efectivo">Deposito a Cuenta / Efectivo</option>
	                <option value="transaccion">Transaccion Interbancaria</option>
	              </select>
	            </div>
              <input id="empresaFactura" name="empresaFactura" placeholder="Factura" class="form-control input-md" type="text"  readonly>
               <label class=" control-label" for="textarea">Varios</label>
	            <div class="">                     
	              <textarea class="form-control" id="empresaVarios" rows="4" name="empresaVarios">Separar los campos con el caracter '|' .</textarea>
	            </div>
              <br>
	             <label class=" control-label" for="textinput">Usuario</label>
	              <input id="empresaIdPerfilE" name="empresaIdPerfilE" placeholder="Usuario Kaltia Control" class="form-control input-md" type="text" readonly>
	          </fieldset></div>
	          <br>
	          <hr>
			  <div id="big-form" class="well auth-box"><fieldset>
	            <label class=" control-label" for="singlebutton">Datos Correctos</label>
	              <button class="btn btn-lg btn-primary btn-block" type="submit">Guardar</button>
				</fieldset></div>	
				</form>
	          </div>
            </div>
<!--     section     -->
          
     	   
		
     <div class="clearfix"></div>
   
<!--    </div> -->
<!-- JAVASCRIPTS -->

<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/generales.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.backtotop.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.mobilemenu.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

<script src="<%=request.getContextPath()%>/js/complementoBody2.js"></script>


</body>
</html>

