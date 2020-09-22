package facade;

/**
 * @Description DVD
 * @ClassName DVDPlayer
 * @Author zzq
 * @Date 2020/9/22 15:18
 */
public class DVDPlayer {
    private static final DVDPlayer instance = new DVDPlayer();

    private DVDPlayer() {
        super();
    }

    public static DVDPlayer getInstance() {
        return instance;
    }

    public void open() {
        System.out.println("DVD打开");
    }

    public void play() {
        System.out.println("DVD播放");
    }

    public void pause() {
        System.out.println("DVD待机");
    }

    public void close() {
        System.out.println("DVD关闭");
    }
}
