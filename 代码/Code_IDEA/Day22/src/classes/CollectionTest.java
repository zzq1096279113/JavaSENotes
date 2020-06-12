package classes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection接口中声明的方法的测试
 * 结论：
 *  向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().
 *
 * @author zzq
 * @creat 2020-05-28 10:08
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(false);
        collection.add(new Person("Jerry",20));
        collection.add(new String("Tom"));

        //1.contains(Object obj):判断当前集合中是否包含obj
        //我们在判断时会调用obj对象所在类的equals()方法
        boolean contains = collection.contains(123);
        System.out.println(contains);
        System.out.println(collection.contains(new String("Tom")));
        System.out.println(collection.contains(new Person("Jerry",20)));
        System.out.println("*************************");

        //2.//2.containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中。
        Collection collection1 = Arrays.asList(false,123);
        System.out.println(collection.containsAll(collection1));
        System.out.println("*************************");

        //3.remove(Object obj):从当前集合中移除obj元素。
        boolean remove = collection.remove(123);
        System.out.println(collection);
        System.out.println(collection.remove(new Person("Jerry", 20)));

        //4. removeAll(Collection coll1):差集：从当前集合中移除coll1中所有的元素。
        Collection collection2 = Arrays.asList(123,567,false);
        boolean b = collection.removeAll(collection2);
        System.out.println(b);
        System.out.println(collection);

    }


    @Test
    public void test2(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(678);
        collection.add(false);
        collection.add(new Person("Jerry",20));
        collection.add(new String("Tom"));

        //5.retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合
//        Collection collection1 = Arrays.asList(123,false,459);
//        collection.retainAll(collection1);
//        System.out.println(collection);

        //6.equals(Object obj):要想返回true，需要当前集合和形参集合的元素都相同。
        Collection collection2 = new ArrayList();
        collection2.add(678);
        collection2.add(123);
        collection2.add(false);
        collection2.add(new Person("Jerry",20));
        collection2.add(new String("Tom"));
        boolean equals = collection.equals(collection2);
        System.out.println(equals);

    }


    @Test
    public void test3() {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(678);
        collection.add(false);
        collection.add(new Person("Jerry", 20));
        collection.add(new String("Tom"));

        //7.hashCode():返回当前对象的哈希值
        int i = collection.hashCode();
        System.out.println(i);

        //8.集合--->数组：toArray()
        Object[] objects = collection.toArray();
        for (int j = 0; j < objects.length; j++) {
            System.out.println(objects[j]);
        }
        //拓展：数组 --->集合:调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "bb", "cC"});
        System.out.println(list);
        
    }
}
