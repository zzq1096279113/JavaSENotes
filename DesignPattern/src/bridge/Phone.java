package bridge;

/**
 * @Description 手机类型抽象类：桥
 * @ClassName Phone
 * @Author zzq
 * @Date 2020/9/20 10:44
 */
public abstract class Phone {
    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    public void open() {
        this.brand.open();
    }

    public void call() {
        this.brand.call();
    }

    public void close() {
        this.brand.close();
    }
}
