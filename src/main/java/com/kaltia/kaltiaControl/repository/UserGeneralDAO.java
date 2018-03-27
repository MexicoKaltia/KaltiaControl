package com.kaltia.kaltiaControl.repository;

import java.io.Serializable;
import java.util.List;

import com.kaltia.kaltiaControl.bean.UserGeneralEntity;

public interface UserGeneralDAO extends Serializable{
	
	public void createUserGeneralDAO();
	public List<UserGeneralEntity> readUserGeneralDAO(String idEmpresa);
	public void updateUserGeneralDAO();
	public void deleteUserGeneralDAO();

}
