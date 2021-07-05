package com.zzq.mapper;

import com.zzq.pojo.Role;
import com.zzq.utils.MybatisUtils;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @ClassName RoleMapperTest
 * @Author zzq
 * @Date 2021/6/27 19:46
 */
public class RoleMapperTest extends TestCase {

    public void testGetRoleList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roles = mapper.getRoleList();
        for (Role role : roles) {
            System.out.println(role);
        }
    }

    public void testAdd() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        mapper.add(new Role(null, "SMBMS_ADMIN", "系统管理员", 1, new Date(), null, null));
    }

    public void testDeleteRoleById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        mapper.deleteRoleById(2);
    }

    public void testModify() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        mapper.modify(new Role(2, "SMBMS_ADMIN", "系统管理员", null, null, 2, new Date()));
    }

    public void testGetRoleById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        Role role = mapper.getRoleById(3);
        System.out.println(role);
    }

    public void testRoleCodeIsExist() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        int count = mapper.roleCodeIsExist("SMBMS_EMPLOYEE");
        System.out.println(count);
    }
}