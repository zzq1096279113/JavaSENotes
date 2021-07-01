package mapper;

import com.zzq.mapper.UserMapper;
import com.zzq.pojo.User;
import com.zzq.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @Description TODO
 * @ClassName UseMapperTest
 * @Author zzq
 * @Date 2021/6/22 10:03
 */
public class UseMapperTest {
    @Test
    public void test1() {
        SqlSession sqlSession = null;
        try {
            // 1.获取 SqlSession 对象
            sqlSession = MybatisUtils.getSqlSession();
            // 执行sql
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(2);
        System.out.println(user);
        sqlSession.close();
    }


    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(4, "zzm", "12345678"));
        // 增删改查需要提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test4() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(1, "zzj", "98765432"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test5() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(2);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test6() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);
        List<User> users = mapper.getUserByLimit(map);
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
