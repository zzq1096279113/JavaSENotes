package state;

/**
 * @Description 奖品发放完毕
 * @ClassName DispenseOutState
 * @Author zzq
 * @Date 2020/10/9 21:56
 */
public class DispenseOutState implements State {

    public DispenseOutState(Activity activity) {
    }

    @Override
    public void deductMoney() {
        System.out.println("奖品发送完了，请下次再参加");
    }

    @Override
    public boolean raffle() {
        System.out.println("奖品发送完了，请下次再参加");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("奖品发送完了，请下次再参加");
    }
}
