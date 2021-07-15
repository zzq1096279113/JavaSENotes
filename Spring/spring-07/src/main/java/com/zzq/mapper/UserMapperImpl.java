package com.zzq.mapper;

import com.zzq.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * @Description TODO
 * @ClassName UserMapperImpl
 * @Author zzq
 * @Date 2021/7/1 16:58
 */
public class UserMapperImpl implements UserMapper {

    private SqlSessionTemplate sqlSession;

    @Override
    public void addUser(User user) {
        sqlSession.getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public void deleteUserById(int id) {
        sqlSession.getMapper(UserMapper.class).deleteUserById(id);
    }

    @Override
    public void updateUser(User user) {
        sqlSession.getMapper(UserMapper.class).updateUser(user);
    }

    @Override
    public List<User> getAllUser() {
        return sqlSession.getMapper(UserMapper.class).getAllUser();
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }
}
