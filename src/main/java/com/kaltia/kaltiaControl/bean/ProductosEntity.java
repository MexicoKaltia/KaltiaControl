package com.kaltia.kaltiaControl.bean;

public class ProductosEntity {
	
	
	
	private String idProducto;
	private PaginaEntity paginaEntity;
	private QREstacionamiento qREstacionamiento;
	private QRRestaurante qRREstaurante;
	private PuntoVenta puntoVenta;
	
	
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
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
