package mediator;

/**
 * @Description 具体同事类：电视机
 * @ClassName TV
 * @Author zzq
 * @Date 2020/10/8 10:55
 */
public class TV extends ColleagueAbstract {
    public TV(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange, this.name);
    }

    public void startTv() {
        System.out.println("打开电视机");
    }

    public void stopTv() {
        System.out.println("关闭电视");
    }
}
