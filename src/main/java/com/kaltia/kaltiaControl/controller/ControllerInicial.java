package com.kaltia.kaltiaControl.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kaltia.kaltiaControl.bean.EmpresaEntity;
import com.kaltia.kaltiaControl.bean.RequestLoginVO;
import com.kaltia.kaltiaControl.bean.ResultDAOVO;
import com.kaltia.kaltiaControl.bean.UserKaltiaControlVO;
import com.kaltia.kaltiaControl.service.EmpresaManager;
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
    									ModelMap model,
    									HttpServletRequest request,
    									HttpServletResponse response)
            throws ServletException, IOException {

//    	 String now = (new Date()).toString();       
         requestLoginVO = this.userManager.readUser(userKaltiaControlFront);
         
         model.addAttribute("requestLoginVO", requestLoginVO);
         request.getSession().setAttribute("requestLoginVO", requestLoginVO);
//         logger.info("Login:" + now+ "-- User:"+requestLoginVO.getUserKaltiaControlEntity().getIdUserKaltiaControlUser());
         logger.info("____________________________________________________________________");

         return new ModelAndView(requestLoginVO.getUserKaltiaControlEntity().getUserKaltiaControlPerfil().toString(), "model", model);
//         return new ModelAndView("prueba", "model", myModel);
     }
	
	@RequestMapping (value= "/inicio.htm" , method = RequestMethod.GET)
	public ModelAndView inicio(ModelMap model, HttpServletRequest request,
							HttpServletResponse response) throws ServletException, IOException  {
		logger.info("----De nuevo Inicio----");
		requestLoginVO = (RequestLoginVO) request.getSession().getAttribute("requestLoginVO");
//		logger.info(requestLoginVO.getUserKaltiaControlEntity().getIdUserKaltiaControlUser().toString());
		requestLoginVO = (RequestLoginVO) model.get("requestLoginVO");
		logger.info(requestLoginVO.getUserKaltiaControlEntity().getIdUserKaltiaControlUser().toString());
	    	
		return new ModelAndView(requestLoginVO.getUserKaltiaControlEntity().getUserKaltiaControlPerfil().toString(), "model", model);
	}
	
	@RequestMapping(value="/inicioEmpresa.htm" , method = RequestMethod.POST)
    public ModelAndView inicioEmpresa(@Valid @ModelAttribute("userKaltiaControl") UserKaltiaControlVO userKaltiaControlFront, 
    									BindingResult result,
    									ModelMap model,
    									HttpServletRequest request,
    									HttpServletResponse response)
            throws ServletException, IOException {
         
         requestLoginVO = this.userManager.updateUser(userKaltiaControlFront);
         
         request.getSession().setAttribute("requestLoginVO", requestLoginVO);
         logger.info("inicioEmpresa:"+requestLoginVO.getUserKaltiaControlEntity().getIdUserKaltiaControlUser());

         return new ModelAndView(requestLoginVO.getUserKaltiaControlEntity().getUserKaltiaControlPerfil().toString(), "model", model);
//         return new ModelAndView("prueba", "model", myModel);
     }

	
	
	@RequestMapping (value= "/edicion.htm" ,
			params ={"action"},
			method = RequestMethod.GET)
	public ModelAndView edicion(ModelMap model,
								HttpServletRequest request,
								HttpServletResponse response) throws ServletException, IOException  {
		requestLoginVO = (RequestLoginVO) request.getSession().getAttribute("requestLoginVO");
		logger.info("----Inicio metodo edicion----" + requestLoginVO.getEmpresaEntity().getIdAction());
		logger.info("modelEdicion:"+request.getRequestURI());
		logger.info("isUser:"+requestLoginVO.getUserKaltiaControlEntity().getIdUserKaltiaControlUser());

		return new ModelAndView("edicion","modelEdicion", model );		
	}
	
	
	@RequestMapping (value= "/alta.htm" , method = RequestMethod.GET)
	public ModelAndView formularioAlta(ModelMap model, HttpServletRequest request,
							HttpServletResponse response) throws ServletException, IOException  {
		logger.info("----Inicio metodo alta----");
		requestLoginVO = (RequestLoginVO) request.getSession().getAttribute("requestLoginVO");
		logger.info(requestLoginVO.getUserKaltiaControlEntity().getIdUserKaltiaControlUser().toString());
			
		return new ModelAndView("alta","modelAlta", model );
	}
	
	@RequestMapping (value = "/empresaAlta.htm", method = RequestMethod.POST)
	public ModelAndView empresaAlta (@Valid @ModelAttribute("empresaEntity") EmpresaEntity empresaEntity, 
									BindingResult result,
									ModelMap model,
									HttpServletRequest request,
									HttpServletResponse response)
								throws ServletException, IOException {
		requestLoginVO = (RequestLoginVO) request.getSession().getAttribute("requestLoginVO");
		String now = (new Date()).toString();
		logger.info("----Inicio metodo empresaAlta----"+now);
		request.getSession().setAttribute("requestLoginVO", requestLoginVO);
		requestLoginVO.setEmpresaEntity(empresaEntity);
		
		resultDAOVO = empresaManager.createEmpresa(empresaEntity);
		
		logger.info("idUser:"+requestLoginVO.getUserKaltiaControlEntity().getIdUserKaltiaControlUser());
		model.addAttribute("empresaEntity", empresaEntity);
		model.addAttribute("requestLoginVO", requestLoginVO);
		
		return new ModelAndView("edicion","modelEdicion", model );
	}
	
	@RequestMapping (value= "/estadistica.htm" , method = RequestMethod.GET)
	public ModelAndView estadistica(HttpServletRequest request,
									HttpServletResponse response) throws ServletException, IOException  {
		logger.info("----Inicio metodo estadistica----");
		Map<String, Object> myModel = new HashMap<String, Object>();
		return new ModelAndView("estadistica","modelEdicion", myModel );		
	}

									
	

     
}