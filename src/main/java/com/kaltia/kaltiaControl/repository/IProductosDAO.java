package com.kaltia.kaltiaControl.repository;

import java.io.Serializable;

import com.kaltia.kaltiaControl.bean.ChatEntity;
import com.kaltia.kaltiaControl.bean.ResultDAOVO;
import com.kaltia.kaltiaControl.bean.VideoEntity;

public interface IProductosDAO extends Serializable{

	ResultDAOVO addVideoDAO(VideoEntity videoEntity);
	ResultDAOVO getVideosService(String idEmpresa);
	ResultDAOVO deleteVideo(String idVideo);
	ResultDAOVO addChatDAO(ChatEntity chatEntity);

}
