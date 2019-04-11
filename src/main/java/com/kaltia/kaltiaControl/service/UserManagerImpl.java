package com.kaltia.kaltiaControl.service;

import java.util.Date;
//import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaltia.kaltiaControl.bean.EmpresaEntity;
import com.kaltia.kaltiaControl.bean.RequestLoginVO;
import com.kaltia.kaltiaControl.bean.ResultDAOVO;
import com.kaltia.kaltiaControl.bean.StatusEmpresaEntity;
import com.kaltia.kaltiaControl.bean.UserEmpresaEntity;
import com.kaltia.kaltiaControl.bean.UserKaltiaControlEntity;
import com.kaltia.kaltiaControl.bean.UserKaltiaControlVO;
import com.kaltia.kaltiaControl.repository.UserKaltiaControlDAO;

@Service
public class UserManagerImpl implements UserManager{
	
	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());
	

	@Autowired
	@Qualifier("userKaltiaControlDAOImpl")
	private UserKaltiaControlDAO userKaltiaControlDAO;
	@Autowired
	private EmpresaManager empresaManager;
	@Autowired
	private UserEmpresaManager userEmpresaManager;
	@Autowired
	private RequestLoginVO requestLoginVO;
	
	private UserKaltiaControlEntity userKaltiaControlEntity;
	private EmpresaEntity empresaEntity;
	private StatusEmpresaEntity statusEmpresaEntity;
	
	
	@Override
	public ResultDAOVO createUser(EmpresaEntity empresaEntity) {
		
		userKaltiaControlEntity.setIdUserKaltiaControlUser(empresaEntity.getIdAction());
		userKaltiaControlEntity.setUserKaltiaControlUser(empresaEntity.getEmpresaIdPerfilE()+"@kaltia.xyz");
		userKaltiaControlEntity.setUserKaltiaControlPass(empresaEntity.getIdAction());
		userKaltiaControlEntity.setUserKaltiaControlDescr("perfilE"+empresaEntity.getIdAction());
		userKaltiaControlEntity.setUserKaltiaControlPerfil("perfilE");
		userKaltiaControlEntity.setUserKaltiaControlNombre(empresaEntity.getIdEmpresa());
		userKaltiaControlEntity.setUserKaltiaControlStatus("inicio");
		userKaltiaControlEntity.setUserKaltiaControlDomicilio(empresaEntity.getEmpresaDireccion());
		userKaltiaControlEntity.setUserKaltiaControlCorreo(empresaEntity.getEmpresaEmail());
		userKaltiaControlEntity.setUserKaltiaControlContacto(empresaEntity.getEmpresaContacto());
		
		ResultDAOVO resultDAOVO = userKaltiaControlDAO.createUserKaltiaControlDAO(userKaltiaControlEntity);
		
		return resultDAOVO;
	}

	@Override
	public RequestLoginVO readUser(UserKaltiaControlVO userKaltiaControlVO) {
		//HashMap<String,Object> userAtributo = new HashMap<String,Object>();
		
		/*
		 * Informacion de perfil usuarioKaltiaControl
		 */
		userKaltiaControlEntity = userKaltiaControlDAO.readUserKaltiaControlDAO(userKaltiaControlVO);
		requestLoginVO.setUserKaltiaControlEntity(userKaltiaControlEntity);
		
		if(userKaltiaControlEntity.getUserKaltiaControlStatus().equals("activo")) {
			if(userKaltiaControlEntity.getUserKaltiaControlPerfil().equals("perfilI")) {
				
				/*
				 * lectura de array Empresas perfil I
				 */
				
				requestLoginVO.setEmpresaArrayEntity(empresaManager.readEmpresaArray(userKaltiaControlEntity.getIdUserKaltiaControlUser().toString()));  
//				for(EmpresaEntity idEmpresa: empresaManager.readEmpresaArray(userKaltiaControlEntity.getIdUserKaltiaControlUser().toString())) {
//					
//					empresaEntityList.add(empresaEntity);
//				}
//				userAtributo.put("eE", empresaEntity);
			}
			
			else if(userKaltiaControlEntity.getUserKaltiaControlPerfil().equals("perfilE")) {	
				/*
				 * Informacion Empresa de usuarioKaltiaControl
				 */
				empresaEntity = empresaManager.readEmpresa(userKaltiaControlEntity.getIdUserKaltiaControlUser().toString());
				List<UserEmpresaEntity> userEmpresaEntity  = userEmpresaManager.readUserEmpresa(empresaEntity.getIdEmpresa());
//				userAtributo.put("uGE", userGeneralEntity);
								
				requestLoginVO.setEmpresaEntity(empresaEntity);
				requestLoginVO.setUserEmpresaEntity(userEmpresaEntity);
				requestLoginVO.setStatusEmpresaEntity(statusEmpresaEntity);
			}	
			 String now = (new Date()).toString();   
			userKaltiaControlEntity.setUserKaltiaControlActividad(now);
			userKaltiaControlDAO.actividadUserKaltiaControlDAO(userKaltiaControlEntity);
			
		}else if(userKaltiaControlEntity.getUserKaltiaControlStatus().equals("inicio")){
			userKaltiaControlEntity.setUserKaltiaControlPerfil("inicio");
			requestLoginVO.setUserKaltiaControlEntity(userKaltiaControlEntity);		
		}else {
			//Exception
			logger.info("EXCEPTION");
			
		}
		
		return requestLoginVO ;
	}

	@Override
	public RequestLoginVO updateUser(UserKaltiaControlVO userKaltiaControl) {
			
		logger.info(userKaltiaControl.getUserUser());
		
		try {
			String[] user = userKaltiaControl.getUserUser().toString().split("@");
			userKaltiaControlEntity.setIdUserKaltiaControlUser(user[0].toString());
			userKaltiaControlEntity.setUserKaltiaControlPass(userKaltiaControl.getPassUser());
			userKaltiaControlEntity.setUserKaltiaControlStatus("activo");
			
			userKaltiaControlEntity = userKaltiaControlDAO.updateUserKaltiaControlDAO(userKaltiaControlEntity);
			
			requestLoginVO = readUser(userKaltiaControl);
			
			return  requestLoginVO;
			
		}catch(Exception e) {
			e.printStackTrace(); 
			userKaltiaControlEntity.setUserKaltiaControlPerfil("error");			 
			return  requestLoginVO;
		}
		
		
	}

	@Override
	public String deleteUser(UserKaltiaControlVO userKaltiaControl) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
//	private ArrayList<EmpresaEntity> empresaPerfilI(String userPerfilI) {
//		
//		ArrayList<EmpresaEntity> empresaEntityArray = new ArrayList();
//		
//		
//		return userKaltiaControlEntity;
//	}

}
