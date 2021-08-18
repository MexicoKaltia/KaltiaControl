var flagNuevaCategoria = false;

$(document).ready(function(){

//	$.categorias = $('#categorias').val();
//	$.categorias = {
//			uno:[{elementoNombre:"asd",
//				elementoDescripcion:"asd",
//				elementoCosto:"asd",
//				elementoImagen:"1.jpg"}],
//			dos:[{elementoNombre:"asd21",
//				elementoDescripcion:"asd21",
//				elementoCosto:"asd21",
//				elementoImagen:"2.jpg"},
//				{elementoNombre:"asd22",
//				elementoDescripcion:"asd22",
//				elementoCosto:"asd22",
//				elementoImagen:"3.jpg"}],
//	};
	/*
	 * Variables Iniciales
	 */
	$.categorias="";
	$.categoria="";
	var valoresFinales="";
	$.tarjetaProducto="";
	$.jsonCategoria="";
	
	 
	/*
	 * GET Contenido Tarjetas Producto 
	 */    
    var contenido = 'http://129.146.252.2:8010/consultaTarjetaProductos?idEmpresa='+idEmpresa;
//    var contenido = 'http://localhost:8010/consultaTarjetaProductos?idEmpresa='+idEmpresa;
    $.getJSON(contenido, function(result){
//    	console.log(result);
    	$.categorias = result.tarjetaProductos; 
//    	console.log($.categorias);
    	$('#selectCategorias').empty()
    	var optionCategorias = '<option value="nuevenueve" selected>Seleccione Categoria</option>\
        <option value="cero">Nueva Categoria</option>';
    	$('#selectCategorias').append(optionCategorias);
    	for(var a in $.categorias){
    		var optionCategorias = '<option value="'+a+'" >'+a+'</option>';
    	    	$('#selectCategorias').append(optionCategorias);
    	}
    });
	
	
	$('#divBotonesEdicion').empty();
    $('#formNuevaCategoria').empty();
    
    $('#selectCategorias').change(function(){
        $('#formNuevaCategoria').empty();
        var valSelect = $(this).val();
        if(valSelect === "cero" ){
        	$('#formNuevaCategoria').show();
        	$('#divBotonesEdicion').empty();
            var textNuevaCategoria = "<div class='row'><div class='col-md-10'><label class='form-label' for='textNuevaCategoria'>Título Nueva Categoría</label>\<input type='text' id='textNuevaCategoria' placeholder='Capture nombre de Nueva Categoria' class='form-control input-md' onfocusout='valorTextNuevaCategoria()' /></div>\
            <div class='col-md-1'><button class='btn btn-primary' id='btnAddNuevaCategoria'  disabled>\
            <i class='fa-2x fa fa-plus-square'></i>\
             </button></div></div>";
            $('#formNuevaCategoria').append(textNuevaCategoria);
            
            $('#btnAddNuevaCategoria').click(function(){
            	flagNuevaCategoria = true;
                $('#textNuevaCategoria').attr('disabled', true);
                edicionNuevoElemento();
                modalNuevoElemento();
                var nuevaCategoria = '<option id="'+$.categoria+'" value="'+$.categoria+'" selected>'+$.categoria+'</option>';
            	$('#selectCategorias').append(nuevaCategoria);
            	
            });
            
        }else if(valSelect !== "nuevenueve" ){
            $.categoria = valSelect;
            edicionNuevoElemento(); 
            pintarCategorias($.categorias, $.categoria);
            
        }
        
    });
    
    
    $('#btnAddElemento').click( function(){ 
    	$.tarjetaProducto = {
    	        'elementoNombre':$('#elementoNombre').val(),
    	        'elementoDescripcion':$('#elementoDescripcion').val(),
    	        'elementoCosto':$('#elementoCosto').val(),
    	        'elementoImagen': formatoImagen($('#imagenObjetoQRD').val())
    	    };
    	//editar Categoria
    	$.jsonCategoria = arrayCategoria($.tarjetaProducto, $.categoria);
    	//editar Categorias
    	$.categorias = arrayValoresFinales($.jsonCategoria);
    	//pintar Categorias
    	pintarCategorias($.categorias, $.categoria);
    	   	
    	$('#modalRegistroTarjetaProducto').modal('hide');
    });
   
    
    
    /*
     * Auxiliares plugins
     */
    
    $("#formAddTarjetaProducto").validate({
		rules: {
			elementoNombre: {
				required: true,
				minlength:2,
				maxlength:50
			},
			elementoDescripcion: "required",
            imagenObjetoQRD :"required"
		},
		messages: {
			elementoNombre: {
				required: "Favor captura Titulo de Producto",
				minlength: "Favor captura Titulo de Producto completo"
			},
			elementoDescripcion: "Favor captura Descripcion",
            imagenObjetoQRD: "Favor Agregar Imagen",
		}
	});
    
    $('#imagenObjetoQRD').on('change', function(){ enviaImagen("imagenObjetoQRDForm", idAction) });
     
   

}); // fin de document


