package strategy.imporve;

/**
 * @Description 客户顿：策略模式
 * @ClassName Client
 * @Author zzq
 * @Date 2020/10/10 11:05
 */
public class Client {
    public static void main(String[] args) {
        ToyDuck toyDuck = new ToyDuck();
        toyDuck.fly();
    }
}
