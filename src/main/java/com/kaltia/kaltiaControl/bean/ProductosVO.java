package com.kaltia.kaltiaControl.bean;

public class ProductosVO {
	
	private String idEmpresa;
	private PaginaEntity paginaEntity;
	private QREstacionamiento qREstacionamiento;
	private QRRestauranteEntity qRREstaurante;
	private PuntoVenta puntoVenta;
	private String modeloProducto;
	private boolean checkPagina;
	private boolean checkQRR;
	private boolean checkQRE;
	private boolean checkPuntoVenta;
	private boolean clientePagina;
	private boolean citaPagina;
	private boolean carpetaPagina;
	private boolean retroalimentacionPagina;
	private boolean chatPagina;
	private boolean notificacionPagina;
	private boolean videoPagina;
	private boolean tarjetaPagina;

	

	
	
	public boolean isCheckPagina() {
		return checkPagina;
	}
	public void setCheckPagina(boolean checkPagina) {
		this.checkPagina = checkPagina;
	}
	public boolean isCheckQRR() {
		return checkQRR;
	}
	public void setCheckQRR(boolean checkQRR) {
		this.checkQRR = checkQRR;
	}
	public boolean isCheckQRE() {
		return checkQRE;
	}
	public void setCheckQRE(boolean checkQRE) {
		this.checkQRE = checkQRE;
	}
	public boolean isCheckPuntoVenta() {
		return checkPuntoVenta;
	}
	public void setCheckPuntoVenta(boolean checkPuntoVenta) {
		this.checkPuntoVenta = checkPuntoVenta;
	}
	public boolean isClientePagina() {
		return clientePagina;
	}
	public void setClientePagina(boolean clientePagina) {
		this.clientePagina = clientePagina;
	}
	public boolean isCitaPagina() {
		return citaPagina;
	}
	public void setCitaPagina(boolean citaPagina) {
		this.citaPagina = citaPagina;
	}
	public boolean isCarpetaPagina() {
		return carpetaPagina;
	}
	public void setCarpetaPagina(boolean carpetaPagina) {
		this.carpetaPagina = carpetaPagina;
	}
	public boolean isRetroalimentacionPagina() {
		return retroalimentacionPagina;
	}
	public void setRetroalimentacionPagina(boolean retroalimentacionPagina) {
		this.retroalimentacionPagina = retroalimentacionPagina;
	}
	public boolean isChatPagina() {
		return chatPagina;
	}
	public void setChatPagina(boolean chatPagina) {
		this.chatPagina = chatPagina;
	}
	public boolean isNotificacionPagina() {
		return notificacionPagina;
	}
	public void setNotificacionPagina(boolean notificacionPagina) {
		this.notificacionPagina = notificacionPagina;
	}
	public boolean isVideoPagina() {
		return videoPagina;
	}
	public void setVideoPagina(boolean videoPagina) {
		this.videoPagina = videoPagina;
	}
	public boolean isTarjetaPagina() {
		return tarjetaPagina;
	}
	public void setTarjetaPagina(boolean tarjetaPagina) {
		this.tarjetaPagina = tarjetaPagina;
	}
	
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
	public QRRestauranteEntity getqRREstaurante() {
		return qRREstaurante;
	}
	public void setqRREstaurante(QRRestauranteEntity qRREstaurante) {
		this.qRREstaurante = qRREstaurante;
	}
	public PuntoVenta getPuntoVenta() {
		return puntoVenta;
	}
	public void setPuntoVenta(PuntoVenta puntoVenta) {
		this.puntoVenta = puntoVenta;
	}

	public String getModeloProducto() {
		return modeloProducto;
	}
	public void setModeloProducto(String modeloProducto) {
		this.modeloProducto = modeloProducto;
	}
	

}
