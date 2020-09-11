package principle.singleresponsibility;

/**
 * @Description 单一职责原则测试2
 * @ClassName SingleResponsibilityTest2
 * @Author zzq
 * @Date 2020/9/11 16:39
 */
public class SingleResponsibilityTest2 {
    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        AirVehicle airVehicle = new AirVehicle();
        WaterVehicle waterVehicle = new WaterVehicle();
        roadVehicle.run("摩托车");
        airVehicle.run("飞机");
        waterVehicle.run("轮船");
    }
}

/*
    1.遵守了单一职责原则
    2.但是改动很大，需要将类分解同时修改客户端
*/

/**
 * @Description 公路运行
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/11 16:40
 */
class RoadVehicle {
    public void run(String v) {
        System.out.println(v + "在公路上运行");
    }
}

/**
 * @Description 天上运行
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/11 16:42
 */
class AirVehicle {
    public void run(String v) {
        System.out.println(v + "在天上运行");
    }
}

/**
 * @Description 水中运行
 * @Param
 * @Return
 * @Author zzq
 * @Date 2020/9/11 16:42
 */
class WaterVehicle {
    public void run(String v) {
        System.out.println(v + "在水里运行");
    }
}
