package by.yandex.anjeymash.news.aspect;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import by.yandex.anjeymash.news.bean.News;

@Aspect
@Component
public class LogingAspect {
private static final Logger log = LogManager.getRootLogger();

@AfterReturning("execution(* by.yandex.anjeymash.news.dao.*.*(..))")
//@Before("execution(* by.yandex.anjeymash.news.dao.impl.NewsDAOImpl.save(..))")
public void logger(JoinPoint joinPoint) {
	log.trace("***** Completed: " + joinPoint.getSignature().getName() + " *****");
    //System.out.println("***** Completed: " + joinPoint.getSignature().getName() + " "+Arrays.toString(joinPoint.getArgs()));
	
}
}
