package com.kaltia.kaltiaControl.service;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaltia.kaltiaControl.bean.ActionEntity;
import com.kaltia.kaltiaControl.bean.BodyEntity;
import com.kaltia.kaltiaControl.bean.EmpresaEntity;
import com.kaltia.kaltiaControl.bean.FooterEntity;
import com.kaltia.kaltiaControl.bean.HeaderEntity;
import com.kaltia.kaltiaControl.bean.ResultDAOVO;
import com.kaltia.kaltiaControl.repository.EmpresaDAO;

@Service
public class EmpresaManagerImpl implements EmpresaManager{
	
	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());
	private EmpresaEntity empresaEntity;
	
	@Autowired
	private EmpresaDAO empresaDAO;
	@Autowired
	private ResultDAOVO resultDAOVO; 
	
//	private ActionEntity actionEntity;
//	private HeaderEntity headerEntity;
//	private BodyEntity bodyEntity;
//	private FooterEntity footerEntity;
	
	
	
	@Override
	public ResultDAOVO createEmpresa(EmpresaEntity empresaEntity) {
		resultDAOVO = (ResultDAOVO) empresaDAO.createEmpresaDAO(empresaEntity);
		logger.info(resultDAOVO.getCode());
		logger.info("create empresa "+resultDAOVO.getMessage());
		if(resultDAOVO.getCode().equals("00")) {
			ActionEntity actionEntity =new ActionEntity();
			actionEntity.setIdAction(empresaEntity.getIdAction());
			actionEntity.setIdEmpresa(empresaEntity.getIdEmpresa());
			actionEntity.setActionEstilo(empresaEntity.getEmpresaModelo());
			actionEntity.setHeaderRequerido(1);
			actionEntity.setBodyRequerido(1);
			actionEntity.setFooterRequerido(1);
			actionEntity.setActionPrincipal(2);
			resultDAOVO = (ResultDAOVO) empresaDAO.createActionDAO(actionEntity);
			logger.info(resultDAOVO.getCode());
			logger.info("create action "+resultDAOVO.getMessage());
			if(resultDAOVO.getCode().equals("00")) {
				HeaderEntity headerEntity = new HeaderEntity();
				headerEntity = (HeaderEntity) empresaDAO.readHeaderDAO(empresaEntity.getEmpresaModelo().toString());
				logger.info("Lectura de Header:"+headerEntity.getIdEmpresa());
				headerEntity.setIdHeader("header_"+empresaEntity.getIdEmpresa());
				headerEntity.setIdEmpresa(empresaEntity.getIdEmpresa());
				logger.info("Actualizacion de Header:"+headerEntity.getIdEmpresa());
				resultDAOVO = (ResultDAOVO) empresaDAO.createHeaderDAO(headerEntity);
				logger.info(resultDAOVO.getCode());
				logger.info("create header : "+resultDAOVO.getMessage());
				if(resultDAOVO.getCode().equals("00")) {
					BodyEntity bodyEntity = new BodyEntity();
					bodyEntity = (BodyEntity) empresaDAO.readBodyDAO(empresaEntity.getEmpresaModelo().toString());
					bodyEntity.setIdBody("body_"+empresaEntity.getIdEmpresa());
					bodyEntity.setIdEmpresa(empresaEntity.getIdEmpresa());
					resultDAOVO = (ResultDAOVO) empresaDAO.createBodyDAO(bodyEntity);	
					logger.info(resultDAOVO.getCode());
					logger.info("create body "+resultDAOVO.getMessage());
					if(resultDAOVO.getCode().equals("00")) {
						FooterEntity footerEntity = new FooterEntity();
						footerEntity = (FooterEntity) empresaDAO.readFooterDAO(empresaEntity.getEmpresaModelo().toString());
						footerEntity.setIdFooter("footer_"+empresaEntity.getIdEmpresa());
						footerEntity.setIdEmpresa(empresaEntity.getIdEmpresa());
						resultDAOVO = (ResultDAOVO) empresaDAO.createFooterDAO(footerEntity);
						logger.info(resultDAOVO.getCode());
						logger.info("create footer "+resultDAOVO.getMessage());
						if(resultDAOVO.getCode().equals("00")) {
							resultDAOVO.setMessage("Alta Exitosa, Action, Header, Body , Footer");
						}else {
							//Create Footer
							logger.info(resultDAOVO.getCode());
							logger.info("Create footer "+resultDAOVO.getMessage());
							
						}
					}else {
						//Create Body
						logger.info(resultDAOVO.getCode());
						logger.info("Create Body "+resultDAOVO.getMessage());
					}				
				}else {
					//Create Header
					logger.info(resultDAOVO.getCode());
					logger.info("Create Header "+resultDAOVO.getMessage());
				}				
			}else {
				//Create Action
				logger.info(resultDAOVO.getCode());
				logger.info("Create Action "+resultDAOVO.getMessage());
			}
		}else {
			//Create Empresa
			logger.info(resultDAOVO.getCode());
			logger.info("Create Empresa "+resultDAOVO.getMessage());
		}
		return resultDAOVO;
	}
	@Override
	public EmpresaEntity readEmpresa(String idUserKaltiaControl) {
		logger.info("readEmpresa:"+idUserKaltiaControl);
		empresaEntity = empresaDAO.readEmpresaDAO(idUserKaltiaControl);

		return empresaEntity;
	}
	@Override
	public ArrayList<EmpresaEntity> readEmpresaArray(String idUserPerfilI) {
		logger.info("readEmpresaArray:"+idUserPerfilI);
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
