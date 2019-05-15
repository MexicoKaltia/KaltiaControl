package com.kaltia.kaltiaControl.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	
	@Override
	public ResultDAOVO createEmpresa(EmpresaEntity empresaEntity) {
		empresaEntity.setEmpresaIdPerfilE(empresaEntity.getIdAction());
		//createEmpresaDAO
		/*
		 * hacer la validacion de un idAction ó un idEmpresa not null... y dublicado !!
		 */
		resultDAOVO = (ResultDAOVO) empresaDAO.createEmpresaDAO(empresaEntity);
		logger.info(empresaEntity.getEmpresaClientes());
		logger.info(empresaEntity.getEmpresaCarpetas());
		logger.info(empresaEntity.getEmpresaCitas());
		
		if(resultDAOVO.getCode().equals("00")) {
			ActionEntity actionEntity =new ActionEntity();
			actionEntity.setIdAction(empresaEntity.getIdAction());
			actionEntity.setIdEmpresa(empresaEntity.getIdEmpresa());
			actionEntity.setActionEstilo(empresaEntity.getEmpresaModelo());
			actionEntity.setHeaderRequerido(1);
			actionEntity.setBodyRequerido(1);
			actionEntity.setFooterRequerido(1);
			actionEntity.setActionPrincipal(2);
			actionEntity.setAmbiente(PROPS.getProperty("ambiente"));
			//createActionDAO
			resultDAOVO = (ResultDAOVO) empresaDAO.createActionDAO(actionEntity);
			logger.info(resultDAOVO.getCode());
			logger.info("create action "+resultDAOVO.getMessage());
			
			if(resultDAOVO.getCode().equals("00")) {
				HeaderEntity headerEntity = new HeaderEntity();
				headerEntity = (HeaderEntity) empresaDAO.readHeaderDAO(empresaEntity.getEmpresaModelo().toString());
				logger.info("Lectura de Header:"+headerEntity.getIdEmpresa());
				headerEntity.setIdHeader(empresaEntity.getIdAction()+"-header");
				headerEntity.setIdEmpresa(empresaEntity.getIdEmpresa());
				logger.info("Actualizacion de Header:"+headerEntity.getIdEmpresa());
				//createHeaderDAO
				resultDAOVO = (ResultDAOVO) empresaDAO.createHeaderDAO(headerEntity);
				logger.info(resultDAOVO.getCode());
				logger.info("create header : "+resultDAOVO.getMessage());
				if(resultDAOVO.getCode().equals("00")) {
					BodyEntity bodyEntity = new BodyEntity();
					bodyEntity = (BodyEntity) empresaDAO.readBodyDAO(empresaEntity.getEmpresaModelo().toString());
					bodyEntity.setIdBody(empresaEntity.getIdAction()+"-body");
					bodyEntity.setIdEmpresa(empresaEntity.getIdEmpresa());
					//createBodyDAO
					resultDAOVO = (ResultDAOVO) empresaDAO.createBodyDAO(bodyEntity);	
					logger.info(resultDAOVO.getCode());
					logger.info("create body "+resultDAOVO.getMessage());
					if(resultDAOVO.getCode().equals("00")) {
						FooterEntity footerEntity = new FooterEntity();
						footerEntity = (FooterEntity) empresaDAO.readFooterDAO(empresaEntity.getEmpresaModelo().toString());
						footerEntity.setIdFooter(empresaEntity.getIdAction()+"-footer");
						footerEntity.setIdEmpresa(empresaEntity.getIdEmpresa());
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
//		Inicio Alta Modulos y carpeta Bash		
		if(resultDAOVO.getCode().equals("00")) {
			try {
			resultVO = clienteRest.createServiceEmpresaNueva(empresaEntity.getIdAction().toString(),
					empresaEntity.getEmpresaClientes(),
					empresaEntity.getEmpresaCitas(),
					empresaEntity.getEmpresaCarpetas());
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
		
		
	@Override
	public EmpresaEntity readEmpresa(String idUserKaltiaControl) {
//		logger.info("readEmpresa:"+idUserKaltiaControl);
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteEmpresa() {
		// TODO Auto-generated method stub
		
	}
	
	public EmpresaEntity validaEmpresa(String idEmpresa) {
		
		
		
		return empresaEntity;
	}
	

}
