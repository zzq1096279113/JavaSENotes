package strategy.imporve;

/**
 * @Description 鸭子抽象类
 * @ClassName Duck
 * @Author zzq
 * @Date 2020/10/10 10:53
 */
public abstract class Duck {
    protected Fly flyBehavior;

    public abstract void show();

    public void quack() {
        System.out.println("鸭子嘎嘎叫");
    }

    public void swim() {
        System.out.println("鸭子会游泳");
    }

    public void fly() {
        if (flyBehavior != null)
            this.flyBehavior.fly();
    }
}
