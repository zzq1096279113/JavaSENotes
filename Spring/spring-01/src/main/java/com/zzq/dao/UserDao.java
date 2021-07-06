package com.zzq.dao;

import com.zzq.pojo.User;

import java.util.List;

/**
 * @Description User Dao层
 * @ClassName UserDao
 * @Author zzq
 * @Date 2021/6/28 16:23
 */
public interface UserDao {

    public List<User> getAllUser();

}
