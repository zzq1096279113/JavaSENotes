package decorator;

/**
 * @Description 调味品：方糖
 * @ClassName Sugar
 * @Author zzq
 * @Date 2020/9/20 19:12
 */
public class Sugar extends Decorator{
    public Sugar(Drink drink) {
        super(drink);
        this.setDescription("方糖");
        this.setPrice(0.3f);
    }
}
