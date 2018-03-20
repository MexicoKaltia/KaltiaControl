package com.kaltia.kaltiaControl.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="tc_userkaltiacontrol")
//@Table
public class UserKaltiaControlEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id	
	private String idUserKaltiaControlUser; 
	@Column(name ="userKaltiaControlUser")
	private String userKaltiaControlUser; 
	@Column(name ="userKaltiaControlPass")
	private String userKaltiaControlPass; 
	@Column(name ="userKaltiaControlDescr")
	private String userKaltiaControlDescr;
	@Column(name ="userKaltiaControlPerfil")
	private String userKaltiaControlPerfil;
	@Column(name ="userKaltiaControlNombre")
	private String userKaltiaControlNombre;
	@Column(name ="userKaltiaControlEstilo")
	private String userKaltiaControlEstilo;
	@Column(name ="userKaltiaControlIdEmpresa")
	private String userKaltiaControlIdEmpresa;
	@Column(name ="userKaltiaControlIdAction")
	private String userKaltiaControlIdAction;
	@Column(name ="userKaltiaControlStatus")
	private String userKaltiaControlStatus;

	public UserKaltiaControlEntity() {
		
	}

	public String getIdUserKaltiaControlUser() {
		return idUserKaltiaControlUser;
	}

	public void setIdUserKaltiaControlUser(String idUserKaltiaControlUser) {
		this.idUserKaltiaControlUser = idUserKaltiaControlUser;
	}

	public String getUserKaltiaControlUser() {
		return userKaltiaControlUser;
	}

	public void setUserKaltiaControlUser(String userKaltiaControlUser) {
		this.userKaltiaControlUser = userKaltiaControlUser;
	}

	public String getUserKaltiaControlPass() {
		return userKaltiaControlPass;
	}

	public void setUserKaltiaControlPass(String userKaltiaControlPass) {
		this.userKaltiaControlPass = userKaltiaControlPass;
	}

	public String getUserKaltiaControlDescr() {
		return userKaltiaControlDescr;
	}

	public void setUserKaltiaControlDescr(String userKaltiaControlDescr) {
		this.userKaltiaControlDescr = userKaltiaControlDescr;
	}

	public String getUserKaltiaControlPerfil() {
		return userKaltiaControlPerfil;
	}

	public void setUserKaltiaControlPerfil(String userKaltiaControlPerfil) {
		this.userKaltiaControlPerfil = userKaltiaControlPerfil;
	}

	public String getUserKaltiaControlNombre() {
		return userKaltiaControlNombre;
	}

	public void setUserKaltiaControlNombre(String userKaltiaControlNombre) {
		this.userKaltiaControlNombre = userKaltiaControlNombre;
	}

	public String getUserKaltiaControlEstilo() {
		return userKaltiaControlEstilo;
	}

	public void setUserKaltiaControlEstilo(String userKaltiaControlEstilo) {
		this.userKaltiaControlEstilo = userKaltiaControlEstilo;
	}

	public String getUserKaltiaControlIdEmpresa() {
		return userKaltiaControlIdEmpresa;
	}

	public void setUserKaltiaControlIdEmpresa(String userKaltiaControlIdEmpresa) {
		this.userKaltiaControlIdEmpresa = userKaltiaControlIdEmpresa;
	}

	public String getUserKaltiaControlIdAction() {
		return userKaltiaControlIdAction;
	}

	public void setUserKaltiaControlIdAction(String userKaltiaControlIdAction) {
		this.userKaltiaControlIdAction = userKaltiaControlIdAction;
	}

	public String getUserKaltiaControlStatus() {
		return userKaltiaControlStatus;
	}

	public void setUserKaltiaControlStatus(String userKaltiaControlStatus) {
		this.userKaltiaControlStatus = userKaltiaControlStatus;
	}

	
	
		
	
	
}
