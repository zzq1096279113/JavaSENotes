package strategy.base;

/**
 * @Description 北京鸭
 * @ClassName PekingDuck
 * @Author zzq
 * @Date 2020/10/10 10:57
 */
public class PekingDuck extends Duck {
    @Override
    public void show() {
        System.out.println("北京鸭");
    }

    @Override
    public void fly() {
        System.out.println("北京鸭不会飞");
    }
}
