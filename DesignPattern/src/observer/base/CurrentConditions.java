package observer.base;

/**
 * @Description 显示天气类
 * @ClassName CurrentConditions
 * @Author zzq
 * @Date 2020/10/5 16:48
 */
public class CurrentConditions {
    private float temperature;  //温度
    private float pressure;     //气压
    private float humidity;     //湿度

    /**
     * @Description 更新天气情况
     * @Param [temperature, pressure, humidity]
     * @Return void
     * @Author zzq
     * @Date 2020/10/5 16:50
     */
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        show();
    }

    /**
     * @Description 显示天气情况
     * @Param []
     * @Return void
     * @Author zzq
     * @Date 2020/10/5 16:50
     */
    public void show() {
        System.out.println("***今天的温度为：" + temperature + "***");
        System.out.println("***今天的起亚为：" + pressure + "***");
        System.out.println("***今天的湿度为：" + humidity + "***");
    }
}
