package com.kaltia.kaltiaControl.service;

import java.io.Serializable;
import java.util.List;

import com.kaltia.kaltiaControl.bean.UserGeneralEntity;

public interface UserGeneralManager extends Serializable{
	
	public void createUserGeneral();
	public List<UserGeneralEntity> readUserGeneral(String idEmpresa);
	public void updateUserGeneral();
	public void deleteUserGeneral();

}