/*
 * funciones externas
 */

function edicionNuevoElemento(){
	$('#divBotonesEdicion').empty();
	var btnEdicionProducto ='<button class="btn btn-warning" type="button" id="btnEraseElemento" style="text-align: left;">Eliminar Producto</button><button class="btn btn-success" type="button" id="btnModalAddElemento" style="text-align: right;">Agregar Producto Nuevo</button>'
    $('#divBotonesEdicion').append(btnEdicionProducto);
	$('#elementoNombre').val("");
	$('#elementoDescripcion').val("");
	$('#elementoCosto').val("");
//	$('#elementoImagen').val("");

	$('#btnModalAddElemento').click(function(){
			flagNuevaCategoria = false;
//    	$('#modalRegistroTarjetaProducto').modal('show');
			$('#elementoNombre').val("");
			$('#elementoDescripcion').val("");
			$('#elementoCosto').val("");
//			$('#elementoImagen').val("");

	    	modalNuevoElemento();
	    });
	
	$('#btnEraseElemento').click(function(){
		console.log('btnEraseElemento');
		var id = $('#contenedorCarrusel .active').attr('id');
		id=id.replace("elementoCarrusel","");
		
		var elementoNombre = $('#elementoCarruselNombre'+id).val();
		var newArrayCategoria = new Array();
		for(var e in $.categorias){
			var i = $.categorias[e];
			if(e === $.categoria){
				for(var o in i){
					var u = i[o];
					if(u.elementoNombre !== elementoNombre){
						newArrayCategoria.push(u);
					} 
				}
			}
		}
		var jsonCategoria = {
				tituloCategoria : newArrayCategoria 
		};	
		jsonCategoria = toJSONtitulo(jsonCategoria, $.categoria);
		$.categorias = arrayValoresFinales(jsonCategoria);
//		console.log($.categorias);
		pintarCategorias($.categorias, $.categoria)

		
	});
}



function modalNuevoElemento(){
    $('#modalRegistroTarjetaProducto').modal();
    if(flagNuevaCategoria){
    	$.categoria = $('#textNuevaCategoria').val(); 
    }else{
    	$.categoria = $('#selectCategorias').val();
    }
    $('#formNuevaCategoria').hide();
    $('#spanCategoria').html($.categoria);
    
}

