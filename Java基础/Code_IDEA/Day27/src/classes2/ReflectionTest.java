package classes2;

import classes1.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构：属性、方法、构造器
 *
 * @author zzq
 * @creat 2020-06-04 10:01
 */
public class ReflectionTest {



    @Test
    public void test1() throws Exception {
        Class<Person> personClass = Person.class;
        Person person = personClass.getConstructor().newInstance();

        //获取指定的属性：要求运行时类中属性声明为public    (通常不采用此方法)
        Field id = personClass.getField("id");

        //设置当前属性的值
        //set():参数1：指明对象   参数2：修改参数
        id.set(person,10086);

        //获取当前属性的值
        //get():参数1：指明对象
        id.get(person);

    }



    //如何操作运行时类中的指定的属性 -- 需要掌握
    @Test
    public void test2() throws Exception {
        Class<Person> personClass = Person.class;
        Person person = personClass.getConstructor().newInstance();

        //1. getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name = personClass.getDeclaredField("name");

        //2.保证当前属性是可访问的
        name.setAccessible(true);

        //3.获取、设置指定对象的此属性值
        name.set(person,"Tom");
        System.out.println(name.get(person));

    }



    @Test
    public void test3() throws Exception {
        Class<Person> personClass = Person.class;
        Person person = personClass.getConstructor().newInstance();

        //1.获取指定的某个方法   getDeclaredMethod():参数1 ：指明方法名称  参数2：指明方法形参列表
        Method show = personClass.getDeclaredMethod("show", String.class);

        //2.保证当前方法是可访问的
        show.setAccessible(true);

        //3.调用方法    invoke():参数1：方法的调用者  参数2：给方法形参赋值的实参
        String china = (String) show.invoke(person, "China");
        System.out.println(china);

        System.out.println("*************如何调用静态方法*****************");
        Method showDesc = personClass.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        showDesc.invoke(Person.class);
    }



    @Test
    public void test4() throws Exception {
        Class<Person> personClass = Person.class;

        //1.获取指定的构造器    getDeclaredConstructor():参数：指明构造器的参数列表
        Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class);

        //2.保证此构造器是可访问的
        constructor.setAccessible(true);

        //3.调用此构造器创建运行时类的对象
        Person person = constructor.newInstance("Jerry");
        System.out.println(person);
    }
}
