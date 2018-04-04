package com.kaltia.kaltiaControl.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kaltia.kaltiaControl.bean.RequestLoginVO;
import com.kaltia.kaltiaControl.bean.UserKaltiaControlEntity;
import com.kaltia.kaltiaControl.bean.UserKaltiaControlVO;
import com.kaltia.kaltiaControl.service.UserManager;


@Controller
public class ControllerInicial {
    protected final Log logger = LogFactory.getLog(getClass());
    
     @Autowired
     //@Qualifier("userManagerImpl")
     private UserManager userManager;
     @Autowired
     //@Qualifier("requestLoginVO")
     private RequestLoginVO requestLoginVO;
     
    

	@RequestMapping(value="/login.htm" , method = RequestMethod.POST)
    public ModelAndView handleRequest(@Valid @ModelAttribute("userKaltiaControl") UserKaltiaControlVO userKaltiaControlFront, 
    	      BindingResult result, ModelMap model, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	 String now = (new Date()).toString();
         logger.info("Returning hello view with " + now);
         logger.info("user:"+userKaltiaControlFront.getUserUser());
         logger.info("pass:"+userKaltiaControlFront.getPassUser());

         Map<String, Object> myModel = new HashMap<String, Object>();
         myModel.put("now", now);
         
         requestLoginVO = this.userManager.readUser(userKaltiaControlFront);
       
         myModel.put("requestLoginVO", requestLoginVO);         

         return new ModelAndView(requestLoginVO.getUserKaltiaControlEntity().getUserKaltiaControlPerfil().toString(), "model", myModel);
//         return new ModelAndView("prueba", "model", myModel);
     }
	

	/*public void setRequestLoginVO(RequestLoginVO requestLoginVO) {
		this.requestLoginVO = requestLoginVO;
	}*/
     
     
}