function pintarCategorias(categorias, categoria){

//	console.log(categorias);
//	console.log(categoria);
	
	var carrusel = '<div id="carouselTajetaProductos" class="carousel slide" data-interval="false">\
	    <div class="carousel-inner container" id="contenedorCarrusel">\
	        <div class="carousel-item col-12 text-center active" id="elementoCarrusel">\
	        </div>\
	     </div>\
	     <a class="carousel-control-prev" href="#carouselTajetaProductos" role="button" data-slide="prev">\
	        <span class="carousel-control-prev-icon" aria-hidden="true">\
	        </span>\
	        <span class="sr-only">Previous\
	        </span>\
	    </a>\
	    <a class="carousel-control-next" href="#carouselTajetaProductos" role="button" data-slide="next">\
	        <span class="carousel-control-next-icon" aria-hidden="true">\
	        </span>\
	        <span class="sr-only">Next\
	        </span>\
	    </a>\
	    <ol class="carousel-indicators">\
	        <li data-target="#carouselTajetaProductos" data-slide-to="0" class="active">\
	        </li>\
	        <li data-target="#carouselTajetaProductos" data-slide-to="1">\
	        </li>\
	        <li data-target="#carouselTajetaProductos" data-slide-to="2">\
	        </li>\
	    </ol>\
	</div>';
	
	$('#divCarouselTajetaProductos').empty();
	$('#divCarouselTajetaProductos').append(carrusel);
	$('#contenedorCarrusel #elementoCarrusel').remove();
	
	var a = 0;
	for(var e in categorias){
		var i = categorias[e];
		if(e === categoria){
			for(var o in i){
				var u = i[o];
				var divElementoCarrusel='<div class="carousel-item col-12 text-center" id="elementoCarrusel'+a+'"></div>'		
				$('#contenedorCarrusel').append(divElementoCarrusel);
				if(a===0){$('#elementoCarrusel'+a).addClass('active');}
				var imagen = 'http://kaltiaservicios.com/store/kaltia/empresa/'+idAction+'/images/'+u.elementoImagen+'?v=1';
				var elementoCarrusel = '<form id="elementoFormCarrusel'+a+'" class="imagenArrayForm">\
				<fieldset>\
				<div class="form-group row">\
				  <span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-user bigicon"></i></span>\
				  <div class="col-7">\
				    <input id="elementoCarruselNombre'+a+'"  name="elementoNombre" type="text" placeholder="Nombre Producto" class="form-control" maxlength="100" value='+u.elementoNombre+' disabled>\
				  </div>\
				</div>\
				<div class="form-group row">\
				  <span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-envelope bigicon"></i></span>\
				  <div class="col-7">\
				    <textarea class="form-control" id="elementoCarruselDescripcion'+a+'" name="message" placeholder="Descripcion Producto" rows="4" disabled>'+u.elementoDescripcion+'</textarea>\
				  </div>\
				</div>\
				<div class="form-group row">\
				  <span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-phone-square bigicon"></i></span>\
				  <div class="col-7">\
				    <input id="elementoCarruselCosto'+a+'" name="elementoCosto" type="text" placeholder="Costo Producto" class="form-control" maxlength="20" value='+u.elementoCosto+' disabled>\
				  </div>\
				</div>\
				<div class="form-group row">\
				    <span class="col-3 col-form-label text-right colorLabel"><i class="fa fa-2x fa-phone-square bigicon"></i></span>\
				    <div class="col-7">\
				        <img class="inspace-10 borderedbox" src="'+imagen+'" >\
				    </div>\
				</div>\
				</fieldset>\
				</form>';
			
			$('#elementoCarrusel'+a).append(elementoCarrusel);	
			a++;
		}
				
		}
		
	}
		
	$('#divbtnActualizarProductos').empty();	
	var btnActualizarProductos = "<br><button class='btn btn-success' id='btnActualizarProductos'  >Actualizar Productos</button>";
	$('#divbtnActualizarProductos').append(btnActualizarProductos);
	
	$('#btnActualizarProductos').click(function(){
		console.log('#btnActualizarProductos');
				finalJson = { action : idAction,
					 idEmpresa : idEmpresa,	
					 seccion : "tarjetaProductos",
					 valoresJson : $.categorias,
					 nombreCorto : nombreCorto,
					 string : usuarioKC
					 }
//			console.log(finalJson);
			enviaDataEdicion(finalJson);

	})

	
}



function arrayValoresFinales(categoria){
	var productos = new Array();
	var tituloCategoria="";
	for(var a in categoria){
		tituloCategoria = a;
		productos = categoria[a];
	}
	
	if(flagNuevaCategoria){
		var categorias = JSON.stringify($.categorias);
		var nuevaCategoria = JSON.stringify(categoria);
		nuevaCategoria = nuevaCategoria.slice(1,nuevaCategoria.length-1);
		categorias = categorias.slice(0, categorias.length-1) + "," + nuevaCategoria + "}";
		$.categorias = JSON.parse(categorias);
		
	}else{
		for(var e in $.categorias){
			var i = $.categorias[e];
			if(e === tituloCategoria){
//				e.i = [];
//				$.categorias.e = productos;
//				e.i = productos;
//				$.categorias.dos = productos;
				$.categorias[e] = productos;
			}
		}	
	}
	
	 return $.categorias;
}




function arrayCategoria (tarjetaProducto, tituloCategoria){
	var newArrayProductos = new Array();
	var newArrayCategorias = new Array();
//	console.log(tituloCategoria);
	
	if(flagNuevaCategoria){
		newArrayProductos.push(tarjetaProducto);
	}else{
		for(var i in $.categorias){
			var o = $.categorias[i];
//			console.log(i);
			if(i === tituloCategoria){
//				for(var a in $.jsonCategoria){
//					var e = $.jsonCategoria[a];
					newArrayProductos = o;
					newArrayProductos.push(tarjetaProducto)
//				}
			}
		}
	}
	var jsonCategoria = {
			tituloCategoria : newArrayProductos 
	};	
	jsonCategoria = toJSONtitulo(jsonCategoria, tituloCategoria);
//	console.log(jsonCategoria);
	return jsonCategoria; 
	
}



