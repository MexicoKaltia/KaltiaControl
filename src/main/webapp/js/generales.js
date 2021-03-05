$(document).ready(function(){
	console.log("generales");
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
	//		$('#empresaFechaCorte').val("Periodo : " + d.getDate()+15 + "/" + meses[d.getMonth()] + "/" + d.getFullYear() +" hasta "+  d.getDate() + "/" + meses[mesD] + "/" + anio);
			$('#empresaFechaCorte').val("Fecha de Corte : " + (d.getDate()+15) + "/" + meses[d.getMonth()] );
		
		});
		
		$('#IdAction').change(function(){
			var IdAction = $('#IdAction').val();
			$('#empresaFactura').val("www.kaltiaControl.xyz/factura/"+IdAction)
		});
		
		$('#empresaEmail').change(function(){
			var empresaEmail = $('#empresaEmail').val();
			$('#empresaIdPerfilE').val(empresaEmail);
		});
		
		$('#IdAction').keyup(function(){
			var valor = $('#IdAction').val();
			while(valor.includes(" ") ){
				valor= valor.replace(" ", "");	
			}
			$('#IdAction').val(valor);
//			console.log($('#IdAction').val());
		});
		$('#empresaTelefono').keyup(function(){
			var valor = $('#empresaTelefono').val();
			while(valor.includes(" ") ){
				valor= valor.replace(" ", "");	
			}
			$('#empresaTelefono').val(valor);
//			console.log($('#IdAction').val());
		});
		
		
});

