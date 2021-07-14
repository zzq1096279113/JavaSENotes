import com.zzq.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description 测试类
 * @ClassName MyTest
 * @Author zzq
 * @Date 2021/6/30 15:03
 */
public class MyTest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("user");
        System.out.println(user);
    }
}
