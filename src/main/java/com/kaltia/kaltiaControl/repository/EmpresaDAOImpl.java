package com.kaltia.kaltiaControl.repository;


import java.util.ArrayList;

import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
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
		empresaEntity.setIdEmpresa("idEmpresa2");
		empresaEntity.setIdAction("idAction");
		empresaEntity.setEmpresaNombreCompleto("empresaNombreCompleto");
		empresaEntity.setEmpresaRFC("empresaRFC");
		empresaEntity.setEmpresaDireccion("empresaDireccion");
		empresaEntity.setEmpresaEmail("empresaEmail");
		empresaEntity.setEmpresaContacto("empresaContacto");
		empresaEntity.setEmpresaIdPerfilE("empresaIdPerfilE");
		empresaEntity.setEmpresaVarios("empresaVarios");
		empresaEntity.setEmpresaIdPerfilI("empresaIdPerfilI");
		empresaEntity.setEmpresaModelo("empresaModelo");
		empresaEntity.setEmpresaStatus("empresaStatus");
		empresaEntity.setEmpresaFechaCorte("empresaFechaCorte");
		empresaEntity.setEmpresaModoPago("empresaModoPago");
		empresaEntity.setEmpresaFactura("empresaFactura");
		
		logger.info("-----------"+eE.getEmpresaNombreCompleto());
		
//		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "kaltiaControlPU" );
//	      EntityManager entitymanager = emfactory.createEntityManager( );
	      
		try {
//			em.getTransaction( ).begin( );
		  em.merge(eE);
//			em.persist( eE );
//		    em.getTransaction( ).commit( );
		      
	      resultDAOVO.setCode("00");
	      resultDAOVO.setMessage("Empresa con exito guardada");
	      
		}catch(Exception e) {
			resultDAOVO.setCode("99");
			resultDAOVO.setMessage(e.toString());
		}finally {
			em.close( );
		      
		}
	      
		return resultDAOVO;
	}

	@Override
	public EmpresaEntity readEmpresaDAO(String idUserKaltiaControl) {
		
		//EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "kaltiaControlPU" );
	     // EntityManager entitymanager = emfactory.createEntityManager();
	      
		
	      Query query = em.createNamedQuery("find empresa by idEmpresa");
	      query.setParameter("id", idUserKaltiaControl);
	      
	      //empresaEntity = (EmpresaEntity) query.getSingleResult();
	      try {
	    	  return (EmpresaEntity) query.getSingleResult();
	      }catch(Exception e){
	    	  logger.info(e);
	    	  empresaEntity.setIdEmpresa("Exception");
	    	  return empresaEntity;
	      }
	}
	
	@Override
	public ArrayList<EmpresaEntity> readEmpresaArrayDAO(String idUserPerfilI) {
		
		//EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "kaltiaControlPU" );
	     // EntityManager entitymanager = emfactory.createEntityManager();
		
	      Query query = em.createNamedQuery("find empresa by idEmpresaArray");
	      query.setParameter("id", idUserPerfilI);
	      
	      ArrayList<EmpresaEntity> empresaEntityArrayDAO = new ArrayList<EmpresaEntity>();
	      try {
	    	  empresaEntityArrayDAO = (ArrayList<EmpresaEntity>) query.getResultList();
	    	  return empresaEntityArrayDAO; 
	      }catch(Exception e){
	    	  logger.info(e);
	    	  return empresaEntityArrayDAO;
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
