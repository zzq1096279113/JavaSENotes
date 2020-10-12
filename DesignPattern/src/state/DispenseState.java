package state;

/**
 * @Description 发放奖品
 * @ClassName DispenseState
 * @Author zzq
 * @Date 2020/10/9 21:48
 */
public class DispenseState implements State {
    private final Activity activity;

    public DispenseState(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("现在不能扣除积分");
    }

    @Override
    public boolean raffle() {
        System.out.println("现在不能抽奖");
        return false;
    }

    @Override
    public void dispensePrize() {
        if(this.activity.getCount()>0){
            System.out.println("恭喜你获得精美礼品一份");
            this.activity.setState(this.activity.cantLotteryState);
        }else{
            System.out.println("很遗憾，奖品发放完了");
            this.activity.setState(this.activity.dispenseOutState);
        }
    }
}
