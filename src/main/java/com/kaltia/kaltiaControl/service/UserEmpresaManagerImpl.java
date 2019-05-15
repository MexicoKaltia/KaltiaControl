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
	public List<UserEmpresaEntity> readUserEmpresa(String userEmpresaAction) {
//		logger.info("readUserEmpresa:"+idEmpresa);
		List<UserEmpresaEntity> userEmpresaEntityList = new ArrayList<UserEmpresaEntity>();
		
		userEmpresaEntityList = (List<UserEmpresaEntity>) userEmpresaDAO.readUserEmpresaDAO(userEmpresaAction);
//		for(int a = 0; a<userEmpresaEntityList.size(); a++) {
//			logger.info(userEmpresaEntityList.get(a).getIdUserEmpresa());
//		}

		return userEmpresaEntityList;
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
