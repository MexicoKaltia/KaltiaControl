          <ul class="nav nav-tabs" id="myTab" role="tablist">
  <li class="nav-item">
    <a class="nav-link active" id="general-tab" data-toggle="tab" href="#general" role="tab" aria-controls="general" aria-selected="true">General</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" id="usuario-tab" data-toggle="tab" href="#usuario" role="tab" aria-controls="usuario" aria-selected="false">Usuario</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" id="status-tab" data-toggle="tab" href="#status" role="tab" aria-controls="status" aria-selected="false">Status</a>
  </li>
</ul>
<div class="tab-content" id="myTabContent">
  <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="general-tab">
            <label class=" control-label" for="textinput">General</label>
              <input id="textinput" name="nombreCompleto" placeholder="Nombre de Empresa Completo" class="form-control input-md" type="text" readonly value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaNombreCompleto()}"/>">
              <input id="textinput" name="Nombre Corto" placeholder="Nombre Corto" class="form-control input-md" type="text"  readonly value="<c:out value="${model.requestLoginVO.empresaEntity.getIdEmpresa()}"/>">
              <input id="textinput" name="IdAction" placeholder="IdAction" class="form-control input-md" type="text" readonly value="<c:out value="${model.requestLoginVO.empresaEntity.getIdAction()}"/>">
              <input id="textinput" name="RFC" placeholder="RFC" class="form-control input-md" type="text" readonly value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaRFC()}"/>">
              <input id="textinput" name="Direccion" placeholder="Direccion" class="form-control input-md" type="text" readonly value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaDireccion()}"/>">
              <input id="textinput" name="email" placeholder="email" class="form-control input-md" type="text" readonly value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaEmail()}"/>">
              <input id="textinput" name="contacto" placeholder="contacto" class="form-control input-md" type="text" readonly value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaContacto()}"/>">
              <input id="textinput" name="representante" placeholder="representante" class="form-control input-md" type="text" readonly value="<c:out value="${model.requestLoginVO.empresaEntity.getEmpresaRepresentante()}"/>">
              <br>

</div>
  <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="usuario-tab">
             	<label class=" control-label" for="textinput">Usuarios</label>
              	<br>
</div>
  <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="status-tab">
	             <label class=" control-label" for="textinput">Status</label>
	              <input id="textinput" name="status" placeholder="status" class="form-control input-md" type="text">
	              <input id="textinput" name="modo de pago" placeholder="modo de pago" class="form-control input-md" type="text">
	              <input id="textinput" name="fecha de corte" placeholder="fecha de corte" class="form-control input-md" type="text">
	              <br>
              
              <label class=" control-label" for="textinput">Factura</label> 
              <input id="textinput" name="link Factura" placeholder="link Factura" class="form-control input-md" type="text">
              

</div>
</div>
          
          <!-- end section -->
