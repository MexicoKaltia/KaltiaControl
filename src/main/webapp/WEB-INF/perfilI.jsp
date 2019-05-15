<%@ include file="/layout/head.jsp" %>

  <!-- ################################################################################################ -->
    <div class="wrapper row1">
    <header id="header" class="hoc clear"> 
      <div id="logo" class="fl_left">
        <h1><a href="#">K A L T I A Control</a></h1>
      </div>
      <nav id="mainav" class="fl_right">
        <ul class="clear">
          <li  class="active"><a href="#">Inicio</a></li>  
          <li><a href="<c:url value="alta.htm"/>">Alta Empresa</a></li>
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

<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="container auth" class="clear">
    <h1 class="text-rigth">Datos Generales Usuario</h1>
    <div id="big-form" class="well auth-box">
      <form>
        <fieldset>
          <div class="btn-group">
            <a href="#usuario" class="btn btn-default">Usuario</a>
            <a href="#infoEmpresa" class="btn btn-default">Informacion Empresa</a>
          </div>
           </fieldset>
     	 </form>
		</div>
    
    <div id="big-form" class="well auth-box">
      <form>
        <fieldset>
          <!-- Text input-->
          <div class="form-group">
            <a  id="usuario"></a>
            <label class=" control-label" for="textinput"><c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlNombre()}"/></label>
            <hr><br>
              <input id="textinput" name="idUser" placeholder=" Id User" class="form-control input-md" type="text" readonly value="<c:out value="${model.requestLoginVO.userKaltiaControlEntity.getIdUserKaltiaControlUser()}"/>">
              <input id="textinput" name="perfil" placeholder="Perfil" class="form-control input-md" type="text"  readonly value="<c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlPerfil()}"/>">
              <input id="textinput" name="descripcion" placeholder="Descripcion" class="form-control input-md" type="text"  readonly value="<c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlDescr()}"/>">
              <input id="textinput" name="domicilio" placeholder="Domicilio" class="form-control input-md" type="text"  readonly value="<c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlDomicilio()}"/>">
              <input id="textinput" name="correo" placeholder="Correo" class="form-control input-md" type="text"  readonly value="<c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlCorreo()}"/>">
              <input id="textinput" name="contacto" placeholder="Contacto" class="form-control input-md" type="text"  readonly value="<c:out value="${model.requestLoginVO.userKaltiaControlEntity.getUserKaltiaControlContacto()}"/>">
              <br>
              </div>
     	   </fieldset>
     	 </form>
		</div>
		
	<div id="big-form" class="well auth-box">
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
              	<c:forEach items="${model.requestLoginVO.empresaArrayEntity}" var="empresaArrayEntity">
			   <div id="big-form" class="well auth-box">
			      <form>
			        <fieldset>
			          <div class="form-group">
              	
        	      <input id="textinput" name="nombreCompleto" placeholder="Nombre de Empresa Completo" class="form-control input-md" type="text" readonly value="<c:out value="${empresaArrayEntity.getEmpresaNombreCompleto()}"/>">
	              <input id="textinput" name="Nombre Corto" placeholder="Nombre Corto" class="form-control input-md" type="text"  readonly value="<c:out value="${empresaArrayEntity.getIdEmpresa()}"/>">
	              <input id="textinput" name="IdAction" placeholder="IdAction" class="form-control input-md" type="text" readonly value="<c:out value="${empresaArrayEntity.getIdAction()}"/>">
	              <input id="textinput" name="modelo" placeholder="Modelo" class="form-control input-md" type="text" readonly value="<c:out value="${empresaArrayEntity.getEmpresaModelo()}"/>">
	              <input id="textinput" name="RFC" placeholder="RFC" class="form-control input-md" type="text" readonly value="<c:out value="${empresaArrayEntity.getEmpresaRFC()}"/>">
	              <input id="textinput" name="Direccion" placeholder="Direccion" class="form-control input-md" type="text" readonly value="<c:out value="${empresaArrayEntity.getEmpresaDireccion()}"/>">
	              <input id="textinput" name="email" placeholder="email" class="form-control input-md" type="text" readonly value="<c:out value="${empresaArrayEntity.getEmpresaEmail()}"/>">
	              <input id="textinput" name="contacto" placeholder="contacto" class="form-control input-md" type="text" readonly value="<c:out value="${empresaArrayEntity.getEmpresaContacto()}"/>">
	              
	            	</div>
		     	   </fieldset>
		     	 </form>
				</div>
              	</c:forEach>

     <div class="clearfix"></div>
   </div>
<!--  </div> -->
<!-- JAVASCRIPTS -->
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.backtotop.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.mobilemenu.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/complementoBody2.js"></script>

</body>
</html>