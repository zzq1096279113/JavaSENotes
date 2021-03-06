package com.zzq.service;

import com.zzq.entity.User;
import com.zzq.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

/**
 * @Description UserServiceImpl测试类
 * @ClassName UserServiceImplTest
 * @Author zzq
 * @Date 2021/2/23 10:58
 */
class UserServiceImplTest {
    UserServiceImpl userService = new UserServiceImpl();

    @Test
    void loginUser() {
        User admin = userService.loginUser("admin", "654321");
        System.out.println(admin);
    }

    @Test
    void registeredUser() {
        userService.registeredUser(new User(null, "zzq", "741258", "zzq@163.com"));
    }

    @Test
    void existUser() {
        System.out.println(userService.existUser("admin"));
    }
}