package com.kaltia.kaltiaControl.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity(name="tc_usuarioGeneral")
@NamedQuery(query ="Select a from tc_usuarioGeneral a where a.idEmpresa = :id", name = "find userGeneral by idEmpresa")
public class UserGeneralEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idUsuarioGeneral;
	@Column
	private String idEmpresa;
	@Column
	private String usuarioGeneralStatus;
	@Column
	private String usuarioGeneralFechaLog;
	@Column
	private String usuarioGeneralPerfil;
	@Column
	private String usuarioGeneralNombreCompleto;
	@Column
	private String usuarioGeneralRolEmpresa;	
	@Column
	private String usuarioGeneralVarios;
	
	
	
	public String getIdUsuarioGeneral() {
		return idUsuarioGeneral;
	}
	public void setIdUsuarioGeneral(String idUsuarioGeneral) {
		this.idUsuarioGeneral = idUsuarioGeneral;
	}
	public String getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getUsuarioGeneralStatus() {
		return usuarioGeneralStatus;
	}
	public void setUsuarioGeneralStatus(String usuarioGeneralStatus) {
		this.usuarioGeneralStatus = usuarioGeneralStatus;
	}
	public String getUsuarioGeneralFechaLog() {
		return usuarioGeneralFechaLog;
	}
	public void setUsuarioGeneralFechaLog(String usuarioGeneralFechaLog) {
		this.usuarioGeneralFechaLog = usuarioGeneralFechaLog;
	}
	public String getUsuarioGeneralPerfil() {
		return usuarioGeneralPerfil;
	}
	public void setUsuarioGeneralPerfil(String usuarioGeneralPerfil) {
		this.usuarioGeneralPerfil = usuarioGeneralPerfil;
	}
	public String getUsuarioGeneralNombreCompleto() {
		return usuarioGeneralNombreCompleto;
	}
	public void setUsuarioGeneralNombreCompleto(String usuarioGeneralNombreCompleto) {
		this.usuarioGeneralNombreCompleto = usuarioGeneralNombreCompleto;
	}
	public String getUsuarioGeneralRolEmpresa() {
		return usuarioGeneralRolEmpresa;
	}
	public void setUsuarioGeneralRolEmpresa(String usuarioGeneralRolEmpresa) {
		this.usuarioGeneralRolEmpresa = usuarioGeneralRolEmpresa;
	}
	public String getUsuarioGeneralVarios() {
		return usuarioGeneralVarios;
	}
	public void setUsuarioGeneralVarios(String usuarioGeneralVarios) {
		this.usuarioGeneralVarios = usuarioGeneralVarios;
	}
	
	
	
	

}