function valorTextNuevaCategoria(){
	if($('#textNuevaCategoria').val() !== ""){
		$('#btnAddNuevaCategoria').attr('disabled', false);
	}else{
		alert("Campo de nueva categoria no puede ser vacío");
	}
}

//function imagenElemento(archivosCampo){
////	$('#imagenObjetoQRD').val(idImagen);
//	        var files = archivosCampo.files;
//	        for (var i = 0; i < files.length; i++) {           
//	            var file = files[i];
//	            enviaImagenElemento(archivosCampo, idEmpresa);
//	            }
////	        // -  console.log(archivosCampo.file.name);
////	        // -  console.log($(archivosCampo).val());
//	 }
//
function formatoImagen(imagenTexto){
	  while(imagenTexto.includes("C:\\fakepath\\") ){
		  imagenTexto = imagenTexto.replace("C:\\fakepath\\", "")
	  }
	  while(imagenTexto.includes(" ") ){
		  imagenTexto = imagenTexto.replace(" ", "")
	  }
	  return imagenTexto;
}

function toJSONtitulo(json, tituloCategoria){
	var tmp = JSON.stringify(json);
	tmp = tmp.replace("tituloCategoria", tituloCategoria);
	return JSON.parse(tmp);
}



//var urlUpload =  "http://localhost:8011/";
var urlUpload= 	"http://129.146.252.2:8011/";
var url		= 	"http://129.146.252.2:8010/";
//var url		= 	"http://localhost:8010/";

function enviaImagen(idImagenForm, idEmpresa){
//	limpiaAlerta();
		console.log("Comineza envio imagenBody:"+idEmpresa);
		var alerta="";
		  $.ajax({
//		    url: "http://localhost:8010/fileUpload",
			url: urlUpload+"fileUpload/"+idEmpresa,
		    type: "POST",
//		    data: new FormData($("#upload-file-form")[0]),
		    data: new FormData($("#"+idImagenForm)[0]),
		    enctype: 'multipart/form-data',
		    processData: false,
		    contentType: false,
		    cache: false,
		    success: 	function(data){
		    	if(data.codigo==="00"){
		    		if(data.codigo==="00"){
		  			  alerta="<div class='alert alert-success' role='alert'>imagen : "+data.codigo+"-"+data.mensaje.toString()+"</div>";
		  			  $(alerta).insertAfter($('.'+idImagenForm));
//		  			  console.log("envio ok");
		  	    	}else{
		  	    		alerta="<div class='alert alert-warning' role='alert'>imagen : "+data.codigo+"-"+data.mensaje.toString()+"</div>";
		  				  $(alerta).insertAfter($('.'+idImagenForm));
		  	    		console.log("envio Nok");
		  	    	}
		    	  } 
		    	},
		    error: function () {
		    	alerta="<div class='alert alert-danger' role='alert'>error de carga de imagen</div><br>";
				  $(alerta).insertAfter($('.'+idImagenForm));
		  	console.log("envio error");
		    }
		  });
		  //$(alerta).insertAfter($('.'+idImagenForm));
}


function enviaDataEdicion(finalJson){
//	limpiaAlerta();
	var context = "";
	for(campo in finalJson){
		if(campo === "action")
			context = context + finalJson.action +"/"
		else{
			context = context + campo +"/"
		}
	}
	console.log(finalJson);
//	alert(url + context);
//	alert(finalJson);
	$.ajax({
	   	  url: url +"edicionSeccionJson/",//+ context,//+finalJson.action+"/"+finalJson[1],
	      dataType: 'json',
		  type: 'POST',
		  contentType: "application/json",
		  data: JSON.stringify(finalJson),
		  headers: {  'Access-Control-Allow-Origin': url, 'Access-Control-Allow-Methods': 'POST, GET, OPTIONS', 'Access-Control-Allow-Headers': 'X-PINGOTHER' },
		  crossDomain: true,
		  success: 	function(data){					  
//			  console.log(data);
//				  avisaAlerta(data);
			  alerta="<div id='limpiaAlerta' class='alert alert-success' role='alert'>"+data.codigo+" "+data.mensaje.toString()+"</div>";
				 $(alerta).insertAfter($('#divCarouselTajetaProductos'));
				 if(data.codigo===0){
					  location.reload();
				  }
			},
		  error: function(){
			  alerta="<div class='alert alert-danger' role='alert'>error de actualizacion productos</div><br>";
			  $(alerta).insertAfter($('#divCarouselTajetaProductos'));
	  	console.log("envio error");
		  }
		});
}
