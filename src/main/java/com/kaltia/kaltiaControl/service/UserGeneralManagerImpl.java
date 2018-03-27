package com.kaltia.kaltiaControl.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaltia.kaltiaControl.bean.UserGeneralEntity;
import com.kaltia.kaltiaControl.repository.UserGeneralDAO;

@Service
public class UserGeneralManagerImpl implements UserGeneralManager{
	
	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private UserGeneralDAO userGeneralDAO; 
	@Override
	public void createUserGeneral() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserGeneralEntity> readUserGeneral(String idEmpresa) {
		logger.info("readUserGeneral:"+idEmpresa);
		List<UserGeneralEntity> userGeneralEntity = new ArrayList<UserGeneralEntity>();
		
		userGeneralEntity = (List<UserGeneralEntity>) userGeneralDAO.readUserGeneralDAO(idEmpresa);
		

		
		return userGeneralEntity;
	}

	@Override
	public void updateUserGeneral() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserGeneral() {
		// TODO Auto-generated method stub
		
	}
}
