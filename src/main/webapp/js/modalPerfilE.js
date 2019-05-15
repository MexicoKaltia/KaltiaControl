$(document).ready(function() {


$('.userEmpresa').click(function(){
		
		conta = $(this).attr('id');
//		console.log(conta);
//		console.log($('#usuarioRegistro'+conta).val());
		$('#usuarioRegistro').val($('#usuarioRegistro'+conta).val());
		$('#nombreRegistro').val($('#nombreRegistro'+conta).val());
		$('#apellidoRegistro').val($('#apellidoRegistro'+conta).val());
		$('#emailRegistro').val($('#emailRegistro'+conta).val());
		$('#telefonoRegistro').val($('#telefonoRegistro'+conta).val());
		
	});




});/*********  fin de documento *********/