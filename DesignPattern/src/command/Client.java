package command;

/**
 * @Description 客户端：命令模式
 * @ClassName Client
 * @Author zzq
 * @Date 2020/9/28 10:11
 */
public class Client {
    public static void main(String[] args) {
        LightOnCommand lightOnCommand = new LightOnCommand();       //电灯的开命令
        LightOffCommand lightOffCommand = new LightOffCommand();    //电灯的关命令
        RemoteController remoteController = new RemoteController();
        remoteController.setCommand(0, lightOnCommand, lightOffCommand);
        remoteController.on(0);
        remoteController.off(0);
        remoteController.revoke();
    }
}
