package com.kaltia.kaltiaControl.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kaltia.kaltiaControl.bean.RequestLoginVO;
import com.kaltia.kaltiaControl.bean.UserKaltiaControlVO;
import com.kaltia.kaltiaControl.service.UserManager;


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
     
     
    

	@RequestMapping(value="/login.htm" , method = RequestMethod.POST)
    public ModelAndView handleRequest(@Valid @ModelAttribute("userKaltiaControl") UserKaltiaControlVO userKaltiaControlFront, 
    									BindingResult result,
    									ModelMap model,
    									HttpServletRequest request,
    									HttpServletResponse response)
            throws ServletException, IOException {

    	 String now = (new Date()).toString();
         logger.info("HELLO " + now);

         Map<String, Object> myModel = new HashMap<String, Object>();
         myModel.put("now", now);
         requestLoginVO = this.userManager.readUser(userKaltiaControlFront);
         myModel.put("requestLoginVO", requestLoginVO);         
         
         model.addAttribute("requestLoginVO", requestLoginVO);
         
         HttpSession session = request.getSession();
	       session.setAttribute("requestLoginVO", requestLoginVO);
//	       String nombre = (String)session.getAttribute("nombre");
//	       logger.info("nombre:"+nombre);

         return new ModelAndView(requestLoginVO.getUserKaltiaControlEntity().getUserKaltiaControlPerfil().toString(), "model", model);
//         return new ModelAndView("prueba", "model", myModel);
     }
	
	
	@RequestMapping (value= "/edicion.htm" ,
//			params ={action},
			method = RequestMethod.GET)
	public ModelAndView edicion(@Valid @ModelAttribute("model") RequestLoginVO requestLoginVO, 
								BindingResult result,
								ModelMap  model,
								HttpServletRequest request,
								HttpServletResponse response) {
		logger.info("----Inicio metodo edicion----"+model.get(requestLoginVO.getEmpresaEntity().getIdAction()));
		logger.info("modelEdicion:"+request.getRequestURI());
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		 
		return new ModelAndView("edicion","modelEdicion", myModel );		
	}
	
	@RequestMapping (value= "/estadistica.htm" , method = RequestMethod.GET)
	public ModelAndView estadistica(HttpServletRequest request) {
		logger.info("----Inicio metodo estadistica----");
		Map<String, Object> myModel = new HashMap<String, Object>();
		 myModel.put("model", request.getAttribute("model"));
		 logger.info("modelEdicion:"+request.getAttribute("model"));
		return new ModelAndView("estadistica","modelEdicion", myModel );
		
	}

	@RequestMapping (value= "/alta.htm" , method = RequestMethod.GET)
	public ModelAndView alta(@Valid @ModelAttribute("model") RequestLoginVO requestLoginVO,
							BindingResult result,
							ModelMap  model,
							HttpServletRequest request,
							HttpServletResponse response) {
		logger.info("----Inicio metodo alta----");
//		HttpSession session = request.getSession();
		
//		Map<String, Object> myModel = new HashMap<String, Object>();
//		 myModel.put("model", request.getAttribute("model"));
		 logger.info("altaEmpresa:"+model.get(requestLoginVO.getUserKaltiaControlEntity().getIdUserKaltiaControlUser()));
		return new ModelAndView("estadistica","modelEdicion", model );
		
	}
	
	

     
}