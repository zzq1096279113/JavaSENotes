package facade;

/**
 * @Description 爆米花机
 * @ClassName Popcorn
 * @Author zzq
 * @Date 2020/9/22 15:27
 */
public class Popcorn {
    private static final Popcorn instance = new Popcorn();

    private Popcorn() {
        super();
    }

    public static Popcorn getInstance() {
        return instance;
    }

    public void open() {
        System.out.println("爆米花机启动");
    }

    public void play() {
        System.out.println("爆米花机工作");
    }

    public void pause() {
        System.out.println("爆米花机暂停");
    }

    public void close() {
        System.out.println("爆米花机关闭");
    }
}
