package com.esprit.examen.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static final Logger l = LogManager.getLogger(LoggingAspect.class);


	@After("execution(* com.esprit.examen.services.*.*(..))")
	public void logMethodExit(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		l.info("méthode : " + name +" exécutée avec succès");
	}
<<<<<<< HEAD
	@Around("execution(* com.esprit.examen.service.*.*(..))")
=======


	@Around("execution(* com.esprit.examen.services.*.*(..))")
>>>>>>> bb85b931b83799a18bc536e87862c9aea57aa014
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		Object obj = pjp.proceed();
		long elapsedTime = System.currentTimeMillis() - start;
		l.info("Method execution time: " + elapsedTime + " milliseconds.");
		return obj;
	}
<<<<<<< HEAD

=======
>>>>>>> bb85b931b83799a18bc536e87862c9aea57aa014

}
