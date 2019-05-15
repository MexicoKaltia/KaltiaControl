<%@ include file="/layout/head.jsp" %>
  <!-- ################################################################################################ -->
  <link href="<%=request.getContextPath()%>/css/jquery.skeduler.min.css" rel="stylesheet" type="text/css" media="all">
  <!-- ################################################################################################ -->
  <div class="wrapper row1">
    <header id="header" class="hoc clear"> 
      <div id="logo" class="fl_left">
        <h1><a href="#">K A L T I A Control</a></h1>
      </div>
      <nav id="mainav" class="fl_right">
        <ul class="clear">
          <li><a href="inicio.htm">Inicio</a></li>
          <li class="active"><a  href="#">Modulos</a>
          <li><a  href="<c:url value="edicion.htm?action=${model.requestLoginVO.getEmpresaEntity().getIdAction()}"/>">Edicion</a>
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
    		    <li><a href="#"><c:out value="${model.requestLoginVO.empresaEntity.getIdEmpresa()}"/></a></li>
				<li><a href="#"><c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlNombre()}"/></a></li>
    		    <li><a href="#">Modulos</a></li>
    </ul>
  </div>

<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="container auth" class="clear">
	<h1 class="text-rigth">Datos Generales Modulos</h1>
    <div id="big-form" class="well auth-box">
     <form>
        <fieldset>
          <div class="btn-group">
            <a href="#userEmpresa" class="btn btn-default">Usuarios <c:out value="${model.requestLoginVO.empresaEntity.getIdEmpresa()}"/></a>
            <a href="#citas" class="btn btn-default">Citas</a>
            <a href="#usuario" class="btn btn-default">Otros Modulos</a>
          </div>
           </fieldset>
        </form>
        </div>
        
        <!-- UserEmpresa -->
        <div class="animated rollIn slow">
        <div id="big-form" class="well auth-box"><form><fieldset>
            	<a  id="userEmpresa"></a>
            <label class=" control-label" for="textinput">Usuarios Activos</label>
            </fieldset></form></div>
            <c:set var = "count" value = "${0}"/>
			<c:forEach items="${model.requestLoginVO.userEmpresaEntity}" var="userEmpresaEntity">
			   <div id="big-form" class="well auth-box">
			      <form>
			        <fieldset>
			          <div class="form-group">
			              <input id="textinput" name="nombreRegistro" placeholder="Nombre Completo" class="form-control input-md" type="text"  readonly value="<c:out value="${userEmpresaEntity.getNombreRegistro()}"/> <c:out value="${userEmpresaEntity.getApellidoRegistro()}"/>">
			              <input id="usuarioRegistro<c:out value = "${count}"/>" name="usuarioRegistro" placeholder="Usuario" class="form-control input-md" type="hidden" readonly value="<c:out value="${userEmpresaEntity.getUsuarioRegistro()}"/>">
			              <input id="nombreRegistro<c:out value = "${count}"/>" name="nombreRegistro" placeholder="Nombre de Usuario" class="form-control input-md" type="hidden" readonly value="<c:out value="${userEmpresaEntity.getNombreRegistro()}"/>">
			              <input id="apellidoRegistro<c:out value = "${count}"/>" name="apellidoRegistro" placeholder="Apelllido de Usuario" class="form-control input-md" type="hidden" readonly value="<c:out value="${userEmpresaEntity.getApellidoRegistro()}"/>">
			              <input id="emailRegistro<c:out value = "${count}"/>" name="emailRegistro" placeholder="Email de Usuario" class="form-control input-md" type="hidden" readonly value="<c:out value="${userEmpresaEntity.getEmailRegistro()}"/>">
			              <input id="telefonoRegistro<c:out value = "${count}"/>" name="telefonoRegistro" placeholder="Numero telefono de Usuario" class="form-control input-md" type="hidden" readonly value="<c:out value="${userEmpresaEntity.getTelefonoRegistro()}"/>">
			              <a id="${count}" data-toggle="modal" data-target="#modalUser"  class="btn btn-default userEmpresa">Ver Datos Completos</a>
			              </div>
			     	  </fieldset>
			       </form>
				</div>
				<c:set var = "count" value = "${count+1}"/>
           	</c:forEach>
		</div>
		
		<div class="animated slideInLeft slow">
	        <div id="big-form" class="well auth-box"><form><fieldset>
	            	<a  id="citas"></a>
	            <label class=" control-label" for="textinput">Citas</label>
	            </fieldset></form>
	        </div>            
<!--               <h1 style="margin:150px auto 30px auto; color:#fff;">jQuery Skeduler Plugin Example</h1> -->
    		  <button onclick="generate()">Presente Semana</button>
            	<div id="skeduler-container">
            		<input id="condiciones" name="condiciones" class="form-control input-md" type="hidden" readonly value="<c:out value="${model.requestLoginVO.datosCitasVO.getCondiciones()}"/>">
            		<input id="mesActual" name="mesActual" class="form-control input-md" type="hidden" readonly value="<c:out value="${model.requestLoginVO.datosCitasVO.getMesActual()}"/>">
            		<input id="mesPost" name="mesPost" class="form-control input-md" type="hidden" readonly value="<c:out value="${model.requestLoginVO.datosCitasVO.getMesPost()}"/>">
            	</div>
            
        </div><!-- fin de animated -->
            
            
            





















            
</div> <!-- fin de div body -->























<!-- MODAL   modalUserEmpresa -->
<div class="modal fade" id="modalUser" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content" style="background-image:url('http://kaltia-store.xyz/kaltia/modelo/modal/modalImagenFondo.jpg?v=1');">
			<div class="modal-header">
				<h5 class="modal-title" id="modalTitle">modalUser </h5>
				<br>
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
			     	<form><fieldset>
			     		<input id="usuarioRegistro" name="usuarioRegistro" placeholder="Nombre de Usuario" class="form-control input-md" type="text" readonly >
						<input id="nombreRegistro" name="nombreRegistro" placeholder="Nombre " class="form-control input-md" type="text" >
						<input id="apellidoRegistro" name="apellidoRegistro" placeholder="Apellido " class="form-control input-md" type="text"  >
						<input id="emailRegistro" name="emailRegistro" placeholder="email " class="form-control input-md" type="email"  value="">
						<input id="telefonoRegistro" name="telefonoRegistro" placeholder="num telefono " class="form-control input-md" type="text"  value="">
					</fieldset></form>
			      </div>
			      </div>
			</div>
 			<!--**********************************************************************************-->
 			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal" id="modalEdicionBody_btnClose">Cerrar</button>
				<button type="submit" class="btn btn-primary" id="modalEdicionHeaderSeccion2_btnSave">Guardar Cambios</button>
			</div>
		</div>
	</div>
</div>
<!-- fin modalUserEmpresa-->

	
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

</body>
</html>