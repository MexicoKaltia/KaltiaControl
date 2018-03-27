package com.kaltia.kaltiaControl.repository;

import java.io.Serializable;

import com.kaltia.kaltiaControl.bean.EmpresaEntity;
import com.kaltia.kaltiaControl.bean.ResultDAOVO;

public interface EmpresaDAO extends Serializable{
	
	public ResultDAOVO createEmpresaDAO(EmpresaEntity eE);
	public EmpresaEntity readEmpresaDAO(String idEmpresa);
	public ResultDAOVO updateEmpresaDAO();
	public ResultDAOVO deleteEmpresaDAO();

}
