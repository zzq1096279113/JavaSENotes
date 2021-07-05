package com.zzq.mapper;

import com.zzq.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @ClassName UserMapper
 * @Author zzq
 * @Date 2021/6/27 16:05
 */
public interface UserMapper {
    /**
     * @Description 通过userCode获取User
     * @Param [userCode]
     * @Return com.zzq.pojo.User
     * @Author zzq
     * @Date 2021/6/27 16:06
     */
    public User getLoginUser(@Param("userCode") String userCode);

    /**
     * @Description 增加用户信息
     * @Param [user]
     * @Return int
     * @Author zzq
     * @Date 2021/6/27 16:06
     */
    public void add(User user);

    /**
     * @Description 通过条件查询userList
     * @Param [userName, userRole, from, pageSize]
     * @Return java.util.List<com.zzq.pojo.User>
     * @Author zzq
     * @Date 2021/6/27 16:06
     */
    public List<User> getUserList(@Param("userName") String userName,
                                  @Param("userRole") Integer userRole,
                                  @Param("from") Integer from,
                                  @Param("pageSize") Integer pageSize);

    /**
     * @Description 通过条件查询-用户记录数
     * @Param [userName, userRole]
     * @Return int
     * @Author zzq
     * @Date 2021/6/27 16:06
     */
    public int getUserCount(@Param("userName") String userName,
                            @Param("userRole") Integer userRole);

    /**
     * @Description 通过userId删除user
     * @Param [id]
     * @Return int
     * @Author zzq
     * @Date 2021/6/27 16:05
     */
    public void deleteUserById(@Param("id") Integer id);

    /**
     * @Description 通过useId获取user
     * @Param [id]
     * @Return com.zzq.pojo.User
     * @Author zzq
     * @Date 2021/6/27 16:05
     */
    public User getUserById(@Param("id") Integer id);

    /**
     * @Description 修改用户信息
     * @Param [user]
     * @Return int
     * @Author zzq
     * @Date 2021/6/27 16:05
     */
    public void modify(User user);

    /**
     * @Description 修改当前用户密码
     * @Param [id, pwd]
     * @Return int
     * @Author zzq
     * @Date 2021/6/27 16:05
     */
    public void updatePwd(@Param("id") Integer id,@Param("pwd") String pwd);

}
