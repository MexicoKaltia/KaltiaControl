package com.kaltia.kaltiaControl.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
	private List<ProductosEntity> productosEntity;
	private StatusEmpresaEntity statusEmpresaEntity;
	private DatosCitasVO datosCitasVO;
	private JSONObject jsonArray;
	
	
	
	
	
	
	
	public JSONObject getJsonArray() {
		return jsonArray;
	}
	public void setJsonArray(JSONObject jsonArray) {
		this.jsonArray = jsonArray;
	}
	public DatosCitasVO getDatosCitasVO() {
		return datosCitasVO;
	}
	public void setDatosCitasVO(DatosCitasVO datosCitasVO) {
		this.datosCitasVO = datosCitasVO;
	}
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
	public List<ProductosEntity> getProductosEntity() {
		return productosEntity;
	}
	public void setProductosEntity(List<ProductosEntity> productosEntity) {
		this.productosEntity = productosEntity;
	}
	
	

}
