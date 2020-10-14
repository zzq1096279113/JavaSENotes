package strategy.imporve;

/**
 * @Description 北京鸭
 * @ClassName PekingDuck
 * @Author zzq
 * @Date 2020/10/10 10:57
 */
public class PekingDuck extends Duck {
    public PekingDuck() {
        this.flyBehavior = new CanFly();
    }

    @Override
    public void show() {
        System.out.println("北京鸭");
    }

}
