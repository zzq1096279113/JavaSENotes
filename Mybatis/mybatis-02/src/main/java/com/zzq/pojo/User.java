package com.zzq.pojo;

import org.apache.ibatis.type.Alias;

/**
 * @Description User实体类
 * @ClassName User
 * @Author zzq
 * @Date 2021/6/22 9:44
 */
@Alias("user")
public class User {
    private int id;
    private String name;
    private String password;

    public User() {
    }

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.password = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + password + '\'' +
                '}';
    }
}
