package com.kaltia.kaltiaControl.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.kaltia.kaltiaControl.bean.StatusEmpresaEntity;

@Repository
public class StatusEmpresaDAOImpl implements StatusEmpresaDAO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());
	//private StatusEmpresaEntity statusEmpresaEntity;
	
    /*
     * Sets the entity manager.
     */
	private EntityManager em = null;
	
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }


	@Override
	public void createStatusEmpresaDAO() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StatusEmpresaEntity readStatusEmpresaDAO(String idEmpresa) {
		
		Query query = em.createNamedQuery("find statusEmpresa by idEmpresa");
	      query.setParameter("id", idEmpresa);
	      
	      try {
	      return (StatusEmpresaEntity) query.getSingleResult();
	      }catch(Exception e){
	      logger.info(e);
	      return null;
	      }
	}

	@Override
	public void updateStatusEmpresaDAO() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStatusEmpresaDAO() {
		// TODO Auto-generated method stub
		
	}

}
