package iterator;

import java.util.Iterator;

/**
 * @Description 信息工程学院专用迭代器
 * @ClassName InformationCollegeIterator
 * @Author zzq
 * @Date 2020/9/30 11:27
 */
public class InformationCollegeIterator implements Iterator {
    public Department[] departments;
    public int index;

    public InformationCollegeIterator(Department[] departments) {
        this.index = 0;
        this.departments = departments;
    }

    /**
     * @Description 判断是否还有下一个元素
     * @Param []
     * @Return boolean
     * @Author zzq
     * @Date 2020/9/30 11:38
     */
    @Override
    public boolean hasNext() {
        return index < departments.length;
    }

    @Override
    public Department next() {
        return departments[index++];
    }
}
