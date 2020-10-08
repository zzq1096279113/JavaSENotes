package iterator;

import java.util.Iterator;

/**
 * @Description 信息工程学院
 * @ClassName InformationCollege
 * @Author zzq
 * @Date 2020/9/30 11:41
 */
public class InformationCollege implements College {
    public Department[] departments;
    public int index;

    public InformationCollege() {
        this.departments = new Department[8];
        this.index = 0;
    }

    @Override
    public String getName() {
        return "信息工程学院";
    }

    @Override
    public void addDepartment(String name, String description) {
        Department department = new Department(name, description);
        this.departments[index] = department;
        index++;
    }

    @Override
    public Iterator creatIterator() {
        return new InformationCollegeIterator(this.departments);
    }
}
