package com.zzq.mapper;

import com.zzq.pojo.User;

import java.util.List;

/**
 * @Description TODO
 * @ClassName UserDao
 * @Author zzq
 * @Date 2021/6/22 9:53
 */
public interface UserMapper {
    // 查询全部用户
    List<User> getUserList();

    // 根据ID查询用户
    User getUserById(int id);

    // 添加用户
    void addUser(User user);

    // 修改用户
    void updateUser(User user);

    // 删除用户
    void deleteUser(int id);
}
