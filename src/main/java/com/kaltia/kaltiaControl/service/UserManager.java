package com.kaltia.kaltiaControl.service;

import java.io.Serializable;

import com.kaltia.kaltiaControl.bean.RequestLoginVO;
import com.kaltia.kaltiaControl.bean.UserKaltiaControlVO;

public interface UserManager extends Serializable{
	
	/*
	 * CRUD UsuarioKaltiaControl
	 */
	
	public String createUser(UserKaltiaControlVO userKaltiaControl);
	public RequestLoginVO readUser(UserKaltiaControlVO userKaltiaControl);
	public String updateteUser(UserKaltiaControlVO userKaltiaControl);
	public String deleteUser(UserKaltiaControlVO userKaltiaControl);

}
