package com.kaltia.kaltiaControl.repository;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kaltia.kaltiaControl.bean.EmpresaEntity;
import com.kaltia.kaltiaControl.bean.ResultDAOVO;

@Repository
public class EmpresaDAOImpl implements EmpresaDAO{

	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());
	private EmpresaEntity empresaEntity;
	@Autowired
	private ResultDAOVO resultDAOVO;
	
    /*
     * Sets the entity manager.
     */
	private EntityManager em = null;
	
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
	// end Entity Manager
    
    
    
	@Override
	@Transactional(readOnly = false)
	public ResultDAOVO createEmpresaDAO(EmpresaEntity eE) {
		
		empresaEntity = new EmpresaEntity();
		empresaEntity.setIdEmpresa("idEmpresa");
		empresaEntity.setIdAction("idAction");
		empresaEntity.setEmpresaNombreCompleto("empresaNombreCompleto");
		empresaEntity.setEmpresaRFC("empresaRFC");
		empresaEntity.setEmpresaDireccion("empresaDireccion");
		empresaEntity.setEmpresaEmail("empresaEmail");
		empresaEntity.setEmpresaContacto("empresaContacto");
		empresaEntity.setEmpresaRepresentante("empresaRepresentante");
		empresaEntity.setEmpresaVarios("empresaVarios");
		empresaEntity.setEmpresaUserKaltia("empresaUserKaltia");
		logger.info("-----------"+empresaEntity.getEmpresaNombreCompleto());
		
		try {
	//	  em.getTransaction( ).begin( );
		  em.merge(empresaEntity);//.persist( empresaEntity );
	  //    em.getTransaction( ).commit( );
	  //	  em.close( );
	      resultDAOVO.setCode("00");
	      
		}catch(Exception e) {
			resultDAOVO.setCode("99");
			resultDAOVO.setMessage(e.toString());
		}finally {
			em.close( );
		      //emfactory.close( );
		}
	      
		return resultDAOVO;
	}

	@Override
	public EmpresaEntity readEmpresaDAO(String idEmpresa) {
		
		//EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "kaltiaControlPU" );
	     // EntityManager entitymanager = emfactory.createEntityManager();
	      
		
	      Query query = em.createNamedQuery("find empresa by idEmpresa");
	      query.setParameter("id", idEmpresa);
	      
	      //empresaEntity = (EmpresaEntity) query.getSingleResult();
	      try {
	    	  return (EmpresaEntity) query.getSingleResult();
	      }catch(Exception e){
	    	  logger.info(e);
	    	  empresaEntity.setIdEmpresa("Exception");
	    	  return empresaEntity;
	      }
	}
	
public ArrayList<EmpresaEntity> readEmpresaArrayDAO(String idUserPerfilI) {
		
		//EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "kaltiaControlPU" );
	     // EntityManager entitymanager = emfactory.createEntityManager();
	      
		
	      Query query = em.createNamedQuery("find empresa by idEmpresaArray");
	      query.setParameter("id", idUserPerfilI);
	      
	      ArrayList<EmpresaEntity> empresaArrayDAO = new ArrayList<EmpresaEntity>();
	      try {
	    	  empresaArrayDAO = (ArrayList<EmpresaEntity>) query.getResultList();
	    	  return empresaArrayDAO; 
	      }catch(Exception e){
	    	  logger.info(e);
	    	  return empresaArrayDAO;
	      }
	}

	@Override
	public ResultDAOVO updateEmpresaDAO() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultDAOVO deleteEmpresaDAO() {
		return null;
		// TODO Auto-generated method stub
		
	}
	
	

}
