package responsibility;

/**
 * @Description 系审批
 * @ClassName DepartmentProcessor
 * @Author zzq
 * @Date 2020/10/10 23:02
 */
public class DepartmentProcessor extends AbstractProcessor {
    public DepartmentProcessor() {
        this.name = "教导主任";
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() <= 5000) {
            System.out.println(purchaseRequest.getName() + "请求被" + this.name + "处理完毕");
            purchaseRequest.setType(true);
        } else {
            this.abstractProcessor.processRequest(purchaseRequest);     //让下一个来处理
        }
    }
}
