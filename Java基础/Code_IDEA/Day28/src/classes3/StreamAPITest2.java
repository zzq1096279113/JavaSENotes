package classes3;

import classes2.Employee;
import classes2.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zzq
 * @creat 2020-06-07 17:27
 */
public class StreamAPITest2 {
    //1-匹配与查找
    @Test
    public void test1(){

        List<Employee> employees = EmployeeData.getEmployees();

        //allMatch(Predicate p) —— 检查是否匹配所有元素。
        boolean b1 = employees.stream().allMatch(employee -> employee.getAge() > 18);//练习：是否所有的员工的年龄都大于18
        System.out.println(b1);
        System.out.println();

        //anyMatch(Predicate p) —— 检查是否至少匹配一个元素。
        boolean b2 = employees.stream().anyMatch(employee -> employee.getSalary() > 9000);//练习：是否存在员工的工资大于 9000
        System.out.println(b2);
        System.out.println();

        //noneMatch(Predicate p) —— 检查是否没有匹配的元素。
        boolean b3 = employees.stream().noneMatch(employee -> employee.getName().startsWith("雷"));//练习：是否存在员工姓“雷”
        System.out.println(b3);
        System.out.println();

        //findFirst —— 返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
        System.out.println();
    }



    @Test
    public void test2(){

        List<Employee> employees = EmployeeData.getEmployees();

        //findAny——返回当前流中的任意元素
        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);
        System.out.println();

        //count——返回流中元素的总个数
        Stream<Employee> employeeStream = employees.stream().filter(employee -> employee.getSalary() > 5000);
        long count = employeeStream.count();
        System.out.println(count);
        System.out.println();

        //max(Comparator c)——返回流中最大值
        Stream<Double> doubleStream = employees.stream().map(employee -> employee.getSalary());
        Optional<Double> max = doubleStream.max(Double::compare);
        System.out.println(max);
        System.out.println();

        //min(Comparator c)——返回流中最小值
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);
        System.out.println();

        //forEach(Consumer c)——内部迭代
        employees.stream().forEach(System.out::println);
    }



    //2-归约
    @Test
    public void test3(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //reduce(T identity, BinaryOperator)——可以将流中元素反复结合起来，得到一个值。返回 T
        Integer reduce1 = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce1);

        //reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);
        Optional<Double> reduce2 = salaryStream.reduce(Double::sum);
        System.out.println(reduce2);
    }



    //3-收集
    @Test
    public void test4(){
        //collect(Collector c)——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect1 = employees.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toList());
        collect1.forEach(System.out::println);
        System.out.println();

        Set<Employee> collect2 = employees.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toSet());
        collect2.forEach(System.out::println);
    }
}
