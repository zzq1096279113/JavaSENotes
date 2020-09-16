package factory.methodfactory.order;

import factory.methodfactory.Pizza.BJCheesePizza;
import factory.methodfactory.Pizza.BJPepperPizza;
import factory.methodfactory.Pizza.Pizza;

/**
 * @Description 北京披萨
 * @ClassName BJOrderPizza
 * @Author zzq
 * @Date 2020/9/15 16:43
 */
public class BJOrderPizza extends OrderPizza {
    @Override
    public Pizza creatPizza(String orderType) {
        Pizza pizza;
        switch (orderType) {
            case "cheese" -> pizza = new BJCheesePizza();
            case "pepper" -> pizza = new BJPepperPizza();
            default -> throw new RuntimeException("披萨类型错误");
        }
        return pizza;
    }
}
