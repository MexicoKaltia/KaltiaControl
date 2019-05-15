package com.kaltia.kaltiaControl.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.kaltia.kaltiaControl.bean.UserEmpresaEntity;

@Repository
public class UserEmpresaDAOImpl implements UserEmpresaDAO{
	
	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());
//	private UserEmpresaEntity userEmpresaEntity;
	
    /*
     * Sets the entity manager.
     */
	private EntityManager em = null;
	
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	@Override
	public void createUserEmpresaDAO() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEmpresaEntity> readUserEmpresaDAO(String userEmpresaAction) {
		
		  Query query = em.createNamedQuery("find userEmpresa by actionRegistro");
	      query.setParameter("id", userEmpresaAction);
	      try {
	      //List<UserEmpresaEntity> userEmpresaEntity = (List<UserEmpresaEntity>)query.getResultList( );
	      return (List<UserEmpresaEntity>)query.getResultList( );
	      }catch(Exception e) {
	    	  logger.info(e);
	    	  return null;
	      }
	}

	@Override
	public void updateUserEmpresaDAO() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserEmpresaDAO() {
		// TODO Auto-generated method stub
		
	}

}
