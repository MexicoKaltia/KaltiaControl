package com.kaltia.kaltiaControl.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class ResultDAOVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String message;
	private String code;
	private String properties;
	private boolean logic;
	private int num;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getProperties() {
		return properties;
	}
	public void setProperties(String properties) {
		this.properties = properties;
	}
	public boolean isLogic() {
		return logic;
	}
	public void setLogic(boolean logic) {
		this.logic = logic;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
	
	
	
	

}
