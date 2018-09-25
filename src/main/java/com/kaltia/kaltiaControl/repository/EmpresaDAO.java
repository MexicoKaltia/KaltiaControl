package com.kaltia.kaltiaControl.repository;

import java.io.Serializable;
import java.util.ArrayList;

import com.kaltia.kaltiaControl.bean.EmpresaEntity;
import com.kaltia.kaltiaControl.bean.ResultDAOVO;

public interface EmpresaDAO extends Serializable{
	
	public ResultDAOVO createEmpresaDAO(EmpresaEntity eE);
	public EmpresaEntity readEmpresaDAO(String idEmpresa);
	public ArrayList<EmpresaEntity> readEmpresaArrayDAO(String idUserPerfilI);
	public ResultDAOVO updateEmpresaDAO();
	public ResultDAOVO deleteEmpresaDAO();

}
