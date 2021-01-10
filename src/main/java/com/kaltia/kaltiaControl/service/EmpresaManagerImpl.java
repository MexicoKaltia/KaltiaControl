package com.kaltia.kaltiaControl.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.LocalTime;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaltia.kaltiaControl.Util.BaseInfra;
import com.kaltia.kaltiaControl.bean.ActionEntity;
import com.kaltia.kaltiaControl.bean.BodyEntity;
import com.kaltia.kaltiaControl.bean.EmpresaEntity;
import com.kaltia.kaltiaControl.bean.FooterEntity;
import com.kaltia.kaltiaControl.bean.HeaderEntity;
import com.kaltia.kaltiaControl.bean.PaginaEntity;
import com.kaltia.kaltiaControl.bean.ProductosEntity;
import com.kaltia.kaltiaControl.bean.ProductosVO;
import com.kaltia.kaltiaControl.bean.QRRestauranteEntity;
import com.kaltia.kaltiaControl.bean.ResultDAOVO;
import com.kaltia.kaltiaControl.bean.ResultVO;
import com.kaltia.kaltiaControl.repository.EmpresaDAO;

@Service
public class EmpresaManagerImpl implements EmpresaManager{
	
	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());
	public static Properties PROPS = BaseInfra.PROPS;
	private EmpresaEntity empresaEntity;
	
	@Autowired
	private EmpresaDAO empresaDAO;
	@Autowired
	private ResultDAOVO resultDAOVO;
	@Autowired
	private UserManager userManager;
	@Autowired
	private ClienteRest clienteRest;
	@Autowired
	ResultVO resultVO;
	
