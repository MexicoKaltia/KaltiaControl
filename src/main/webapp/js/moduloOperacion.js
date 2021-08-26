$(document).ready(function(){
	
	
	
	
	//productos
	if(productos["checkPagina"]){
//		console.log("checkPagina");
		$('#accordionProductos').append(checkPaginaEdicion);
		
	}if(productos["checkQRR"]){
//		console.log("checkQRR");
		$('#accordionProductos').append(checkQRREdicion);
		
	}if(productos["checkQRE"]){
//		console.log("checkQRE");
		$('#accordionProductos').append(checkQREEdicion);
		
	}if(productos["checkPuntoVenta"]){
//		console.log("checkQRE");
		$('#accordionProductos').append(checkPuntoVentaEdicion);
		
	}
	// modulos sencillos
	if(productos["checkClientePagina"]){
//		console.log("checkClientePagina");
		$('#accordionModulosS').append(userTable);
		
	}if(productos["checkChatPagina"]){
//		console.log("checkChatPagina");
		$('#accordionModulosS').append(checkChatEdicion);
		
	}if(productos["checkVideoPagina"]){
//		console.log("checkVideoPagina");
		$('#accordionModulosS').append(checkVideoEdicion);
		
	}if(productos["checkTarjetaPagina"]){
//		console.log("checkTarjetaPagina");
		$('#accordionModulosS').append(checkTarjetaEdicion);
		
	}if(productos["checkRetroalimentacionPagina"]){
//		console.log("checkRetroalimentacionPagina");
		$('#accordionModulosS').append(checkRetroalimentacionEdicion);
		
	}
	// modulos compuestos
	if(productos["checkCitaPagina"]){
//		console.log("checkCitaPagina");
		$('#accordionModulosC').append(checkCitaEdicion);
		
	}if(productos["checkCarpetaPagina"]){
//		console.log("checkCarpetaPagina");
		$('#accordionModulosC').append(checkCarpetaEdicion);
		
	}if(productos["checkNotificacionPagina"]){
//		console.log("checkNotificacionPagina");
		$('#accordionModulosC').append(checkNotificacionEdicion);
		
	}
	
//	for(a in productos){
//		console.log(a);
//		console.log(productos[a]);
//	}
		
}); // Fin documento
//idEmpresa=$('#idEmpresa').val();
//console.log($idEmpresa);

var checkPaginaEdicion = '<div class="card">\
						    <div class="card-header" id="headingOne">\
								<h5 class="mb-0">\
								  <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapsePagina" aria-expanded="true" aria-controls="collapseOne">\
										Edicion Contenido Pagina WEB\
								  </button>\
								</h5>\
							</div>\
							<div id="collapsePagina" class="collapse " aria-labelledby="headingOne" data-parent="#accordion">\
								<div class="card-body">\
									Acceso al modulo de Edicion Pagina Web\
									<a href="edicion.htm?idAction='+idAction+'&tipo="+"" class="btn btn-default addUserEmpresaBtn"><i class="fa fa-4x fa-bullseye" aria-hidden="true"></i><h1>Edicion Web</h1></a>\
								</div>\
							</div>\
						</div>';

var checkQRREdicion = '<div class="card">\
						    <div class="card-header" id="headingOne">\
							<h5 class="mb-0">\
							  <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseQRR" aria-expanded="true" aria-controls="collapseOne">\
									Edicion Contenido Menu WEB\
							  </button>\
							</h5>\
						</div>\
						<div id="collapseQRR" class="collapse " aria-labelledby="headingOne" data-parent="#accordion">\
							<div class="card-body">\
								Acceso al modulo de Edicion Menu Web\
								<a href="edicion.htm?idAction='+idAction+'&tipo=qr" class="btn btn-default addUserEmpresaBtn"><i class="fa fa-4x fa-bullseye" aria-hidden="true"></i><h1>Edicion Menu</h1></a>\
							</div>\
						</div>\
					</div>';

