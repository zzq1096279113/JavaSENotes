package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description 代理工厂
 * @ClassName TeacherProxyFactory
 * @Author zzq
 * @Date 2020/9/25 16:53
 */
public class TeacherProxyFactory {
    private final TeacherDAO instance;

    public TeacherProxyFactory(TeacherDAO instance) {
        this.instance = instance;
    }

    public TeacherDAO getProxyInstance() {
        return (TeacherDAO) Proxy.newProxyInstance(instance.getClass().getClassLoader(), instance.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public TeacherDAO invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("JDK代理开始");
                        TeacherDAO invoke = (TeacherDAO) method.invoke(instance, args);
                        System.out.println("JDK代理结束");
                        return invoke;
                    }
                }
        );
    }
}
