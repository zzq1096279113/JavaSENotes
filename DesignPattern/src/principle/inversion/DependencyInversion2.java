package principle.inversion;

/**
 * @Description 依赖倒置原则：已使用
 * @ClassName DependencyInversion2
 * @Author zzq
 * @Date 2020/9/12 9:55
 */
public class DependencyInversion2 {
    public static void main(String[] args) {
        Person2 p = new Person2();
        p.receive(new Email2());
        p.receive(new WeChat());
    }
}

/**
 * @Description 对接口的依赖：通过接口调用实现类，对实现类的修改增加不会影响到本身
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 10:00
 */
class Person2 {
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}

/**
 * @Description 接口的实现类：Email
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 9:58
 */
class Email2 implements IReceiver {
    @Override
    public String getInfo() {
        return "Email:Hello world";
    }
}

/**
 * @Description 接口的实现类：WeChat
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 10:03
 */
class WeChat implements IReceiver {
    @Override
    public String getInfo() {
        return "WeChat:Hello world";
    }
}

/**
 * @Description 将getInfo放入接口，根据不同的实现类实现不同的功能
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/12 9:57
 */
interface IReceiver {
    public String getInfo();
}

