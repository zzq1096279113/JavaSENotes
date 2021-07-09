import com.zzq.pojo.Student;
import com.zzq.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description 测试类
 * @ClassName MyTest
 * @Author zzq
 * @Date 2021/6/29 20:46
 */
public class MyTest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = context.getBean("user1", User.class);
        System.out.println(user);
    }

    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user1 = context.getBean("user1", User.class);
        User user2 = context.getBean("user1", User.class);
        System.out.println(user1 == user2);
    }
}
