<%@ include file="/layout/head.jsp" %>
  <!-- ################################################################################################ -->
  <div class="wrapper row1">
    <header id="header" class="hoc clear"> 
      <div id="logo" class="fl_left">
        <h1><a href="#">K A L T I A Control</a></h1>
      </div>
      <nav id="mainav" class="fl_right">
        <ul class="clear">
          <li class="active"><a href="inicio.htm">Inicio</a></li>
<%--           <li><a  href="<c:url value="modulo.htm"/>">Modulos</a> --%>
		  <li><a  href="<c:url value="#"/>">Modulos</a>
          <li><a  href="<c:url value="edicion.htm?action=${model.requestLoginVO.getEmpresaEntity().getIdAction()}"/>">Edicion Sitio Web</a>
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
    		    <li><a href="#"><c:out value="${model.requestLoginVO.empresaEntity.getEmpresaNombreCorto()}"/></a></li>
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
            <a href="#status" class="btn btn-default">Status</a>
            <a href="#usuario" class="btn btn-default">Usuario</a>
          </div>
           </fieldset>
        </form>
        </div>
          <!-- Text input-->
          
          <div id="big-form" class="well auth-box"><form><fieldset>
            	<a  id="general"></a>
            <label class=" control-label" for="textinput">General</label>
            </fieldset></form></div>
            
            
            <div id="big-form" class="well auth-box"><form><fieldset>
              <input id="empresaNombreCompleto" name="empresaNombreCompleto" placeholder="Nombre de Empresa Completo" class="form-control input-md" type="text" value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaNombreCompleto()}"/>" readonly>
              <input id="idEmpresa" name="idEmpresa" placeholder="Nombre Corto" class="form-control input-md" type="text"    value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaNombreCorto()}"/>" readonly>
              <input id="IdAction" name="IdAction" placeholder="IdAction" class="form-control input-md" type="text" value="<c:out value="${model.requestLoginVO.empresaEntity.getIdAction()}"/>" readonly>
              <input id="empresaRFC" name="empresaRFC" placeholder="RFC" class="form-control input-md" type="text" readonly value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaRFC()}"/>" readonly>
              <input id="empresaDireccion" name="empresaDireccion" placeholder="Direccion" class="form-control input-md" type="text" value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaDireccion()}"/>" readonly>
              <input id="empresaEmail" name="empresaEmail" placeholder="Email" class="form-control input-md" type="email" value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaEmail()}"/>" readonly>
              <input id="empresaContacto" name="empresaContacto" placeholder="Contacto" class="form-control input-md" type="text" value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaContacto()}"/>" readonly>
              <input id="empresaIdPerfilI" name="empresaIdPerfilI" placeholder="Representante Kaltia" class="form-control input-md" type="text"  value="<c:out value="${modelAlta.requestLoginVO.getUserKaltiaControlEntity().getIdUserKaltiaControlUser().toString()}"/>" readonly>
<!--               <input id="empresaModelo" name="empresaModelo" placeholder="Modelo" class="form-control input-md" type="text"  > -->
<!--               <label class=" control-label" for="selectbasic">Modelo</label> -->
<!-- 	            <div class=""> -->
<%-- 	              <select id="empresaModelo" name="empresaModelo" class="form-control" default="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaModelo()}"/>" disabled> --%>
<!-- 	                <option value="bronea">Bronea</option> -->
<!-- 	                <option value="pendiente">Pendiente</option> -->
<!-- 	              </select> -->
<!-- 	            </div> -->
              <br>
              </form></fieldset>
              </div>
              
              <div id="big-form" class="well auth-box"><form><fieldset>
              <a id="status"></a>
             	<label class=" control-label" for="textinput">Status</label>
              	<br></form></fieldset></div>	
              	<div id="big-form" class="well auth-box"><form><fieldset>
              <input id="empresaStatus" name="empresaStatus" placeholder="Status" class="form-control input-md" type="text" value="Activo" readonly>
              <input id="empresaFechaCorte" name="empresaFechaCorte" placeholder="Fecha de Corte" class="form-control input-md" type="text" value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaFechaCorte()}"/>" readonly> 
<%--               readonly value="<c:out value="${modelAlta.requestLoginVO.empresaEntity.getEmpresaFechaCorte()}"/>"> --%>
<!--               <input id="empresaModoPago" name="empresaModoPago" placeholder="Modo de Pago" class="form-control input-md" type="text"  > -->
              <label class=" control-label" for="selectbasic">Modo de Pago</label>
	            <div class="">
	              <select id="empresaModoPago" name="empresaModoPago" class="form-control" default="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaModoPago()}"/>" disabled>
	                <option value="efectivo">Deposito a Cuenta / Efectivo</option>
	                <option value="transaccion">Transaccion Interbancaria</option>
	              </select>
	            </div>
              <input id="empresaFactura" name="empresaFactura" placeholder="Factura" class="form-control input-md" type="text" value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaFactura()}"/>" readonly>
<!--               <input id="empresaVarios" name="empresaVarios" placeholder="Varios" class="form-control input-md" type="text"  > -->
               <label class=" control-label" for="textarea">Varios</label>
	            <div class="">                     
	              <textarea class="form-control" id="empresaVarios" name="empresaVarios" value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaVarios()}"/>" readonly>Separar los campos con el caracter '|' .</textarea>
	            </div>
              <br>
              <a id="usuario"></a>
	             <label class=" control-label" for="textinput">Usuario</label>
	              <input id="empresaIdPerfilE" name="empresaIdPerfilE" placeholder="Usuario Kaltia Control" class="form-control input-md" type="text" value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaIdPerfilE()}"/>" readonly>
<!-- 	              <input id="userKaltiaControlPass" name="userKaltiaControlPass" placeholder="Password" class="form-control input-md" type="password"> -->
<!-- 	              <input id="userKaltiaControlPass1" name="userKaltiaControlPass1" placeholder="Confirma Password" class="form-control input-md" type="password"> -->
	          </form></fieldset></div>	
	          
	   </div>
<!-- JAVASCRIPTS -->
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.backtotop.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.mobilemenu.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/complementoBody2.js"></script>

</body>
</html>