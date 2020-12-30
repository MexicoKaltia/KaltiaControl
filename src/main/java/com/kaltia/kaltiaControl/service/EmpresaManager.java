package com.kaltia.kaltiaControl.service;

import java.io.Serializable;
import java.util.ArrayList;

import com.kaltia.kaltiaControl.bean.EmpresaEntity;
import com.kaltia.kaltiaControl.bean.ProductosVO;
import com.kaltia.kaltiaControl.bean.ResultDAOVO;

public interface EmpresaManager extends Serializable{
	
	
	public ResultDAOVO createEmpresa(EmpresaEntity eE);
	public EmpresaEntity readEmpresa(String idEmpresa);
	public ArrayList<EmpresaEntity> readEmpresaArray(String idUserPerfilI);
	public void updateEmpresa();
	public void deleteEmpresa();
	public ResultDAOVO createEmpresaProductos(ProductosVO productosVO);
	
	

}
