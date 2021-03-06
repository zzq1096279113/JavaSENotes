package com.zzq.dao;

import com.zzq.entity.User;

/**
 * @Description TODO
 * @ClassName UserDao
 * @Author zzq
 * @Date 2021/2/21 9:55
 */
public interface UserDao {
    /**
     * @Description 根据用户名查询信息
     * @Param [username]
     * @Return com.zzq.entity.User
     * @Author zzq
     * @Date 2021/2/21 9:56
     */
    public User selectUserByUsername(String username);

    /**
     * @Description 根据用户名和密码查询用户
     * @Param [username, password]
     * @Return com.zzq.entity.User
     * @Author zzq
     * @Date 2021/2/21 10:02
     */
    public User selectUserByUsernamePassword(String username, String password);

    /**
     * @Description 保存用户信息
     * @Param [user]
     * @Return int
     * @Author zzq
     * @Date 2021/2/21 10:01
     */
    public int saveUser(User user);
}
