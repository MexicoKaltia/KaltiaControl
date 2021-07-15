package com.kaltia.kaltiaControl.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kaltia.kaltiaControl.bean.EmpresaEntity;
import com.kaltia.kaltiaControl.bean.ProductosEntity;
import com.kaltia.kaltiaControl.bean.ResultDAOVO;
import com.kaltia.kaltiaControl.bean.VideoEntity;

@Repository
public class ProductosDAOImpl implements IProductosDAO {

	/**
	 * 
	 */
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
	@Transactional
	public ResultDAOVO addVideoDAO(VideoEntity videoEntity) {
		logger.info("-----------"+videoEntity.getVideoTitulo());
	     
		try {
		  em.merge(videoEntity);
	      
	      resultDAOVO.setCode("00");
	      resultDAOVO.setMessage("Video guardado con exito ");
	      
		}catch(Exception e) {
			resultDAOVO.setCode("99");
			resultDAOVO.setMessage(e.toString());
			e.printStackTrace();
		}finally {
			em.close( );
		}
		return resultDAOVO;
	}

	
	@SuppressWarnings("unchecked") // Este metodo no esta en servicio se consultan por medio del REST /constulaVideos  en Edicion.jar
	@Override
	public ResultDAOVO getVideosService(String idEmpresa) {
		
		Query query=null;
		query = em.createNamedQuery("find videos by idEmpresa");
		query.setParameter("id", idEmpresa);
      ArrayList<VideoEntity> videosEntityArray = new ArrayList<VideoEntity>();
      try {
    	  videosEntityArray = (ArrayList<VideoEntity>) query.getResultList();
    	  resultDAOVO.setArrayJson(listToJSONVideos(videosEntityArray));
    	  resultDAOVO.setMessage("Exito en consulta de Videos");
    	  resultDAOVO.setCode("00");
      }catch(Exception e){
    	  resultDAOVO.setMessage("Error en consulta de Videos");
    	  resultDAOVO.setCode("99");
    	  e.printStackTrace();
      }
      return resultDAOVO;
	}
	
	@Override
	@Transactional
	public ResultDAOVO deleteVideo(String idVideo) {

		  //Delete Action
		try {
			String qry = "delete from tw_videos p where p.idVideo=:idVideo";
			em.createQuery(qry).setParameter("idVideo", idVideo).executeUpdate();
			
			resultDAOVO.setCode("00");
			resultDAOVO.setMessage("EXITO delete :"+idVideo);
		} catch (Exception e) {
			resultDAOVO.setCode("99");
			resultDAOVO.setMessage("error delete :"+idVideo);
			e.printStackTrace();
		}
		return resultDAOVO;
		

	}
	
	/*
	 * privates
	 */
	private List<JSONObject> listToJSONVideos(ArrayList<VideoEntity> videosEntityArray) {

		List<JSONObject> arrayJson = new ArrayList<JSONObject>();
		
		for(VideoEntity ve : videosEntityArray) {
			JSONObject json = new JSONObject();
			json.put("idVideo", ve.getVideoTitulo());
			json.put("videoTitulo", ve.getVideoTitulo());
			json.put("videoURL", ve.getVideoURL());
			arrayJson.add(json);
		}
		return arrayJson;
	}


	
}