var checkQREEdicion = '<div class="card">\
						<div class="card-header" id="headingOne">\
						<h5 class="mb-0">\
						  <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseQRE" aria-expanded="true" aria-controls="collapseOne">\
								Edicion QRE WEB\
						  </button>\
						</h5>\
						</div>\
						<div id="collapseQRE" class="collapse " aria-labelledby="headingOne" data-parent="#accordion">\
						<div class="card-body">\
							Acceso al modulo de Edicion QRE Web\
							<a href="edicion.htm?idAction='+idAction+'&tipo="+"qr" class="btn btn-default addUserEmpresaBtn"><i class="fa fa-4x fa-bullseye" aria-hidden="true"></i><h1>Edicion QRE Web</h1></a>\
						</div>\
						</div>\
					</div>';

var checkPuntoVenta = '<div class="card">\
							<div class="card-header" id="headingOne">\
							<h5 class="mb-0">\
							  <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapsePV" aria-expanded="true" aria-controls="collapseOne">\
									Edicion Punto de Venta WEB\
							  </button>\
							</h5>\
							</div>\
							<div id="collapsePV" class="collapse " aria-labelledby="headingOne" data-parent="#accordion">\
							<div class="card-body">\
								Acceso al modulo de Edicion Punto de Venta Web\
								<a href="edicion.htm?idAction='+idAction+'&tipo="+"pv" class="btn btn-default addUserEmpresaBtn"><i class="fa fa-4x fa-bullseye" aria-hidden="true"></i><h1>Edicion Punto de Venta Web</h1></a>\
							</div>\
							</div>\
						</div>'; 



//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	/*
	 * modulos sencillos
	 */
var userTable = '<div class="card">\
					<div class="card-header" id="headingOne">\
					<h5 class="mb-0">\
					  <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseUsuarios" aria-expanded="true" aria-controls="collapseOne">\
							Edicion Usuarios Clientes\
					  </button>\
					</h5>\
					</div>\
					<div id="collapseUsuarios" class="collapse " aria-labelledby="headingOne" data-parent="#accordion">\
						<div class="card-body">\
						  <div class="table-responsive">\
							<table id="usuariosEmpresaTable" data-row-style="rowStyle" class="table-dark" data-locale="es-MX" data-toggle="table"  data-sort-name="statusRegistro" data-sort-order="asc" data-pagination="true" data-page-list="[10, 25, 50, 100, 200, Todos]" data-search="true" data-click-to-select="true" data-checkbox-header="false" >\
								<thead class="thead-dark">\
									<tr>\
										<th data-width="40" data-width-unit="%" data-halign="center" data-align="left" data-field="nombreRegistro" data-sortable="true">Nombre</th>\
										<th data-width="20" data-width-unit="%" data-halign="center" data-align="left" data-field="statusRegistro" data-sortable="true">Status</th>\
										<th data-width="20" data-width-unit="%" data-halign="center" data-align="left" data-field="messageRegistro" data-sortable="true">Observaciones</th>\
										<th data-width="10" data-width-unit="%" data-halign="center" data-align="left" data-field="operateUpdate" data-formatter="operateFormatterUpdateUsuariosEmpresa" data-events="window.operateEventsUpdateUsuariosEmpresa">Editar</th>\
										<th data-width="10" data-width-unit="%" data-halign="center" data-align="left" data-field="operateDelete" data-formatter="operateFormatterDelete" data-events="window.operateEventsDelete">Eliminar</th>\
									</tr>\
								</thead>\
							</table>\
							<script>\
						    function rowStyle(row, index){\
						        return {\
						            css : {\
						                 color: "cyan",\
						                 background: "rgba(1,50,105, 0.8)!important"\
						             }\
						        }\
							}\
						</script>\
						</div>\
					</div>\
					<div class="report-footer">\
						<span>\
							<a id="addUser" data-toggle="modal" data-target="#modalRegistro"class="btn btn-default addUserEmpresaBtn"><i class="fa fa-2x fa-user-plus" aria-hidden="true"></i></a>\
						</span>\
					</div>\
				<div>\
			</div>';
