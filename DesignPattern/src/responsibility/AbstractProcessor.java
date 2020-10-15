package responsibility;

/**
 * @Description 抽象处理者
 * @ClassName AbstractProcessor
 * @Author zzq
 * @Date 2020/10/10 22:52
 */
public abstract class AbstractProcessor {
    public String name;    //审批人名字
    public AbstractProcessor abstractProcessor;    //下一个处理者

    public void setAbstractProcessor(AbstractProcessor abstractProcessor) {
        this.abstractProcessor = abstractProcessor;
    }

    public abstract void processRequest(PurchaseRequest purchaseRequest);
}
