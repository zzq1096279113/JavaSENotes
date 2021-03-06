package com.zzq.service;

import com.zzq.entity.User;

/**
 * @Description TODO
 * @ClassName UserService
 * @Author zzq
 * @Date 2021/2/23 10:32
 */
public interface UserService {

    public User loginUser(String username, String password);

    public void registeredUser(User user);

    public boolean existUser(String username);
}
