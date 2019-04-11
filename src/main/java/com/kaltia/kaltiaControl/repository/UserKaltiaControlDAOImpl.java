package com.kaltia.kaltiaControl.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kaltia.kaltiaControl.bean.ResultDAOVO;
import com.kaltia.kaltiaControl.bean.UserKaltiaControlEntity;
import com.kaltia.kaltiaControl.bean.UserKaltiaControlVO;

@Repository
public class UserKaltiaControlDAOImpl implements UserKaltiaControlDAO{

	/*
	 * @Autowired
	 * @Qualifier("userKaltiaControlEntity")
	 */
	private UserKaltiaControlEntity userKaltiaControlEntity;
	@Autowired
	private ResultDAOVO resultDAOVO;
	
	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());
	
	
    /*
     * Sets the entity manager.
     */
	private EntityManager em = null;
	
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	@Override
	@Transactional(readOnly = false)
	public ResultDAOVO createUserKaltiaControlDAO(UserKaltiaControlEntity uKCE) {
		try {
//			em.getTransaction( ).begin( );
		  em.merge(uKCE);
//			em.persist( eE );
//		    em.getTransaction( ).commit( );
		      
	      resultDAOVO.setCode("00");
	      resultDAOVO.setMessage("UserKaltiaControl con exito guardado");
	      
		}catch(Exception e) {
			resultDAOVO.setCode("99");
			resultDAOVO.setMessage(e.toString());
		}finally {
			em.close( );
		      
		}
	      
		return resultDAOVO;
	}
	
	
	//@Transactional(readOnly = true)
    //@SuppressWarnings("unchecked")
	@Override
	public UserKaltiaControlEntity readUserKaltiaControlDAO(UserKaltiaControlVO userKaltiaControlVO) {
		String id = userKaltiaControlVO.getUserUser();
		String pass = userKaltiaControlVO.getPassUser();
		String qry = "select p from tc_userkaltiacontrol p where p.userKaltiaControlUser='"+id+"' and p.userKaltiaControlPass='"+pass+"'";
		logger.info(qry);
		userKaltiaControlEntity = new UserKaltiaControlEntity();
		
		try {
			return (UserKaltiaControlEntity) em.createQuery(qry).getSingleResult();
		}catch(Exception e){
			logger.info(e);
			userKaltiaControlEntity.setUserKaltiaControlPerfil("#");
			userKaltiaControlEntity.setIdUserKaltiaControlUser("vacio");
			userKaltiaControlEntity.setUserKaltiaControlDescr("Usuario no existente");
			userKaltiaControlEntity.setUserKaltiaControlStatus("NOK");
			return userKaltiaControlEntity;
		}
	       
	}

	@Override
	@Transactional(readOnly = false)
	public UserKaltiaControlEntity updateUserKaltiaControlDAO(UserKaltiaControlEntity userKaltiaControlEntity) {
//		String id = userKaltiaControlVO.getUserUser();
//		String pass = userKaltiaControlVO.getPassUser();
		String qry = "update tc_userkaltiacontrol p set p.userKaltiaControlPass='"+userKaltiaControlEntity.getUserKaltiaControlPass()
		+"',  p.userKaltiaControlStatus='"+userKaltiaControlEntity.getUserKaltiaControlStatus()+"'"
		+ " where p.idUserKaltiaControlUser = '"+userKaltiaControlEntity.getIdUserKaltiaControlUser()+"'";
		logger.info(qry);
//		userKaltiaControlEntity = new UserKaltiaControlEntity();
		
		try {
			 em.createQuery(qry).executeUpdate();
			 userKaltiaControlEntity.setUserKaltiaControlPerfil("activo");
			return userKaltiaControlEntity;
		}catch(Exception e){
			e.printStackTrace();
			userKaltiaControlEntity.setUserKaltiaControlPerfil("#");
			userKaltiaControlEntity.setIdUserKaltiaControlUser("vacio");
			userKaltiaControlEntity.setUserKaltiaControlDescr("Usuario no existente");
			userKaltiaControlEntity.setUserKaltiaControlStatus("NOK");
			return userKaltiaControlEntity;
		}
	}
	
	@Override
	@Transactional(readOnly = false)
	public void actividadUserKaltiaControlDAO(UserKaltiaControlEntity userKaltiaControlEntity) {
//		String id = userKaltiaControlVO.getUserUser();
//		String pass = userKaltiaControlVO.getPassUser();
		String qry = "update tc_userkaltiacontrol p set p.userKaltiaControlActividad='"+userKaltiaControlEntity.getUserKaltiaControlActividad()+"'"
		+ " where p.idUserKaltiaControlUser = '"+userKaltiaControlEntity.getIdUserKaltiaControlUser()+"'";
		
		try {
			 em.createQuery(qry).executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUserKaltiaControlDAO(UserKaltiaControlVO userKaltiaControl) {
		// TODO Auto-generated method stub
		
	}

	
	

}
