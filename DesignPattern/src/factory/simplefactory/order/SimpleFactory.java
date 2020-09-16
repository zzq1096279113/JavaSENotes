package factory.simplefactory.order;

import factory.simplefactory.Pizza.CheesePizza;
import factory.simplefactory.Pizza.GreekPizza;
import factory.simplefactory.Pizza.PepperPizza;
import factory.simplefactory.Pizza.Pizza;

/**
 * @Description 简单工厂类
 * @ClassName SimpleFactory
 * @Author zzq
 * @Date 2020/9/15 10:46
 */
public class SimpleFactory {
    public Pizza creatPizza(String type) {
        Pizza pizza;
        switch (type) {
            case "greek" -> pizza = new GreekPizza();
            case "cheese" -> pizza = new CheesePizza();
            case "pepper" -> pizza = new PepperPizza();
            default -> throw new RuntimeException("披萨类型错误");
        }
        return pizza;
    }
}
