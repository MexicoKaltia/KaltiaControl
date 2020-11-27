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
	private String idEmpresaPagina;
	@Column
	private String idActionPagina;
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

	
	public String getIdPagina() {
		return idPagina;
	}
	public void setIdPagina(String idPagina) {
		this.idPagina = idPagina;
	}
	public String getIdEmpresaPagina() {
		return idEmpresaPagina;
	}
	public void setIdEmpresaPagina(String idEmpresaPagina) {
		this.idEmpresaPagina = idEmpresaPagina;
	}
	public String getModeloPagina() {
		return modeloPagina;
	}
	public void setModeloPagina(String modeloPagina) {
		this.modeloPagina = modeloPagina;
	}
	public String getClientePagina() {
		return clientePagina;
	}
	public void setClientePagina(String clientePagina) {
		this.clientePagina = clientePagina;
	}
	public String getCitaPagina() {
		return citaPagina;
	}
	public void setCitaPagina(String citaPagina) {
		this.citaPagina = citaPagina;
	}
	public String getCarpetaPagina() {
		return carpetaPagina;
	}
	public void setCarpetaPagina(String carpetaPagina) {
		this.carpetaPagina = carpetaPagina;
	}
	public String getRetroAlimentacionPagina() {
		return retroAlimentacionPagina;
	}
	public void setRetroAlimentacionPagina(String retroAlimentacionPagina) {
		this.retroAlimentacionPagina = retroAlimentacionPagina;
	}
	public String getChatPagina() {
		return chatPagina;
	}
	public void setChatPagina(String chatPagina) {
		this.chatPagina = chatPagina;
	}
	public String getNotificacionPagina() {
		return notificacionPagina;
	}
	public void setNotificacionPagina(String notificacionPagina) {
		this.notificacionPagina = notificacionPagina;
	}
	public String getVideoPagina() {
		return videoPagina;
	}
	public void setVideoPagina(String videoPagina) {
		this.videoPagina = videoPagina;
	}
	public String getTarjetaPagina() {
		return tarjetaPagina;
	}
	public void setTarjetaPagina(String tarjetaPagina) {
		this.tarjetaPagina = tarjetaPagina;
	}
	public String getIdActionPagina() {
		return idActionPagina;
	}
	public void setIdActionPagina(String idActionPagina) {
		this.idActionPagina = idActionPagina;
	}



	
		
}
