package strategy.imporve;

/**
 * @Description 善于飞行
 * @ClassName GoodFly
 * @Author zzq
 * @Date 2020/10/10 11:22
 */
public class GoodFly implements Fly {
    @Override
    public void fly() {
        System.out.println("非常善于飞行");
    }
}
