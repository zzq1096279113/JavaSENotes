package responsibility;

/**
 * @Description 学院审批
 * @ClassName CollegeProcessor
 * @Author zzq
 * @Date 2020/10/10 23:08
 */
public class CollegeProcessor extends AbstractProcessor {
    public CollegeProcessor() {
        this.name = "院长";
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (5000 < purchaseRequest.getPrice() && purchaseRequest.getPrice() <= 50000) {
            System.out.println(purchaseRequest.getName() + "请求被" + this.name + "处理完毕");
            purchaseRequest.setType(true);
        } else {
            this.abstractProcessor.processRequest(purchaseRequest);     //让下一个来处理
        }
    }
}
