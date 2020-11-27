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
//			console.log("Periodo : " + d.getDate() + "/" + meses[d.getMonth()] + "/" + d.getFullYear() +"---"+  d.getDate() + "/" + meses[mesD] + "/" + anio);
		$('#empresaFechaCorte').val("Periodo : " + d.getDate() + "/" + meses[d.getMonth()] + "/" + d.getFullYear() +" hasta "+  d.getDate() + "/" + meses[mesD] + "/" + anio);
		
		})
		
		$('#IdAction').change(function(){
			var IdAction = $('#IdAction').val();
			$('#empresaFactura').val("www.kaltiaControl.site/factura/"+IdAction)
		});
		
		$('#empresaEmail').change(function(){
			var empresaEmail = $('#empresaEmail').val();
			$('#empresaIdPerfilE').val(empresaEmail);
		})
		
})

