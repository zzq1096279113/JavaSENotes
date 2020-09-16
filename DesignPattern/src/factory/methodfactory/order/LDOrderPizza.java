package factory.methodfactory.order;

import factory.methodfactory.Pizza.LDCheesePizza;
import factory.methodfactory.Pizza.LDPepperPizza;
import factory.methodfactory.Pizza.Pizza;

/**
 * @Description 伦敦披萨
 * @ClassName LDOrderPizza
 * @Author zzq
 * @Date 2020/9/15 16:43
 */
public class LDOrderPizza extends OrderPizza {
    @Override
    public Pizza creatPizza(String orderType) {
        Pizza pizza;
        switch (orderType) {
            case "cheese" -> pizza = new LDCheesePizza();
            case "pepper" -> pizza = new LDPepperPizza();
            default -> throw new RuntimeException("披萨类型错误");
        }
        return pizza;
    }
}
