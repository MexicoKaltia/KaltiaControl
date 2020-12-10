package com.kaltia.kaltiaControl.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="tc_qrr")
public class QRRestaurante {
	
	@Id
	private String idQRRestaurante;
	@Column
	private String idEmpresa;
	@Column
	private String idAction;
	@Column
	private String modeloQRRestaurante;
	@Column
	private String modeloEstaticoQRR;
	@Column
	private String modeloDinamicoQRR;
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
	
	
	public QRRestaurante() {
	}
	
	
	
	
	

}
