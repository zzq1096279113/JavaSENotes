package principle.singleresponsibility;

/**
 * @Description 单一职责原则测试3
 * @ClassName SingleResponsibilityTest3
 * @Author zzq
 * @Date 2020/9/11 16:47
 */
public class SingleResponsibilityTest3 {
    public static void main(String[] args) {
        Vehicle2 vehicle2 = new Vehicle2();
        vehicle2.runRoad("摩托车");
        vehicle2.runAir("飞机");
        vehicle2.runWater("轮船");
    }
}

/*
    1.没有对原来的类进行较大的修改，只是新增了方法
    2.虽然没有在类级别遵守单一职责原则，但是方法级别上遵守了单一职责
*/

class Vehicle2 {
    public void runRoad(String v) {
        System.out.println(v + "在路上运行");
    }

    public void runAir(String v) {
        System.out.println(v + "在天上运行");
    }

    public void runWater(String v) {
        System.out.println(v + "在水中运行");
    }
}