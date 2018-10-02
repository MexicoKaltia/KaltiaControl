package com.kaltia.kaltiaControl.repository;

import java.io.Serializable;
import java.util.List;

import com.kaltia.kaltiaControl.bean.UserEmpresaEntity;

public interface UserEmpresaDAO extends Serializable{
	
	public void createUserEmpresaDAO();
	public List<UserEmpresaEntity> readUserEmpresaDAO(String idEmpresa);
	public void updateUserEmpresaDAO();
	public void deleteUserEmpresaDAO();

}
