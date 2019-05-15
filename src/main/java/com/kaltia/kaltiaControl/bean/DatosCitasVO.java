package com.kaltia.kaltiaControl.bean;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class DatosCitasVO {

	public DatosCitasVO() {
		// TODO Auto-generated constructor stub
	}
	
	private JSONObject condiciones;
	private JSONObject mesActual;
	private JSONObject mesPost;
	
	
	
	public JSONObject getCondiciones() {
		return condiciones;
	}
	public void setCondiciones(JSONObject condiciones) {
		this.condiciones = condiciones;
	}
	public JSONObject getMesActual() {
		return mesActual;
	}
	public void setMesActual(JSONObject mesActual) {
		this.mesActual = mesActual;
	}
	public JSONObject getMesPost() {
		return mesPost;
	}
	public void setMesPost(JSONObject mesPost) {
		this.mesPost = mesPost;
	}

	
	

}
