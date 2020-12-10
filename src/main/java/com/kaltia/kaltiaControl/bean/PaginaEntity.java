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
	private String idEmpresa;
	@Column
	private String idAction;
	@Column
	private String modeloPagina;
	@Column
	private String clientePagina;
	@Column
	private String citaPagina;
	@Column
	private String carpetaPagina;
	@Column
	private String retroAlimentacionPagina;
	@Column
	private String chatPagina;
	@Column
	private String notificacionPagina;
	@Column
	private String videoPagina;
	@Column
	private String tarjetaPagina;

	
	

	
		
}
