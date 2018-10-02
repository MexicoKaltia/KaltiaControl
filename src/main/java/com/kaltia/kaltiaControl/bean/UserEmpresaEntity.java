package com.kaltia.kaltiaControl.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity(name="tc_usuarioEmpresa")
@NamedQuery(query ="Select a from tc_usuarioEmpresa a where a.idEmpresa = :id", name = "find userEmpresa by idEmpresa")
public class UserEmpresaEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idUsuarioEmpresa;
	@Column
	private String idEmpresa;
	@Column
	private String usuarioEmpresaStatus;
	@Column
	private String usuarioEmpresaFechaLog;
	@Column
	private String usuarioEmpresaPerfil;
	@Column
	private String usuarioEmpresaNombreCompleto;
	@Column
	private String usuarioEmpresaRolEmpresa;	
	@Column
	private String usuarioEmpresaVarios;
	
	
	
	public String getIdUsuarioEmpresa() {
		return idUsuarioEmpresa;
	}
	public void setIdUsuarioEmpresa(String idUsuarioEmpresa) {
		this.idUsuarioEmpresa = idUsuarioEmpresa;
	}
	public String getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getUsuarioEmpresaStatus() {
		return usuarioEmpresaStatus;
	}
	public void setUsuarioEmpresaStatus(String usuarioEmpresaStatus) {
		this.usuarioEmpresaStatus = usuarioEmpresaStatus;
	}
	public String getUsuarioEmpresaFechaLog() {
		return usuarioEmpresaFechaLog;
	}
	public void setUsuarioEmpresaFechaLog(String usuarioEmpresaFechaLog) {
		this.usuarioEmpresaFechaLog = usuarioEmpresaFechaLog;
	}
	public String getUsuarioEmpresaPerfil() {
		return usuarioEmpresaPerfil;
	}
	public void setUsuarioEmpresaPerfil(String usuarioEmpresaPerfil) {
		this.usuarioEmpresaPerfil = usuarioEmpresaPerfil;
	}
	public String getUsuarioEmpresaNombreCompleto() {
		return usuarioEmpresaNombreCompleto;
	}
	public void setUsuarioEmpresaNombreCompleto(String usuarioEmpresaNombreCompleto) {
		this.usuarioEmpresaNombreCompleto = usuarioEmpresaNombreCompleto;
	}
	public String getUsuarioEmpresaRolEmpresa() {
		return usuarioEmpresaRolEmpresa;
	}
	public void setUsuarioEmpresaRolEmpresa(String usuarioEmpresaRolEmpresa) {
		this.usuarioEmpresaRolEmpresa = usuarioEmpresaRolEmpresa;
	}
	public String getUsuarioEmpresaVarios() {
		return usuarioEmpresaVarios;
	}
	public void setUsuarioEmpresaVarios(String usuarioEmpresaVarios) {
		this.usuarioEmpresaVarios = usuarioEmpresaVarios;
	}
	
	
	
	

}
