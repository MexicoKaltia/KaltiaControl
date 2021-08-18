package com.kaltia.kaltiaControl.service;

import java.io.Serializable;

import com.kaltia.kaltiaControl.bean.ChatEntity;
import com.kaltia.kaltiaControl.bean.ResultDAOVO;
import com.kaltia.kaltiaControl.bean.VideoEntity;

public interface IProductosService extends Serializable{

	ResultDAOVO addVideoService(VideoEntity videoEntity);

	ResultDAOVO addChatService(ChatEntity chatEntity);

	
	

}
