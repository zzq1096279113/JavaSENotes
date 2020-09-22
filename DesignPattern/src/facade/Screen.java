package facade;

/**
 * @Description 屏幕
 * @ClassName Screen
 * @Author zzq
 * @Date 2020/9/22 15:39
 */
public class Screen {
    private static final Screen instance = new Screen();

    private Screen(){
        super();
    }

    public static Screen getInstance() {
        return instance;
    }

    public void open() {
        System.out.println("屏幕打开");
    }

    public void pause() {
        System.out.println("屏幕待机");
    }

    public void close() {
        System.out.println("屏幕关闭");
    }
}
