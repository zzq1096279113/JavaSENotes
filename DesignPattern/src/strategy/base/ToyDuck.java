package strategy.base;

/**
 * @Description 玩具鸭
 * @ClassName ToyDuck
 * @Author zzq
 * @Date 2020/10/10 10:59
 */
public class ToyDuck extends Duck {
    @Override
    public void show() {
        System.out.println("玩具鸭");
    }

    @Override
    public void quack() {
        System.out.println("玩具鸭不能叫");
    }

    @Override
    public void swim() {
        System.out.println("玩具鸭不能游泳");
    }

    @Override
    public void fly() {
        System.out.println("玩具鸭不能飞");
    }
}
