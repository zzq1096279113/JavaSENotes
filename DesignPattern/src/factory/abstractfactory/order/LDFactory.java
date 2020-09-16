package factory.abstractfactory.order;

import factory.abstractfactory.Pizza.BJCheesePizza;
import factory.abstractfactory.Pizza.BJPepperPizza;
import factory.abstractfactory.Pizza.Pizza;

/**
 * @Description 伦敦披萨工厂
 * @ClassName LDFactory
 * @Author zzq
 * @Date 2020/9/16 16:08
 */
public class LDFactory implements AbstractFactory {
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
