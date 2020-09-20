package bridge;

/**
 * @Description Vivo品牌
 * @ClassName Vivo
 * @Author zzq
 * @Date 2020/9/20 10:42
 */
public class Vivo implements Brand {
    @Override
    public void open() {
        System.out.println("Vivo手机开机");
    }

    @Override
    public void call() {
        System.out.println("Vivo手机打电话");
    }

    @Override
    public void close() {
        System.out.println("Vivo手机关机");
    }
}
