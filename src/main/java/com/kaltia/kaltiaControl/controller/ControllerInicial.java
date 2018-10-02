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

    	 String now = (new Date()).toString();
         logger.info("HELLO " + now);
         requestLoginVO = this.userManager.readUser(userKaltiaControlFront);
         request.getSession().setAttribute("requestLoginVO", requestLoginVO);


         return new ModelAndView(requestLoginVO.getUserKaltiaControlEntity().getUserKaltiaControlPerfil().toString(), "model", model);
//         return new ModelAndView("prueba", "model", myModel);
     }
	
	
	@RequestMapping (value= "/edicion.htm" ,
			params ={"action"},
			method = RequestMethod.GET)
	public ModelAndView edicion(HttpServletRequest request,
								HttpServletResponse response) throws ServletException, IOException  {
		requestLoginVO = (RequestLoginVO) request.getSession().getAttribute("requestLoginVO");
		logger.info("----Inicio metodo edicion----" + requestLoginVO.getEmpresaEntity().getIdAction());
		logger.info("modelEdicion:"+request.getRequestURI());

		return new ModelAndView("edicion");//,"modelEdicion", model );		
	}
	
	@RequestMapping (value= "/estadistica.htm" , method = RequestMethod.GET)
	public ModelAndView estadistica(HttpServletRequest request,
									HttpServletResponse response) throws ServletException, IOException  {
		logger.info("----Inicio metodo estadistica----");
		Map<String, Object> myModel = new HashMap<String, Object>();
		return new ModelAndView("estadistica","modelEdicion", myModel );		
	}

	@RequestMapping (value= "/alta.htm" , method = RequestMethod.GET)
	public ModelAndView formularioAlta(HttpServletRequest request,
							HttpServletResponse response) throws ServletException, IOException  {
		
		
		return new ModelAndView("alta","modelAlta", requestLoginVO );
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
		logger.info("----Inicio metodo alta----"+now);
		//requestLoginVO.getUserKaltiaControlEntity().getEmpresaEntity().setEmpresaFechaCorte(now);
		request.getSession().setAttribute("requestLoginVO", requestLoginVO);
		
		resultDAOVO = empresaManager.createEmpresa(empresaEntity);
		
		
		return new ModelAndView("prueba");//,"modelEdicion", model );
	}
									
	

     
}