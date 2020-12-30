package com.kaltia.kaltiaControl.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="tc_qrr")
public class QRRestauranteEntity {
	
	@Id
	private String idQRR;
	@Column
	private String idAction;
	@Column
	private String modeloQRR;
	@Column
	private String tipoQRR;
	
	
	
	public QRRestauranteEntity() {
	}



	public QRRestauranteEntity(String idQRR, String idAction, String modeloQRR, String tipoQRR) {
		super();
		this.idQRR = idQRR;
		this.idAction = idAction;
		this.modeloQRR = modeloQRR;
		this.tipoQRR = tipoQRR;
	}



	public String getIdQRR() {
		return idQRR;
	}



	public void setIdQRR(String idQRR) {
		this.idQRR = idQRR;
	}



	public String getIdAction() {
		return idAction;
	}



	public void setIdAction(String idAction) {
		this.idAction = idAction;
	}



	public String getModeloQRR() {
		return modeloQRR;
	}



	public void setModeloQRR(String modeloQRR) {
		this.modeloQRR = modeloQRR;
	}



	public String getTipoQRR() {
		return tipoQRR;
	}



	public void setTipoQRR(String tipoQRR) {
		this.tipoQRR = tipoQRR;
	}


	
}
