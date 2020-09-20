package bridge;

/**
 * @Description 直立类型
 * @ClassName UpRightPhone
 * @Author zzq
 * @Date 2020/9/20 11:11
 */
public class UpRightPhone extends Phone {
    public UpRightPhone(Brand brand) {
        super(brand);
    }

    public void open() {
        super.open();
        System.out.println("直立手机开机");
    }

    public void call() {
        super.call();
        System.out.println("直立手机打电话");
    }

    public void close() {
        super.close();
        System.out.println("直立手机关机");
    }
}
