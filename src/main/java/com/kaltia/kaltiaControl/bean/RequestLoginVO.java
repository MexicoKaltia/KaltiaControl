package com.kaltia.kaltiaControl.bean;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RequestLoginVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserKaltiaControlEntity userKaltiaControlEntity;
	private EmpresaEntity empresaEntity;
	private List<UserGeneralEntity> userGeneralEntity;
	
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
	public List<UserGeneralEntity> getUserGeneralEntity() {
		return userGeneralEntity;
	}
	public void setUserGeneralEntity(List<UserGeneralEntity> userGeneralEntity) {
		this.userGeneralEntity = userGeneralEntity;
	}
	public StatusEmpresaEntity getStatusEmpresaEntity() {
		return statusEmpresaEntity;
	}
	public void setStatusEmpresaEntity(StatusEmpresaEntity statusEmpresaEntity) {
		this.statusEmpresaEntity = statusEmpresaEntity;
	}
	
	
	
	

}
