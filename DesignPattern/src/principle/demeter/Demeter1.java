package principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 迪米特法则
 * @ClassName Demeter1
 * @Author zzq
 * @Date 2020/9/12 16:35
 */
public class Demeter1 {
    public static void main(String[] args) {
        SchoolManager schoolManager = new SchoolManager();
        schoolManager.printAllEmployee(new TemporaryManager());
    }
}


/**
 * @Description 学校正式员工类
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 16:36
 */
class Employee {
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
class TemporaryEmployee {
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
class TemporaryManager {
    /**
     * @Description 返回所用的临时工
     * @Param []
     * @Return java.util.List<principle.demeter.TemporaryEmployee>
     * @Author zzq
     * @Date 2020/9/12 16:44
     */
    public List<TemporaryEmployee> getAllEmployee() {
        TemporaryEmployee emp;
        List<TemporaryEmployee> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {  //增加10个临时工
            emp = new TemporaryEmployee();
            emp.setId("学院临时工id:" + i);
            list.add(emp);
        }
        return list;
    }
}

/**
 * @Description 学校正式员工的管理类
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 16:43
 */
class SchoolManager {
    /**
     * @Description 返回所用的正式员工
     * @Param []
     * @Return java.util.List<principle.demeter.Employee>
     * @Author zzq
     * @Date 2020/9/12 16:44
     */
    public List<Employee> getAllEmployee() {
        Employee emp;
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {   //增加5个员工
            emp = new Employee();
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
    void printAllEmployee(TemporaryManager sub) {
        System.out.println("------------学院临时工------------");
        List<TemporaryEmployee> list1 = sub.getAllEmployee();   //获取所有临时工信息
        for (TemporaryEmployee e : list1) {
            System.out.println(e.getId());
        }
        System.out.println("------------学校总部员工------------");
        List<Employee> list2 = this.getAllEmployee();   ////获取到学校正式员工信息
        for (Employee e : list2) {
            System.out.println(e.getId());
        }
    }
}
