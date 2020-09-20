package decorator;

/**
 * @Description 咖啡
 * @ClassName Coffee
 * @Author zzq
 * @Date 2020/9/20 18:49
 */
public abstract class Coffee extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}
