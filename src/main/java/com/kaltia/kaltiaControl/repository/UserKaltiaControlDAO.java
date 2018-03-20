package com.kaltia.kaltiaControl.repository;

import java.io.Serializable;

import com.kaltia.kaltiaControl.bean.UserKaltiaControlEntity;
import com.kaltia.kaltiaControl.bean.UserKaltiaControlVO;

public interface UserKaltiaControlDAO extends Serializable{
	
	/*
	 *  CRUD Data Object UserControlKaltia
	 */
	public void createUserKaltiaControlDAO(UserKaltiaControlVO userKaltiaControlVO);
	
	public UserKaltiaControlEntity readUserKaltiaControlDAO(UserKaltiaControlVO userKaltiaControlVO);
	
	public void updateUserKaltiaControlDAO(UserKaltiaControlVO userKaltiaControlVO);
	
	public void deleteUserKaltiaControlDAO(UserKaltiaControlVO userKaltiaControlVO);

}
