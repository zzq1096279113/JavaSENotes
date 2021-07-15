package com.zzq.mapper;

import com.zzq.pojo.User;

import java.util.List;

/**
 * @Description TODO
 * @ClassName UserMapper
 * @Author zzq
 * @Date 2021/7/1 15:18
 */
public interface UserMapper {

    public void addUser(User user);

    public void deleteUserById(int id);

    public void updateUser(User user);

    public List<User> getAllUser();

}
