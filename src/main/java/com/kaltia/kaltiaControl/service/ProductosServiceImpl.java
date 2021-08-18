package com.kaltia.kaltiaControl.service;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaltia.kaltiaControl.Util.BaseInfra;
import com.kaltia.kaltiaControl.bean.ChatEntity;
import com.kaltia.kaltiaControl.bean.ResultDAOVO;
import com.kaltia.kaltiaControl.bean.VideoEntity;
import com.kaltia.kaltiaControl.repository.IProductosDAO;

@Service
public class ProductosServiceImpl implements IProductosService {

	protected final Log logger = LogFactory.getLog(getClass());
	private static final long serialVersionUID = -6261847286451961617L;
	
	@Autowired
    private ResultDAOVO resultDAOVO;
	@Autowired
    private IProductosDAO productosDAO;
	
	
	@Override
	public ResultDAOVO addVideoService(VideoEntity videoEntity) {
		
		logger.info(videoEntity.toString());
		String now = (new Date()).toString();
		videoEntity.setIdVideo(BaseInfra.idLocalTime());
		videoEntity.setVideoContexto(videoContexto(videoEntity.getVideoURL()));
		videoEntity.setTimestamp(now);
		videoEntity.setStatus("create");
		
		
		resultDAOVO = productosDAO.addVideoDAO(videoEntity);
		
		return resultDAOVO;
	}
	
	@Override
	public ResultDAOVO addChatService(ChatEntity chatEntity) {
		logger.info(chatEntity.toString());
		String now = (new Date()).toString();
		
		chatEntity.setChatContexto("Whats App");
		chatEntity.setTimestamp(now);
		chatEntity.setStatus("create");
		
		
		resultDAOVO = productosDAO.addChatDAO(chatEntity);
		
		return resultDAOVO;
	}




	private String videoContexto(String videoURL) {
		//https://www.youtube.com/watch?v=3hCnZ4WNug4&list=RDVUb450Alpps&index=17
		String contexto="";
		if(videoURL.contains("?v=")) {
			contexto = videoURL.substring(videoURL.indexOf("?v=")+3,videoURL.length());
			if(contexto.contains("&list=")) {
				contexto = contexto.substring(0, contexto.indexOf("&list="));
			}
			logger.info(contexto);
			return contexto ;
		}else
			return "video no válido";
		
	}


	
	
	

}
