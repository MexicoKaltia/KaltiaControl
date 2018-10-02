package com.kaltia.kaltiaControl.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RequestLoginVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserKaltiaControlEntity userKaltiaControlEntity;
	private ArrayList<EmpresaEntity> empresaArrayEntity;
	private EmpresaEntity empresaEntity;
	private List<UserEmpresaEntity> userEmpresaEntity;
	private StatusEmpresaEntity statusEmpresaEntity;
	
	
	
	public UserKaltiaControlEntity getUserKaltiaControlEntity() {
		return userKaltiaControlEntity;
	}
	public void setUserKaltiaControlEntity(UserKaltiaControlEntity userKaltiaControlEntity) {
		this.userKaltiaControlEntity = userKaltiaControlEntity;
	}
	public EmpresaEntity getEmpresaEntity() {
		return empresaEntity;
	}
	public void setEmpresaEntity(EmpresaEntity empresaEntity) {
		this.empresaEntity = empresaEntity;
	}
	public List<UserEmpresaEntity> getUserEmpresaEntity() {
		return userEmpresaEntity;
	}
	public void setUserEmpresaEntity(List<UserEmpresaEntity> userEmpresaEntity) {
		this.userEmpresaEntity = userEmpresaEntity;
	}
	public StatusEmpresaEntity getStatusEmpresaEntity() {
		return statusEmpresaEntity;
	}
	public void setStatusEmpresaEntity(StatusEmpresaEntity statusEmpresaEntity) {
		this.statusEmpresaEntity = statusEmpresaEntity;
	}
	
	public ArrayList<EmpresaEntity> getEmpresaArrayEntity() {
		return empresaArrayEntity;
	}
	public void setEmpresaArrayEntity(ArrayList<EmpresaEntity> empresaArrayEntity) {
		this.empresaArrayEntity = empresaArrayEntity;
	}
	
	

}
