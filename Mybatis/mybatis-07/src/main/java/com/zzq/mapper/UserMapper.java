package com.zzq.mapper;

import com.zzq.pojo.User;

import java.util.List;

/**
 * @Description TODO
 * @ClassName UserMapper
 * @Author zzq
 * @Date 2021/6/27 10:35
 */
public interface UserMapper {

    /**
     * @Description 查询所有用户
     * @Param []
     * @Return java.util.List<com.zzq.pojo.User>
     * @Author zzq
     * @Date 2021/6/27 10:39
     */
    List<User> getAllUser();

    /**
     * @Description 通过用户id查询用户
     * @Param [id]
     * @Return com.zzq.pojo.User
     * @Author zzq
     * @Date 2021/6/27 10:41
     */
    User queryUserById(int id);

    /**
     * @Description 修改用户
     * @Param [user]
     * @Return void
     * @Author zzq
     * @Date 2021/6/27 10:51
     */
    void updateUser(User user);
}
