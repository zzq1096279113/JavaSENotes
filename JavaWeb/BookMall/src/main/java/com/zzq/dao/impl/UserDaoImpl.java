package com.zzq.dao.impl;

import com.zzq.dao.BaseDao;
import com.zzq.dao.UserDao;
import com.zzq.entity.User;

/**
 * @Description TODO
 * @ClassName UserDaoImpl
 * @Author zzq
 * @Date 2021/2/21 10:02
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User selectUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where `username`=?";
        return selectOne(User.class, sql, username);
    }

    @Override
    public User selectUserByUsernamePassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where `username`=? and `password`=?";
        return selectOne(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`) values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
