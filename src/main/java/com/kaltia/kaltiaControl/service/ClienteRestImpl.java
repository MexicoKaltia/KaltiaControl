package com.kaltia.kaltiaControl.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.kaltia.kaltiaControl.bean.CitasVO;
import com.kaltia.kaltiaControl.bean.ResultVO;
import com.kaltia.kaltiaControl.bean.ValoresJsonVO;

@Service
public class ClienteRestImpl extends WebMvcConfigurerAdapter implements ClienteRest {
	
	protected final Log logger = LogFactory.getLog(getClass());
	private static final long serialVersionUID = -3393657707811218360L;
	@Autowired
	private ResultVO resultVO;
	@Autowired
	private ValoresJsonVO valoresJsonVO;
	@Autowired
	private CitasVO citasVO;
	

	public ClienteRestImpl() {
		// TODO Auto-generated constructor stub
	}
	

	
//	static final String URL_GET_USER_EMPRESA = "http://31.220.60.92:8010/userEmpresaRead";
//	static final String URL_GET_EMPRESA = 		"http://31.220.60.92:8010/empresaRead";
	
	////////////   URL LOCAL /////////////////
	//static final String URL_GET_USER_EMPRESA =      "http://31.220.63.183:8010/userEmpresaRead";
	//static final String URL_GET_EMPRESA = 	        "http://31.220.63.183:8010/empresaRead";
	
	static final String URL_POST_EMPRESAMODULOSCREATE    = "http://31.220.63.183:8010/empresaModulosCreate";
//	static final String URL_POST_EMPRESACITA      = "http://31.220.63.183:8010/empresaCitaActivar";
	static final String URL_POST_READCITA         = "http://31.220.63.183:8010/readCita";
	
	static final String POST = "HttpMethod.POST";
	static final String GET  = "HttpMethod.GET";
	static final String PUT  = "HttpMethod.PUT";
	


	@Override
	public ResultVO createService(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ResultVO createServiceModulosEmpresaNueva(String idAction, String horario, String modulos) {
				
		if(horario.equals("") || horario == null)
		{	horario = "No Activo";}
		if(modulos.equals("") || modulos == null)
		{	modulos = "No Activo";}
		
		
		 JSONObject jsonRequest = new JSONObject();
			 jsonRequest.put("action", idAction);	 
			 jsonRequest.put("valoresFinales", horario+"++"+ modulos);
//			 
//			 Map<String,String> req_content = new HashMap();
//			 req_content.put("idAction", idAction);
//			 Map<String, String> map= new HashMap<>();
//			    map.put("idAction", idAction);
//			    
//			 valoresJsonVO.setAction(idAction);

			 return  getTemplate(URL_POST_EMPRESAMODULOSCREATE, POST, jsonRequest.toString());
	
	}
	
//	@Override
//	public ResultVO createEmpresaModulos(String clientes, String horario, String carpetas) {
////			JSONObject jsonRequest = new JSONObject();
////			jsonRequest.put("valoresFinales", horario);
//			 return  getTemplate(URL_POST_EMPRESACREATE, POST, jsonRequest.toString());
//	}

	@Override
	public ResultVO readCitas(String idAction) {
	
		 JSONObject jsonRequest = new JSONObject();
		 jsonRequest.put("action", idAction);
		 resultVO = getTemplate(URL_POST_READCITA, POST, jsonRequest.toString());

		 return resultVO;  
	}
	

	@Override
	public ResultVO readService(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultVO updateService(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultVO deleteService(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private ResultVO getTemplate(String url, String metodo, String valoresJsonVO) {
		try {
			logger.info("valoresJsonVO:"+valoresJsonVO);
//			URI uri = new URI(url);
		 HttpHeaders headers = new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_JSON);
	    
	    // HttpEntity<String>: To get result as String.
		 
		 HttpEntity<String> entity = new HttpEntity<String>(valoresJsonVO, headers);
//		 HttpEntity<?> entity = new HttpEntity<>(req_content, headers);

	    // RestTemplate
	    RestTemplate restTemplate = new RestTemplate();
	   
	   
	    // Send request with POST method, and Headers.
//	    ResponseEntity<ResultVO> response = restTemplate.postForObject(url, valoresJsonVO, ResultVO.class);
//	    ResponseEntity<ResultVO> response  = restTemplate.postForEntity(url, valoresJsonVO, ResultVO.class);
	    ResponseEntity<ResultVO> response  = restTemplate.exchange(url, HttpMethod.POST, entity, ResultVO.class);

	    resultVO.setMensaje(response.getBody() .getMensaje());
	    resultVO.setCodigo(response.getBody() .getCodigo());
	    resultVO.setResponse(response.getBody() .getResponse());
	    resultVO.setMensajeArray(response.getBody() .getMensajeArray());
	    resultVO.setJsonResponse(response.getBody() .getJsonResponse());
	    
//	    logger.info(resultVO.getCodigo());
//	    logger.info(resultVO.getMensaje());
	    
	    }catch(Exception e) {
	    	resultVO.setMensaje("Fallo conexion RestTemplate");
	    	e.printStackTrace();
	    }
	    return resultVO;

	}
	
	 public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	        super.configureMessageConverters(converters);        
	        converters.add(mappingJackson2HttpMessageConverter());
	    }
	
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setPrettyPrint(true);
        return mappingJackson2HttpMessageConverter;
    }



}
