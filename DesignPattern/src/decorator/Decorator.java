package decorator;

/**
 * @Description 装饰者模式
 * @ClassName Decorator
 * @Author zzq
 * @Date 2020/9/20 18:58
 */
public abstract class Decorator extends Drink {
    private Drink drink;    //与饮料聚合

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float cost() {
        return super.getPrice() + drink.cost(); //自己的价格加上其他的价格
    }

    @Override
    public String getDescription() {
        return this.drink.getDescription() + "+" + super.getDescription();
    }
}
