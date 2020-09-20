package decorator;

/**
 * @Description 调味品：巧克力
 * @ClassName Chocolate
 * @Author zzq
 * @Date 2020/9/20 19:14
 */
public class Chocolate extends Decorator {
    public Chocolate(Drink drink) {
        super(drink);
        this.setDescription("巧克力");
        this.setPrice(0.5f);
    }
}
