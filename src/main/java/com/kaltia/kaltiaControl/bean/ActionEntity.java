package com.kaltia.kaltiaControl.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name ="tc_action")
public class ActionEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String idAction;// varchar(45) PK
	@Column
	private String idEmpresa;// varchar(45) PK
	@Column
	private String actionEstilo;// varchar(45)
	@Column
	private Integer headerRequerido;// tinyint(4)
	@Column
	private Integer bodyRequerido;// tinyint(4)
	@Column
	private Integer footerRequerido;// tinyint(4)
	@Column
	private Integer leftRequerido;// tinyint(4)
	@Column
	private Integer rigthRequerido;// tinyint(4)
	@Column
	private Integer actionPrincipal;// tinyint(4)
	@Column
	private String actionSeccion1;// text
	@Column
	private String actionSeccion2;// text

	
	public ActionEntity() {}
	
	
	
	public ActionEntity(String idAction, String idEmpresa, String actionEstilo, Integer headerRequerido,
			Integer bodyRequerido, Integer footerRequerido, Integer leftRequerido, Integer rigthRequerido,
			Integer actionPrincipal, String actionSeccion1, String actionSeccion2) {
		super();
		this.idAction = idAction;
		this.idEmpresa = idEmpresa;
		this.actionEstilo = actionEstilo;
		this.headerRequerido = headerRequerido;
		this.bodyRequerido = bodyRequerido;
		this.footerRequerido = footerRequerido;
		this.leftRequerido = leftRequerido;
		this.rigthRequerido = rigthRequerido;
		this.actionPrincipal = actionPrincipal;
		this.actionSeccion1 = actionSeccion1;
		this.actionSeccion2 = actionSeccion2;
	}
	public String getIdAction() {
		return idAction;
	}
	public void setIdAction(String idAction) {
		this.idAction = idAction;
	}
	public String getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getActionEstilo() {
		return actionEstilo;
	}
	public void setActionEstilo(String actionEstilo) {
		this.actionEstilo = actionEstilo;
	}
	public Integer getHeaderRequerido() {
		return headerRequerido;
	}
	public void setHeaderRequerido(Integer headerRequerido) {
		this.headerRequerido = headerRequerido;
	}
	public Integer getBodyRequerido() {
		return bodyRequerido;
	}
	public void setBodyRequerido(Integer bodyRequerido) {
		this.bodyRequerido = bodyRequerido;
	}
	public Integer getFooterRequerido() {
		return footerRequerido;
	}
	public void setFooterRequerido(Integer footerRequerido) {
		this.footerRequerido = footerRequerido;
	}
	public Integer getLeftRequerido() {
		return leftRequerido;
	}
	public void setLeftRequerido(Integer leftRequerido) {
		this.leftRequerido = leftRequerido;
	}
	public Integer getRigthRequerido() {
		return rigthRequerido;
	}
	public void setRigthRequerido(Integer rigthRequerido) {
		this.rigthRequerido = rigthRequerido;
	}
	public Integer getActionPrincipal() {
		return actionPrincipal;
	}
	public void setActionPrincipal(Integer actionPrincipal) {
		this.actionPrincipal = actionPrincipal;
	}
	public String getActionSeccion1() {
		return actionSeccion1;
	}
	public void setActionSeccion1(String actionSeccion1) {
		this.actionSeccion1 = actionSeccion1;
	}
	public String getActionSeccion2() {
		return actionSeccion2;
	}
	public void setActionSeccion2(String actionSeccion2) {
		this.actionSeccion2 = actionSeccion2;
	}
	
}
