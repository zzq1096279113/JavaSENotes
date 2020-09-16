package factory.simplefactory.order;

/**
 * @Description 披萨店
 * @ClassName PizzaStore
 * @Author zzq
 * @Date 2020/9/15 10:12
 */
public class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza(new SimpleFactory());
    }
}
