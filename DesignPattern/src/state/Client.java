package state;

/**
 * @Description 客户端：状态模式
 * @ClassName Client
 * @Author zzq
 * @Date 2020/10/9 20:43
 */
public class Client {
    public static void main(String[] args) {
        Activity activity = new Activity(5);
        activity.deductMoney();
        activity.raffle();
    }
}
