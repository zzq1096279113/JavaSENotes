package com.zzq.service.impl;

import com.zzq.dao.UserDao;
import com.zzq.dao.impl.UserDaoImpl;
import com.zzq.entity.User;
import com.zzq.service.UserService;

/**
 * @Description TODO
 * @ClassName UserServiceImpl
 * @Author zzq
 * @Date 2021/2/23 10:37
 */
public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public User loginUser(String username, String password) {
        return userDao.selectUserByUsernamePassword(username, password);
    }

    @Override
    public void registeredUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public boolean existUser(String username) {
        return null != userDao.selectUserByUsername(username);
    }
}
