package com.zzq.service;

import com.zzq.dao.UserDaoSqlServerImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description UserServiceImpl测试类
 * @ClassName UserServiceImplTest
 * @Author zzq
 * @Date 2021/6/28 16:31
 */
public class UserServiceImplTest {

    @Test
    public void test1() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoSqlServerImpl());
        userService.getAllUser();
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("userServiceImpl");
        userServiceImpl.getAllUser();
    }
}
