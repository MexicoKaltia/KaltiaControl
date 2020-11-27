package com.kaltia.kaltiaControl.bean;

import java.io.Serializable;
//import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
	@Column(name ="userKaltiaControlStatus")
	private String userKaltiaControlStatus;
	@Column(name ="userKaltiaControlDomicilio")
	private String userKaltiaControlDomicilio;
	@Column(name ="userKaltiaControlCorreo")
	private String userKaltiaControlCorreo;
	@Column(name ="userKaltiaControlContacto")
	private String userKaltiaControlContacto;
	@Column(name ="userKaltiaControlActividad")
	private String userKaltiaControlActividad;

	
	public UserKaltiaControlEntity() {
		
	}



	
	public UserKaltiaControlEntity(String string) {
		this.setUserKaltiaControlPerfil(string);
	}




	/*
	 * getter y setter
	 */
	public String getUserKaltiaControlDomicilio() {
		return userKaltiaControlDomicilio;
	}

	public void setUserKaltiaControlDomicilio(String userKaltiaControlDomicilio) {
		this.userKaltiaControlDomicilio = userKaltiaControlDomicilio;
	}

	public String getUserKaltiaControlCorreo() {
		return userKaltiaControlCorreo;
	}

	public void setUserKaltiaControlCorreo(String userKaltiaControlCorreo) {
		this.userKaltiaControlCorreo = userKaltiaControlCorreo;
	}

	public String getUserKaltiaControlContacto() {
		return userKaltiaControlContacto;
	}

	public void setUserKaltiaControlContacto(String userKaltiaControlContacto) {
		this.userKaltiaControlContacto = userKaltiaControlContacto;
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


	public String getUserKaltiaControlStatus() {
		return userKaltiaControlStatus;
	}

	public void setUserKaltiaControlStatus(String userKaltiaControlStatus) {
		this.userKaltiaControlStatus = userKaltiaControlStatus;
	}	

	public String getUserKaltiaControlActividad() {
		return userKaltiaControlActividad;
	}

	public void setUserKaltiaControlActividad(String userKaltiaControlActividad) {
		this.userKaltiaControlActividad = userKaltiaControlActividad;
	}

	


	
	
		
	
	
}
