package state;

/**
 * @Description 状态接口
 * @ClassName State
 * @Author zzq
 * @Date 2020/10/9 21:15
 */
public interface State {
    public void deductMoney();  //扣除积分

    public boolean raffle();    //是否抽中奖品

    public void dispensePrize();    //发放奖品
}
