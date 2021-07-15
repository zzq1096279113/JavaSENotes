package com.zzq.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Description 前置
 * @ClassName BeforeLog
 * @Author zzq
 * @Date 2021/7/1 11:19
 */
public class BeforeLog implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object o) throws Throwable {
        System.out.println(method.getName() + "将要执行");
    }
}
