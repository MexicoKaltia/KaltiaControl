package com.kaltia.kaltiaControl.service;

import java.io.Serializable;

import com.kaltia.kaltiaControl.bean.ResultVO;

public interface ClienteRest extends Serializable{
	
	public ResultVO createService(Object object);
	public ResultVO createServiceEmpresaNueva(String idAction);
//	public ResultVO createEmpresaModulos(String clientes, String horario, String carpetas);
	public ResultVO readService(Object object);
	public ResultVO updateService(Object object);
	public ResultVO deleteService(Object object);
	
	public ResultVO readCitas(String idAction);

}
