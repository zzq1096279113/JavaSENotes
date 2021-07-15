package com.zzq.diy;

/**
 * @Description 自定义切入点
 * @ClassName DiyPointCut
 * @Author zzq
 * @Date 2021/7/1 14:21
 */
public class DiyPointCut {

    public void before(){
        System.out.println("=======方法实现前=======");
    }

    public void after(){
        System.out.println("=======方法实现后=======");
    }

}
