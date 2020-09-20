package bridge;

/**
 * @Description 小米品牌
 * @ClassName XiaoMi
 * @Author zzq
 * @Date 2020/9/20 10:41
 */
public class XiaoMi implements Brand {
    @Override
    public void open() {
        System.out.println("小米手机开机");
    }

    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }

    @Override
    public void close() {
        System.out.println("小米手机关机");
    }
}
