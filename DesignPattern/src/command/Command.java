package command;

/**
 * @Description 命令接口
 * @ClassName Command
 * @Author zzq
 * @Date 2020/9/28 10:06
 */
public interface Command {
    public void execute();

    public void revoke();
}
