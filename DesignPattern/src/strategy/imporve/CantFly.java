package strategy.imporve;

/**
 * @Description 不能飞
 * @ClassName CantFly
 * @Author zzq
 * @Date 2020/10/10 11:23
 */
public class CantFly implements Fly {
    @Override
    public void fly() {
        System.out.println("不能飞行");
    }
}
