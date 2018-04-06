package com.kaltia.kaltiaControl.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.kaltia.kaltiaControl.bean.UserKaltiaControlEntity;
import com.kaltia.kaltiaControl.bean.UserKaltiaControlVO;

@Repository
public class UserKaltiaControlDAOImpl implements UserKaltiaControlDAO{

	/*
	 * @Autowired
	 * @Qualifier("userKaltiaControlEntity")
	 */
	private UserKaltiaControlEntity userKaltiaControlEntity;
	
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
	public void createUserKaltiaControlDAO(UserKaltiaControlVO userKaltiaControl) {
		// TODO Auto-generated method stub
		
	}
	
	
	//@Transactional(readOnly = true)
    //@SuppressWarnings("unchecked")
	@Override
	public UserKaltiaControlEntity readUserKaltiaControlDAO(UserKaltiaControlVO userKaltiaControlVO) {
		String id = userKaltiaControlVO.getUserUser();
		String pass = userKaltiaControlVO.getPassUser();
		String qry = "select p from tc_userkaltiacontrol p where p.userKaltiaControlUser='"+id+"' and p.userKaltiaControlPass='"+pass+"'";
		logger.info(qry);
		
		try {
			return (UserKaltiaControlEntity) em.createQuery(qry).getSingleResult();
		}catch(Exception e){
			logger.info(e);
			userKaltiaControlEntity.setUserKaltiaControlPerfil("vacio");
			userKaltiaControlEntity.setIdUserKaltiaControlUser("vacio");
			userKaltiaControlEntity.setUserKaltiaControlDescr("Usuario no existente");
			return userKaltiaControlEntity;
		}
	       
	}

	@Override
	public void updateUserKaltiaControlDAO(UserKaltiaControlVO userKaltiaControl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserKaltiaControlDAO(UserKaltiaControlVO userKaltiaControl) {
		// TODO Auto-generated method stub
		
	}

	
	

}
