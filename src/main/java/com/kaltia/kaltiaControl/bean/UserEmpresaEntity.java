package com.kaltia.kaltiaControl.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity(name="tc_userempresa")
@NamedQuery(query ="Select a from tc_userempresa a where a.actionRegistro = :id and a.statusRegistro='activo'", name = "find userEmpresa by actionRegistro")
public class UserEmpresaEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String idUserEmpresa;
	@Column
	private String actionRegistro;
	@Column
	private String nombreRegistro;
	@Column
	private String apellidoRegistro;
	@Column
	private String emailRegistro;
	@Column
	private String telefonoRegistro;
	@Column
	private String usuarioRegistro;
	@Column
	private String passRegistro;
	@Column
	private String messageRegistro;
	@Column
	private String monitorRegistro;
	@Column
	private String statusRegistro;
	
	public String getIdUserEmpresa() {
		return idUserEmpresa;
	}
	public void setIdUserEmpresa(String idUserEmpresa) {
		this.idUserEmpresa = idUserEmpresa;
	}
	public String getActionRegistro() {
		return actionRegistro;
	}
	public void setActionRegistro(String actionRegistro) {
		this.actionRegistro = actionRegistro;
	}
	public String getNombreRegistro() {
		return nombreRegistro;
	}
	public void setNombreRegistro(String nombreRegistro) {
		this.nombreRegistro = nombreRegistro;
	}
	public String getApellidoRegistro() {
		return apellidoRegistro;
	}
	public void setApellidoRegistro(String apellidoRegistro) {
		this.apellidoRegistro = apellidoRegistro;
	}
	public String getEmailRegistro() {
		return emailRegistro;
	}
	public void setEmailRegistro(String emailRegistro) {
		this.emailRegistro = emailRegistro;
	}
	public String getTelefonoRegistro() {
		return telefonoRegistro;
	}
	public void setTelefonoRegistro(String telefonoRegistro) {
		this.telefonoRegistro = telefonoRegistro;
	}
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}
	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}
	public String getPassRegistro() {
		return passRegistro;
	}
	public void setPassRegistro(String passRegistro) {
		this.passRegistro = passRegistro;
	}
	public String getMessageRegistro() {
		return messageRegistro;
	}
	public void setMessageRegistro(String messageRegistro) {
		this.messageRegistro = messageRegistro;
	}
	public String getMonitorRegistro() {
		return monitorRegistro;
	}
	public void setMonitorRegistro(String monitorRegistro) {
		this.monitorRegistro = monitorRegistro;
	}
	public String getStatusRegistro() {
		return statusRegistro;
	}
	public void setStatusRegistro(String statusRegistro) {
		this.statusRegistro = statusRegistro;
	}

	
//	@Id
//	private String idUsuarioEmpresa;
//	@Column
//	private String idEmpresa;
//	@Column
//	private String usuarioEmpresaStatus;
//	@Column
//	private String usuarioEmpresaFechaLog;
//	@Column
//	private String usuarioEmpresaPerfil;
//	@Column
//	private String usuarioEmpresaNombreCompleto;
//	@Column
//	private String usuarioEmpresaRolEmpresa;	
//	@Column
//	private String usuarioEmpresaVarios;
//	
//	
//	
//	public String getIdUsuarioEmpresa() {
//		return idUsuarioEmpresa;
//	}
//	public void setIdUsuarioEmpresa(String idUsuarioEmpresa) {
//		this.idUsuarioEmpresa = idUsuarioEmpresa;
//	}
//	public String getIdEmpresa() {
//		return idEmpresa;
//	}
//	public void setIdEmpresa(String idEmpresa) {
//		this.idEmpresa = idEmpresa;
//	}
//	public String getUsuarioEmpresaStatus() {
//		return usuarioEmpresaStatus;
//	}
//	public void setUsuarioEmpresaStatus(String usuarioEmpresaStatus) {
//		this.usuarioEmpresaStatus = usuarioEmpresaStatus;
//	}
//	public String getUsuarioEmpresaFechaLog() {
//		return usuarioEmpresaFechaLog;
//	}
//	public void setUsuarioEmpresaFechaLog(String usuarioEmpresaFechaLog) {
//		this.usuarioEmpresaFechaLog = usuarioEmpresaFechaLog;
//	}
//	public String getUsuarioEmpresaPerfil() {
//		return usuarioEmpresaPerfil;
//	}
//	public void setUsuarioEmpresaPerfil(String usuarioEmpresaPerfil) {
//		this.usuarioEmpresaPerfil = usuarioEmpresaPerfil;
//	}
//	public String getUsuarioEmpresaNombreCompleto() {
//		return usuarioEmpresaNombreCompleto;
//	}
//	public void setUsuarioEmpresaNombreCompleto(String usuarioEmpresaNombreCompleto) {
//		this.usuarioEmpresaNombreCompleto = usuarioEmpresaNombreCompleto;
//	}
//	public String getUsuarioEmpresaRolEmpresa() {
//		return usuarioEmpresaRolEmpresa;
//	}
//	public void setUsuarioEmpresaRolEmpresa(String usuarioEmpresaRolEmpresa) {
//		this.usuarioEmpresaRolEmpresa = usuarioEmpresaRolEmpresa;
//	}
//	public String getUsuarioEmpresaVarios() {
//		return usuarioEmpresaVarios;
//	}
//	public void setUsuarioEmpresaVarios(String usuarioEmpresaVarios) {
//		this.usuarioEmpresaVarios = usuarioEmpresaVarios;
//	}
	
	
	
	

}
