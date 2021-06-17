package com.kaltia.kaltiaControl.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
//import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaltia.kaltiaControl.Util.BaseInfra;
import com.kaltia.kaltiaControl.bean.DatosCitasVO;
import com.kaltia.kaltiaControl.bean.EmpresaEntity;
import com.kaltia.kaltiaControl.bean.ProductosEntity;
import com.kaltia.kaltiaControl.bean.RequestLoginVO;
import com.kaltia.kaltiaControl.bean.ResultDAOVO;
import com.kaltia.kaltiaControl.bean.ResultVO;
import com.kaltia.kaltiaControl.bean.UserEmpresaEntity;
import com.kaltia.kaltiaControl.bean.UserKaltiaControlEntity;
import com.kaltia.kaltiaControl.bean.UserKaltiaControlVO;
import com.kaltia.kaltiaControl.repository.UserKaltiaControlDAO;

@Service
public class UserManagerImpl implements UserManager{
	
	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());
	

	@Autowired
	@Qualifier("userKaltiaControlDAOImpl")
	private UserKaltiaControlDAO userKaltiaControlDAO;
	@Autowired
	private EmpresaManager empresaManager;
	@Autowired
	private UserEmpresaManager userEmpresaManager;
	@Autowired
	private RequestLoginVO requestLoginVO;
	@Autowired
	private ResultVO resultVO;
	@Autowired
	private ClienteRest clienteRest;
	@Autowired
	private DatosCitasVO datosCitasVO;
	
	private UserKaltiaControlEntity userKaltiaControlEntity =null;
	private EmpresaEntity empresaEntity;
