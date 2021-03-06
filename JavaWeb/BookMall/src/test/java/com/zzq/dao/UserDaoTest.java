package com.zzq.dao;

import com.zzq.dao.impl.UserDaoImpl;
import com.zzq.entity.User;
import org.junit.jupiter.api.Test;

/**
 * @Description UserDao测试类
 * @ClassName UserDaoTest
 * @Author zzq
 * @Date 2021/2/21 10:15
 */
class UserDaoTest {

    @Test
    void selectUserByUsername() {
        UserDaoImpl userDao = new UserDaoImpl();
        User root = userDao.selectUserByUsername("root");
        System.out.println(root);
    }

    @Test
    void selectUserByUsernamePassword() {
        UserDaoImpl userDao = new UserDaoImpl();
        User root = userDao.selectUserByUsernamePassword("root", "123456");
        System.out.println(root);
    }

    @Test
    void saveUser() {
        UserDaoImpl userDao = new UserDaoImpl();
        int admin = userDao.saveUser(new User(null, "admin", "654321", "admin@126.com"));
        System.out.println(admin);
    }
}