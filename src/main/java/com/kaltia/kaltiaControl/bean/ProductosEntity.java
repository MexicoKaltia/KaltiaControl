package com.kaltia.kaltiaControl.bean;

public class ProductosEntity {
	
	
	
	private String idEmpresa;
	private PaginaEntity paginaEntity;
	private QREstacionamiento qREstacionamiento;
	private QRRestaurante qRREstaurante;
	private PuntoVenta puntoVenta;
	
	
	public String getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public PaginaEntity getPaginaEntity() {
		return paginaEntity;
	}
	public void setPaginaEntity(PaginaEntity paginaEntity) {
		this.paginaEntity = paginaEntity;
	}
	public QREstacionamiento getqREstacionamiento() {
		return qREstacionamiento;
	}
	public void setqREstacionamiento(QREstacionamiento qREstacionamiento) {
		this.qREstacionamiento = qREstacionamiento;
	}
	public QRRestaurante getqRREstaurante() {
		return qRREstaurante;
	}
	public void setqRREstaurante(QRRestaurante qRREstaurante) {
		this.qRREstaurante = qRREstaurante;
	}
	public PuntoVenta getPuntoVenta() {
		return puntoVenta;
	}
	public void setPuntoVenta(PuntoVenta puntoVenta) {
		this.puntoVenta = puntoVenta;
	}
	
	
	

}
