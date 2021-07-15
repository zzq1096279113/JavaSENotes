package com.zzq.mapper;

import com.zzq.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.apache.ibatis.io.Resources;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @ClassName UserMapperTest
 * @Author zzq
 * @Date 2021/7/1 15:28
 */
public class UserMapperTest {

    @Test
    public void addUser() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        List<User> users = userMapper.getAllUser();
        for (User user: users){
            System.out.println(user);
        }
    }

    @Test
    public void deleteUserById() {
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void getAllUser() {
    }
}