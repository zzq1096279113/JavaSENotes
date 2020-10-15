package responsibility;

/**
 * @Description 购买请求
 * @ClassName PurchaseRequest
 * @Author zzq
 * @Date 2020/10/10 22:55
 */
public class PurchaseRequest {
    private String name;
    private float price;
    private boolean type;

    public PurchaseRequest(String name, float price) {
        this.name = name;
        this.price = price;
        this.type = false;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }
}
