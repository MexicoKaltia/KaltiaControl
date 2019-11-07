/**
 * Archivo de control JS para la pagina de Modulo 
 */

$(document).ready(function(){
	
	/*
	 * Variables Globales
	 */
//	var url = "http://31.220.63.183:8010/";
//	var urlUpload= "http://31.220.63.183:8011/";
//	var urlCita = "http://31.220.63.183:8012/";
	var url = "http://localhost:8010/";
	var urlUpload= "http://localhost:8011/";
	var urlCita = "http://localhost:8012/";
	
	$.idEmpresa = $("#idEmpresa").val();
	$.action = $("#idAction").val();
	$.idUserEmpresa ="";
	
	$.userEmpresa = $(function(){
		readIdUserEmpresa("0");
	});



	
/*
 * Rest jquery
 */	
	$('#altabtnSaveRegistro').click(function(){
		limpiaAlerta();
		valoresRegistro = $('#altanombreRegistro').val()+"++"+$('#altaapellidoRegistro').val()+"++"+$('#altaemailRegistro').val()+"++"+$('#altatelefonoRegistro').val()+"++"+$('#altausuarioRegistro').val()+"++"+$('#altapassRegistro1').val()+"++"+$('#altamessageRegistro').val();
		 
			registroJson = { action : $.action,
				 idEmpresa : $.idEmpresa,	
//				 seccion : "bodySeccionArray1",
				 valoresFinales : valoresRegistro}
			console.log(registroJson);

		$.ajax({
		   	  url: url +"createUserEmpresa/",//+ context,//+finalJson.action+"/"+finalJson[1],
		      dataType: 'json',
			  type: 'POST',
			  contentType: "application/json",
			  data: JSON.stringify(registroJson),
			  headers: {  'Access-Control-Allow-Origin': url, 'Access-Control-Allow-Methods': 'POST, GET, OPTIONS', 'Access-Control-Allow-Headers': 'X-PINGOTHER' },
			  crossDomain: true,
			  success: 	function(data){					  
				  console.log(data);
				  if(data.codigo===0){
					  avisaAlerta(data);}
				},
			  error: function(){
				  errorAlerta();
			  }
			});
	});
	
	
		function readIdUserEmpresa(idUserEmpresa){
		limpiaAlerta();
		valoresRegistro = $('#readidUserEmpresa').val();
		$.idUserEmpresa = idUserEmpresa
		 
			registroJson = { idAction : $.action,
							idUserEmpresa : $.idUserEmpresa,	
//				 seccion : "bodySeccionArray1",
//				 valoresFinales : valoresRegistro
				 }
			console.log(registroJson);

		$.ajax({
		   	  url: url +"readUserEmpresa/"+$.action+"/"+$.idUserEmpresa,
		      dataType: 'json',
			  type: 'GET',
			  contentType: "application/json",
//			  data: JSON.stringify(registroJson),
			  headers: {  'Access-Control-Allow-Origin': url, 'Access-Control-Allow-Methods': 'POST, GET, OPTIONS', 'Access-Control-Allow-Headers': 'X-PINGOTHER' },
			  crossDomain: true,
			  success: 	function(data){					  
				  console.log(data);
				  if(data.codigo===0){
					  avisaAlerta(data);}
				},
			  error: function(){
				  errorAlerta();
			  }
			});
	}
	
	
	
	
	
	
	
	
	
	function limpiaAlerta(){
		$( "div" ).remove( "#limpiaAlerta" );
	}
	function errorAlerta(){
		alerta="<div id='limpiaAlerta' class='alert alert-danger' role='alert'>Error de Enlace</div>";
		$(alerta).insertAfter($('.alerta_in'));
	}
	
	function avisaAlerta(data){
		limpiaAlerta();
		 if(data.codigo===0){
//			  validaUsuarioEmpresa(data.mensajeArray);
			  alerta="<div id='limpiaAlerta' class='alert alert-success' role='alert'>"+data.codigo+" "+data.mensaje.toString()+"</div>";
			  $(alerta).insertAfter($('.alerta_in'));//.delay(2000);
			  
//			  location.reload();
		  }else{
			  alerta="<div id='limpiaAlerta' class='alert alert-warning' role='alert'>"+data.codigo+" "+data.mensaje.toString()+"</div>";
				$(alerta).insertAfter($('.alerta_in'));
		  }
	}
		
}); // Fin documento



