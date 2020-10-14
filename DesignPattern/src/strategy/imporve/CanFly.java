package strategy.imporve;

/**
 * @Description 能飞
 * @ClassName CanFly
 * @Author zzq
 * @Date 2020/10/10 11:22
 */
public class CanFly implements Fly {
    @Override
    public void fly() {
        System.out.println("仅仅是能飞");
    }
}
