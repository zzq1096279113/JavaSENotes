package decorator;

/**
 * @Description 饮料
 * @ClassName Drink
 * @Author zzq
 * @Date 2020/9/20 18:46
 */
public abstract class Drink {
    private String description;  //饮料的描述
    private float price;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract float cost();   //计算费用：子类实现
}
