package com.kaltia.kaltiaControl.bean;

public class QRRestaurante {
	
	private Long idQRRestaurante;
	private String idEmpresa;
	private String idAction;
	private String modeloEstaticoQRR;
	private String modeloDinamicoQRR;
	
	
	
	public QRRestaurante() {
	}
	
	
	public Long getIdQRRestaurante() {
		return idQRRestaurante;
	}
	public void setIdQRRestaurante(Long idQRRestaurante) {
		this.idQRRestaurante = idQRRestaurante;
	}
	public String getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getModeloEstaticoQRR() {
		return modeloEstaticoQRR;
	}
	public void setModeloEstaticoQRR(String modeloEstaticoQRR) {
		this.modeloEstaticoQRR = modeloEstaticoQRR;
	}
	public String getModeloDinamicoQRR() {
		return modeloDinamicoQRR;
	}
	public void setModeloDinamicoQRR(String modeloDinamicoQRR) {
		this.modeloDinamicoQRR = modeloDinamicoQRR;
	}
	
	public String getIdAction() {
		return idAction;
	}
	public void setIdAction(String idAction) {
		this.idAction = idAction;
	}
	
	

}
