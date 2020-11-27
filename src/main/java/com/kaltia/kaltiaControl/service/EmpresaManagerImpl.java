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
	public ResultDAOVO createEmpresaProductos(ProductosEntity productosEntity) {
		
		empresaEntity = empresaDAO.readIdEmpresaDAO(productosEntity.getIdProducto());
		
		String modeloPagina = productosEntity.getPaginaEntity().getModeloPagina();
		boolean carpetaFileSystem = false;
		if(productosEntity.getPaginaEntity() != null) {
			
			/*
			 * Siguiente IF es para el producto de la Pagina
			 */
			if(resultDAOVO.getCode().equals("00")) {
				ActionEntity actionEntity =new ActionEntity();
				actionEntity.setIdAction(empresaEntity.getIdAction());
				actionEntity.setIdEmpresa(empresaEntity.getIdEmpresa());
				actionEntity.setActionEstilo(modeloPagina);
				actionEntity.setHeaderRequerido(1);
				actionEntity.setBodyRequerido(1);
				actionEntity.setFooterRequerido(1);
				actionEntity.setActionPrincipal(2);
				actionEntity.setAmbiente(PROPS.getProperty("ambiente"));
//				actionEntity.setActionModulos(empresaEntity.getEmpresaModulos());
				//createActionDAO
				resultDAOVO = (ResultDAOVO) empresaDAO.createActionDAO(actionEntity);
				logger.info(resultDAOVO.getCode());
				logger.info("create action:"+resultDAOVO.getMessage());
				
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
									//Create UserKaltiaControl
									logger.info(resultDAOVO.getCode());
									logger.info("Fail create UserKaltiaControl "+resultDAOVO.getMessage());
								}
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
				}else {
					//Create Action
					logger.info(resultDAOVO.getCode());
					logger.info("Fail create Action "+resultDAOVO.getMessage());
				}
			}else {
				//Create Empresa
				logger.info(resultDAOVO.getCode());
				logger.info("Fail create Empresa "+resultDAOVO.getMessage());
			}
			// Inserta el IdPagina
			if(resultDAOVO.getCode().equals("00")) {
				PaginaEntity pE = productosEntity.getPaginaEntity();
				pE.setIdActionPagina(empresaEntity.getIdAction());
				pE.setIdPagina(BaseInfra.idLocalTime());
				
				resultDAOVO = empresaDAO.createPagina(pE);
				logger.info("Exito create PaginaEntity"+resultDAOVO.getMessage());
				carpetaFileSystem = true;
			}else {
					logger.info(resultDAOVO.getCode());
					logger.info("Fail create PaginaEntity"+resultDAOVO.getMessage());
			}
		}
		
		/*
		 * 
		 */
		if( productosEntity.getqRREstaurante() != null) {
			
		}

		/*
		 * 
		 */
		if(productosEntity.getqREstacionamiento() != null) {
			
		}

		/*
		 * 
		 */
		if(productosEntity.getPuntoVenta() != null) {
			
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
		
		return resultDAOVO;
	}
	

}
