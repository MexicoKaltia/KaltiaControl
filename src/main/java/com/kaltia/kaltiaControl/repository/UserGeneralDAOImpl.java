package com.kaltia.kaltiaControl.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.kaltia.kaltiaControl.bean.UserGeneralEntity;

@Repository
public class UserGeneralDAOImpl implements UserGeneralDAO{
	
	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());
	private UserGeneralEntity userGeneralEntity;
	
    /*
     * Sets the entity manager.
     */
	private EntityManager em = null;
	
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	@Override
	public void createUserGeneralDAO() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserGeneralEntity> readUserGeneralDAO(String idEmpresa) {
		
		  Query query = em.createNamedQuery("find userGeneral by idEmpresa");
	      query.setParameter("id", idEmpresa);
	      try {
	      //List<UserGeneralEntity> userGeneralEntity = (List<UserGeneralEntity>)query.getResultList( );
	      return (List<UserGeneralEntity>)query.getResultList( );
	      }catch(Exception e) {
	    	  logger.info(e);
	    	  return null;
	      }
	}

	@Override
	public void updateUserGeneralDAO() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserGeneralDAO() {
		// TODO Auto-generated method stub
		
	}

}
