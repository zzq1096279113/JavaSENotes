package responsibility;

/**
 * @Description 校长审批
 * @ClassName SchoolProcessor
 * @Author zzq
 * @Date 2020/10/10 23:11
 */
public class SchoolProcessor extends AbstractProcessor {
    public SchoolProcessor() {
        this.name = "校长";
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (50000 < purchaseRequest.getPrice()) {
            System.out.println(purchaseRequest.getName() + "请求被" + this.name + "处理完毕");
            purchaseRequest.setType(true);
        } else {
            this.abstractProcessor.processRequest(purchaseRequest);     //让下一个来处理
        }
    }
}
