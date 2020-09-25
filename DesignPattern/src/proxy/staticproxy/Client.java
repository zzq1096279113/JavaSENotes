package proxy.staticproxy;

/**
 * @Description 客户端：静态代理
 * @ClassName Client
 * @Author zzq
 * @Date 2020/9/25 10:05
 */
public class Client {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        TeacherProxy teacherProxy = new TeacherProxy(teacher);
        teacherProxy.teach();
    }
}
