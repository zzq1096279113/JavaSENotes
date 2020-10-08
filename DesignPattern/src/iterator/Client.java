package iterator;

import java.util.Iterator;

/**
 * @Description 客户端：迭代器
 * @ClassName Client
 * @Author zzq
 * @Date 2020/9/29 12:34
 */
public class Client {
    public static void main(String[] args) {
        InformationCollege informationCollege = new InformationCollege();
        System.out.println(informationCollege.getName());
        informationCollege.addDepartment("计算机科学与技术", "研究计算机");
        informationCollege.addDepartment("大数据", "研究大数据");
        Iterator iterator = informationCollege.creatIterator();
        Department next = (Department) iterator.next();
        Department next2 = (Department) iterator.next();
        System.out.println(next.getName());
        System.out.println(next2.getName());

    }
}
