package com.zzq.service;

import com.zzq.dao.UserDao;

/**
 * @Description UserService实现类
 * @ClassName UserServiceImpl
 * @Author zzq
 * @Date 2021/6/28 16:24
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getAllUser() {
        userDao.getAllUser();
    }
}
