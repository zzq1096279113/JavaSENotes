package proxy.staticproxy;

/**
 * @Description 代理对象：静态代理
 * @ClassName TeacherProxy
 * @Author zzq
 * @Date 2020/9/25 10:05
 */
public class TeacherProxy implements TeacherDAO {
    private final TeacherDAO target;

    public TeacherProxy(TeacherDAO teacherDAO) {
        this.target = teacherDAO;
    }

    @Override
    public void teach() {
        System.out.println("开始代理");
        this.target.teach();
        System.out.println("代理结束");
    }
}
