package classes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk 5.0 新增了foreach循环，用于遍历集合、数组
 *
 * @author zzq
 * @creat 2020-05-28 14:10
 */
public class ForTest {

    @Test
    public void test1() {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(678);
        collection.add(false);
        collection.add(new Person("Jerry", 20));
        collection.add(new String("Tom"));

        //for(集合元素的类型 局部变量 : 集合对象)
        for (Object obj : collection) {
            System.out.println(obj);
        }
    }

    @Test
    public void test2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        //for(数组元素的类型 局部变量 : 数组对象)
        for (int i : arr) {
            System.out.println(i);
        }
    }

    @Test
    public void test3() {
        String[] arr = new String[]{"MM","MM","MM"};

        //方式一：普通for赋值
//        for(int i = 0;i < arr.length;i++){
//            arr[i] = "GG";
//        }
//        for(int i = 0;i < arr.length;i++){
//            System.out.println(arr[i]);
//        }

        //方式二：增强for循环
        for(String s:arr){//对s进行修改原来数组没有变化
            s = "GG";
        }
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }


    }
}
