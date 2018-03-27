package com.kaltia.kaltiaControl.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity(name="tc_empresa")
@NamedQuery(query ="Select a from tc_empresa a where a.idEmpresa = :id", name = "find empresa by idEmpresa")
public class EmpresaEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idEmpresa;
	@Column
	private String idAction;
	@Column
	private String empresaNombreCompleto;
	@Column
	private String empresaRFC;
	@Column
	private String empresaDireccion;
	@Column
	private String empresaEmail;
	@Column
	private String empresaContacto;
	@Column
	private String empresaRepresentante;
	@Column
	private String empresaVarios;
	@Column
	private String empresaUserKaltia;
	
	public EmpresaEntity() {
		
	}
	
	
	public String getEmpresaUserKaltia() {
		return empresaUserKaltia;
	}
	public void setEmpresaUserKaltia(String empresaUserKaltia) {
		this.empresaUserKaltia = empresaUserKaltia;
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
	public String getEmpresaNombreCompleto() {
		return empresaNombreCompleto;
	}
	public void setEmpresaNombreCompleto(String empresaNombreCompleto) {
		this.empresaNombreCompleto = empresaNombreCompleto;
	}
	public String getEmpresaRFC() {
		return empresaRFC;
	}
	public void setEmpresaRFC(String empresaRFC) {
		this.empresaRFC = empresaRFC;
	}
	public String getEmpresaDireccion() {
		return empresaDireccion;
	}
	public void setEmpresaDireccion(String empresaDireccion) {
		this.empresaDireccion = empresaDireccion;
	}
	public String getEmpresaEmail() {
		return empresaEmail;
	}
	public void setEmpresaEmail(String empresaEmail) {
		this.empresaEmail = empresaEmail;
	}
	public String getEmpresaContacto() {
		return empresaContacto;
	}
	public void setEmpresaContacto(String empresaContacto) {
		this.empresaContacto = empresaContacto;
	}
	public String getEmpresaRepresentante() {
		return empresaRepresentante;
	}
	public void setEmpresaRepresentante(String empresaRepresentante) {
		this.empresaRepresentante = empresaRepresentante;
	}
	public String getEmpresaVarios() {
		return empresaVarios;
	}
	public void setEmpresaVarios(String empresaVarios) {
		this.empresaVarios = empresaVarios;
	}
	
	
	

}
