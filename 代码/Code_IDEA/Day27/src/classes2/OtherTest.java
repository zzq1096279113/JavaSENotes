package classes2;

import classes1.Person;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author zzq
 * @creat 2020-06-04 8:55
 */
public class OtherTest {
    /*
        获取构造器结构
    */
    @Test
    public void test1(){
        Class<Person> personClass = Person.class;

        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor<?>[] constructors = personClass.getConstructors();
        for(Constructor c : constructors){
            System.out.println(c);
        }
        System.out.println("******************************************");
        //getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
        Constructor<?>[] dC = personClass.getDeclaredConstructors();
        for(Constructor c : dC){
            System.out.println(c);
        }
    }




    @Test
    public void test2(){
        Class<Person> personClass = Person.class;
        //获取运行时类的父类
        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);

        //获取运行时类的带泛型的父类
        Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println(genericSuperclass);

        //获取泛型类型
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
    }



    @Test
    public void test3(){
        Class<Person> personClass = Person.class;
        //获取运行时类实现的接口
        Class<?>[] interfaces = personClass.getInterfaces();
        for(Class c : interfaces){
            System.out.println(c);
        }
        System.out.println("******************************************");
        Class<? super Person> superclass = personClass.getSuperclass();
        Class<?>[] interfaces1 = superclass.getInterfaces();
        for(Class c : interfaces1){
            System.out.println(c);
        }
    }



    @Test
    public void test4(){
        Class<Person> personClass = Person.class;
        //获取运行时类所在的包
        Package aPackage = personClass.getPackage();
        System.out.println(aPackage);
    }



    @Test
    public void test5(){
        Class<Person> personClass = Person.class;
        //获取运行时类声明的注解
        Annotation[] annotations = personClass.getAnnotations();
        System.out.println(annotations[0]);
    }
}
