package adapter.objectadapter;

/**
 * @Description 手机
 * @ClassName Phone
 * @Author zzq
 * @Date 2020/9/18 21:51
 */
public class Phone {
    public void recharge(Voltage5V v) {
        if (v.output5V() == 5)
            System.out.println("电压合适");
        else
            System.out.println("电压异常");
    }
}
