/*
 * funciones de table Genericas
 */

	/*
	 * Acciones de EVENTOS userEmpresaTable
	 */

 function operateFormatterUpdateCliente(value, row, index) {
	    return [
	      '<a class="like" href="javascript:void(0)" data-toggle="modal" data-target="#modalEdicionCliente">',
	      '<i class="fa fa-3x fa-address-book" aria-hidden="true"></i>',
	      '</a>'
	    ].join('')
	  }
 function operateFormatterUpdateModulos(value, row, index) {
	    return [
	      '<a class="like" href="javascript:void(0)" data-toggle="modal" data-target="#modalEdicionProductos">',
	      '<i class="fa fa-3x fa-window-restore" aria-hidden="true"></i>',
	      '</a>'
	    ].join('')
	  }
 function operateFormatterUpdateSitioWeb(value, row, index) {
	    return [
	      '<a class="like" href="javascript:void(0)" >',
	      '<i class="fa fa-3x fa-bullseye" aria-hidden="true"></i>',
	      '</a>'
	    ].join('')
	  }
 function operateFormatterUpdateMenuQR(value, row, index) {
	    return [
	      '<a class="like" href="javascript:void(0)">' ,
	      '<i class="fa fa-3x fa-clone" aria-hidden="true"></i>',
	      '</a>'
	    ].join('')
	  }
	  
	  function operateFormatterDelete(value, row, index) {
		    return [
		      '<a class="remove" href="javascript:void(0)" title="Eliminar">',
		      '<i class="fa fa-2x fa-edit">',
		      '</a>'
		    ].join('')
		  }
	  

	  function alerta(){
//	  	alert("prueba js invocada desde html");
	  }
	 
	  
	
$(document).ready(function(){
	
	console.log($data);
	console.log(productos);
		
	window.operateEventsUpdateCliente = {
		    'click .like': function (e, value, row, index) {
//		    	console.log(row);
		    	$('#empresaNombreCompleto').val(row.empresaNombreCompleto);
		    	$('#idAction').val(row.idAction);
		    	$('#empresaEmail').val(row.empresaEmail);
		    	$('#empresaStatus').val(row.empresaStatus);
		    	$('#empresaFechaCorte').val(row.empresaFechaCorte);
		    	$('#empresaFactura').val(row.empresaFactura);
		    	$('#empresaModoPago').val(row.empresaModoPago);
		    	$('#empresaIdPerfilE').val(row.empresaIdPerfilE);
		    	$('#empresaNombreCorto').val(row.empresaNombreCorto);
		    	$('#empresaRFC').val(row.empresaRFC);
		    	$('#empresaDireccion').val(row.empresaDireccion);
		    	$('#empresaContacto').val(row.empresaContacto);
		    	$('#empresaTelefono').val(row.empresaTelefono);
		    	$('#idEmpresa').val(row.idEmpresa);
		    	$('#empresaIdPerfilI').val(row.empresaIdPerfilI);
		    	$('#empresaVarios').val(row.empresaVarios);
		    }
		   }
	
	window.operateEventsUpdateModulos = {
		    'click .like': function (e, value, row, index) {
		    	var idEmpresa = row.idEmpresa;
		    	$('.form-check-input').attr('checked', false);
		    	for(a in productos){
		    		var idEmpresaProductos = productos[a].idEmpresa;
		    		if(idEmpresaProductos === idEmpresa){
		    			var productosEmpresa = productos[a];
//		    			console.log(productosEmpresa);
		    			$('#checkPagina').attr('checked', productosEmpresa.checkPagina);
//		    			if(productosEmpresa.checkPagina){}
				    	$('#checkQRR').attr('checked', productosEmpresa.checkQRR);
				    	$('#checkQRE').attr('checked', productosEmpresa.checkQRE);
				    	$('#checkPuntoVenta').attr('checked', productosEmpresa.checkPuntoVenta);
				    	$('#clientePagina').attr('checked', productosEmpresa.clientePagina);
				    	$('#carpetaPagina').attr('checked', productosEmpresa.carpetaPagina);
				    	$('#retroalimentacionPagina').attr('checked', productosEmpresa.retroalimentacionPagina);
				    	$('#chatPagina').attr('checked', productosEmpresa.chatPagina);
				    	$('#notificacionPagina').attr('checked', productosEmpresa.notificacionPagina);
				    	$('#videoPagina').attr('checked', productosEmpresa.videoPagina);
				    	$('#tarjetaPagina').attr('checked', productosEmpresa.tarjetaPagina);
				    	$('#idEmpresaProducto').attr('checked', productosEmpresa.idEmpresa);
		    		}
		    	}
		    	
		    }
		   }
	
	window.operateEventsUpdateSitioWeb = {
		    'click .like': function (e, value, row, index) {
		    	console.log(row.idAction);
			    $('#divEdicion').empty();
			    window.location.replace("edicion.htm?idAction="+row.idAction+"&tipo="+"" );	
			    }
		   }
	window.operateEventsUpdateMenuQR = {
		    'click .like': function (e, value, row, index) {
		    	console.log(row.idAction);
		    	window.location.href = "edicion.htm?idAction="+row.idAction+"&tipo=qr" ;
		    }
		   }
	
	
	window.operateEventsDelete = {
	    'click .remove': function (e, value, row, index) {
	    	confirm("Estás seguro de Eliminar el Registro : "+row.idAction);
	    	$('#clientesTable').bootstrapTable('remove', {
	        field: 'idAction',
	        values: [row.idCliente]
	      });
	      console.log(row);
	      deleteEmpresa(row.idAction);
	    }
	  }
	
	$('#clientesTable').bootstrapTable({data : $data});
	
	


	function stringToList(cadena){
		return cadena.split(";");
	}
		
	
}); // Fin documento

function getEdicionSitioWeb(idAction){
	
}

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


function checkStatusInstructor(){
	$('#statusInstructorbtn').html("Instructor Baja");
	$('#statusInstructorbtn').removeClass("btn-info");
	$('#statusInstructorbtn').addClass("btn-danger");
	var r = confirm("Seguro de dar de baja al Instructor, esta operacion no se puede reversar, tendría que dar de Alta Instructor nuevo.")
	if(r){
		$('#statusInstructor').val("Baja");
	}	
}
