	  

	  
$(document).ready(function(){
	
	idActionChat
	
	$("#formAddNumeroChat").validate({
		rules: {
			numeroChat: {
				required: true,
				minlength:10,
				maxlength:10,
				number: true
			},
		},
		messages: {
			videoTitulo: {
				required: "Favor captura Numero Telefono válido",
				minlength: "Favor captura Numero Telefono  completo"
			}
		}
	});
	
	

}); //fin de documento

