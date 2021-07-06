package com.zzq.dao;

import com.zzq.pojo.User;

import java.util.List;

/**
 * @Description UserDao实现类
 * @ClassName UserDaoMysqlImpl
 * @Author zzq
 * @Date 2021/6/28 16:23
 */
public class UserDaoMysqlImpl implements UserDao {

    @Override
    public List<User> getAllUser() {
        System.out.println("通过Mysql获取所有用户");
        return null;
    }
}
