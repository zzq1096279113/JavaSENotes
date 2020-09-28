package command;

/**
 * @Description 电灯开
 * @ClassName LightOn
 * @Author zzq
 * @Date 2020/9/28 11:07
 */
public class LightOnCommand implements Command {
    LightReceiver lightReceiver;

    public LightOnCommand() {
        this.lightReceiver = LightReceiver.getInstance();
    }

    @Override
    public void execute() {
        this.lightReceiver.on();
    }

    @Override
    public void revoke() {
        this.lightReceiver.off();
    }
}
