package responsibility;

/**
 * @Description 客户端：职责链模式
 * @ClassName Client
 * @Author zzq
 * @Date 2020/10/10 20:47
 */
public class Client {
    public static void main(String[] args) {
        PurchaseRequest purchase = new PurchaseRequest("体育器材", 40000);
        DepartmentProcessor departmentProcessor = new DepartmentProcessor();
        CollegeProcessor collegeProcessor = new CollegeProcessor();
        SchoolProcessor schoolProcessor = new SchoolProcessor();
        departmentProcessor.setAbstractProcessor(collegeProcessor);
        collegeProcessor.setAbstractProcessor(schoolProcessor);
        schoolProcessor.setAbstractProcessor(departmentProcessor);
        departmentProcessor.processRequest(purchase);
    }
}
