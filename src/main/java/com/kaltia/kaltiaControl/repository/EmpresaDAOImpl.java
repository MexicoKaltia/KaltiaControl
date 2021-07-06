package com.kaltia.kaltiaControl.repository;


import java.util.ArrayList;
import java.util.List;

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

import com.kaltia.kaltiaControl.bean.ActionEntity;
import com.kaltia.kaltiaControl.bean.BodyEntity;
import com.kaltia.kaltiaControl.bean.EmpresaEntity;
import com.kaltia.kaltiaControl.bean.FooterEntity;
import com.kaltia.kaltiaControl.bean.HeaderEntity;
import com.kaltia.kaltiaControl.bean.PaginaEntity;
import com.kaltia.kaltiaControl.bean.ProductosEntity;
import com.kaltia.kaltiaControl.bean.QRRestauranteEntity;
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
			
		logger.info("-----------"+eE.getEmpresaNombreCompleto());
		     
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
	
	/*
	 * PRODUCTOS
	 */
	
	@Override
	@Transactional(readOnly = false)
	public ResultDAOVO createProductos(ProductosEntity productosEntity) {
		try {
		  em.merge(productosEntity);
	      resultDAOVO.setCode("00");
	      resultDAOVO.setMessage("Productos exito guardada");
	      
		}catch(Exception e) {
			resultDAOVO.setCode("99");
			resultDAOVO.setMessage(e.toString());
		}finally {
			em.close( );	      
		}
		return resultDAOVO;
	}
	
	



	@Override
	public List<ProductosEntity> readProductos() {
		Query query=null;
			query = em.createNamedQuery("find Productos All");
	      ArrayList<ProductosEntity> productosEntityArray = new ArrayList<ProductosEntity>();
	      try {
	    	  productosEntityArray = (ArrayList<ProductosEntity>) query.getResultList();
	    	  return productosEntityArray; 
	      }catch(Exception e){
	    	  logger.info(e);
	    	  return productosEntityArray;
	      }
	}
	
	@Override
	public ProductosEntity readProductos(String idEmpresa) {
		Query query=null;
			query = em.createNamedQuery("find Productos Id");
			query.setParameter("id", idEmpresa);
	      ProductosEntity productosEntity = new ProductosEntity();
	      try {
	    	  productosEntity = (ProductosEntity) query.getSingleResult();
	    	  return productosEntity; 
	      }catch(Exception e){
	    	  logger.info(e);
	    	  return productosEntity;
	      }
	}
	
	@Override
	@Transactional(readOnly = false)
	public ResultDAOVO updateProductosDAO(ProductosEntity productosEntity) {
		
		try {
		  em.merge(productosEntity);
		      
	      resultDAOVO.setCode("00");
	      resultDAOVO.setMessage("Empresa Productos Actualizada con Exito");
	      
		}catch(Exception e) {
			resultDAOVO.setCode("99");
			resultDAOVO.setMessage(e.toString());
			e.printStackTrace();
		}finally {
			em.close( );
		      
		}
		return resultDAOVO;


	}


	//
	
	@Override
	@Transactional(readOnly = false)
	public ResultDAOVO createPagina(PaginaEntity paginaEntity) {
		logger.info("-----------"+paginaEntity.getIdAction());
	      
		try {
		  em.merge(paginaEntity);
	      resultDAOVO.setCode("00");
	      resultDAOVO.setMessage("Pagina con exito guardada");
	      
		}catch(Exception e) {
			resultDAOVO.setCode("99");
			resultDAOVO.setMessage(e.toString());
			logger.info(e);
		}finally {
			em.close( );
		}
		
		return resultDAOVO;
	}
	
	@Override
	@Transactional(readOnly = false)
	public ResultDAOVO createQRR(QRRestauranteEntity qrrEntity) {
		logger.info("-----------"+qrrEntity.getIdAction());
	      
		try {
		  em.merge(qrrEntity);
	      resultDAOVO.setCode("00");
	      resultDAOVO.setMessage("QRR con exito guardada");
	      
		}catch(Exception e) {
			resultDAOVO.setCode("99");
			resultDAOVO.setMessage(e.toString());
			logger.info(e);
		}finally {
			em.close( );
		}
		
		return resultDAOVO;

	}



	@Override
	public EmpresaEntity readEmpresaDAO(String idAction) {
		
		//EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "kaltiaControlPU" );
	     // EntityManager entitymanager = emfactory.createEntityManager();
		 empresaEntity = new EmpresaEntity();
		
	      Query query = em.createNamedQuery("find idAction by idAction");
	      query.setParameter("id", idAction);
	      try {
	    	  empresaEntity = (EmpresaEntity) query.getSingleResult();
	    	  
	      }catch(Exception e){
	    	  logger.info(e);
	    	  empresaEntity.setIdEmpresa("Exception");
	      }
	      return empresaEntity;
	}
	
	@Override
	public EmpresaEntity readIdEmpresaDAO(String idEmpresaPagina) {
		//EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "kaltiaControlPU" );
	     // EntityManager entitymanager = emfactory.createEntityManager();
		 empresaEntity = new EmpresaEntity();
		
//	      Query query = em.createNamedQuery("find idAction by idAction");
//	      query.setParameter("id", idUserKaltiaControl);
	      try {
	    	  empresaEntity =  em.find(EmpresaEntity.class, idEmpresaPagina);
	    	  
	      }catch(Exception e){
	    	  logger.info(e);
	    	  empresaEntity.setIdEmpresa("Exception");
	      }
	      return empresaEntity;
	}
	

	
	@Override
	public ArrayList<EmpresaEntity> readEmpresaArrayDAO(String idUserPerfil, String userPerfil) {
		
		//EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "kaltiaControlPU" );
	     // EntityManager entitymanager = emfactory.createEntityManager();
		Query query=null;
		if(userPerfil.equals("perfilI")) {
			query = em.createNamedQuery("find empresa by idEmpresaArray");
		      query.setParameter("id", idUserPerfil);
		}else {
			query = em.createNamedQuery("find empresa by All");
		}
	      
	      
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
	@Transactional(readOnly = false)
	public ResultDAOVO updateEmpresaDAO(EmpresaEntity eE) {
		
		try {
//			em.getTransaction( ).begin( );
		  em.merge(eE);
//			em.persist( eE );
//		    em.getTransaction( ).commit( );
		      
	      resultDAOVO.setCode("00");
	      resultDAOVO.setMessage("Empresa Actualizada con Exito");
	      
		}catch(Exception e) {
			resultDAOVO.setCode("99");
			resultDAOVO.setMessage(e.toString());
		}finally {
			em.close( );
		      
		}
		return resultDAOVO;

		
	}

	

	@Override
	@Transactional(readOnly = false)
	public ResultDAOVO createActionDAO(ActionEntity actionEntity) {
		try {
//			em.getTransaction( ).begin( );
		  em.merge(actionEntity);
//			em.persist( eE );
//		    em.getTransaction( ).commit( );
		      
	      resultDAOVO.setCode("00");
	      resultDAOVO.setMessage(actionEntity.getIdAction()+" con exito guardada");
	      
		}catch(Exception e) {
			resultDAOVO.setCode("99");
			resultDAOVO.setMessage(e.toString());
		}finally {
			em.close( );
		      
		}
	      
		return resultDAOVO;
	}



	@Override
	@Transactional(readOnly = false)
	public ResultDAOVO createHeaderDAO(HeaderEntity headerEntity) {
		try {
//			em.getTransaction( ).begin( );
		  em.merge(headerEntity);
//			em.persist( eE );
//		    em.getTransaction( ).commit( );
		      
	      resultDAOVO.setCode("00");
	      resultDAOVO.setMessage("Header con exito guardada");
	      
		}catch(Exception e) {
			resultDAOVO.setCode("99");
			resultDAOVO.setMessage(e.toString());
		}finally {
			em.close( );
		      
		}
	      
		return resultDAOVO;
	}



	@Override
	@Transactional(readOnly = false)
	public ResultDAOVO createBodyDAO(BodyEntity bodyEntity) {
		try {
//			em.getTransaction( ).begin( );
		  em.merge(bodyEntity);
//			em.persist( eE );
//		    em.getTransaction( ).commit( );
		      
	      resultDAOVO.setCode("00");
	      resultDAOVO.setMessage("Body con exito guardada");
	      
		}catch(Exception e) {
			resultDAOVO.setCode("99");
			resultDAOVO.setMessage(e.toString());
		}finally {
			em.close( );
		      
		}
	      
		return resultDAOVO;

	}



	@Override
	@Transactional(readOnly = false)
	public ResultDAOVO createFooterDAO(FooterEntity footerEntity) {
		try {
//			em.getTransaction( ).begin( );
		  em.merge(footerEntity);
//			em.persist( eE );
//		    em.getTransaction( ).commit( );
		      
	      resultDAOVO.setCode("00");
	      resultDAOVO.setMessage("footer con exito guardada");
	      
		}catch(Exception e) {
			resultDAOVO.setCode("99");
			resultDAOVO.setMessage(e.toString());
		}finally {
			em.close( );
		      
		}
	      
		return resultDAOVO;

	}



	@Override
	@Transactional(readOnly = true)
	public HeaderEntity readHeaderDAO(String IdEmpresa) {
		Query query = em.createNamedQuery("findEmpresaHeaderByIdEmpresa");
	      query.setParameter("IdEmpresa", IdEmpresa);
	      
	      //empresaEntity = (EmpresaEntity) query.getSingleResult();
	      try {
	    	  return (HeaderEntity) query.getSingleResult();
	      }catch(Exception e){
	    	  logger.info(e);
	    	  //empresaEntity.setIdEmpresa("Exception");
	    	  return null;
	      }
	      
	}



	@Override
	public BodyEntity readBodyDAO(String IdEmpresa) {
		Query query = em.createNamedQuery("findEmpresaBodyByIdEmpresa");
	      query.setParameter("IdEmpresa", IdEmpresa);
	      
	      //empresaEntity = (EmpresaEntity) query.getSingleResult();
	      try {
	    	  return (BodyEntity) query.getSingleResult();
	      }catch(Exception e){
	    	  logger.info(e);
	    	  //empresaEntity.setIdEmpresa("Exception");
	    	  return null;
	      }	}



	@Override
	public FooterEntity readFooterDAO(String IdEmpresa) {
		Query query = em.createNamedQuery("findEmpresaFooterByIdEmpresa");
	      query.setParameter("IdEmpresa", IdEmpresa);
	      
	      //empresaEntity = (EmpresaEntity) query.getSingleResult();
	      try {
	    	  return (FooterEntity) query.getSingleResult();
	      }catch(Exception e){
	    	  logger.info(e);
	    	  //empresaEntity.setIdEmpresa("Exception");
	    	  return null;
	      }	}



	@Override
	@Transactional
	public ResultDAOVO deleteEmpresaDAO(String idEmpresa) {
		
		  //Delete Action
		try {
			String qry = "delete from tc_action p where p.idEmpresa=:idEmpresa";
			em.createQuery(qry).setParameter("idEmpresa", idEmpresa).executeUpdate();
			qry = "delete from tc_userkaltiacontrol p where p.idUserKaltiaControlUser=:idEmpresa";
			em.createQuery(qry).setParameter("idEmpresa", idEmpresa).executeUpdate();
			qry = "delete from tc_pagina p where p.idPagina=:idEmpresa";
			em.createQuery(qry).setParameter("idEmpresa", idEmpresa).executeUpdate();
			qry = "delete from tc_productos p where p.idEmpresa=:idEmpresa";
			em.createQuery(qry).setParameter("idEmpresa", idEmpresa).executeUpdate();
			qry = "delete from tc_qrr p where p.idQRR=:idEmpresa";
			em.createQuery(qry).setParameter("idEmpresa", idEmpresa).executeUpdate();
			qry = "delete from tw_body p where p.idEmpresa=:idEmpresa";
			em.createQuery(qry).setParameter("idEmpresa", idEmpresa).executeUpdate();
			qry = "delete from tw_header p where p.idEmpresa=:idEmpresa";
			em.createQuery(qry).setParameter("idEmpresa", idEmpresa).executeUpdate();
			qry = "delete from tw_footer p where p.idEmpresa=:idEmpresa";
			em.createQuery(qry).setParameter("idEmpresa", idEmpresa).executeUpdate();
			qry = "delete from tc_empresa p where p.idEmpresa=:idEmpresa";
			em.createQuery(qry).setParameter("idEmpresa", idEmpresa).executeUpdate();
			resultDAOVO.setCode("00");
			resultDAOVO.setMessage("EXITO delete :"+idEmpresa);
		} catch (Exception e) {
			resultDAOVO.setCode("99");
			resultDAOVO.setMessage("error delete :"+idEmpresa);
			e.printStackTrace();
		}
		return resultDAOVO;
		
	}



	



}
