package mediator;

/**
 * @Description 具体同事类：闹钟
 * @ClassName Alarm
 * @Author zzq
 * @Date 2020/10/8 10:44
 */
public class Alarm extends ColleagueAbstract {
    public Alarm(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange, this.name);
    }
}
