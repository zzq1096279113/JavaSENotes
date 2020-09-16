package factory.abstractfactory.order;

import factory.abstractfactory.Pizza.Pizza;

/**
 * @Description 抽象工厂
 * @ClassName AbstractFactory
 * @Author zzq
 * @Date 2020/9/16 16:02
 */
public interface AbstractFactory {
    /**
     * @Description 让工厂子类具体实现接口
     * @Param [orderType]
     * @Return factory.abstractfactory.Pizza.Pizza
     * @Author zzq
     * @Date 2020/9/16 16:04
     */
    public Pizza creatPizza(String orderType);
}
