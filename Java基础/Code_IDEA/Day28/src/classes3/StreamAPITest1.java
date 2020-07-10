package classes3;

import classes2.Employee;
import classes2.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author zzq
 * @creat 2020-06-07 16:42
 */
public class StreamAPITest1 {
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();

        //filter(Predicate p)——接收 Lambda ， 从流中排除某些元素。
        employees.stream().filter(employee -> employee.getSalary() > 7000).forEach(System.out::println);
        System.out.println();

        //limit(n)——截断流，使其元素不超过给定数量。
        employees.stream().limit(3).forEach(System.out::println);
        System.out.println();

        //skip(n) —— 跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补
        employees.stream().skip(4).forEach(System.out::println);
        System.out.println();

        //distinct()——筛选，通过流所生成元素的hashCode()和equals()去除重复元素
        employees.add(new Employee(1010,"刘强东",40,8000));
        employees.add(new Employee(1010,"刘强东",41,8000));
        employees.stream().distinct().forEach(System.out::println);

    }




    //映射
    @Test
    public void test2(){
        //map(Function f)——接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println();

        //练习1
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> stringStream = employees.stream().map(Employee::getName);//获取name的stream
        stringStream.filter(name -> name.length() > 3).forEach(System.out::println);//对name的stream进行筛选
        System.out.println();

        //练习2
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);
        streamStream.forEach(s ->{s.forEach(System.out::println);});
        System.out.println();

        //flatMap(Function f)——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest1::fromStringToStream);
        characterStream.forEach(System.out::println);
    }

    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for(Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }



    //排序
    @Test
    public void test3(){
        //sorted()——自然排序
        List<Integer> list = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);
        list.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com)——定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted( (e1,e2) -> {
            int compare = Integer.compare(e1.getAge(), e2.getAge());
            if(compare == 0){
                return Double.compare(e1.getSalary(),e2.getSalary());
            }else
                return compare;
        }).forEach(System.out::println);
    }
}
