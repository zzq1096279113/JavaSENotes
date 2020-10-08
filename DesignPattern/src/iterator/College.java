package iterator;

import java.util.Iterator;

/**
 * @Description 大学
 * @ClassName College
 * @Author zzq
 * @Date 2020/10/5 9:18
 */
public interface College {
    public String getName();

    public void addDepartment(String name, String description);

    public Iterator creatIterator();
}
