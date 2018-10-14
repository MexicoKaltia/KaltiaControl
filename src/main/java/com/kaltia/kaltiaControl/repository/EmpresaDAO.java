package com.kaltia.kaltiaControl.repository;

import java.io.Serializable;
import java.util.ArrayList;

import com.kaltia.kaltiaControl.bean.ActionEntity;
import com.kaltia.kaltiaControl.bean.BodyEntity;
import com.kaltia.kaltiaControl.bean.EmpresaEntity;
import com.kaltia.kaltiaControl.bean.FooterEntity;
import com.kaltia.kaltiaControl.bean.HeaderEntity;
import com.kaltia.kaltiaControl.bean.ResultDAOVO;

public interface EmpresaDAO extends Serializable{
	
	public ResultDAOVO createEmpresaDAO(EmpresaEntity eE);
	public EmpresaEntity readEmpresaDAO(String idEmpresa);
	public ArrayList<EmpresaEntity> readEmpresaArrayDAO(String idUserPerfilI);
	public ResultDAOVO updateEmpresaDAO();
	public ResultDAOVO deleteEmpresaDAO();
	
	public ResultDAOVO createActionDAO(ActionEntity actionEntity);
	
	public ResultDAOVO createHeaderDAO(HeaderEntity headerEntity);
	public HeaderEntity readHeaderDAO(String idEmpresa);
	
	public ResultDAOVO createBodyDAO(BodyEntity bodyEntity);
	public BodyEntity readBodyDAO(String idEmpresa);
	
	public ResultDAOVO createFooterDAO(FooterEntity footerEntity);
	public FooterEntity readFooterDAO(String idEmpresa);

}
