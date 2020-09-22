package facade;

/**
 * @Description 音响
 * @ClassName Stereo
 * @Author zzq
 * @Date 2020/9/22 15:41
 */
public class Stereo {
    private static final Stereo instance = new Stereo();

    private Stereo(){
        super();
    }

    public static Stereo getInstance() {
        return instance;
    }

    public void open() {
        System.out.println("音响打开");
    }

    public void play() {
        System.out.println("音响播放");
    }

    public void pause() {
        System.out.println("音响待机");
    }

    public void close() {
        System.out.println("音响关闭");
    }
}
