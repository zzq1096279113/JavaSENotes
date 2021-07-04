import com.zzq.mapper.UserMapper;
import com.zzq.pojo.User;
import com.zzq.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Description 测试缓存
 * @ClassName MyTest
 * @Author zzq
 * @Date 2021/6/27 10:43
 */
public class MyTest {
    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users1 = mapper.getAllUser();
        for (User user: users1){
            System.out.println(user);
        }
        System.out.println("***************************");
        List<User> users2 = mapper.getAllUser();
        for (User user: users2){
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        List<User> users1 = mapper1.getAllUser();
        for (User user: users1){
            System.out.println(user);
        }
        sqlSession1.close();
        System.out.println("***************************");
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        List<User> users2 = mapper2.getAllUser();
        for (User user: users2){
            System.out.println(user);
        }
        sqlSession2.close();
    }
}
