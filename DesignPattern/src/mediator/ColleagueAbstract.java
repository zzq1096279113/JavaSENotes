package mediator;

/**
 * @Description 抽象同事类
 * @ClassName ColleagueAbstract
 * @Author zzq
 * @Date 2020/10/8 9:47
 */
public abstract class ColleagueAbstract {
    public String name;
    private MediatorAbstract mediator;

    public ColleagueAbstract(Mediator mediator, String name) {
        this.name = name;
        this.mediator = mediator;
    }

    public MediatorAbstract getMediator() {
        return this.mediator;
    }

    public abstract void sendMessage(int stateChange);
}
