
function generate() {
	var condiciones = JSON.parse($('#condiciones').val());
	var mesActual = JSON.parse($('#mesActual').val());
	var mesPost = JSON.parse($('#mesPost').val());
	console.log(condiciones);
	console.log(mesActual);
	console.log(mesPost);
	var d = new Date();

//	console.log("MES:"+(d.getMonth()+1));
	console.log("Date:"+d.getDate());
	var headers = [];
	headers = diaSemana(d.getDay());

	  var tasks = [];
//	console.log(((condiciones.horario12out/100)-(condiciones.horario11in/100)))
	  
	  var elementosSemana = [];
	  var elementosDia = [];
	  
//	  elementosSemana = elementosSem(mesActual, d);
	  for (var i = 0; i < headers.length ; i++) {  // <-- Elementos por semana
	    var startTime = -1
	    var startTime2 = 1
	    var duration = 0.5; //citasDia.lenght
	    var comida = 0;
	    elementosDia = elemenDia(mesActual, d, i);
	    var cantElementos = elementosDia.length;
//	    console.log("i:"+i+" "+cantElementos)
	    if(cantElementos === 0){
	    	cantElementos = 1;
	    	comida = 1
	    	duration = 1
	    }
	    for (var j = 0; j < cantElementos; j++) {  // <--Elementos por dia
//	    	console.log(elementosDia[j])
	    	var inicio = (elementosDia[j] - condiciones.horario11in) % 100
//	    	console.log(inicio)
	    	if(inicio > 10){
//	    		console.log("hora:"+elementosDia[j])
	    		startTime2 = ((elementosDia[j] - condiciones.horario11in) /100) + 0.2;
	    	}
	    	if(comida===1){
	    		startTime2 = 5;
	    	}
//	    	console.log(startTime2);
	      var task = {
	        startTime: startTime2,
	        duration: duration,
	        column: i,
	        id: Math.ceil(Math.random() * 100000),
	        title: 'Service ' + i + ' ' + j
	      };
	      tasks.push(task);
	    }
	  }

//	  console.log(tasks);

	  $("#skeduler-container").skeduler({
	    headers:  headers,//["Specialist 1", "Specialist 2", "Specialist 3", "Specialist 4", "Specialist 5",  "Specialist 6", "Specialist 7", "Specialist 8", "Specialist 9", "Specialist 10"],
	    tasks: tasks,
	    cardTemplate: '<div>${id}</div><div>${title}</div>',
	    onClick: function (e, t) { console.log(e, t); },
	    horarioIn : (condiciones.horario11in/100),
	    horarioOut : (condiciones.horario12out/100)
	  });
	}


	function diaSemana(getDay){
		var diaHoy = getDay;
		var days = ["Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"];
		console.log(days[getDay]);
		var header = [];
		for(getDay; getDay < days.length; getDay++){
			header.push(days[getDay]);
		}
		for(a=0; a < diaHoy; a++){
			header.push(days[a]);
		}
		return header;		
	}
	
	function elemenDia(mesActual, d, i){
		var dia = (d.getDate()+i)
		var tmp = [];
		if(mesActual[dia]){
			console.log(mesActual[dia])
			return mesActual[dia]
		}else{
			return tmp;
		}
//		for(a in mesActual){
//			if((a+i) >= (1*d.getDate())){
//				for(b in a){
//					console.log(mesActual[a]);
//				}
//			}
//		}	
	}
