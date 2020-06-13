package classes;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 泛型的使用
 *
 * 1.jdk 5.0新增的特性
 *
 * 2.在集合中使用泛型：
 *  总结：
 *      ① 集合接口或集合类在jdk5.0时都修改为带泛型的结构。
 *      ② 在实例化集合类时，可以指明具体的泛型类型。
 *      ③ 指明以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法、构造器、属性等）使用到类的泛型的位置，都指定为实例化的泛型类型。
 *        比如：add(E e) ---> 实例化以后：add(Integer e)
 *      ④ 注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换。
 *      ⑤ 如果实例化时，没有指明泛型的类型。默认类型为Object类型。
 *
 * 3.如何自定义泛型结构：泛型类、泛型接口；泛型方法。见 GenericTest1.java
 *
 * @author zzq
 * @creat 2020-05-30 14:41
 */
public class GenericTest {
    @Test
    public void test1() {
        ArrayList arrayList = new ArrayList();
        //需求：存放学生的成绩
        arrayList.add(78);
        arrayList.add(76);
        arrayList.add(89);
        arrayList.add(88);

        //问题一：类型不安全
//        arrayList.add("Tom");


        for (Object obj : arrayList) {
            //问题二：强转时，可能出现ClassCastException
            int score = (Integer) obj;
            System.out.println(score);
        }
    }


    //在集合中使用泛型的情况：以ArrayList为例
    @Test
    public void test2() {
        ArrayList<Integer> strings = new ArrayList<>();
        strings.add(78);
        strings.add(76);
        strings.add(89);
        strings.add(88);

        //编译时，就会进行类型检查，保证数据的安全
//        strings.add("tom");

        //方式一：
//        for (Integer score : strings){
//            //避免了强转操作
//            int stuScore = score;
//            System.out.println(stuScore);
//        }

        //方式二：
        Iterator<Integer> iterator = strings.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    //在集合中使用泛型的情况：以HashMap为例
    @Test
    public void test3(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Tom",87);
        map.put("Jerry",87);
        map.put("Jack",67);

//        map.put(123,"ABC");
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key + "----" + value);
        }
    }


    //测试泛型方法
    @Test
    public void test4(){
        Order<String> stringOrder = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4,5};
        //泛型方法在调用时，指明泛型参数的类型。
        List<Integer> integers = stringOrder.copyFromArrayToList(arr);
        System.out.println(integers);
    }
}
