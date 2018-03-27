package com.kaltia.kaltiaControl.repository;

import java.io.Serializable;

import com.kaltia.kaltiaControl.bean.StatusEmpresaEntity;

public interface StatusEmpresaDAO extends Serializable{
	
	public void createStatusEmpresaDAO();
	public StatusEmpresaEntity readStatusEmpresaDAO(String idEmpresa);
	public void updateStatusEmpresaDAO();
	public void deleteStatusEmpresaDAO();

}
