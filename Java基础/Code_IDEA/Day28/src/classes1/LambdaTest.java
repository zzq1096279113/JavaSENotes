package classes1;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

/**
 * @author zzq
 * @creat 2020-06-07 8:59
 */
public class LambdaTest {
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        r1.run();
        System.out.println("***********************");
        Runnable r2 = () -> System.out.println("我爱北京故宫");
        r2.run();
    }



    @Test
    public void test2() {
        //正常写法
        Comparator<Integer> c1 = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = c1.compare(12, 21);
        System.out.println(compare1);
        System.out.println("***********************");

        //Lambda表达式的写法
        Comparator<Integer> c2 = (o1, o2) -> Integer.compare(o1, o2);
        int compare2 = c2.compare(32, 21);
        System.out.println(compare2);
        System.out.println("***********************");

        //方法引用
        Comparator<Integer> c3 = Integer :: compare;
        int compare3 = c3.compare(32,32);
        System.out.println(compare3);
    }
}
