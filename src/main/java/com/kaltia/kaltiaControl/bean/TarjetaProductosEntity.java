package com.kaltia.kaltiaControl.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name="tw_tarjetaProductos")
@NamedQueries({
	@NamedQuery(query ="Select a from tw_tarjetaProductos a where a.idEmpresa= :id", name = "find tarjetaProductos by idEmpresa")
	
})
public class TarjetaProductosEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idTarjetaProductos;
	@Column
	private String idEmpresa;
	@Column
	private String idAction;
	@Column
	private String tarjetaProductos;
	@Column
	private String status;
	@Column
	private String userCreate;
	@Column
	private String timestamp;
	
	public TarjetaProductosEntity() {}

	@Override
	public String toString() {
		return "TarjetaProductosEntity [idTarjetaProductos=" + idTarjetaProductos + ", idEmpresa=" + idEmpresa
				+ ", idAction=" + idAction + ", tarjetaProductos=" + tarjetaProductos + ", status=" + status
				+ ", userCreate=" + userCreate + ", timestamp=" + timestamp + "]";
	}

	public TarjetaProductosEntity(String idTarjetaProductos, String idEmpresa, String idAction, String tarjetaProductos,
			String status, String userCreate, String timestamp) {
		super();
		this.idTarjetaProductos = idTarjetaProductos;
		this.idEmpresa = idEmpresa;
		this.idAction = idAction;
		this.tarjetaProductos = tarjetaProductos;
		this.status = status;
		this.userCreate = userCreate;
		this.timestamp = timestamp;
	}

	public String getIdTarjetaProductos() {
		return idTarjetaProductos;
	}

	public void setIdTarjetaProductos(String idTarjetaProductos) {
		this.idTarjetaProductos = idTarjetaProductos;
	}

	public String getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getIdAction() {
		return idAction;
	}

	public void setIdAction(String idAction) {
		this.idAction = idAction;
	}

	public String getTarjetaProductos() {
		return tarjetaProductos;
	}

	public void setTarjetaProductos(String tarjetaProductos) {
		this.tarjetaProductos = tarjetaProductos;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserCreate() {
		return userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

			
	}
