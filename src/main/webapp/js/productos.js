$(document).ready(function(){
	
	var idProducto = $('#idProducto').val();
	var idAction = $('#idAction').val();
	
	$('#modeloPagina').change(function(){
		 
		 var modeloPagina = $('#modeloPagina').val();
		 console.log(modeloPagina);
		 console.log(idProducto);
		 if(modeloPagina !== ""){
			 $('#moduloEdicionCheck').attr('disabled', false);
			 $('#moduloClienteCheck').attr('disabled', false);
			 $('#moduloCitaCheck').attr('disabled', false);
			 $('#moduloCarpetaCheck').attr('disabled', false);
			 $('#moduloRetroAlimentacionCheck').attr('disabled', false);
			 $('#moduloChatCheck').attr('disabled', false);
			 $('#moduloNotificacionesCheck').attr('disabled', false);
			 $('#moduloVideoCheck').attr('disabled', false);
			 $('#moduloTarjetaCheck').attr('disabled', false);

			 $('#moduloEdicionCheck').prop('checked', true);
			if($('#moduloEdicionCheck').prop('checked')){
			    $('#moduloEdicion').collapse('show');
			    $('#empresaEdicion').val("activo");
			    $('#empresaModulos').val("11");
			    $('#idEmpresaPagina').val(idProducto);
			    $('#idActionPagina').val(idAction);
				 $('#guardarPagina').attr('disabled', false);
	        }else{
	        	$('#moduloEdicion').collapse('hide');
	        	$('#empresaModulos').val("");
	        	 $('#idEmpresaPagina').val("");
	        	 $('#idActionPagina').val("");
	        	}
		 }else{
			 $('#moduloEdicionCheck').prop('checked', false);
			 $('#moduloEdicionCheck').attr('disabled', true);
			 $('#idEmpresaPagina').val("");
			 $('#idActionPagina').val("");
		 }
	 });
	
	
	$('#moduloClienteCheck').change(function(){
		if($('#moduloClienteCheck').prop('checked')){
            $('#moduloCliente').collapse('show');
            $('#empresaClientes').val("activo");
            $('#empresaModulos').val("11,21,22");
        }else{
        	$('#moduloCliente').collapse('hide');
        	$('#empresaModulos').val("11");
        	}
//		console.log($('#empresaModulos').val())
        });
	
	$('#moduloCitaCheck').change(function(){
		if($('#moduloCitaCheck').prop('checked')){	
			$('#moduloClienteCheck').prop("checked", true);
			$('#moduloCliente').collapse('show');
			$('#moduloClienteCheck').prop("disabled", true);
            $('#moduloCita').collapse('show');
            $('#empresaClientes').val("activo");
            for(i=0; i<24; i++){
            	$('#cita11').append('<option value="'+i+'00">'+i+':00</option>')
            }
            for(i=0; i<24; i++){
            	$('#citaS21').append('<option value="'+i+'00">'+i+':00</option>')
            }
            
            
            if($('#moduloCarpetaCheck').prop('checked')){
            	$('#empresaModulos').val("11,21,22,31,41");
            }else{
            	$('#empresaModulos').val("11,21,22,31");
            }
        }else{
        	$( "div" ).remove( "#limpiaAlertaCita" );
        	$('#moduloCita').collapse('hide')
        	$('#empresaModulos').val("11");
        	if($('#moduloCarpetaCheck').prop('checked')){
				$('#moduloClienteCheck').prop("checked", true);
				$('#moduloCliente').collapse('show');
				$('#moduloClienteCheck').prop("disabled", true);
				$('#empresaModulos').val("11,21,22,41");
			}else{
	        	$('#moduloCliente').collapse('hide');
	        	$('#moduloClienteCheck').prop("checked", false);
				$('#moduloClienteCheck').prop("disabled", false);
				$('#empresaModulos').val("11");
				}
        	}
//		console.log($('#empresaModulos').val());
	});
	
	
	$('#moduloCarpetaCheck').change(function(){
		if($('#moduloCarpetaCheck').prop('checked')){
			$('#moduloClienteCheck').prop("checked", true);
			$('#moduloCliente').collapse('show');
			$('#moduloClienteCheck').prop("disabled", true);
            $('#moduloCarpeta').collapse('show');
            $('#empresaCarpetas').val("activo");
            $('#empresaClientes').val("activo");
            if($('#moduloCitaCheck').prop('checked')){
            	$('#empresaModulos').val("11,21,22,31,41");
            }else{
            	$('#empresaModulos').val("11,21,22,41");
            }
        }else{
        	$('#moduloCarpeta').collapse('hide');
        	$('#empresaModulos').val("11");
        	if($('#moduloCitaCheck').prop('checked')){
				$('#moduloClienteCheck').prop("checked", true);
				$('#moduloCliente').collapse('show');
				$('#moduloClienteCheck').prop("disabled", true);
				$('#empresaModulos').val("11,21,22,31");
			}else{
	        	$('#moduloCliente').collapse('hide');
	        	$('#moduloClienteCheck').prop("checked", false);
				$('#moduloClienteCheck').prop("disabled", false);
				$('#empresaModulos').val("11");
				}
        }
//		console.log($('#empresaModulos').val())
	});
	
	$('#moduloQRRestauranteCheck').change(function(){
		if($('#moduloQRRestauranteCheck').prop('checked')){
            $('#moduloQRRestaurante').collapse('show');
            $('#empresaQRRestaurante').val("activo");
            $('#empresaModulos').val("51");
        }else{
        	$('#moduloQRRestaurante').collapse('hide');
        	$('#empresaModulos').val("");
        	}
//		console.log($('#empresaModulos').val())
        });
	
	$('#moduloQREstacionamientoCheck').change(function(){
		if($('#moduloQREstacionamientoCheck').prop('checked')){
            $('#moduloQREstacionamiento').collapse('show');
            $('#empresaQREstacionamiento').val("activo");
            $('#empresaModulos').val("61");
        }else{
        	$('#moduloQREstacionamiento').collapse('hide');
        	$('#empresaModulos').val("");
        	}
//		console.log($('#empresaModulos').val())
        });



	
	
	
	$('#cita11').change(function(){
		$("#cita12").empty();
		 for(var i = $(this).val()/100; i < 24 ; i++)
			 $("#cita12").append('<option value="'+(i+1)+'00">'+(i+1)+':00</option>');
	})
	$('#cita12').change(function(){
		$("#cita21").empty();
		 for(var i = $(this).val()/100; i < 24 ; i++)
			 $("#cita21").append('<option value="'+(i+1)+'00">'+(i+1)+':00</option>');
	})
	$('#cita21').change(function(){
		$("#cita22").empty();
		 for(var i = $(this).val()/100; i < 24 ; i++)
			 $("#cita22").append('<option value="'+(i+1)+'00">'+(i+1)+':00</option>');
	})
	
	$('#citaS21').change(function(){
		$("#citaS22").empty();
		 for(var i = $(this).val()/100; i < 24 ; i++)
			 $("#citaS22").append('<option value="'+(i+1)+'00">'+(i+1)+':00</option>');
	})
	
	
	$('#saveCita').click(function(){
		//{"dias1": "0-4", "dias2": "5", "horario11in": "900", "horario12in": "1500", "horario11out": "1400", "horario12out": "1800"}
		citaJson = {dias1: "0-4", 
					dias2: "5",
					horario11in: $('#cita11').val(),
					horario11out: $('#cita12').val(),
					horario12in: $('#cita21').val(),
					horario12out: $('#cita22').val(),
					horario21in: $('#citaS21').val(),
					horario22out: $('#citaS22').val()
					};
		//console.log(citaJson);
		$('#empresaCitas').val(JSON.stringify(citaJson))
		  alerta="<div id='limpiaAlertaCita' class='alert alert-success' role='alert'>Modulo Citas Activado</div>";
		  $(alerta).insertAfter($('#moduloCitalabel'));
	});

	
	$('#guardarPagina').click(function(){
		console.log("guardar pagina");
		$('#activoPagina').collapse('show');
		$('#guardarProducto').attr('disabled', false);
	});
	
	 
})  // fin de documento


 