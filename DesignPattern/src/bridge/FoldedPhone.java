package bridge;

/**
 * @Description 折叠类型
 * @ClassName FoldedPhone
 * @Author zzq
 * @Date 2020/9/20 11:16
 */
public class FoldedPhone extends Phone {
    public FoldedPhone(Brand brand) {
        super(brand);
    }

    public void open() {
        super.open();
        System.out.println("折叠手机开机");
    }

    public void call() {
        super.call();
        System.out.println("折叠手机打电话");
    }

    public void close() {
        super.close();
        System.out.println("折叠手机关机");
    }
}
