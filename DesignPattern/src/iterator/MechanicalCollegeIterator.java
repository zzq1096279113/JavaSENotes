package iterator;

import java.util.Iterator;
import java.util.List;

/**
 * @Description 机械工程学院专用迭代器
 * @ClassName MechanicalCollegeIterator
 * @Author zzq
 * @Date 2020/9/30 11:42
 */
public class MechanicalCollegeIterator implements Iterator {
    public List<Department> departments;
    public int index;

    public MechanicalCollegeIterator(List<Department> departments) {
        this.departments = departments;
        this.index = 0;
    }

    /**
     * @Description 判断list中是否还有下一个元素
     * @Param []
     * @Return boolean
     * @Author zzq
     * @Date 2020/10/5 9:09
     */
    @Override
    public boolean hasNext() {
        return index < departments.size();
    }

    @Override
    public Department next() {
        index++;
        return departments.get(index);
    }
}
