package decorator;

/**
 * @Description 调味品：牛奶
 * @ClassName Milk
 * @Author zzq
 * @Date 2020/9/20 19:10
 */
public class Milk extends Decorator {
    public Milk(Drink drink) {
        super(drink);
        this.setDescription("牛奶");
        this.setPrice(0.7f);
    }
}
