package exer;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *  创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 *      1). 使 Employee 实现 Comparable 接口，并按 name 排序
 *      2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排序
 *
 * @author zzq
 * @creat 2020-05-29 13:42
 */
public class TreeSetTest {
    //1). 使 Employee 实现 Comparable 接口，并按 name 排序
    @Test
    public void test1(){
        TreeSet treeSet = new TreeSet();

        Employee e1 = new Employee("liudehua",55,new MyDate(1965,5,4));
        Employee e2 = new Employee("zhangxueyou",43,new MyDate(1987,5,4));
        Employee e3 = new Employee("guofucheng",44,new MyDate(1987,5,9));
        Employee e4 = new Employee("liming",51,new MyDate(1954,8,12));
        Employee e5 = new Employee("liangzhaowei",21,new MyDate(1978,12,4));

        treeSet.add(e1);
        treeSet.add(e2);
        treeSet.add(e3);
        treeSet.add(e4);
        treeSet.add(e5);

        Iterator iterator = treeSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    //2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排序
    @Test
    public void test2(){
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee) {
                    Employee employee1 = (Employee) o1;
                    Employee employee2 = (Employee) o2;
                    MyDate birthday1 = employee1.getBirthday();
                    MyDate birthday2 = employee2.getBirthday();

                    //方式一：
//                    if(birthday1.getYear() == birthday2.getYear()){
//                        if(birthday1.getMonth() == birthday2.getMonth()){
//                            return Integer.compare(birthday1.getDay(),birthday2.getDay());
//                        }
//                        return Integer.compare(birthday1.getMonth(),birthday2.getMonth());
//                    }
//                    return Integer.compare(birthday1.getYear(),birthday2.getYear());
//                }
//                throw new RuntimeException("数据类型错误");

                    //方式二：
                    return birthday1.compareTo(birthday2);
                }
                throw new RuntimeException("数据类型错误");
            }
        });

        Employee e1 = new Employee("liudehua",55,new MyDate(1965,5,4));
        Employee e2 = new Employee("zhangxueyou",43,new MyDate(1987,5,4));
        Employee e3 = new Employee("guofucheng",44,new MyDate(1987,5,9));
        Employee e4 = new Employee("liming",51,new MyDate(1954,8,12));
        Employee e5 = new Employee("liangzhaowei",21,new MyDate(1978,12,4));

        treeSet.add(e1);
        treeSet.add(e2);
        treeSet.add(e3);
        treeSet.add(e4);
        treeSet.add(e5);

        Iterator iterator = treeSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
