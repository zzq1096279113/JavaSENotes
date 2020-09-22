package facade;

/**
 * @Description 家庭影院：外观类
 * @ClassName HomeTheaterFacade
 * @Author zzq
 * @Date 2020/9/22 15:46
 */
public class HomeTheaterFacade {
    private final DVDPlayer dvdPlayer;
    private final Popcorn popcorn;
    private final Projector projector;
    private final Screen screen;
    private final Stereo stereo;
    private final TheaterLight theaterLight;

    public HomeTheaterFacade() {
        this.dvdPlayer = DVDPlayer.getInstance();
        this.popcorn = Popcorn.getInstance();
        this.projector = Projector.getInstance();
        this.screen = Screen.getInstance();
        this.stereo = Stereo.getInstance();
        this.theaterLight = TheaterLight.getInstance();
    }

    public void ready() {
        this.popcorn.open();
        this.popcorn.play();
        this.screen.open();
        this.projector.open();
        this.stereo.open();
        this.dvdPlayer.open();
        this.theaterLight.close();
        System.out.println("家庭影院：准备");
    }

    public void play() {
        this.dvdPlayer.play();
        System.out.println("家庭影院：播放");
    }

    public void pause() {
        this.dvdPlayer.pause();
        System.out.println("家庭影院：暂停");
    }

    public void end() {
        this.projector.close();
        this.popcorn.close();
        this.dvdPlayer.close();
        this.stereo.close();
        this.screen.close();
        this.theaterLight.open();
        System.out.println("家庭影院：关闭");
    }
}
