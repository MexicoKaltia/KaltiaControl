package com.kaltia.kaltiaControl.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaltia.kaltiaControl.bean.EmpresaEntity;
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
	
	
	
	@Override
	public ResultDAOVO createEmpresa(EmpresaEntity empresaEntity) {
	
	
		resultDAOVO = (ResultDAOVO) empresaDAO.createEmpresaDAO(empresaEntity);
		logger.info(resultDAOVO.getCode());
		logger.info(resultDAOVO.getMessage());
		
		return resultDAOVO;
	}
	@Override
	public EmpresaEntity readEmpresa(String idEmpresa) {
		logger.info("readEmpresa:"+idEmpresa);
		empresaEntity = validaEmpresa(idEmpresa);

		return empresaEntity;
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
		
		empresaEntity = empresaDAO.readEmpresaDAO(idEmpresa);
		
		return empresaEntity;
	}
	

}
