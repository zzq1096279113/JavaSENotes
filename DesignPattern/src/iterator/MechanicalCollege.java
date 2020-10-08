package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description 机械工程学院
 * @ClassName MechanicalCollege
 * @Author zzq
 * @Date 2020/10/5 9:18
 */
public class MechanicalCollege implements College {
    public List<Department> departments;

    public MechanicalCollege() {
        this.departments = new ArrayList<>();
    }

    @Override
    public String getName() {
        return "机械工程学院";
    }

    @Override
    public void addDepartment(String name, String description) {
        Department department = new Department(name, description);
        departments.add(department);
    }

    @Override
    public Iterator creatIterator() {
        return new MechanicalCollegeIterator(departments);
    }
}
