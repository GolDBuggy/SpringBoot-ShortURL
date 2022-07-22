package com.urlproject.java.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CustomerUrlAspect {

    private static final Logger logger=Logger.getLogger(CustomerUrlAspect.class.getName());

    @Before("execution(* com.urlproject.java.Controller.CustomerController.*(..))")
    private void beforeController(JoinPoint joinPoint){
        MethodSignature signature=(MethodSignature) joinPoint.getSignature();
        logger.info(signature+" method worked!");
    }


    @Before("execution(* com.urlproject.java.Controller.UrlController.*(..))")
    private void beforeUrl(JoinPoint joinPoint){
        MethodSignature signature=(MethodSignature) joinPoint.getSignature();
        logger.info(signature+" method worked!");
    }

    @AfterThrowing(value = "execution(* com.company.java.Service.*.*(..))",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,RuntimeException e){
        MethodSignature signature=(MethodSignature) joinPoint.getSignature();
        logger.info(signature+" method worked!");
        logger.info("Exception Message => "+e.getMessage());
    }


    @AfterReturning(value = "execution(* com.company.java.Controller.*.*(..))",returning = "object")
    public void afterReturn(JoinPoint joinPoint,Object object){
        MethodSignature signature=(MethodSignature) joinPoint.getSignature();
        logger.info(signature+" method worked!");
        logger.info("Returning value => "+object);
    }



}