package com.kaltia.kaltiaControl.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaltia.kaltiaControl.bean.RequestLoginVO;
import com.kaltia.kaltiaControl.bean.UserKaltiaControlEntity;
import com.kaltia.kaltiaControl.bean.UserKaltiaControlVO;
import com.kaltia.kaltiaControl.repository.UserKaltiaControlDAO;
import com.kaltia.kaltiaControl.service.UserManager;

@Service
public class UserManagerImpl implements UserManager{
	
	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());
	

	@Autowired
	@Qualifier("userKaltiaControlDAOImpl")
	private UserKaltiaControlDAO userKaltiaControlDAO;
	@Autowired
	private RequestLoginVO requestLoginVO1;
	
	private UserKaltiaControlEntity userKaltiaControlEntity;

	@Override
	public String createUser(UserKaltiaControlVO userKaltiaControl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestLoginVO readUser(UserKaltiaControlVO userKaltiaControlVO) {
		logger.info("id:"+userKaltiaControlVO.getUserUser());
		logger.info("pass:"+userKaltiaControlVO.getPassUser());
		
		userKaltiaControlEntity = userKaltiaControlDAO.readUserKaltiaControlDAO(userKaltiaControlVO);
	
		logger.info("perfil:"+userKaltiaControlEntity.getUserKaltiaControlPerfil());
		logger.info("descripcion:"+ userKaltiaControlEntity.getUserKaltiaControlDescr());
		
		requestLoginVO1 = validaUserKaltiaControl(userKaltiaControlEntity);
		
//		
//		logger.info("readUser:"+requestLoginVO1.getUserPerfil());
//		
		
		
		return requestLoginVO1 ;
	}

	@Override
	public String updateteUser(UserKaltiaControlVO userKaltiaControl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(UserKaltiaControlVO userKaltiaControl) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private RequestLoginVO validaUserKaltiaControl(UserKaltiaControlEntity uKCEValida) {
		
		/*
		 * Estas lineas deben ser temporales, ya que se tiene que actualizar la tabla :
		 * tc_usuarioPrimario --> tc_userKaltiaControl
		 * Adjuntar la normalizacion de los campos :
		 * 	userEstilo
		 * 	userIdEmpresa
		 * 	userIdAction
		 * 	userStatus
		 */
		
		requestLoginVO1.setUserEstilo(uKCEValida.getUserKaltiaControlEstilo());
		requestLoginVO1.setUserIdEmpresa(uKCEValida.getUserKaltiaControlIdEmpresa());
		requestLoginVO1.setUserIdAction(uKCEValida.getUserKaltiaControlIdAction());
		requestLoginVO1.setUserStatus(uKCEValida.getUserKaltiaControlStatus());
		requestLoginVO1.setUserPerfil(uKCEValida.getUserKaltiaControlPerfil());
		
		logger.info("valida:"+requestLoginVO1.getUserPerfil());
		/*
		 * Validar Status de usuarioKaltiaControl
		 * adjuntar en property
		 */
		
		return requestLoginVO1;
	}

}
