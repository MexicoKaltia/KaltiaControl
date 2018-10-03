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
	
	$('#idEmpresa').change(function(){
		var idEmpresa = $('#idEmpresa').val();
		
		$('#empresaIdPerfilE').val(idEmpresa + "@kaltiaControl.com");
		$('#empresaFactura').val("www.kaltiaControl.xyz/factura/"+idEmpresa)
		
	});
	
	$('#userKaltiaControlPass1').change(function(){
		var pass = $('#userKaltiaControlPass').val();
		
		if(pass !== $('#userKaltiaControlPass1').val())
		alert("La contraseña no son iguales");
		else{
			$('#empresaIdPerfilE').val($('#empresaIdPerfilE').val()+$('#userKaltiaControlPass1').val())
		
		}
		
	});
	
	
	
});