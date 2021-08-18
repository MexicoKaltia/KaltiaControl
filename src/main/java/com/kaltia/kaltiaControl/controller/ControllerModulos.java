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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kaltia.kaltiaControl.bean.ChatEntity;
import com.kaltia.kaltiaControl.bean.EmpresaEntity;
import com.kaltia.kaltiaControl.bean.ProductosEntity;
import com.kaltia.kaltiaControl.bean.ProductosVO;
import com.kaltia.kaltiaControl.bean.RequestLoginVO;
import com.kaltia.kaltiaControl.bean.ResultDAOVO;
import com.kaltia.kaltiaControl.bean.UserEmpresaEntity;
import com.kaltia.kaltiaControl.bean.UserKaltiaControlVO;
import com.kaltia.kaltiaControl.bean.VideoEntity;
import com.kaltia.kaltiaControl.repository.IProductosDAO;
import com.kaltia.kaltiaControl.service.EmpresaManager;
import com.kaltia.kaltiaControl.service.IProductosService;
import com.kaltia.kaltiaControl.service.UserManager;

//@CrossOrigin(origins = {"http://kaltia.xyz", "http://localhost:8081"})
@Controller
@ControllerAdvice
@SessionAttributes ("model")
public class ControllerModulos extends HttpServlet {
    
	private static final long serialVersionUID = -914904182640401317L;
 
	protected final Log logger = LogFactory.getLog(getClass());
    
    @Autowired
    IProductosService productosService ;
    @Autowired
    IProductosDAO productosDAO;
    @Autowired
    private RequestLoginVO requestLoginVO;
    @Autowired
    private ResultDAOVO resultDAOVO;
    @Autowired
    private EmpresaManager empresaManager;
    
    
    @RequestMapping (value = "/altaProductos.htm", method = RequestMethod.POST)
	public ModelAndView altaProductos (@Valid @ModelAttribute("productosVO") ProductosVO productosVO,		
//										@RequestParam(name="empresaEntity", required=false) EmpresaEntity empresaEntity,
									BindingResult result,
									ModelMap model)
								throws ServletException, IOException {
		
		String now = (new Date()).toString();
		logger.info("----Inicio metodo altaProductos----"+now);
		
		resultDAOVO = empresaManager.createEmpresaProductos(productosVO);
		
		ModelAndView mav = new ModelAndView();
//		
		if(!resultDAOVO.getCode().equals("99")) {
			if(productosVO.getqRREstaurante().getTipoQRR().contains("QR")) {
				mav.setViewName("redirect:/edicion.htm?idAction="+productosVO.getqRREstaurante().getIdAction()+"&tipo=qr" );
			}else {
				mav.setViewName("redirect:/edicion.htm?idAction="+productosVO.getPaginaEntity().getIdAction()+"&tipo=");
			}

		}else {
			mav.setViewName("redirect:/alta.htm");
			mav.addObject("error", true);
		}
		return mav;
	}
	
	@RequestMapping (value = "/actualizaModulos.htm", method = RequestMethod.POST)
	public ModelAndView actualizaModulos(@Valid @ModelAttribute("productosEntity") ProductosEntity productosEntity,		
									BindingResult result,
									ModelMap model)
									throws ServletException, IOException {
		logger.info(productosEntity.toString());
		
		String now = (new Date()).toString();
		logger.info("----Inicio metodo actualizaCliente----"+now);
//		requestLoginVO.setProductosEntity(productosEntity);
		
		resultDAOVO = empresaManager.updateProductos(productosEntity);
		
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
	
	@RequestMapping(value="/addVideo.htm" , method = RequestMethod.POST)
    public ModelAndView addVideo(@Valid @ModelAttribute("videoEntity") VideoEntity videoEntity, 
    									BindingResult result,
    									ModelMap model){
		logger.info("----Inicio metodo addVideo----");
		
		ModelAndView mav = new ModelAndView();
		
		requestLoginVO = (RequestLoginVO) model.get("requestLoginVO");
		String idUser = requestLoginVO.getUserKaltiaControlEntity().getIdUserKaltiaControlUser();
		String idEmpresa = requestLoginVO.getEmpresaEntity().getIdEmpresa();
		String idAction = requestLoginVO.getEmpresaEntity().getIdAction();
		logger.info("idUser:"+idUser);
		videoEntity.setUserCreate(idUser);
		videoEntity.setIdEmpresa(idEmpresa);
		videoEntity.setIdAction(idAction);
		resultDAOVO = productosService.addVideoService(videoEntity);
		
		if(!resultDAOVO.getCode().equals("99")) {
			mav.addObject("exito", true);
		}else {
			mav.addObject("error", true);
		}
		mav.setViewName("redirect:/modulos.htm");
		return mav;
     }
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping (value= "/eliminarVideo.htm" , params = {"idVideo"} , method = RequestMethod.POST)
	public ModelAndView eliminarVideo(ModelMap model,
								@RequestParam(value = "idVideo") String idVideo) throws ServletException, IOException  {
		
		String contexto = idVideo;
		
		model.addAttribute("contexto", contexto);
		logger.info("----Inicio metodo eliminarVideo----" + idVideo);
		resultDAOVO = productosDAO.deleteVideo(idVideo);
		ModelAndView mav = new ModelAndView();
		logger.info(resultDAOVO.getCode());
		if(resultDAOVO.getCode().equals("00")) {
			logger.info("----resultDAOVO.getCode().equals(\"00\")----");
			requestLoginVO = (RequestLoginVO) model.get("requestLoginVO");
			model.addAttribute("requestLoginVO", requestLoginVO);
			mav.addObject("exito", true);
			mav.setViewName("redirect:/modulos.htm");
		}

		return mav;		
	}
	
	@RequestMapping(value="/addNumeroChat.htm" , method = RequestMethod.POST)
    public ModelAndView addVideo(@Valid @ModelAttribute("chatEntity") ChatEntity chatEntity, 
    									BindingResult result,
    									ModelMap model){
		logger.info("----Inicio metodo add Numero Chat----");
		
		ModelAndView mav = new ModelAndView();
		
		requestLoginVO = (RequestLoginVO) model.get("requestLoginVO");
		String idUser = requestLoginVO.getUserKaltiaControlEntity().getIdUserKaltiaControlUser();
		String idEmpresa = requestLoginVO.getEmpresaEntity().getIdEmpresa();
		String idAction = requestLoginVO.getEmpresaEntity().getIdAction();
		logger.info("idUser:"+idUser);
		chatEntity.setUserCreate(idUser);
		chatEntity.setIdEmpresa(idEmpresa);
		chatEntity.setIdAction(idAction);
		resultDAOVO = productosService.addChatService(chatEntity);
		
		if(!resultDAOVO.getCode().equals("99")) {
			mav.addObject("exito", true);
		}else {
			mav.addObject("error", true);
		}
		mav.setViewName("redirect:/modulos.htm");
		return mav;
     }
	
	
     
}