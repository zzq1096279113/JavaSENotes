package state;

import java.util.Random;

/**
 * @Description 可以抽奖
 * @ClassName CanLotteryState
 * @Author zzq
 * @Date 2020/10/9 21:31
 */
public class CanLotteryState implements State {
    private final Activity activity;

    public CanLotteryState(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("积分已经扣除，请抽奖");
    }

    @Override
    public boolean raffle() {
        System.out.println("正在抽奖，请稍等！");
        Random r = new Random();
        int num = r.nextInt(10);    //随机0~9之间的整数
        if (num == 0) {   //如果数等于0，代表抽中奖品
            System.out.println("恭喜你，抽中奖品一份！");
            this.activity.setState(this.activity.dispenseState);  //改变状态为发放奖品
            return true;
        } else {
            System.out.println("很遗憾，没有抽中奖品！");
            this.activity.setState(this.activity.cantLotteryState);   //改变状态为不能抽奖
            return false;
        }
    }

    @Override
    public void dispensePrize() {
        System.out.println("还没有中奖，不能发放奖品");
    }
}
