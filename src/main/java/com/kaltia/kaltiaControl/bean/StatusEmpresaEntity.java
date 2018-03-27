package com.kaltia.kaltiaControl.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity(name="tw_statusEmpresa")
@NamedQuery(query ="Select a from tw_statusEmpresa a where a.idEmpresa = :id", name = "find statusEmpresa by idEmpresa")
public class StatusEmpresaEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String idEmpresa;
	@Column
	private String statusEmpresa;
	@Column
	private String statusEmpresaFechaCorte;
	@Column
	private String statusEmpresaModoPago;
	@Column
	private String statusEmpresaVarios;
	@Column
	private String statusEmpresaFactura;

	
	
	public String getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getStatusEmpresa() {
		return statusEmpresa;
	}
	public void setStatusEmpresa(String statusEmpresa) {
		this.statusEmpresa = statusEmpresa;
	}
	public String getStatusEmpresaFechaCorte() {
		return statusEmpresaFechaCorte;
	}
	public void setStatusEmpresaFechaCorte(String statusEmpresaFechaCorte) {
		this.statusEmpresaFechaCorte = statusEmpresaFechaCorte;
	}
	public String getStatusEmpresaModoPago() {
		return statusEmpresaModoPago;
	}
	public void setStatusEmpresaModoPago(String statusEmpresaModoPago) {
		this.statusEmpresaModoPago = statusEmpresaModoPago;
	}
	public String getStatusEmpresaVarios() {
		return statusEmpresaVarios;
	}
	public void setStatusEmpresaVarios(String statusEmpresaVarios) {
		this.statusEmpresaVarios = statusEmpresaVarios;
	}
	public String getStatusEmpresaFactura() {
		return statusEmpresaFactura;
	}
	public void setStatusEmpresaFactura(String statusEmpresaFactura) {
		this.statusEmpresaFactura = statusEmpresaFactura;
	}
	
	
	
	

}
