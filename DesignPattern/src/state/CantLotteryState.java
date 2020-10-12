package state;

/**
 * @Description 不能抽奖
 * @ClassName CantLotteryState
 * @Author zzq
 * @Date 2020/10/9 21:36
 */
public class CantLotteryState implements State{
    private final Activity activity;

    public CantLotteryState(Activity activity) {
        this.activity = activity;
    }

    /**
     * @Description 扣除积分，如果扣除成功，将状态变为可以抽奖
     * @Param []
     * @Return void
     * @Author zzq
     * @Date 2020/10/9 21:44
     */
    @Override
    public void deductMoney() {
        System.out.println("积分扣除50");
        this.activity.setState(this.activity.canLotteryState);
    }

    /**
     * @Description 当前还在不能抽奖的状态中
     * @Param []
     * @Return boolean
     * @Author zzq
     * @Date 2020/10/9 21:44
     */
    @Override
    public boolean raffle() {
        System.out.println("积分还未扣除，不能抽奖");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("还没有中奖，不能发放奖品");
    }
}
