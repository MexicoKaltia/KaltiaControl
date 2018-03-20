package com.kaltia.kaltiaControl.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class RequestLoginVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userEstilo;
	private String userIdEmpresa;
	private String userIdAction;
	private String userStatus;
	private String userPerfil;
	
	public RequestLoginVO() {
		
	}
	
	
	public String getUserPerfil() {
		return userPerfil;
	}
	public void setUserPerfil(String userPerfil) {
		this.userPerfil = userPerfil;
	}
	public String getUserEstilo() {
		return userEstilo;
	}
	public void setUserEstilo(String userEstilo) {
		this.userEstilo = userEstilo;
	}
	public String getUserIdEmpresa() {
		return userIdEmpresa;
	}
	public void setUserIdEmpresa(String userIdEmpresa) {
		this.userIdEmpresa = userIdEmpresa;
	}
	public String getUserIdAction() {
		return userIdAction;
	}
	public void setUserIdAction(String userIdAction) {
		this.userIdAction = userIdAction;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	
	
	

}
