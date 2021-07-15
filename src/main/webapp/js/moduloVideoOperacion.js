
 	  
	  function operateFormatterAccesoVideo(value, row, index) {
		    return [
		      '<a class="like" href="javascript:void(0)" data-toggle="modal" data-target="#modalVerVideo">',
		      '<i class="fa fa-3x fa-eye">',
		      '</a>'
		    ].join('')
		  }

	  function operateFormatterDeleteVideo(value, row, index) {
		    return [
		      '<a class="remove" href="javascript:void(0)" title="Eliminar">',
		      '<i class="fa fa-3x fa-edit">',
		      '</a>'
		    ].join('')
		  }
	  

	  
$(document).ready(function(){
	

	window.operateEventsAccesoVideo = {
		    'click .like': function (e, value, row, index) {
		    	console.log(row);
		    	$('#modalEnlaceVideo').attr('src', 'https://www.youtube.com/embed/'+row.videoContexto);
		    }
	};
	
	
	window.operateEventsDeleteVideo= {
			'click .remove': function (e, value, row, index) {
	    	confirm("Estás seguro de Eliminar el Registro : "+row.videoTitulo);
	    	$('#videosTable').bootstrapTable('remove', {
	        field: 'idVideo',
	        values: [row.idVideo]
	      });
	      console.log(row);
	      deleteVideo(row.idVideo);
	    }
	};

	
	
	$('#videosTable').bootstrapTable();
	
	$("#formAddVideo").validate({
		rules: {
			videoTitulo: {
				required: true,
				minlength:3,
				maxlength:50
			},
			videoURL: "required"
		},
		messages: {
			videoTitulo: {
				required: "Favor captura Titulo de Video",
				minlength: "Favor captura Titulo de Video completo"
			},
			emailRegistro: "Favor captura URL correcto",
		}
	});
	
//	$('#btnsubmitVideo').hide();

//	$('#addVideo').click(function(){
//		console.log("hello");
//		var videoTitulo = $('#videoTitulo').val();
//		var videoURL = $('#videoURL').val();
//		if(videoTitulo !== "" && videoURL !== ""){
//			var liVideos = '<tr>\
//		      <td>'+videoTitulo+'</td>\
//		      <td>'+videoURL+'</td>\
//		      <td><span><i class="fa fa-3x fa-edit"></span></td>\
//		      </tr>';
//			$('#tbodyVideos').append(liVideos)
//		}
//		alert('gello');
//	})
//	

}); //fin de documento



function deleteVideo(idVideo){
	console.log("4"+idVideo);
	var jsonRequest = {
			'idVideo' : idVideo
	}
	var url = 'eliminarVideo.htm?idVideo='+idVideo;
	$.ajax({
	   	  url: url,
	      dataType: 'json',
		  type: 'POST',
		  contentType: "application/json",
		  data: JSON.stringify(jsonRequest),
		  headers: {  'Access-Control-Allow-Origin': url, 'Access-Control-Allow-Methods': 'POST, GET, OPTIONS', 'Access-Control-Allow-Headers': 'X-PINGOTHER' },
		  crossDomain: true,
		 
		});
	
}