package classes2;

import classes1.Person;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author zzq
 * @creat 2020-06-04 8:00
 */
public class FieldTest {
    @Test
    public void test1(){
        Class<Person> personClass = Person.class;

        //getFields()：获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = personClass.getFields();
        for(Field f : fields){
            System.out.println(f);
        }
        System.out.println("******************************************");
        //getDeclaredFields()：获取当前运行时类中声明的所有属性。（不包含父类中声明的属性）
        Field[] declaredFields = personClass.getDeclaredFields();
        for(Field dF : declaredFields){
            System.out.println(dF);
        }
    }


    @Test
    public void test2(){
        Class<Person> personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();
        for(Field dF : declaredFields){
            //1.权限修饰符
            int modifiers = dF.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");
            //2.数据类型
            Class<?> type = dF.getType();
            System.out.print(type.getName() + " ");
            //3.变量名
            String name = dF.getName();
            System.out.print(name);
            System.out.println();
        }
    }
}
