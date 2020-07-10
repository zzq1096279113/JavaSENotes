package classes;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author zzq
 * @creat 2020-06-03 16:22
 */
public class NewInstanceTest {
    /*
    newInstance():调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参的构造器。
    要想此方法正常的创建运行时类的对象，要求：
        1.运行时类必须提供空参的构造器
        2.空参的构造器的访问权限得够。通常，设置为public。
    在javabean中要求提供一个public的空参构造器。原因：
        1.便于通过反射，创建运行时类的对象
        2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器

         */
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> pC = Person.class;
        Person person = pC.newInstance();
        System.out.println(person);
    }



    //体会反射的动态性
    @Test
    public void test2(){
        int i = new Random().nextInt(3);
        String classPath = "";
        switch (i){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "classes.Person";
                break;
        }
        try {
            Object instance = getInstance(classPath);
            System.out.println(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
    创建一个指定类的对象。
    classPath:指定类的全类名
    */
    public Object getInstance(String classPath) throws Exception {
        Class clazz =  Class.forName(classPath);
        return clazz.getDeclaredConstructor().newInstance();
    }
}
