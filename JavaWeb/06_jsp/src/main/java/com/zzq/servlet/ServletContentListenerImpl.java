package com.zzq.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Description ServletContentListener监听器的使用
 * @ClassName ServletContentListenerImpl
 * @Author zzq
 * @Date 2021/2/1 17:53
 */
public class ServletContentListenerImpl implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("servletContent被初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("servletContent被销毁");
    }
}