//	private StatusEmpresaEntity statusEmpresaEntity;
	
	
	@Override
	public ResultDAOVO createUser(EmpresaEntity empresaEntity) {
		
		userKaltiaControlEntity.setIdUserKaltiaControlUser(empresaEntity.getIdEmpresa());//BaseInfra.idLocalTime());
		userKaltiaControlEntity.setUserKaltiaControlUser(empresaEntity.getEmpresaEmail());
		userKaltiaControlEntity.setUserKaltiaControlPass(empresaEntity.getIdAction());
		userKaltiaControlEntity.setUserKaltiaControlDescr(empresaEntity.getIdAction());
		userKaltiaControlEntity.setUserKaltiaControlPerfil("perfilE");
		userKaltiaControlEntity.setUserKaltiaControlNombre(empresaEntity.getEmpresaContacto());
		userKaltiaControlEntity.setUserKaltiaControlStatus("inicio");
		userKaltiaControlEntity.setUserKaltiaControlDomicilio(empresaEntity.getEmpresaDireccion());
		userKaltiaControlEntity.setUserKaltiaControlCorreo(empresaEntity.getEmpresaEmail());
		userKaltiaControlEntity.setUserKaltiaControlContacto(empresaEntity.getEmpresaContacto());
		
		ResultDAOVO resultDAOVO = userKaltiaControlDAO.createUserKaltiaControlDAO(userKaltiaControlEntity);
		
		return resultDAOVO;
	}

	@Override
	public RequestLoginVO readUser(UserKaltiaControlVO userKaltiaControlVO) {
		
		/*
		 * Informacion de perfil usuarioKaltiaControl
		 */
		userKaltiaControlEntity = userKaltiaControlDAO.readUserKaltiaControlDAO(userKaltiaControlVO);
		
		if(!userKaltiaControlEntity.getIdUserKaltiaControlUser().equals("vacio")) {
			requestLoginVO.setUserKaltiaControlEntity(userKaltiaControlEntity);
			
			if(userKaltiaControlEntity.getUserKaltiaControlStatus().equals("activo")) {
				  //lectura de array Empresas perfil A
				String perfil = userKaltiaControlEntity.getUserKaltiaControlPerfil();
				String idUser = userKaltiaControlEntity.getIdUserKaltiaControlUser().toString();
				if(perfil.equals("perfilA") || perfil.equals("perfilI")) {
				
					requestLoginVO.setEmpresaArrayEntity(empresaManager.readEmpresaArray(idUser, perfil ));
					requestLoginVO.setProductosEntity(empresaManager.readEmpresaProductos());
					requestLoginVO.setJsonArray(arrayEmpresa(requestLoginVO)); 
				}
				//lectura de array Empresas perfil E
				else if(perfil.equals("perfilE")) {	
					/*
					 * Informacion Empresa de usuarioKaltiaControl
					 */
					empresaEntity = empresaManager.readEmpresa(idUser);
					logger.info(empresaEntity.toString());
					/*
					 * Informacion Empresa de userEmpresa -- MODULOS
					 */		
//					if(!empresaEntity.getEmpresaCitas().equals("No Activo") || !empresaEntity.getEmpresaModulos().equals("No Activo")) {
						List<UserEmpresaEntity> userEmpresaEntity  = userEmpresaManager.readUserEmpresa(empresaEntity.getIdAction());
						requestLoginVO.setUserEmpresaEntity(userEmpresaEntity);
//						if(!empresaEntity.getEmpresaCitas().equals("No Activo")) {
//							resultVO = clienteRest.readCitas(empresaEntity.getIdAction());
							logger.info(resultVO.getMensajeArray());
//							datosCitasVO.setCondiciones((JSONObject) JSONValue.parse(resultVO.getMensajeArray().get(0)));
//							datosCitasVO.setMesActual((JSONObject) JSONValue.parse(resultVO.getMensajeArray().get(1)));
//							datosCitasVO.setMesPost((JSONObject) JSONValue.parse(resultVO.getMensajeArray().get(2)));
//							requestLoginVO.setDatosCitasVO(datosCitasVO);
//						}
						
//					}
			
					requestLoginVO.setEmpresaEntity(empresaEntity);
//					requestLoginVO.setStatusEmpresaEntity(statusEmpresaEntity);
				}
				 String now = (new Date()).toString();   
				userKaltiaControlEntity.setUserKaltiaControlActividad(now);
				userKaltiaControlDAO.actividadUserKaltiaControlDAO(userKaltiaControlEntity);
				
			}else if(userKaltiaControlEntity.getUserKaltiaControlStatus().equals("inicio")){
				userKaltiaControlEntity.setUserKaltiaControlPerfil("inicio");
				requestLoginVO.setUserKaltiaControlEntity(userKaltiaControlEntity);		
			}else {
//				Usuario suspendido 
				requestLoginVO.setUserKaltiaControlEntity(new UserKaltiaControlEntity("Usuario Suspendido"));
				return requestLoginVO;	
			}

		}else {
			requestLoginVO.setUserKaltiaControlEntity(new UserKaltiaControlEntity("errorLogin"));
			return requestLoginVO;
		}
		
		
				
		return requestLoginVO ;
	}

	@Override
	public RequestLoginVO updateUser(UserKaltiaControlVO userKaltiaControl) {
			
		logger.info(userKaltiaControl.toString());
		
		try {
			String[] user = userKaltiaControl.getUserUser().toString().split("@");
//			userKaltiaControlEntity.setIdUserKaltiaControlUser(user[0].toString());
			userKaltiaControlEntity.setUserKaltiaControlPass(userKaltiaControl.getPassUser());
			userKaltiaControlEntity.setUserKaltiaControlStatus("activo");
			
			userKaltiaControlEntity = userKaltiaControlDAO.updateUserKaltiaControlDAO(userKaltiaControlEntity);
			
			requestLoginVO = readUser(userKaltiaControl);
			
			return  requestLoginVO;
			
		}catch(Exception e) {
			e.printStackTrace(); 
			userKaltiaControlEntity.setUserKaltiaControlPerfil("error");			 
			return  requestLoginVO;
		}
		
		
	}

	@Override
	public String deleteUser(UserKaltiaControlVO userKaltiaControl) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private JSONObject arrayEmpresa(RequestLoginVO request) {
		
		List<JSONObject> listEmpresa = new ArrayList();
		List<JSONObject> listProductos = new ArrayList();
		JSONArray jsonArrayEmpresas = new JSONArray();
		JSONObject jsonArray = new JSONObject();
		Map<String, Object> response = new HashMap();
		for(EmpresaEntity empresa: request.getEmpresaArrayEntity()) {
			JSONObject jsonEmpresa = new JSONObject();
			jsonEmpresa.put("idEmpresa", empresa.getIdEmpresa());
			jsonEmpresa.put("idAction", empresa.getIdAction());
			jsonEmpresa.put("empresaNombreCorto", empresa.getEmpresaNombreCorto());
			jsonEmpresa.put("empresaNombreCompleto", empresa.getEmpresaNombreCompleto());
			jsonEmpresa.put("empresaRFC", empresa.getEmpresaRFC());
			jsonEmpresa.put("empresaDireccion", empresa.getEmpresaDireccion());
			jsonEmpresa.put("empresaEmail", empresa.getEmpresaEmail());
			jsonEmpresa.put("empresaContacto", empresa.getEmpresaContacto());
			jsonEmpresa.put("empresaTelefono", empresa.getEmpresaTelefono());
			jsonEmpresa.put("empresaIdPerfilI", empresa.getEmpresaIdPerfilI());
			jsonEmpresa.put("empresaIdPerfilE", empresa.getEmpresaIdPerfilE());
			jsonEmpresa.put("empresaVarios", empresa.getEmpresaVarios());
			jsonEmpresa.put("empresaStatus", empresa.getEmpresaStatus());
			jsonEmpresa.put("empresaFechaCorte", empresa.getEmpresaFechaCorte());
			jsonEmpresa.put("empresaModoPago", empresa.getEmpresaModoPago());
			jsonEmpresa.put("empresaFactura", empresa.getEmpresaFactura());
			
			listEmpresa.add(jsonEmpresa);
			jsonArrayEmpresas.add(jsonEmpresa);
		}
		
		for(ProductosEntity productos: request.getProductosEntity()) {
			JSONObject jsonProductos = new JSONObject();
			jsonProductos.put("idEmpresa", productos.getIdEmpresa());
			jsonProductos.put("checkPagina", productos.isCheckPagina());
			jsonProductos.put("checkQRR", productos.isCheckQRR());
			jsonProductos.put("checkQRE", productos.isCheckQRE());
			jsonProductos.put("checkPuntoVenta", productos.isCheckPuntoVenta());
			jsonProductos.put("clientePagina", productos.isClientePagina());
			jsonProductos.put("citaPagina", productos.isCitaPagina());
			jsonProductos.put("carpetaPagina", productos.isCarpetaPagina());
			jsonProductos.put("retroalimentacionPagina", productos.isRetroalimentacionPagina());
			jsonProductos.put("chatPagina", productos.isChatPagina());
			jsonProductos.put("notificacionPagina", productos.isNotificacionPagina());
			jsonProductos.put("videoPagina", productos.isVideoPagina());
			jsonProductos.put("tarjetaPagina", productos.isCitaPagina());
			
			listProductos.add(jsonProductos);
			jsonArrayEmpresas.add(jsonProductos);
		}
		
		response.put("clientes", listEmpresa);
		jsonArray.put("clientes", response.get("clientes"));
		
		response.put("productos", listProductos);
		jsonArray.put("productos", response.get("productos"));

		request.setJsonArray(jsonArray);
	
		return jsonArray;
	}

}
