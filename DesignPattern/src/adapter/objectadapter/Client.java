package adapter.objectadapter;

/**
 * @Description 对象适配器模式
 * @ClassName Client
 * @Author zzq
 * @Date 2020/9/18 21:54
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.recharge(new VoltageAdapter(new Voltage220V()));
    }
}
