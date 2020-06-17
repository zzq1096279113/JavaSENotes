package classes1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *  java内置的4大核心函数式接口
 *      消费型接口 Consumer<T>     void accept(T t)
 *      供给型接口 Supplier<T>     T get()
 *      函数型接口 Function<T,R>   R apply(T t)
 *      断定型接口 Predicate<T>    boolean test(T t)
 *
 * @author zzq
 * @creat 2020-06-07 10:20
 */
public class LambdaTest2 {

    @Test
    public void test1() {
        happyTime(200, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("存款：" + aDouble);
            }
        });
        System.out.println("***********************");
        happyTime(500,aDouble -> System.out.println("存款：" + aDouble));
    }

    public void happyTime(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }



    @Test
    public void test2() {
        List<String> list = Arrays.asList("北京","南京","天津","东京","西京","普京");
        List<String> jing1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(jing1);
        System.out.println("*****************************");
        List<String> jing2 = filterString(list, s -> s.contains("京"));
        System.out.println(jing2);
    }

    //根据给定的规则过滤集合中的字符串。规则由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> strings = new ArrayList<>();
        for(String s : list){
            if(pre.test(s)){
                strings.add(s);
            }
        }
        return strings;
    }
}
