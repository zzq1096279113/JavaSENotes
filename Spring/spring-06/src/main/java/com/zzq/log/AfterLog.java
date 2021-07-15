package com.zzq.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @Description 后置
 * @ClassName AfterLog
 * @Author zzq
 * @Date 2021/7/1 11:24
 */
public class AfterLog implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(method.getName() + "被执行了");
    }
}
