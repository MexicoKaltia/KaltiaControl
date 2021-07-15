package com.kaltia.kaltiaControl.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kaltia.kaltiaControl.bean.EmpresaEntity;
import com.kaltia.kaltiaControl.bean.ProductosEntity;
import com.kaltia.kaltiaControl.bean.ProductosVO;
import com.kaltia.kaltiaControl.bean.RequestLoginVO;
import com.kaltia.kaltiaControl.bean.ResultDAOVO;
import com.kaltia.kaltiaControl.bean.UserEmpresaEntity;
import com.kaltia.kaltiaControl.bean.UserKaltiaControlVO;
import com.kaltia.kaltiaControl.service.EmpresaManager;
import com.kaltia.kaltiaControl.service.UserManager;

//@CrossOrigin(origins = {"http://kaltia.xyz", "http://localhost:8081"})
@Controller
@ControllerAdvice
@SessionAttributes ("model")
public class ControllerInicial extends HttpServlet {
    
	private static final long serialVersionUID = -914904182640401317L;
 
	protected final Log logger = LogFactory.getLog(getClass());
    
     @Autowired
     //@Qualifier("userManagerImpl")
     private UserManager userManager;
     @Autowired
     //@Qualifier("requestLoginVO")
     private RequestLoginVO requestLoginVO;
     @Autowired
     private EmpresaManager empresaManager;
     @Autowired
     private ResultDAOVO resultDAOVO;
     
     @ModelAttribute
     public void modeloComun(Model model) {
    	 model.addAttribute("requestLoginVO", requestLoginVO);
    	 
     }

	@RequestMapping(value="/login.htm" , method = RequestMethod.POST)
    public ModelAndView handleRequest(@Valid @ModelAttribute("userKaltiaControl") UserKaltiaControlVO userKaltiaControlFront, 
    									BindingResult result,
    									ModelMap model){

         requestLoginVO = this.userManager.readUser(userKaltiaControlFront);
         model.addAttribute("requestLoginVO", requestLoginVO);
         logger.info("____________________________________________________________________");

         return new ModelAndView(requestLoginVO.getUserKaltiaControlEntity().getUserKaltiaControlPerfil().toString(), "model", model);
     }
	
	@RequestMapping (value= "/inicio.htm" , method = RequestMethod.GET)
	public ModelAndView inicio(ModelMap model,
			@RequestParam(name="delete", required=false) boolean delete
							) throws ServletException, IOException  {
		logger.info("----De nuevo Inicio----");
		requestLoginVO = (RequestLoginVO) model.get("requestLoginVO");
		ModelAndView mav = new ModelAndView(requestLoginVO.getUserKaltiaControlEntity().getUserKaltiaControlPerfil().toString(), "model", model);
		mav.addObject("delete", delete);
		return mav; 
	}
	
	
	@RequestMapping (value= "/alta.htm" , method = RequestMethod.GET)
	public ModelAndView formularioAlta(ModelMap model, 
							@RequestParam(name="error", required=false) boolean error){
		logger.info("----Inicio metodo alta----");
		ModelAndView mav = new ModelAndView("alta","modelAlta", model );
		mav.addObject("error", error);
		requestLoginVO = (RequestLoginVO) model.get("requestLoginVO");
//		requestLoginVO = (RequestLoginVO) request.getSession().getAttribute("requestLoginVO");
//		logger.info(requestLoginVO.getUserKaltiaControlEntity().getIdUserKaltiaControlUser().toString());
			
		return mav; 
	}
	
	@RequestMapping (value = "/altaGenerales.htm", method = RequestMethod.POST)
	public ModelAndView empresaAlta (@Valid @ModelAttribute("empresaEntity") EmpresaEntity empresaEntity,		
									BindingResult result,
									ModelMap model)
									throws ServletException, IOException {
		logger.info(empresaEntity.toString());
		
		String now = (new Date()).toString();
		logger.info("----Inicio metodo altaGenerales----"+now);
		requestLoginVO.setEmpresaEntity(empresaEntity);
		
		resultDAOVO = empresaManager.createEmpresa(empresaEntity);
		
		logger.info("idUser:"+requestLoginVO.getUserKaltiaControlEntity().getIdUserKaltiaControlUser());
		
		ModelAndView mav = new ModelAndView();
		
		if(!resultDAOVO.getCode().equals("99")) {
			mav.setViewName("altaProductos");
			mav.addObject("empresaEntity", empresaEntity);
		}else {
			mav.setViewName("redirect:/alta.htm");
			mav.addObject("error", true);
		}
		return mav;
	}
	
