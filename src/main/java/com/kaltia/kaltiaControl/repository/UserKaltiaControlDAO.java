package com.kaltia.kaltiaControl.repository;

import java.io.Serializable;

import com.kaltia.kaltiaControl.bean.ResultDAOVO;
import com.kaltia.kaltiaControl.bean.UserKaltiaControlEntity;
import com.kaltia.kaltiaControl.bean.UserKaltiaControlVO;

public interface UserKaltiaControlDAO extends Serializable{
	
	/*
	 *  CRUD Data Object UserControlKaltia
	 */
	public ResultDAOVO createUserKaltiaControlDAO(UserKaltiaControlEntity uKCE);
	
	public UserKaltiaControlEntity readUserKaltiaControlDAO(UserKaltiaControlVO uKCVO);
	
	public UserKaltiaControlEntity updateUserKaltiaControlDAO(UserKaltiaControlEntity uKCE);
	
	public void actividadUserKaltiaControlDAO(UserKaltiaControlEntity uKCE);
	
	public void deleteUserKaltiaControlDAO(UserKaltiaControlVO uKCVO);

}
