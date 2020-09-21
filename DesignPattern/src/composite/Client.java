package composite;

/**
 * @Description 客户端
 * @ClassName Client
 * @Author zzq
 * @Date 2020/9/21 17:39
 */
public class Client {
    public static void main(String[] args) {
        //创建大学
        University university = new University("清华大学", "世界一流大学");
        //创建院系
        College college1 = new College("信息工程学院", "计算机相关");
        College college2 = new College("机械工程学院", "机械相关");
        //创建专业
        Department department1 = new Department("计算机科学与技术", "软硬件研究");
        Department department2 = new Department("大数据专业", "大数据研究");
        Department department3 = new Department("精密仪器系", "仪器研究");
        Department department4 = new Department("热能工程系", "能量研究");
        //组成的树状结构
        college1.add(department1);
        college1.add(department2);
        college2.add(department3);
        college2.add(department4);
        university.add(college1);
        university.add(college2);
        university.show();
    }
}
