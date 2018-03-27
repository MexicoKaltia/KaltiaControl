package com.kaltia.kaltiaControl.service;

import java.io.Serializable;

import com.kaltia.kaltiaControl.bean.StatusEmpresaEntity;

public interface StatusEmpresaManager extends Serializable{
	
	public void createStatusEmpresaManager();
	public StatusEmpresaEntity readStatusEmpresaManager(String idEmpresa);
	public void updateStatusEmpresaManager();
	public void deleteStatusEmpresaManager();
	

}
