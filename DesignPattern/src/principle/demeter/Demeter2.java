package principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 迪米特法则：已改进
 * @ClassName Demeter2
 * @Author zzq
 * @Date 2020/9/12 17:07
 */
public class Demeter2 {
    public static void main(String[] args) {
        SchoolManager1 schoolManager1 = new SchoolManager1();
        schoolManager1.printAllEmployee(new TemporaryManager1());
    }
}


/**
 * @Description 学校正式员工类
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 16:36
 */
class Employee1 {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}


/**
 * @Description 学校临时工类
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 16:37
 */
class TemporaryEmployee1 {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}


/**
 * @Description 学校临时工的管理类
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 16:37
 */
class TemporaryManager1 {
    /**
     * @Description 返回所用的临时工
     * @Param []
     * @Return java.util.List<principle.demeter.TemporaryEmployee>
     * @Author zzq
     * @Date 2020/9/12 16:44
     */
    public List<TemporaryEmployee1> getAllEmployee() {
        TemporaryEmployee1 emp;
        List<TemporaryEmployee1> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {  //增加10个临时工
            emp = new TemporaryEmployee1();
            emp.setId("学院临时工id:" + i);
            list.add(emp);
        }
        return list;
    }

    /**
     * @Description 打印所有临时工信息
     * @Param
     * @Return
     * @Author zzq
     * @Date 2020/9/12 17:13
     */
    public void printAllEmployee() {
        List<TemporaryEmployee1> list1 = this.getAllEmployee();
        for (TemporaryEmployee1 e : list1) {
            System.out.println(e.getId());
        }
    }
}

/**
 * @Description 学校正式员工的管理类
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 16:43
 */
class SchoolManager1 {
    /**
     * @Description 返回所用的正式员工
     * @Param []
     * @Return java.util.List<principle.demeter.Employee>
     * @Author zzq
     * @Date 2020/9/12 16:44
     */
    public List<Employee1> getAllEmployee() {
        Employee1 emp;
        List<Employee1> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {   //增加5个员工
            emp = new Employee1();
            emp.setId("学校正式员工id:" + i);
            list.add(emp);
        }
        return list;
    }

    /**
     * @Description 打印学校所有员工和临时工信息
     * @Param [sub]
     * @Return void
     * @Author zzq
     * @Date 2020/9/12 16:45
     */
    void printAllEmployee(TemporaryManager1 sub) {
        System.out.println("------------学院临时工------------");
        sub.printAllEmployee();
        System.out.println("------------学校正式员工------------");
        List<Employee1> list2 = this.getAllEmployee();   ////获取到学校正式员工信息
        for (Employee1 e : list2) {
            System.out.println(e.getId());
        }
    }
}