//	@SuppressWarnings("unused")
	@Override
	public ResultDAOVO createEmpresa(EmpresaEntity empresaEntity) {

		// validacion de un idAction dublicado !!
		EmpresaEntity empresaExiste = empresaDAO.readEmpresaDAO(empresaEntity.getIdAction());
		if( empresaExiste == null  || empresaExiste.getIdEmpresa().equals("Exception")) {
			empresaEntity.setIdEmpresa(BaseInfra.idLocalTime());
			logger.info(empresaEntity.getIdEmpresa());
			resultDAOVO = (ResultDAOVO) empresaDAO.createEmpresaDAO(empresaEntity);
		}else {
			resultDAOVO.setCode("99");
			resultDAOVO.setMessage("Empresa IdAction ya esta registrada");
		}
			return resultDAOVO;	

	}
		
	@Override
	public EmpresaEntity readEmpresa(String idUserKaltiaControl) {
		empresaEntity = empresaDAO.readEmpresaDAO(idUserKaltiaControl);
		return empresaEntity;
	}

	@Override
	public ArrayList<EmpresaEntity> readEmpresaArray(String idUserPerfilI) {
//		logger.info("readEmpresaArray:"+idUserPerfilI);
		ArrayList<EmpresaEntity> empresaEntityArray =  empresaDAO.readEmpresaArrayDAO(idUserPerfilI);
//		for(EmpresaEntity idEmpresa: empresaEntityArray) {
//			empresaEntity = validaEmpresa(idUserPerfilI);
//		}
		return empresaEntityArray;
	}
	@Override
	public void updateEmpresa() {
		
	}
	@Override
	public void deleteEmpresa() {
		
	}
	
	public EmpresaEntity validaEmpresa(String idEmpresa) {
		return empresaEntity;
	}


	@Override
	public ResultDAOVO createEmpresaProductos(ProductosVO productosVO) {
		
		empresaEntity = empresaDAO.readIdEmpresaDAO(productosVO.getIdEmpresa());
		String modeloPagina = productosVO.getModeloProducto();
		String codigo="";
		boolean carpetaFileSystem = false;
		
		/*
		 * Productos
		 */
		ProductosEntity productosEntity = new ProductosEntity();
		productosEntity.setIdEmpresa(productosVO.getIdEmpresa());
		productosEntity.setCheckPagina(productosVO.isCheckPagina());
		productosEntity.setCheckQRR(productosVO.isCheckQRR());
		productosEntity.setCheckQRE(productosVO.isCheckQRE());
		productosEntity.setCheckPuntoVenta(productosVO.isCheckPuntoVenta());
		productosEntity.setClientePagina(productosVO.isClientePagina());
		productosEntity.setCitaPagina(productosVO.isCitaPagina());
		productosEntity.setCarpetaPagina(productosVO.isCarpetaPagina());
		productosEntity.setRetroalimentacionPagina(productosVO.isRetroalimentacionPagina());
		productosEntity.setChatPagina(productosVO.isChatPagina());
		productosEntity.setNotificacionPagina(productosVO.isNotificacionPagina());
		productosEntity.setVideoPagina(productosVO.isVideoPagina());
		productosEntity.setTarjetaPagina(productosVO.isTarjetaPagina());
		resultDAOVO = (ResultDAOVO) empresaDAO.createProductos(productosEntity);
		
		codigo = createAction(empresaEntity, modeloPagina);
		if(!codigo.equals("00")) {
			resultDAOVO.setCode("99");
			resultDAOVO.setMessage("Error createAction");
			return resultDAOVO;
		}
		
		/*
		 * Producto Pagina
		 */
		if (productosVO.isCheckPagina()) {
			resultDAOVO = createPagina(modeloPagina);
			if (!resultDAOVO.getCode().equals("00")) {
				return resultDAOVO;
			}
		}

		// Inserta el IdPagina
		if (productosVO.isCheckPagina()) {
			PaginaEntity pE = productosVO.getPaginaEntity();
			pE.setIdPagina(empresaEntity.getIdEmpresa());
			pE.setIdAction(empresaEntity.getIdAction());
			pE.setModeloPagina(modeloPagina);

			resultDAOVO = empresaDAO.createPagina(pE);
			if(resultDAOVO.getCode().equals("00")) {
				logger.info("Exito create PaginaEntity" + resultDAOVO.getMessage());
				carpetaFileSystem = true;
			}else {
					logger.info(resultDAOVO.getCode());
					logger.info("Fail create PaginaEntity" + resultDAOVO.getMessage());
					carpetaFileSystem = false;
					return resultDAOVO;
			}
		}
		
		/*
		 *  Producto QRR
		 */
		if( productosVO.isCheckQRR()) {
			logger.info("QRR Activo:"+productosVO.getqRREstaurante().getTipoQRR());
			resultDAOVO = createQRR(modeloPagina, productosVO, carpetaFileSystem);
		}

		/*
		 * Producto QRE
		 */
		if(productosVO.getqREstacionamiento() != null) {
			
		}

		/*
		 * Producto Punto de Venta
		 */
		if(productosVO.getPuntoVenta() != null) {
			
		}
		
		/*
		 *  user kaltiaControl
		 */
		if(resultDAOVO.getCode().equals("00")) {
			//createUserKaltiaControl perfil E
			resultDAOVO = userManager.createUser(empresaEntity);
			logger.info(resultDAOVO.getCode());
			logger.info("create UserKaltiaControl "+resultDAOVO.getMessage());
			if(resultDAOVO.getCode().equals("00")) {
			resultDAOVO.setMessage("Alta Exitosa, Action, Header, Body , Footer, UserKaltiaControl");
			logger.info(resultDAOVO.getMessage());
			carpetaFileSystem = true;
			}else {
				logger.info(resultDAOVO.getCode());
				logger.info("Fail create UserKaltiaControl "+resultDAOVO.getMessage());
			}
		}
			
		/*
		 *  CREA LAS CARPETAS FILE SYSTEM
		 */
		if(carpetaFileSystem) {
			try {
				resultVO = clienteRest.createServiceEmpresaNueva(empresaEntity.getIdAction().toString());
				if(resultVO.getCodigo()==0) {
					resultDAOVO.setCode("00");
				}else {
					resultDAOVO.setCode("99");
					resultDAOVO.setMessage("Error Creacion Carpeta");
				}
			}catch(Exception e) {
				resultDAOVO.setCode("99");
				resultDAOVO.setMessage("Error en Conexion Creacion Carpeta");
				e.printStackTrace();
			}
		}
		
		if(resultVO.getCodigo()==0) {
			empresaEntity.setEmpresaStatus("inicio");
			resultDAOVO = (ResultDAOVO) empresaDAO.createEmpresaDAO(empresaEntity);
		}else {
			resultDAOVO.setCode("99");
			resultDAOVO.setMessage("Error Actualiza Status Empresa");
		}
		
		
		return resultDAOVO;

	}

	private ResultDAOVO createQRR(String modeloPagina, ProductosVO productosVO, boolean carpetaFileSystem) {
		QRRestauranteEntity qrrEntity = new QRRestauranteEntity();
		qrrEntity.setIdQRR(empresaEntity.getIdEmpresa());
		qrrEntity.setIdAction(empresaEntity.getIdAction());
		qrrEntity.setModeloQRR(modeloPagina);
		qrrEntity.setTipoQRR(productosVO.getqRREstaurante().getTipoQRR());
		
		resultDAOVO = empresaDAO.createQRR(qrrEntity);
		if(resultDAOVO.getCode().equals("00")) {
			logger.info("Exito create QRR" + resultDAOVO.getMessage());
			resultDAOVO = createPagina(modeloPagina);
			carpetaFileSystem = true;
		}else {
				logger.info(resultDAOVO.getCode());
				logger.info("Fail create QRR" + resultDAOVO.getMessage());
				carpetaFileSystem = false;
			}
		return resultDAOVO;
	}

	private ResultDAOVO createPagina(String modeloPagina) {
		if(resultDAOVO.getCode().equals("00")) {
			HeaderEntity headerEntity = new HeaderEntity();
			headerEntity = (HeaderEntity) empresaDAO.readHeaderDAO(modeloPagina);
			logger.info("Lectura de Header:"+headerEntity.getIdEmpresa());
			headerEntity.setIdHeader(empresaEntity.getIdAction()+"-header");
			headerEntity.setIdEmpresa(empresaEntity.getIdEmpresa());
			headerEntity.setIdAction(empresaEntity.getIdAction());
			logger.info("Actualizacion de Header:"+headerEntity.getIdEmpresa());
			//createHeaderDAO
			resultDAOVO = (ResultDAOVO) empresaDAO.createHeaderDAO(headerEntity);
			logger.info(resultDAOVO.getCode());
			logger.info("create header : "+resultDAOVO.getMessage());
			if(resultDAOVO.getCode().equals("00")) {
				BodyEntity bodyEntity = new BodyEntity();
				bodyEntity = (BodyEntity) empresaDAO.readBodyDAO(modeloPagina);
				bodyEntity.setIdBody(empresaEntity.getIdAction()+"-body");
				bodyEntity.setIdEmpresa(empresaEntity.getIdEmpresa());
				bodyEntity.setIdAction(empresaEntity.getIdAction());
				//createBodyDAO
				resultDAOVO = (ResultDAOVO) empresaDAO.createBodyDAO(bodyEntity);	
				logger.info(resultDAOVO.getCode());
				logger.info("create body "+resultDAOVO.getMessage());
				if(resultDAOVO.getCode().equals("00")) {
					FooterEntity footerEntity = new FooterEntity();
					footerEntity = (FooterEntity) empresaDAO.readFooterDAO(modeloPagina);
					footerEntity.setIdFooter(empresaEntity.getIdAction()+"-footer");
					footerEntity.setIdEmpresa(empresaEntity.getIdEmpresa());
					footerEntity.setIdAction(empresaEntity.getIdAction());
					//createFooterDAO
					resultDAOVO = (ResultDAOVO) empresaDAO.createFooterDAO(footerEntity);
					logger.info(resultDAOVO.getCode());
					logger.info("create footer "+resultDAOVO.getMessage());
					
					}else {
						//Create Footer
						logger.info(resultDAOVO.getCode());
						logger.info("Fail create footer "+resultDAOVO.getMessage());
					}
				}else {
					//Create Body
					logger.info(resultDAOVO.getCode());
					logger.info("Fail create Body "+resultDAOVO.getMessage());
				}				
			}else {
				//Create Header
				logger.info(resultDAOVO.getCode());
				logger.info("Fail create Header "+resultDAOVO.getMessage());
			}	
		return resultDAOVO;
	}
	
	private ResultDAOVO createPaginaQRR(String modeloPagina) {
		if(resultDAOVO.getCode().equals("00")) {
			HeaderEntity headerEntity = new HeaderEntity();
			headerEntity = (HeaderEntity) empresaDAO.readHeaderDAO(modeloPagina);
			logger.info("Lectura de Header:"+headerEntity.getIdEmpresa());
			headerEntity.setIdHeader(empresaEntity.getIdAction()+"-header");
			headerEntity.setIdEmpresa(empresaEntity.getIdEmpresa());
			headerEntity.setIdAction(empresaEntity.getIdAction());
			logger.info("Actualizacion de Header:"+headerEntity.getIdEmpresa());
			//createHeaderDAO
			resultDAOVO = (ResultDAOVO) empresaDAO.createHeaderDAO(headerEntity);
			logger.info(resultDAOVO.getCode());
			logger.info("create header : "+resultDAOVO.getMessage());
				if(resultDAOVO.getCode().equals("00")) {
					FooterEntity footerEntity = new FooterEntity();
					footerEntity = (FooterEntity) empresaDAO.readFooterDAO(modeloPagina);
					footerEntity.setIdFooter(empresaEntity.getIdAction()+"-footer");
					footerEntity.setIdEmpresa(empresaEntity.getIdEmpresa());
					footerEntity.setIdAction(empresaEntity.getIdAction());
					//createFooterDAO
					resultDAOVO = (ResultDAOVO) empresaDAO.createFooterDAO(footerEntity);
					logger.info(resultDAOVO.getCode());
					logger.info("create footer "+resultDAOVO.getMessage());
					
					}else {
						//Create Footer
						logger.info(resultDAOVO.getCode());
						logger.info("Fail create footer "+resultDAOVO.getMessage());
					}
			}else {
				//Create Header
				logger.info(resultDAOVO.getCode());
				logger.info("Fail create Header "+resultDAOVO.getMessage());
			}	
		return resultDAOVO;
	}


	private String createAction(EmpresaEntity empresaEntity, String modeloPagina) {
		logger.info("Pagina Editable Activo:"+empresaEntity.getIdAction());
		
		ActionEntity actionEntity =new ActionEntity();
		actionEntity.setIdAction(empresaEntity.getIdAction());
		actionEntity.setIdEmpresa(empresaEntity.getIdEmpresa());
		actionEntity.setActionEstilo(modeloPagina);
		actionEntity.setHeaderRequerido(1);
		actionEntity.setBodyRequerido(1);
		actionEntity.setFooterRequerido(1);
		actionEntity.setActionPrincipal(2);
		actionEntity.setAmbiente(PROPS.getProperty("ambiente"));
		resultDAOVO = (ResultDAOVO) empresaDAO.createActionDAO(actionEntity);
		logger.info(resultDAOVO.getCode());
		logger.info("create action:"+resultDAOVO.getMessage());
		
		return resultDAOVO.getCode();

		
	}
	

}
