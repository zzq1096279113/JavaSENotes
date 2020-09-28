package command;

/**
 * @Description 电灯关
 * @ClassName LightOffCommand
 * @Author zzq
 * @Date 2020/9/28 11:40
 */
public class LightOffCommand implements Command {
    LightReceiver lightReceiver;

    public LightOffCommand() {
        this.lightReceiver = LightReceiver.getInstance();
    }

    @Override
    public void execute() {
        this.lightReceiver.off();
    }

    @Override
    public void revoke() {
        this.lightReceiver.on();
    }
}
