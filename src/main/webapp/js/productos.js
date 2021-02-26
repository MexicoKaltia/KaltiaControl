$(document).ready(function(){
	
	var idProducto = $('#idProducto').val();
	var idAction = $('#idAction').val();
	var modeloPagina;
	$.modeloPagina;
	
	/*
	 * Modelo Pagina
	 */
	$('#modeloProducto').change(function(){
		modeloPagina = $('#modeloProducto').val();
		 console.log(modeloPagina);
		 console.log(idProducto);
		 if(modeloPagina !== ""){
			 $('.moduloPagina').attr('disabled', false);
			 $('.moduloQRR').attr('disabled', false);
			 $('.moduloCliente').attr('disabled', false);
			 $('.moduloCita').attr('disabled', false);
			 $('.moduloCarpeta').attr('disabled', false);
			 $('.moduloRetroAlimentacion').attr('disabled', false);
			 $('.moduloChat').attr('disabled', false);
			 $('.moduloNotificacion').attr('disabled', false);
			 $('.moduloVideo').attr('disabled', false);
			 $('.moduloTarjeta').attr('disabled', false);
			 $('#moduloEdicionCheck').prop('checked', true);
		 }else{
			 $('.moduloPagina').attr('disabled', true);
			 $('.moduloQRR').attr('disabled', true);
			 $('.moduloCliente').attr('disabled', true);
			 $('.moduloCita').attr('disabled', true);
			 $('.moduloCarpeta').attr('disabled', true);
			 $('.moduloRetroAlimentacion').attr('disabled', true);
			 $('.moduloChat').attr('disabled', true);
			 $('.moduloNotificacion').attr('disabled', true);
			 $('.moduloVideo').attr('disabled', true);
			 $('.moduloTarjeta').attr('disabled', true);
			 
			 $('.moduloPagina').prop('checked', false);
			 $('.moduloQRR').prop('checked', false);
			 $('.moduloCliente').prop('checked', false);
			 $('.moduloCita').prop('checked', false);
			 $('.moduloCarpeta').prop('checked', false);
			 $('.moduloRetroAlimentacion').prop('checked', false);
			 $('.moduloChat').prop('checked', false);
			 $('.moduloNotificacion').prop('checked', false);
			 $('.moduloVideo').prop('checked', false);
			 $('.moduloTarjeta').prop('checked', false);
			
			 $('#moduloPagina').collapse('hide');
			 $('#moduloQRR').collapse('hide');
			 $('#moduloCliente').collapse('hide');
			 $('#moduloCita').collapse('hide');
			 $('#moduloCarpeta').collapse('hide');
			 $('#moduloRetroAlimentacion').collapse('hide');
			 $('#moduloChat').collapse('hide');
			 $('#moduloNotificacion').collapse('hide');
			 $('#moduloVideo').collapse('hide');
			 $('#moduloTarjeta').collapse('hide');
			 
			 $('#guardarProducto').attr('disabled', true);
			 $('#guardarPagina').attr('disabled', true);
			 $('#guardarQRR').attr('disabled', true);
		
			 $('#activoPagina').collapse('hide');
			 $('#activoQRR').collapse('hide');
			 
			 $('#moduloEdicionCheck').prop('checked', false);
			 $('#moduloEdicionCheck').attr('disabled', true);
			 $('#idEmpresaPagina').val("");
			 $('#idActionPagina').val("");
		 }
	 });
	
		
	$('#guardarPagina').click(function(){
		console.log("guardar pagina");
		$('#activoPagina').collapse('show');
		$('#guardarProducto').attr('disabled', false);
		 
		$.modeloPagina = $("#modeloPagina option:selected").text();
		console.log($.modeloPagina);
		console.log(modeloPagina);
		$('#modeloQRR').empty();
		$('#modeloQRR').append('<option value="'+modeloPagina+'" selected >'+$.modeloPagina+'</option>');
		$('#modeloQRR').prop("disabled", true);
		
		
	});

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 *  ACTIVACION MODULOS
	 */
	
	/*
	 * PAGINA Editable
	 */
	$('.moduloPagina').change(function(){
		
		if($('.moduloPagina').prop('checked')){
			 $('#moduloPagina').collapse('show');
			 $('#guardarPagina').attr('disabled', false);
			 $('#guardarProducto').attr('disabled', false);
			 
			 console.log($('#checkPagina').prop('checked'));
			 
			 $('#idEmpresaPagina').val($('#idEmpresa').val());
			 $('#idActionPagina').val($('#idAction').val());
        }else{      	
        	console.log($('#checkPagina').prop('checked'));
        	$('#moduloPagina').collapse('hide');
        	$('#guardarPagina').attr('disabled', true);
        	$('#guardarProducto').attr('disabled', true);
        	
        	$('#idEmpresa').val($('#idProducto').val(""));
			$('#idActionPagina').val("");
        	}
        });

	/*
	 * QR Restaurante
	 */
	$('.moduloQRR').change(function(){
		if($('.moduloQRR').prop('checked')){
			console.log($('#checkQRR').prop('checked'));
    		
            $('#moduloQRR').collapse('show');
            $('#modeloEstaticoQRR').prop("disabled", false);
    		$('#modeloDinamicoQRR').prop("disabled", false);
    		 
    		$('#modeloEstaticoQRR').change(function(){
    			$('#guardarQRR').attr('disabled', false);
    		})
    		$('#modeloDinamicoQRR').change(function(){
    			 $('#guardarQRR').attr('disabled', false);
    		})
    		
    		
    	}else{
    		console.log($('#checkQRR').prop('checked'));
        	$('#moduloQRR').collapse('hide');
        	$('#modeloEstaticoQRR').prop("disabled", true);
    		$('#modeloDinamicoQRR').prop("disabled", true);
    		$('#guardarQRR').attr('disabled', true);
    		$('#guardarPagina').attr('disabled', true);
    		$('#idEmpresaQRR').val($('#idEmpresa').val(""));
			 $('#idActionQRR').val($('#idAction').val(""));
			 $('#modeloQRR').val($('#modeloPagina').val(""));
			 $('#tipoQRR').val("");
        }
		
     });
	
	$('#guardarQRR').click(function(){
		console.log("guardar QRR");
		$('#activoQRR').collapse('show');
		$('#moduloQRRActivo').collapse('show');
		
		$('#idEmpresaQRR').val($('#idEmpresa').val());
		$('#idActionQRR').val($('#idAction').val());
		$('#modeloQRR').val($('#modeloProducto').val());
		var tipoQRR = $('input:radio[name=radioQRR]:checked').val();
		$('#tipoQRR').val($('#modeloQRR').val()+tipoQRR);
		$('#idActionPagina').val($('#idAction').val());
		
		$('#guardarProducto').attr('disabled', false);
	});
	
	
	
	/*
	 * Cliente Pagina
	 */
	$('.moduloCliente').change(function(){
		if($('.moduloCliente').prop('checked')){
            $('#moduloCliente').collapse('show');
            $('#empresaClientes').val("activo");
            $('#empresaModulos').val("11,21,22");
        }else{
        	$('#moduloCliente').collapse('hide');
        	$('#empresaModulos').val("11");
        	}
//		console.log($('#empresaModulos').val())
        });
	
	/*
	 * Cita Pagina
	 */
	$('.moduloCita').change(function(){
		if($('.moduloCita').prop('checked')){	
			$('.moduloCliente').prop("checked", true);
			$('#moduloCliente').collapse('show');
			$('.moduloCliente').prop("disabled", true);
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

	
	
	/*
	 * CARPETA
	 */
	$('.moduloCarpeta').change(function(){
		
		if($('.moduloCarpeta').prop('checked')){
			$('#moduloCarpeta').collapse('show');
			$('.moduloCliente').prop("checked", true);
			$('#moduloCliente').collapse('show');
			$('.moduloCliente').prop("disabled", true);
        }else{
        	$('#moduloCarpeta').collapse('hide');
        	$('#moduloCliente').collapse('hide');
        	$('.moduloCliente').prop("checked", false);
        	$('.moduloCliente').prop("disabled", false);
        	}
        });

	/*
	 * RETROALIMENTACION
	 */
	$('.moduloRetroAlimentacion').change(function(){
		console.log($('.moduloRetroAlimentacion').prop('checked'));
		
		if($('.moduloRetroAlimentacion').prop('checked')){
			$('.moduloCliente').prop("checked", true);
			$('#moduloCliente').collapse('show');
			$('#qRRCliente').collapse('show');
			$('.moduloCliente').prop("disabled", true);
			$('#moduloRetroAlimentacion').collapse('show');
        }else{
        	$('#moduloRetroAlimentacion').collapse('hide');
        	$('#moduloCliente').collapse('hide');
        	$('.moduloCliente').prop("checked", false);
        	$('.moduloCliente').prop("disabled", false);
        	}
        });
	
	/*
	 * CHAT
	 */
	$('.moduloChat').change(function(){
		
		if($('.moduloChat').prop('checked')){
			$('#moduloChat').collapse('show');
        }else{      	
        	$('#moduloChat').collapse('hide');
        	}
//		console.log($('#empresaModulos').val())
        });
		
	/*
	 * NOTIFICACIONES
	 */
	$('.moduloNotificacion').change(function(){
		
		if($('.moduloNotificacion').prop('checked')){
			$('.moduloCliente').prop("checked", true);
			$('#moduloCliente').collapse('show');
			$('.moduloCliente').prop("disabled", true);
			$('#moduloNotificacion').collapse('show');
        }else{
        	$('#moduloNotificacion').collapse('hide');
        	$('#moduloCliente').collapse('hide');
        	$('.moduloCliente').prop("checked", false);
        	$('.moduloCliente').prop("disabled", false);
        	}
        });
	 
	/*
	 * VIDEOS
	 */
	$('.moduloVideo').change(function(){
		
		if($('.moduloVideo').prop('checked')){
			$('#moduloVideo').collapse('show');
        }else{      	
        	$('#moduloVideo').collapse('hide');
        	}
        });
	
	/*
	 * Tarjeta
	 */
	$('.moduloTarjeta').change(function(){
		
		if($('.moduloTarjeta').prop('checked')){
			$('#moduloTarjeta').collapse('show');
        }else{      	
        	$('#moduloTarjeta').collapse('hide');
        	}
        });
})  // fin de documento


 