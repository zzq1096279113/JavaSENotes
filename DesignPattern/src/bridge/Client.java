package bridge;

/**
 * @Description 客户端
 * @ClassName Client
 * @Author zzq
 * @Date 2020/9/20 11:20
 */
public class Client {
    public static void main(String[] args) {
        XiaoMi xiaoMi = new XiaoMi();   //  手机的品牌
        FoldedPhone foldedPhone = new FoldedPhone(xiaoMi);  //根据品牌实现具体机型
        foldedPhone.open();

        Vivo vivo = new Vivo();
        UpRightPhone upRightPhone = new UpRightPhone(vivo);
        upRightPhone.call();
    }
}
