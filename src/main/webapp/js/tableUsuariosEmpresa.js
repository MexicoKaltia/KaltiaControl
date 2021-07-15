/*
 * funciones de table Genericas
 */

	/*
	 * Acciones de EVENTOS userEmpresaTable
	 */

 function operateFormatterUpdateUsuariosEmpresa(value, row, index) {
	    return [
	      '<a class="like" href="javascript:void(0)" data-toggle="modal" data-target="#modalEdicionUsuariosEmpresa">',
	      '<i class="fa fa-3x fa-address-book" aria-hidden="true"></i>',
	      '</a>'
	    ].join('')
	  }
 	  
	  function operateFormatterDelete(value, row, index) {
		    return [
		      '<a class="remove" href="javascript:void(0)" title="Eliminar">',
		      '<i class="fa fa-3x fa-edit">',
		      '</a>'
		    ].join('')
		  }
	  

	  function alerta(){
//	  	alert("prueba js invocada desde html");
	  }
	 
	  
	
$(document).ready(function(){
	
//	console.log(usuariosEmpresa);
	
		
	window.operateEventsUpdateUsuariosEmpresa = {
		    'click .like': function (e, value, row, index) {
		    	console.log(row);
		    	$('#nombreRegistro').val(row.nombreRegistro);
		    	$('#emailRegistro').val(row.emailRegistro);
		    	$('#telefonoRegistro').val(row.telefonoRegistro);
		    	$('#usuarioRegistro').val(row.usuarioRegistro);
		    	$('#passRegistro1').val(row.passRegistro);
		    	$('#messageRegistro').val(row.messageRegistro);
		    	
		    }
		   }
	
	window.operateEventsDelete= {
		    'click .like': function (e, value, row, index) {
		    	console.log(row);
		    }
		   }
	
	
	$('#usuariosEmpresaTable').bootstrapTable({data : usuariosEmpresa});
	
	
}); // Fin documento


function deleteEmpresa(idAction){
	console.log("4"+idAction);
	var jsonRequest = {
			'idAction' : idAction
	}
	var url = 'eliminarEmpresa.htm?idAction='+idAction;
	$.ajax({
	   	  url: url,
	      dataType: 'json',
		  type: 'POST',
		  contentType: "application/json",
		  data: JSON.stringify(jsonRequest),
		  headers: {  'Access-Control-Allow-Origin': url, 'Access-Control-Allow-Methods': 'POST, GET, OPTIONS', 'Access-Control-Allow-Headers': 'X-PINGOTHER' },
		  crossDomain: true,
		 
		});
	
}


