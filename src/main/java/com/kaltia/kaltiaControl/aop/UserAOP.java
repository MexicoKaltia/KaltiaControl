package com.kaltia.kaltiaControl.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class UserAOP {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	/*
	 * @Autowired
		private UserKaltiaControlDAO userKaltiaControlDAO;
		private UserKaltiaControlEntity userKaltiaControlEntity; 
	 */
	

	//@Pointcut("execution(* com.kaltia.kaltiaControl.service.UserKaltiaControl.validaUserKaltiaControl(..))")
	public void userKaltiaControlAOP() {
		
	}
	//@Around("userKaltiaControlAOP()")
	public void loginAOP(ProceedingJoinPoint joinpoint) {
		try {
			logger.info("Inicio UserKaltiaControl");
			
			//userKaltiaControlEntity = userKaltiaControlDAO.readUserKaltiaControlDAO(userKaltiaControlVO);
			
			// Anotamos la hora de inicio
			long horaInicio = System.currentTimeMillis();
			
			// Se llama al método de negocio (método objetivo)
			joinpoint.proceed();
			
			Thread.sleep(1000); // 1 segundo
			// Este delay en milisegundos es opcional y se puede poner en los métodos
			// de negocio para simular la duración del método
			long horaTermino = System.currentTimeMillis();
			logger.info("busqueda exitosa UserKaltiaControl");
			logger.info("busqueda tuvo una duración:" + (horaTermino - horaInicio));
		} catch (Throwable t) {
			logger.info("El usuario no existe");
		}
	}

}
