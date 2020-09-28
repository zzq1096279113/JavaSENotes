package command;

/**
 * @Description 遥控器
 * @ClassName RemoteController
 * @Author zzq
 * @Date 2020/9/28 11:36
 */
public class RemoteController {
    private Command[] onCommand;
    private Command[] offCommand;
    private Command revoke;     //用于记录最后一次按下的按钮

    public RemoteController() {
        this.onCommand = new Command[5];
        this.offCommand = new Command[5];
        for (int i = 0; i < 5; i++) {
            this.onCommand[i] = new NoCommand();
            this.offCommand[i] = new NoCommand();
        }
    }

    /**
     * @Description 根据编号传入开按钮和关按钮
     * @Param [index, onCommand, offCommand]
     * @Return void
     * @Author zzq
     * @Date 2020/9/28 14:40
     */
    public void setCommand(int index, Command onCommand, Command offCommand) {
        this.onCommand[index] = onCommand;
        this.offCommand[index] = offCommand;
    }

    /**
     * @Description 按下编号的开按钮
     * @Param [index]
     * @Return void
     * @Author zzq
     * @Date 2020/9/28 14:39
     */
    public void on(int index) {
        this.onCommand[index].execute();
        this.revoke = this.onCommand[index];
    }

    /**
     * @Description 按下编号的关按钮
     * @Param [index]
     * @Return void
     * @Author zzq
     * @Date 2020/9/28 14:43
     */
    public void off(int index) {
        this.offCommand[index].execute();
        this.revoke = this.offCommand[index];
    }

    /**
     * @Description 按下撤销按钮
     * @Param []
     * @Return void
     * @Author zzq
     * @Date 2020/9/28 15:01
     */
    public void revoke() {
        this.revoke.revoke();   //调用最后一次指令的撤销方法
    }
}
