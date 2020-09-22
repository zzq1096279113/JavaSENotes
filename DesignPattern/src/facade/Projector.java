package facade;

/**
 * @Description 投影仪
 * @ClassName Projector
 * @Author zzq
 * @Date 2020/9/22 15:31
 */
public class Projector {
    private static final Projector instance = new Projector();

    private Projector() {
        super();
    }

    public static Projector getInstance() {
        return instance;
    }

    public void open() {
        System.out.println("投影仪打开");
    }

    public void play() {
        System.out.println("投影仪播放");
    }

    public void pause() {
        System.out.println("投影仪待机");
    }

    public void close() {
        System.out.println("投影仪关闭");
    }
}
