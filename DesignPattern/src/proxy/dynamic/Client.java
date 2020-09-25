package proxy.dynamic;

import proxy.staticproxy.TeacherProxy;

/**
 * @Description 客户端
 * @ClassName Client
 * @Author zzq
 * @Date 2020/9/25 16:55
 */
public class Client {
    public static void main(String[] args) {
        Teacher instance = new Teacher();
        TeacherDAO proxyInstance = new TeacherProxyFactory(instance).getProxyInstance();
    }
}
