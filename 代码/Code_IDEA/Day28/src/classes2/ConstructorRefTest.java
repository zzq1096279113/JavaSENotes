package classes2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *      和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致。
 *      抽象方法的返回值类型即为构造器所属的类的类型
 *
 * 二、数组引用
 *     大家可以把数组看做是一个特殊的类，则写法与构造器引用一致。
 *
 * @author zzq
 * @creat 2020-06-07 14:59
 */
public class ConstructorRefTest {

	//构造器引用
    //Supplier中的T get()
    //Employee的空参构造器：Employee()
    @Test
    public void test1(){
        Supplier<Employee> s1 = () -> new Employee();
        System.out.println(s1.get());
        System.out.println("*******************");
        Supplier<Employee> s2 = Employee::new;
        System.out.println(s2.get());
    }

	//Function中的R apply(T t)
    @Test
    public void test2(){
        Function<Integer,Employee> f1 = id -> new Employee(id);
        Employee apply1 = f1.apply(2020);
        System.out.println(apply1);
        System.out.println("*******************");
        Function<Integer,Employee> f2 = Employee::new;
        Employee apply2 = f2.apply(2021);
        System.out.println(apply2);
    }

	//BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){
        BiFunction<Integer,String,Employee> b1 = (id,name) -> new Employee(id,name);
        Employee tom = b1.apply(2001, "Tom");
        System.out.println(tom);
        System.out.println("*******************");
        BiFunction<Integer,String,Employee> b2 = Employee::new;
        Employee jerry = b2.apply(2002, "Jerry");
        System.out.println(jerry);
    }

	//数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
        Function<Integer,String[]> f1 = length -> new String[length];
        String[] apply1 = f1.apply(5);
        System.out.println(Arrays.toString(apply1));
        Function<Integer,String[]> f2 = String[] :: new;
        String[] apply2 = f2.apply(10);
        System.out.println(Arrays.toString(apply2));
    }
}