var urlVideos = 'http://129.146.252.2:8010/consultaVideos?idEmpresa='+idEmpresa;
//var urlVideos = 'http://localhost:8010/consultaVideos?idEmpresa='+idEmpresa;
//console.log(urlVideos);
var checkVideoEdicion ='<div class="card">\
						    <div class="card-header" id="headingOne">\
								<h5 class="mb-0">\
								  <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseVideo" aria-expanded="true" aria-controls="collapseOne">\
								    EDICION VIDEO\
								  </button>\
								</h5>\
							</div>\
							<div id="collapseVideo" class="collapse " aria-labelledby="headingOne" data-parent="#accordion">\
								<div class="card-body" >\
								   <form id="formAddVideo" action="addVideo.htm" method="post" modelAttribute="videoEntity"><div class="well auth-box"><fieldset>\
								    <div class="form-row">\
								      <div class="form-group col-md-3">\
								         <label class="form-label" for="name">Titulo Video</label>\
								         <input type="text" class="form-control input-md" id="videoTitulo" name="videoTitulo" placeholder="titulo Video" maxlength="40"  required>\
								      </div>\
								     <div class="form-group col-md-8">\
								       <label class="form-label" for="name">URL Video</label>\
								       <input type="url" class="form-control" id="videoURL" name="videoURL" placeholder="URL Video"  required>\
								     </div>\
								     <div class="col-md-1">\
								       <button class="btn btn-primary" id="addVideo"  >\
										   <i class="fa-3x fa fa-plus-square"></i>\
										</button>\
								     </div>\
								  </div>\
								</fieldset></div></form>\
								<br>\
								<div id="divVideos>\
								<form><div class="well auth-box"><fieldset>\
									<div class="table-responsive">\
									<table  id="videosTable" data-row-style="rowStyleVideosTable" data-toggle="table" data-url="'+urlVideos+'">\
									  <thead>\
									    <tr>\
									      <th data-width="20" data-width-unit="%" data-halign="center" data-align="left" data-field="videoTitulo">Titulo Video</th>\
									      <th data-width="60" data-width-unit="%" data-halign="center" data-align="left" data-field="videoURL" >URL</th>\
									      <th data-width="10" data-width-unit="%" data-halign="center" data-align="left" data-field="operateAcceso" data-formatter="operateFormatterAccesoVideo" data-events="window.operateEventsAccesoVideo">Acceso</th>\
									      <th data-width="10" data-width-unit="%" data-halign="center" data-align="left" data-field="operateDelete" data-formatter="operateFormatterDeleteVideo" data-events="window.operateEventsDeleteVideo">Eliminar</th>\
									    </tr>\
									  </thead>\
									  </table>\
									  <script>\
									    function rowStyleVideosTable(row, index){\
									        return {\
									            css : {\
									                 color: "cyan",\
									                 background: "rgba(1,50,105, 0.8)!important"\
									             }\
									        }\
										}\
									</script>\
									</div>\
								</fieldset></div></form>\
							</div>\
						</div>\
					</div>\
				</div>';

var checkChatEdicion = '<div class="card">\
    <div class="card-header" id="headingOne">\
	<h5 class="mb-0">\
	  <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseChat" aria-expanded="true" aria-controls="collapseOne">\
	    EDICION CHAT\
	  </button>\
	</h5>\
</div>\
<div id="collapseChat" class="collapse " aria-labelledby="headingOne" data-parent="#accordion">\
	<div class="card-body">\
	<form id="formAddNumeroChat" action="addNumeroChat.htm" method="post" modelAttribute="chatEntity">\
		<div class="well auth-box">\
			<fieldset>\
		    	<div class="form-row">\
		      		<div class="form-group col-8">\
		         		<label class="form-label" for="name">Agrega num de Whats App</label>\
		         		<input type="hidden" id="idActionChat" name="idAction">\
				 		<input type="text" class="form-control input-md" id="numeroChat" name="numeroChat" placeholder="Numero Chat" maxlength="10"  required>\
		      		</div>\
		     		<div class="col-1">\
		       			<button class="btn btn-primary" id="btnAddNumeroChat"  >\
				   			<i class="fa-3x fa fa-plus-square"></i>\
						</button>\
		     		</div>\
		  		</div>\
			</fieldset>\
		</div>\
	</form>\
</div>\
</div>\
</div>';

