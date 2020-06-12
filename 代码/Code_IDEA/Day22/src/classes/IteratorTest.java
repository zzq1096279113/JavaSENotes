package classes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用迭代器Iterator接口
 * 1.内部的方法：hasNext()和next()
 * 2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
 * 3.内部定义了remove(),可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()
 * 如果还未调用next()或在上一次调用next()方法之后已经调用了 remove 方法，再调用remove都会报IllegalStateException。
 *
 * @author zzq
 * @creat 2020-05-28 13:34
 */
public class IteratorTest {

    @Test
    public void test1() {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(678);
        collection.add(false);
        collection.add(new Person("Jerry", 20));
        collection.add(new String("Tom"));

        Iterator iterator = collection.iterator();
        //方式一：
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());//报异常：NoSuchElementException

        //方式二：不推荐
//        for (int i = 0; i < collection.size(); i++) {
//            System.out.println(iterator.next());
//        }

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    @Test
    public void test2() {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(678);
        collection.add(false);
        collection.add(new Person("Jerry", 20));
        collection.add(new String("Tom"));
        Iterator iterator = collection.iterator();

        //错误方式一：
//        while((iterator.next()) != null){
//            System.out.println(iterator.next());
//        }

        //错误方式二：
//        while (collection.iterator().hasNext()){  //集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
//            System.out.println(collection.iterator().next());
//        }
    }


    @Test
    public void test3() {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(678);
        collection.add(false);
        collection.add(new Person("Jerry", 20));
        collection.add(new String("Tom"));
        Iterator iterator = collection.iterator();

        while (iterator.hasNext()) {
            Object o = iterator.next();
            if ("Tom".equals(o)) {
                iterator.remove();
            }
        }

        iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
