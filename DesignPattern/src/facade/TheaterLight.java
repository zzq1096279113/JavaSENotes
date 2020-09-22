package facade;

/**
 * @Description 灯光
 * @ClassName TheaterLight
 * @Author zzq
 * @Date 2020/9/22 15:43
 */
public class TheaterLight {
    private static final TheaterLight instance = new TheaterLight();

    private TheaterLight() {
        super();
    }

    public static TheaterLight getInstance() {
        return instance;
    }


    public void open() {
        System.out.println("灯光打开");
    }

    public void close() {
        System.out.println("灯光关闭");
    }
}
