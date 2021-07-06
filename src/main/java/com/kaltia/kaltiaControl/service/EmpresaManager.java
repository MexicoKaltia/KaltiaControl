package com.kaltia.kaltiaControl.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.kaltia.kaltiaControl.bean.EmpresaEntity;
import com.kaltia.kaltiaControl.bean.ProductosEntity;
import com.kaltia.kaltiaControl.bean.ProductosVO;
import com.kaltia.kaltiaControl.bean.ResultDAOVO;

public interface EmpresaManager extends Serializable{
	
	
	public ResultDAOVO createEmpresa(EmpresaEntity eE);
	public EmpresaEntity readEmpresa(String idEmpresa);
	public ArrayList<EmpresaEntity> readEmpresaArray(String idUserPerfilI, String userPerfil);
	public ResultDAOVO updateEmpresa(EmpresaEntity eE);
	public ResultDAOVO deleteEmpresa(String idAction);
	
	public ResultDAOVO createEmpresaProductos(ProductosVO productosVO);
	public ResultDAOVO updateEmpresaProductos(ProductosVO productosVO);
	public ResultDAOVO updateProductos(ProductosEntity productosEntity );
	public List<ProductosEntity>  readEmpresaProductos();
	public ProductosEntity readProductos(String idEmpresa);
	
	
	

}
