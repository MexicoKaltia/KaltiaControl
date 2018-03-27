package com.kaltia.kaltiaControl.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmpresaAOP {
	
	protected final Log logger = LogFactory.getLog(getClass());
	private String idEmpresa;

	@Pointcut("execution(*  com.kaltia.kaltiaControl.service.EmpresaManagerImpl.validaEmpresa(String)) && args(idEmpresa)")
	public void empresaAOP(String idEmpresa) {
		
	}
	
	@Before("empresaAOP(idEmpresa)")
	public void beforeEmpresaAOP(String idEmpresa) {
		logger.info("antes de la ejecucion de idEmpresa:" + idEmpresa );
	}
	
	@After("empresaAOP(idEmpresa)")
	public void afterEmpresaAOP(String idEmpresa) {
		logger.info("despues de la ejecucion de idEmpresa:" + idEmpresa);
		
	}
	
	
	
	
	
	public String getIdEmpresa() {
		return idEmpresa;
	}


	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	

}
