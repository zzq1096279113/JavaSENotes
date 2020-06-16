package classes2;

import classes1.Person;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author zzq
 * @creat 2020-06-04 8:23
 */
public class MethodTest {
    @Test
    public void test1(){
        Class<Person> personClass = Person.class;

        //getMethods():获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = personClass.getMethods();
        for(Method m : methods){
            System.out.println(m);
        }
        System.out.println("******************************************");
        //getDeclaredMethods():获取当前运行时类中声明的所有方法。（不包含父类中声明的方法）
        Method[] dM = personClass.getDeclaredMethods();
        for(Method d : dM){
            System.out.println(d);
        }
    }



    /*
    @Xxxx
    权限修饰符  返回值类型  方法名(参数类型1 形参名1,...) throws XxxException{}
    */
    @Test
    public void test2(){
        Class<Person> personClass = Person.class;

        Method[] dM = personClass.getDeclaredMethods();
        for(Method d : dM){
            //1.获取方法声明的注解
            Annotation[] annotations = d.getAnnotations();
            for(Annotation a : annotations){
                System.out.println(a);
            }

            //2.权限修饰符
            System.out.print(Modifier.toString(d.getModifiers()) + " ");

            //3.返回值类型
            System.out.print(d.getReturnType().getName() + " ");

            //4.方法名
            System.out.print(d.getName());

            //5.形参列表
            Class<?>[] parameterTypes = d.getParameterTypes();
            System.out.print("(");
            if(!(parameterTypes == null && parameterTypes.length == 0)){
                for(int i = 0;i < parameterTypes.length;i++){
                    if(i == parameterTypes.length - 1){
                        System.out.print(parameterTypes[i].getName() + " arg");
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + " args" + ",");
                }
            }
            System.out.print(")");

            //6.抛出的异常
            Class<?>[] exceptionTypes = d.getExceptionTypes();
            if(exceptionTypes.length > 0){
                System.out.print(" throws ");
                for(int i = 0;i < exceptionTypes.length;i++){
                    if(i == exceptionTypes.length - 1){
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }

            System.out.println();
        }
    }
}
