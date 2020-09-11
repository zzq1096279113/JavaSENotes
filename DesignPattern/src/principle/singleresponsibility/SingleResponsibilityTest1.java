package principle.singleresponsibility;

/**
 * @Description 单一职责原则测试1
 * @ClassName SingleResponsibilityTest1
 * @Author zzq
 * @Date 2020/9/11 16:32
 */
public class SingleResponsibilityTest1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("轮船");
        vehicle.run("飞机");
    }
}

class Vehicle {
    /**
     * @Description 违反了单一执行原则，应该根据交通工具运行的方法分解成不同的类
     * @Param [v]
     * @Return void
     * @Author zzq
     * @Date 2020/9/11 16:38
     */
    public void run(String v) {
        System.out.println(v + "在公路上运行");
    }
}
