package com.kaltia.kaltiaControl.bean;

public class UserEmpresaVO{
	
	public UserEmpresaVO(){}

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String idUserEmpresa;
//	@Column
	private String actionRegistro;
//	@Column
	private String nombreRegistro;
//	@Column
	private String apellidoRegistro;
//	@Column
	private String emailRegistro;
//	@Column
	private String telefonoRegistro;
//	@Column
	private String usuarioRegistro;
//	@Column
	private String passRegistro;
//	@Column
	private String messageRegistro;
//	@Column
	private String monitorRegistro;
//	@Column
	private String statusRegistro;
	
	
	
	public String getStatusRegistro() {
		return statusRegistro;
	}
	public void setStatusRegistro(String statusRegistro) {
		this.statusRegistro = statusRegistro;
	}
	public String getMonitorRegistro() {
		return monitorRegistro;
	}
	public void setMonitorRegistro(String monitorRegistro) {
		this.monitorRegistro = monitorRegistro;
	}
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

	



}
