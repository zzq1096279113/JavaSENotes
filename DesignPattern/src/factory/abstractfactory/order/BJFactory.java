package factory.abstractfactory.order;

import factory.abstractfactory.Pizza.BJCheesePizza;
import factory.abstractfactory.Pizza.BJPepperPizza;
import factory.abstractfactory.Pizza.Pizza;

/**
 * @Description 北京披萨工厂
 * @ClassName BJFactory
 * @Author zzq
 * @Date 2020/9/16 16:05
 */
public class BJFactory implements AbstractFactory {
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
