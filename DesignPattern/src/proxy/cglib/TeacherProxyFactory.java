package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description 代理对象工厂
 * @ClassName TeacherProxyFactory
 * @Author zzq
 * @Date 2020/9/25 22:54
 */
public class TeacherProxyFactory implements MethodInterceptor {
    private final Teacher instance;

    public TeacherProxyFactory(Teacher instance) {
        this.instance = instance;
    }

    public Teacher getProxyInstance() {
        Enhancer enhancer = new Enhancer();             //创建一个工具类
        enhancer.setSuperclass(instance.getClass());    //设置工具类的父类
        enhancer.setCallback(this);
        return (Teacher) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib代理开始");
        Object invoke = method.invoke(instance, objects);
        System.out.println("Cglib代理结束");
        return invoke;
    }
}
