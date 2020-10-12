package state;

/**
 * @Description 活动
 * @ClassName Activity
 * @Author zzq
 * @Date 2020/10/9 21:28
 */
public class Activity {
    private State state; //当前状态
    private int count;  //奖品数量
    public State cantLotteryState = new CantLotteryState(this);     //不能抽奖
    public State canLotteryState = new CanLotteryState(this);       //可以抽奖
    public State dispenseState = new DispenseState(this);           //发放奖品
    public State dispenseOutState = new DispenseOutState(this);     //奖品发完

    public Activity(int count) {
        this.state = cantLotteryState; //初始化状态为不能抽奖
        this.count = count;
    }

    /**
     * @Description 扣除积分，将状态转变为可以抽奖
     * @Param []
     * @Return void
     * @Author zzq
     * @Date 2020/10/9 22:13
     */
    public void deductMoney() {
        this.state.deductMoney();
    }

    /**
     * @Description 抽奖，如果抽中了领取奖品
     * @Param []
     * @Return void
     * @Author zzq
     * @Date 2020/10/9 22:14
     */
    public void raffle() {
        if (state.raffle()) {
            state.dispensePrize();
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    /**
     * @Description 将当前礼品数量返回，再对礼品数量修改
     * @Param []
     * @Return int
     * @Author zzq
     * @Date 2020/10/9 22:12
     */
    public int getCount() {
        int currentCount = count;
        count--;
        return currentCount;
    }
}
