package classes1;

import classes.Person;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author zzq
 * @creat 2020-05-29 9:02
 */
public class TreeSetTest {

    /*
        1.向TreeSet中添加的数据，要求是相同类的对象。
        2.两种排序方式：自然排序（实现Comparable接口）和定制排序（Comparator）
        3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0.不再是equals().
        4.定制排序中，比较两个对象是否相同的标准为：compare()返回0.不再是equals().
    */
    @Test
    public void test1(){
        TreeSet treeSet = new TreeSet();

        //失败：不能添加不同类的对象
//        treeSet.add(123);
//        treeSet.add(789);
//        treeSet.add("ABC");

        //例一：
//        treeSet.add(34);
//        treeSet.add(-34);
//        treeSet.add(43);
//        treeSet.add(11);
//        treeSet.add(8);

        //例二；
//        treeSet.add("张三");
//        treeSet.add("赵五");
//        treeSet.add("李四");
//        treeSet.add("王二");

        treeSet.add(new Person("Tom",12));
        treeSet.add(new Person("Jerry",32));
        treeSet.add(new Person("Jim",2));
        treeSet.add(new Person("Mike",65));
        treeSet.add(new Person("Jack",33));
        treeSet.add(new Person("Jack",56));

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }



    @Test
    public void test2(){
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person)o1;
                    Person p2 = (Person)o2;
                    return Integer.compare(p1.getAge(),p2.getAge());
                }else
                    throw new RuntimeException("输入类型错误");
            }
        });

        treeSet.add(new Person("Tom",12));
        treeSet.add(new Person("Jerry",32));
        treeSet.add(new Person("Jim",2));
        treeSet.add(new Person("Mike",65));
        treeSet.add(new Person("Marry",33));
        treeSet.add(new Person("Jack",33));
        treeSet.add(new Person("Jack",56));

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
