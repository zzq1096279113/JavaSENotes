package adapter.classadapter;

/**
 * @Description 220V电压：被适配类
 * @ClassName Voltage220V
 * @Author zzq
 * @Date 2020/9/18 21:38
 */
public class Voltage220V {
    public int output220V() {    //输出220V电压
        int voltage = 220;
        System.out.println("初始电压为220V");
        return voltage;
    }
}
