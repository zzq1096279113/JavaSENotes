package classes;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理的举例
 *
 * @author zzq
 * @creat 2020-06-06 16:54
 */
interface Human{
    String getBelief();

    void eat(String food);
}

//实现类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "氪星";
    }

    @Override
    public void eat(String food) {
        System.out.println("超人喜欢吃氪石");
    }

}

class HumanUtil{
    public void method1(){
        System.out.println("====================通用方法一====================");

    }

    public void method2(){
        System.out.println("====================通用方法二====================");
    }
}

class MyInvocationHandler implements InvocationHandler{
    private Object object;//需要使用实现类的对象进行赋值

    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    //当我们通过代理类的对象， 调用方法a时，就会自动的调用如下的方法：invoke()
    // 将实现类要执行的方法a的功能声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil humanUtil = new HumanUtil();
        humanUtil.method1();
        //method:即为代理类对象调用的方法，此方法也就作为了实现类对象要调用的方法
        Object invoke = method.invoke(object, args);//obj:实现类的对象
        humanUtil.method2();

        //上述方法的返回值就作为当前类中的invoke()的返回值。
        return invoke;
    }
}

/*
要想实现动态代理，需要解决的问题？
    问题一：如何根据加载到内存中的实现类，动态的创建一个代理类及其对象。
    问题二：当通过代理类的对象调用方法a时，如何动态的去调用实现类中的同名方法a。
*/
class ProxyFactory{
    //调用此方法，返回一个代理类的对象。解决问题一
    public static Object getProxyInstance(Object object){//obj：实现类的对象
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(object);
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),myInvocationHandler);
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        //proxyInstance:代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);

        //当通过代理类对象调用方法时，会自动的调用实现类中同名的方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("apply");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyInstance1 = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyInstance1.produceCloth();
    }
}
