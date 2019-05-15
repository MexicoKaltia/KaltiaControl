$(document).ready(function(){
	
	$('#empresaFechaCorte').ready(function(){
		
	var d = new Date();
	var mesD = d.getMonth()+1;
	var anio = d.getFullYear();
	var meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
	if(d.getMonth === 11){
		 mesD = 0;
		 anio = d.getFullYear() + 1;
	}
//		console.log("Periodo : " + d.getDate() + "/" + meses[d.getMonth()] + "/" + d.getFullYear() +"---"+  d.getDate() + "/" + meses[mesD] + "/" + anio);
	$('#empresaFechaCorte').val("Periodo : " + d.getDate() + "/" + meses[d.getMonth()] + "/" + d.getFullYear() +" hasta "+  d.getDate() + "/" + meses[mesD] + "/" + anio);
	
	})
	
	$('#IdAction').change(function(){
		var IdAction = $('#IdAction').val();
		
		$('#empresaIdPerfilE').val(IdAction + "@kaltia.xyz");
		$('#empresaFactura').val("www.kaltiaControl.xyz/factura/"+IdAction)
		
	});
	
	$('#userKaltiaControlPass1').change(function(){
		var pass = $('#userKaltiaControlPass').val();
		
		if(pass !== $('#userKaltiaControlPass1').val())
		alert("La contraseña no son iguales");
		else{
			$('#savePass').prop('disabled', false);
			$('#empresaIdPerfilE').val($('#empresaIdPerfilE').val()+$('#userKaltiaControlPass1').val())
		
		}
		
	});
	
//	$('#moduloEdicionCheck').on(function(){
//		alert(true);
//		if($('#moduloEdicionCheck').prop('checked'))
//        {
//            $('#moduloEdicion').collapse('show');
//        }else{
//        	$('#moduloEdicion').collapse('hide');
//        }
//	})


	$('#moduloClienteCheck').change(function(){
		if($('#moduloClienteCheck').prop('checked'))
        {
            $('#moduloCliente').collapse('show');
            $('#empresaClientes').val("activo");
        }else{
        	$('#moduloCliente').collapse('hide')
        	}
        })
      
	$('#moduloCitaCheck').change(function(){
		if($('#moduloCitaCheck').prop('checked')){	
			$('#moduloClienteCheck').prop("checked", true);
			$('#moduloCliente').collapse('show');
			$('#moduloClienteCheck').prop("disabled", true);
            $('#moduloCita').collapse('show');
            $('#empresaClientes').val("activo");
        }else{
        	$( "div" ).remove( "#limpiaAlertaCita" );
        	$('#moduloCita').collapse('hide')
        	if($('#moduloCarpetaCheck').prop('checked')){
				$('#moduloClienteCheck').prop("checked", true);
				$('#moduloCliente').collapse('show');
				$('#moduloClienteCheck').prop("disabled", true);
				}else{
	        	$('#moduloCliente').collapse('hide');
	        	$('#moduloClienteCheck').prop("checked", false);
				$('#moduloClienteCheck').prop("disabled", false);
				}
        	}

//		$("#moduloCita").on("hide.bs.collapse", function(){
//		    $(".btn").html('<span class="glyphicon glyphicon-collapse-down"></span> Activar moduloCita');
//		  });
//		  $("#moduloCita").on("show.bs.collapse", function(){
//		    $(".btn").html('<span class="glyphicon glyphicon-collapse-up"></span> NO activar Cita');
//		  });
	})
	$('#moduloCarpetaCheck').change(function(){
		if($('#moduloCarpetaCheck').prop('checked'))
        {
			$('#moduloClienteCheck').prop("checked", true);
			$('#moduloCliente').collapse('show');
			$('#moduloClienteCheck').prop("disabled", true);
            $('#moduloCarpeta').collapse('show');
            $('#empresaCarpetas').val("activo");
            $('#empresaClientes').val("activo");
        }else{
        	$('#moduloCarpeta').collapse('hide');
        	if($('#moduloCitaCheck').prop('checked')){
				$('#moduloClienteCheck').prop("checked", true);
				$('#moduloCliente').collapse('show');
				$('#moduloClienteCheck').prop("disabled", true);
				}else{
	        	$('#moduloCliente').collapse('hide');
	        	$('#moduloClienteCheck').prop("checked", false);
				$('#moduloClienteCheck').prop("disabled", false);
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
					horario22out: $('#citaS22').val(),
						};
		console.log(citaJson);
		$('#empresaCitas').val(JSON.stringify(citaJson))
		  alerta="<div id='limpiaAlertaCita' class='alert alert-success' role='alert'>Modulo Citas Activado</div>";
		  $(alerta).insertAfter($('#moduloCitalabel'));
	})
		
});



//$('#horCitaLV').change(function(){
//	//Horario L-V (9:00-13:00,14:00-18:00)
//	
//	if( !$('#horCitaLV').val().includes('\:') || $('#horCitaLV').val()==null || $('#horCitaLV').val()==""){
//		hrInvalido();
//	}else{
//		if( $('#horCitaLV').val().includes('\,')){
//			var hrSplit = $('#horCitaLV').val().split('\,')
//			if(hrSplit[0]==null || hrSplit[0]==""){
//				hrInvalido();
//			}else{
//				var hr1S = $('#horCitaLV').val().split('\,')
//				if(!hrSplit[0].includes('\-')){
//					hrInvalido();
//				}else{
//					var hr1S = hrSplit[0].split('\-');
//					hr1S[0] = hr1S[0].replace('\:','');
//					hr1S[1] = hr1S[1].replace('\:','');
//					Number(hr1S[0]);
//					Number(hr1S[1]);
//					if(hr1S[0]*1 > 2359){
//						hrInvalido();	
//					}else{
//						console.log(hr1S[0]);
//					}
//					if(hr1S[1]*1 < hr1S[0]*1 || hr1S[1]*1 > 2359){
//						hrInvalido();	
//					}else{
//						console.log(hr1S[1]);
//					}
//				}
//				if(!hrSplit[1].includes('\-')){
//					hrInvalido();
//				}else{
//					var hr2S = hrSplit[1].split('\-')
//					hr2S[0] = hr2S[0].replace('\:','')
//					hr2S[1] = hr2S[1].replace('\:','')
//					Number(hr2S[0]);
//					Number(hr2S[1]);
//					if(hr2S[0]*1 < hr1S[1]*1 || hr2S[0]*1 > 2359){
//						hrInvalido();
//					}else{
//						console.log(hr2S[0]);
//					}
//					if(hr2S[1]*1 < hr2S[0]*1 || hr2S[1]*1 > 2359){
//						hrInvalido();
//					}else{
//						console.log(hr2S[1]);							
//					}
//				}
//			}
//		}else{
//			var hr1Sin = $('#horCitaLV').val().split('\-')
//			hr1Sin[0] = hr1Sin[0].replace('\:','')
//			hr1Sin[1] = hr1Sin[1].replace('\:','')
//			Number(hr1Sin[0]);
//			Number(hr1Sin[1]);
//			if(hr1Sin[0]*1 > 2359){
//				hrInvalido();
//			}else{
//				console.log(hr1Sin[0]);
//			}
//			if(hr1Sin[1]*1 < hr1Sin[0]*1 || hr1Sin[1]*1 > 2359){
//				hrInvalido();
//			}else{
//				console.log(hr1Sin[1]);							
//			}
//		} 
//	}
//	
//});
//
//function hrInvalido(){
//	alert("Horario Inicial Inválido")
//	$('#horCitaLV').val("")
//}