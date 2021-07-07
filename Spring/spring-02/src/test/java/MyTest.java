import com.zzq.pojo.Hello;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description 测试类
 * @ClassName MyTest
 * @Author zzq
 * @Date 2021/6/29 10:25
 */
public class MyTest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello);
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello world = (Hello) context.getBean("world");
        System.out.println(world);
    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello spring = (Hello) context.getBean("spring");
        System.out.println(spring);
    }

    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello mybatis = (Hello) context.getBean("mybatis");
        System.out.println(mybatis);
    }

    @Test
    public void test5() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello helloMybatis = (Hello) context.getBean("helloMybatis");
        System.out.println(helloMybatis);
    }

    @Test
    public void test6() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello hm = (Hello) context.getBean("hm");
        System.out.println(hm);
    }
}
