package com.kaltia.kaltiaControl.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.kaltia.kaltiaControl.bean.RequestLoginVO;
import com.kaltia.kaltiaControl.bean.ResultDAOVO;
import com.kaltia.kaltiaControl.service.EmpresaManager;
import com.kaltia.kaltiaControl.service.UserManager;

@RestController
public class ControllerUtil {
	
	
									
	
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
    
//    @ModelAttribute
//    public void modeloComun(Model model) {
//   	 model.addAttribute("requestLoginVO", requestLoginVO);
//   	 
//    }


}
