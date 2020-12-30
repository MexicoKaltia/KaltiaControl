package com.kaltia.kaltiaControl.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="tc_pagina")
public class PaginaEntity {

	
	public PaginaEntity() {
	}
	
	
	@Id
	private String idPagina;
	@Column
	private String idAction;
	@Column
	private String modeloPagina;
	
	public PaginaEntity(String idPagina, String idAction, String modeloPagina) {
		super();
		this.idPagina = idPagina;
		this.idAction = idAction;
		this.modeloPagina = modeloPagina;
	}

	public String getIdPagina() {
		return idPagina;
	}

	public void setIdPagina(String idPagina) {
		this.idPagina = idPagina;
	}

	public String getIdAction() {
		return idAction;
	}

	public void setIdAction(String idAction) {
		this.idAction = idAction;
	}

	public String getModeloPagina() {
		return modeloPagina;
	}

	public void setModeloPagina(String modeloPagina) {
		this.modeloPagina = modeloPagina;
	}
	

	

	
	

	
		
}