var checkTarjetaEdicion = '<div class="card">\
    <div class="card-header" id="headingOne">\
	<h5 class="mb-0">\
	  <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseTarjeta" aria-expanded="true" aria-controls="collapseOne">\
	    EDICION PRODUCTOS\
	  </button>\
	</h5>\
</div>\
<div id="collapseTarjeta" class="collapse " aria-labelledby="headingOne" data-parent="#accordion">\
	<div class="card-body">\
	<div class="well auth-box">\
		<fieldset>\
		    <div class="form-row container">\
		        <div class="col-md-6" id="divCategorias">\
					<label class="form-label" for="selectCategorias">Seleccione Categoria</label>\
		            <select class="form-control" id="selectCategorias">\
		                <option value="nuevenueve" selected>Seleccione Categoria</option>\
		                <option value="cero">Nueva Categoria</option>\
		            </select>\
		        </div>\
		        <div class="col-md-6" id="formNuevaCategoria"></div>\
		    </div>\
			<div class="container" id="divBotonesEdicion" >\
			</div>\
			<div class="form-row container">\
				<div class="col-md-12" id="divCarouselTajetaProductos">\
				</div>\
			</div>\
			<div class="form-row container">\
				<div class="col-md-12" id="divbtnActualizarProductos">\
				</div>\
			</div>\
		</fieldset>\
	</div>\
</div>\
</div>\
</div>';

var checkRetroalimentacionEdicion = '<div class="card">\
    <div class="card-header" id="headingOne">\
	<h5 class="mb-0">\
	  <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseRetroalimentacion" aria-expanded="true" aria-controls="collapseOne">\
	    EDICION ENCUESTA / RETRO ALIMENTACION \
	  </button>\
	</h5>\
</div>\
<div id="collapseRetroalimentacion" class="collapse " aria-labelledby="headingOne" data-parent="#accordion">\
	<div class="card-body">\
	  TEXT BODY\
	</div>\
</div>\
</div>';




//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
/*
 * modulos compuestos
 */
var checkCitaEdicion = '<div class="card">\
    <div class="card-header" id="headingOne">\
	<h5 class="mb-0">\
	  <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseCita" aria-expanded="true" aria-controls="collapseOne">\
	    EDICION CITAS\
	  </button>\
	</h5>\
</div>\
<div id="collapseCita" class="collapse " aria-labelledby="headingOne" data-parent="#accordion">\
	<div class="card-body">\
	  TEXT BODY\
	</div>\
</div>\
</div>';

var checkCarpetaEdicion = '<div class="card">\
    <div class="card-header" id="headingOne">\
	<h5 class="mb-0">\
	  <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseCarpeta" aria-expanded="true" aria-controls="collapseOne">\
	    EDICION DOCUMENTOS / CARPETAS\
	  </button>\
	</h5>\
</div>\
<div id="collapseCarpeta" class="collapse " aria-labelledby="headingOne" data-parent="#accordion">\
	<div class="card-body">\
	  TEXT BODY\
	</div>\
</div>\
</div>';

var checkNotificacionEdicion = '<div class="card">\
    <div class="card-header" id="headingOne">\
	<h5 class="mb-0">\
	  <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseNotificacion" aria-expanded="true" aria-controls="collapseOne">\
	    EDICION NOTIFICACION\
	  </button>\
	</h5>\
</div>\
<div id="collapseNotificacion" class="collapse " aria-labelledby="headingOne" data-parent="#accordion">\
	<div class="card-body">\
	  TEXT BODY\
	</div>\
</div>\
</div>';