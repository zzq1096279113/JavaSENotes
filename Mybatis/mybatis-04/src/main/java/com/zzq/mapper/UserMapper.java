package com.zzq.mapper;

import com.zzq.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

/**
 * @Description 使用注解
 * @ClassName UserDao
 * @Author zzq
 * @Date 2021/6/22 9:53
 */
public interface UserMapper {
    // 查询全部用户
    @Select("select * from user")
    List<User> getUserList();

    // 根据ID查询用户
    @Select("select * from user where `id` = #{id}")
    User getUserById(@Param("id") int id);

    // 添加用户
    @Insert("insert into user(`id`, `name`, `pwd`) values (#{id}, #{name}, #{pwd})")
    void addUser(User user);

    // 修改用户
    @Update("update user set `name` = #{name}, `pwd` = #{pwd} where `id` = #{id}")
    void updateUser(User user);

    // 删除用户
    @Delete("delete from user where `id` = #{id}")
    void deleteUser(@Param("id") int id);

    // 分页查询
    List<User> getUserByLimit(HashMap<String, Integer> map);
}
