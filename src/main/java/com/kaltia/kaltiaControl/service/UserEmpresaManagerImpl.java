package com.kaltia.kaltiaControl.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaltia.kaltiaControl.bean.UserEmpresaEntity;
import com.kaltia.kaltiaControl.repository.UserEmpresaDAO;

@Service
public class UserEmpresaManagerImpl implements UserEmpresaManager{
	
	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private UserEmpresaDAO userEmpresaDAO; 
	@Override
	public void createUserEmpresa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserEmpresaEntity> readUserEmpresa(String idEmpresa) {
		logger.info("readUserEmpresa:"+idEmpresa);
		List<UserEmpresaEntity> userEmpresaEntity = new ArrayList<UserEmpresaEntity>();
		
		userEmpresaEntity = (List<UserEmpresaEntity>) userEmpresaDAO.readUserEmpresaDAO(idEmpresa);

		return userEmpresaEntity;
	}

	@Override
	public void updateUserEmpresa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserEmpresa() {
		// TODO Auto-generated method stub
		
	}
}
