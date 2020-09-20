package decorator;

/**
 * @Description 意大利咖啡
 * @ClassName Espresso
 * @Author zzq
 * @Date 2020/9/20 18:51
 */
public class Espresso extends Coffee {
    public Espresso() {
        this.setDescription("意大利咖啡");
        this.setPrice(6.0f);
    }
}
