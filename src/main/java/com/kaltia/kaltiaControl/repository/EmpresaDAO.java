package com.kaltia.kaltiaControl.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.kaltia.kaltiaControl.bean.ActionEntity;
import com.kaltia.kaltiaControl.bean.BodyEntity;
import com.kaltia.kaltiaControl.bean.EmpresaEntity;
import com.kaltia.kaltiaControl.bean.FooterEntity;
import com.kaltia.kaltiaControl.bean.HeaderEntity;
import com.kaltia.kaltiaControl.bean.PaginaEntity;
import com.kaltia.kaltiaControl.bean.ProductosEntity;
import com.kaltia.kaltiaControl.bean.QRRestauranteEntity;
import com.kaltia.kaltiaControl.bean.ResultDAOVO;

public interface EmpresaDAO extends Serializable{
	
	public ResultDAOVO createEmpresaDAO(EmpresaEntity eE);
	public EmpresaEntity readEmpresaDAO(String idEmpresa);
	public EmpresaEntity readIdEmpresaDAO(String idEmpresaPagina);
//	public EmpresaEntity readEmpresaIdAction(String idAction);
	public ArrayList<EmpresaEntity> readEmpresaArrayDAO(String idUserPerfilI, String userPerfilI);
	public ResultDAOVO updateEmpresaDAO(EmpresaEntity eE);
	public ResultDAOVO deleteEmpresaDAO(String idEmpresa);
	
	public ResultDAOVO createActionDAO(ActionEntity actionEntity);
	
	public ResultDAOVO createHeaderDAO(HeaderEntity headerEntity);
	public HeaderEntity readHeaderDAO(String idEmpresa);
	
	public ResultDAOVO createBodyDAO(BodyEntity bodyEntity);
	public BodyEntity readBodyDAO(String idEmpresa);
	
	public ResultDAOVO createFooterDAO(FooterEntity footerEntity);
	public FooterEntity readFooterDAO(String idEmpresa);
	
	public ResultDAOVO createPagina(PaginaEntity paginaEntity);
	public ResultDAOVO createQRR(QRRestauranteEntity qrrEntity);
	
	public ResultDAOVO createProductos(ProductosEntity productosEntity);
	public ResultDAOVO updateProductos(ProductosEntity productosEntity);
	public List<ProductosEntity> readProductos();


}