	@RequestMapping (value = "/actualizaCliente.htm", method = RequestMethod.POST)
	public ModelAndView actualizaCliente (@Valid @ModelAttribute("empresaEntity") EmpresaEntity empresaEntity,		
									BindingResult result,
									ModelMap model)
									throws ServletException, IOException {
		logger.info(empresaEntity.toString());
		
		String now = (new Date()).toString();
		logger.info("----Inicio metodo actualizaCliente----"+now);
		requestLoginVO.setEmpresaEntity(empresaEntity);
		
		resultDAOVO = empresaManager.updateEmpresa(empresaEntity);
		
		logger.info("idUser:"+requestLoginVO.getUserKaltiaControlEntity().getIdUserKaltiaControlUser());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(requestLoginVO.getUserKaltiaControlEntity().getUserKaltiaControlPerfil().toString());
		if(!resultDAOVO.getCode().equals("99")) {
			mav.addObject("actualiza", true);
		}else {
			mav.addObject("errorActualiza", true);
		}
		return mav;
	}
	
		
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping (value= "/eliminarEmpresa.htm" , params = {"idAction"} , method = RequestMethod.POST)
	public ModelAndView eliminarEmpresa(ModelMap model,
//								@Valid @ModelAttribute("jsonRequest") Object object,
								@RequestParam(value = "idAction") String idAction) throws ServletException, IOException  {
		
		String contexto = idAction;
		
		model.addAttribute("contexto", contexto);
		logger.info("----Inicio metodo eliminarEmpresa----" + idAction);
		resultDAOVO = empresaManager.deleteEmpresa(idAction);
		ModelAndView mav = new ModelAndView();
		logger.info(resultDAOVO.getCode());
		if(resultDAOVO.getCode().equals("00")) {
			logger.info("----resultDAOVO.getCode().equals(\"00\")----");
			requestLoginVO = (RequestLoginVO) model.get("requestLoginVO");
			model.addAttribute("requestLoginVO", requestLoginVO);
			mav.addObject("delete", true);
			mav.setViewName("redirect:/inicio.htm");
//			mav.setViewName("windows.location.reload()");
		}

		return mav;		
	}
			
	
	@RequestMapping (value= "/modulos.htm" , method = RequestMethod.GET)
	public ModelAndView modulo(ModelMap model,
			@RequestParam(name="error", required=false) boolean error,
			@RequestParam(name="exito", required=false) boolean exito) {
		logger.info("----Inicio metodo modulo----");
		requestLoginVO = (RequestLoginVO) model.get("requestLoginVO");
		logger.info(requestLoginVO.getUserKaltiaControlEntity().getIdUserKaltiaControlUser().toString());
		List<JSONObject> jsonUserEmpresa = getJSONUserEmpresa(requestLoginVO.getUserEmpresaEntity());
		model.addAttribute("usuariosEmpresa", jsonUserEmpresa);
		ModelAndView mav = new ModelAndView("modulos","model", model );
		mav.addObject("error", error);
		mav.addObject("exito", exito);
		
		return mav;
	}
	

	
	/*
	 * private
	 */
	private List<JSONObject> getJSONUserEmpresa(List<UserEmpresaEntity> userEmpresaEntity) {
		
		List<JSONObject> arrayJson = new ArrayList();
		for(UserEmpresaEntity a : userEmpresaEntity) {
			JSONObject json = new JSONObject();
			json.put("idUserEmpresa", a.getIdUserEmpresa());
			json.put("actionRegistro", a.getActionRegistro());
			json.put("nombreRegistro", a.getNombreRegistro());
			json.put("emailRegistro", a.getEmailRegistro());
			json.put("telefonoRegistro", a.getTelefonoRegistro());
			json.put("usuarioRegistro", a.getUsuarioRegistro());
			json.put("passRegistro", a.getPassRegistro());
			json.put("messageRegistro", a.getMessageRegistro());
			json.put("monitorRegistro", a.getMonitorRegistro());
			json.put("statusRegistro", a.getStatusRegistro());
			arrayJson.add(json);
		}
		
		return arrayJson;
	}
	
	/*
	 *  Verificar los siguientes metodos, no estan en uso 19 nov 2020
	 */
	
	

	@RequestMapping (value= "/edicion.htm" , params = {"tipo","idAction"} , method = RequestMethod.GET)
	public ModelAndView edicion(ModelMap model,
								HttpServletRequest request,
								HttpServletResponse response,
								@RequestParam(value = "idAction") String idAction,
								@RequestParam(value = "tipo") String tipo) throws ServletException, IOException  {
		
//		requestLoginVO = (RequestLoginVO) request.getSession().getAttribute("requestLoginVO");
		String contexto = idAction;
		if(tipo.equals("qr")) {
			contexto = tipo +"/"+ idAction;
		}
		
		model.addAttribute("contexto", contexto);
//		logger.info("----Inicio metodo edicion----" + requestLoginVO.getEmpresaEntity().getIdAction());
		logger.info("modelEdicion:"+request.getRequestURI());
//		logger.info("isUser:"+requestLoginVO.getUserKaltiaControlEntity().getUserKaltiaControlNombre());

		return new ModelAndView("edicion","modelEdicion", model );		
	}
	
	
	
	
	
	@RequestMapping (value= "/estadistica.htm" , method = RequestMethod.GET)
	public ModelAndView estadistica(HttpServletRequest request,
									HttpServletResponse response) throws ServletException, IOException  {
		logger.info("----Inicio metodo estadistica----");
		Map<String, Object> myModel = new HashMap<String, Object>();
		return new ModelAndView("estadistica","modelEdicion", myModel );		
	}
	
	@RequestMapping(value="/inicioEmpresa.htm" , method = RequestMethod.POST)
    public ModelAndView inicioEmpresa(@Valid @ModelAttribute("userKaltiaControl") UserKaltiaControlVO userKaltiaControlFront, 
    									BindingResult result,
    									ModelMap model)
    	    throws ServletException, IOException {
         
         requestLoginVO = this.userManager.updateUser(userKaltiaControlFront);
         logger.info("inicioEmpresa:"+requestLoginVO.getUserKaltiaControlEntity().getIdUserKaltiaControlUser());

         return new ModelAndView(requestLoginVO.getUserKaltiaControlEntity().getUserKaltiaControlPerfil().toString(), "model", model);
//         return new ModelAndView("prueba", "model", myModel);
     }

     
}