$(document).ready(function(){
	
	
	
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

	

	
      
	
	
	
		
	
		
}); // Fin documento



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