package strategy.imporve;

/**
 * @Description 野鸭
 * @ClassName WildDuck
 * @Author zzq
 * @Date 2020/10/10 10:56
 */
public class WildDuck extends Duck {
    public WildDuck() {
        this.flyBehavior = new GoodFly();
    }

    @Override
    public void show() {
        System.out.println("野鸭");
    }
}
