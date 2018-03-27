package com.kaltia.kaltiaControl.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaltia.kaltiaControl.bean.StatusEmpresaEntity;
import com.kaltia.kaltiaControl.repository.StatusEmpresaDAO;

@Service
public class StatusEmpresaManagerImpl implements StatusEmpresaManager{
	
	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());

	
	@Autowired
	private StatusEmpresaDAO statusEmpresaDAO;
	private StatusEmpresaEntity statusEmpresaEntity;

	@Override
	public void createStatusEmpresaManager() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StatusEmpresaEntity readStatusEmpresaManager(String idEmpresa) {
		logger.info("readStatusEmpresaManager:"+idEmpresa);
		//statusEmpresaEntity = 
				return statusEmpresaDAO.readStatusEmpresaDAO(idEmpresa);

		
	}

	@Override
	public void updateStatusEmpresaManager() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStatusEmpresaManager() {
		// TODO Auto-generated method stub
		
	}

}
