package command;

/**
 * @Description 电灯
 * @ClassName LightReceiver
 * @Author zzq
 * @Date 2020/9/28 11:17
 */
public class LightReceiver {
    private static final LightReceiver instance = new LightReceiver();

    private LightReceiver() {
        super();
    }

    public static LightReceiver getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("电灯打开");
    }

    public void off() {
        System.out.println("电灯关闭");
    }
}
