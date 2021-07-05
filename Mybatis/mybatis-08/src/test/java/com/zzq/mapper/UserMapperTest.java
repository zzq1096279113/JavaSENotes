package com.zzq.mapper;

import com.zzq.pojo.User;
import com.zzq.utils.MybatisUtils;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @ClassName UserMapperTest
 * @Author zzq
 * @Date 2021/6/27 19:57
 */
public class UserMapperTest extends TestCase {

    public void testGetLoginUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getLoginUser("hanlubiao");
        System.out.println(user);
    }

    public void testAdd() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.add(new User(null, "admin", "系统管理员", "1234567", 1, new Date(), "13688889999", "北京市海淀区成府路207号", 1, 1, new Date(), null, null, null, null));
    }

    public void testGetUserList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUserList(null, 3, 0, 5);
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void testGetUserCount() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count = mapper.getUserCount(null, 3);
        System.out.println(count);
    }

    public void testDeleteUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUserById(2);
    }

    public void testGetUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(2);
        System.out.println(user);
    }

    public void testModify() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.modify(new User(1, "admin", "系统管理员", "1234567", 1,null, "13688889999", "北京市海淀区成府路207号", 1, null,null, 2, new Date(), null, null));
    }

    public void testUpdatePwd() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updatePwd(8, "7654321");
    }
}