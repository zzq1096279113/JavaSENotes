package com.zzq.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @Description 注解AOP
 * @ClassName AnnotationPointCut
 * @Author zzq
 * @Date 2021/7/1 14:39
 */
@Aspect
public class AnnotationPointCut {

    @Before("execution(public * com.zzq.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("========注解实现前========");
    }

    @After("execution(public * com.zzq.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("========注解实现后========");
    }

    @Around("execution(public * com.zzq.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("执行前");
        System.out.println(proceedingJoinPoint.getSignature());
        proceedingJoinPoint.proceed();
        System.out.println("执行后");
    }
}
