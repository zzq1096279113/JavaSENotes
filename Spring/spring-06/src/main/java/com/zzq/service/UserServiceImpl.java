package com.zzq.service;

/**
 * @Description UserService实现类
 * @ClassName UserServiceImpl
 * @Author zzq
 * @Date 2021/7/1 11:17
 */
public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("add方法");
    }

    @Override
    public void delete() {
        System.out.println("delete方法");
    }

    @Override
    public void update() {
        System.out.println("update方法");
    }

    @Override
    public void query() {
        System.out.println("query方法");
    }
}
