package com.kaltia.kaltiaControl.service;

import java.io.Serializable;
import java.util.List;

import com.kaltia.kaltiaControl.bean.UserEmpresaEntity;

public interface UserEmpresaManager extends Serializable{
	
	public void createUserEmpresa();
	public List<UserEmpresaEntity> readUserEmpresa(String idEmpresa);
	public void updateUserEmpresa();
	public void deleteUserEmpresa();

}
