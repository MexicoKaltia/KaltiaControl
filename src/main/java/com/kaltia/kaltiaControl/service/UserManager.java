package com.kaltia.kaltiaControl.service;

import java.io.Serializable;

import com.kaltia.kaltiaControl.bean.EmpresaEntity;
import com.kaltia.kaltiaControl.bean.RequestLoginVO;
import com.kaltia.kaltiaControl.bean.ResultDAOVO;
import com.kaltia.kaltiaControl.bean.UserKaltiaControlVO;

public interface UserManager extends Serializable{
	
	/*
	 * CRUD UsuarioKaltiaControl
	 */
	
	public ResultDAOVO createUser(EmpresaEntity empresaEntity);
	public RequestLoginVO readUser(UserKaltiaControlVO userKaltiaControl);
	public RequestLoginVO updateUser(UserKaltiaControlVO userKaltiaControl);
	public String deleteUser(UserKaltiaControlVO userKaltiaControl);

}
