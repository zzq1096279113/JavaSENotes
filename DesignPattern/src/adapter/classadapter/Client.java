package adapter.classadapter;

/**
 * @Description 类适配器模式
 * @ClassName Client
 * @Author zzq
 * @Date 2020/9/18 21:54
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.recharge(new VoltageAdapter());
    }
}
