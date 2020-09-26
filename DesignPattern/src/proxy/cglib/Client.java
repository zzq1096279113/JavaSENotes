package proxy.cglib;

/**
 * @Description 客户端：cglib代理
 * @ClassName Client
 * @Author zzq
 * @Date 2020/9/25 22:56
 */
public class Client {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Teacher teacherProxy = new TeacherProxyFactory(teacher).getProxyInstance();
        teacherProxy.teach();
    }
}
