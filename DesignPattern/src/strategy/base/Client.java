package strategy.base;

/**
 * @Description 客户端
 * @ClassName Client
 * @Author zzq
 * @Date 2020/10/10 11:02
 */
public class Client {
    public static void main(String[] args) {
        WildDuck wildDuck = new WildDuck();
        wildDuck.show();
        ToyDuck toyDuck = new ToyDuck();
        toyDuck.swim();
    }
}
