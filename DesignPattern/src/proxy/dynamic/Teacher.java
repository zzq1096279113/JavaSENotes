package proxy.dynamic;

/**
 * @Description 被代理对象
 * @ClassName Teacher
 * @Author zzq
 * @Date 2020/9/25 10:04
 */
public class Teacher implements TeacherDAO {
    @Override
    public void teach() {
        System.out.println("老师正在授课");
    }
}
