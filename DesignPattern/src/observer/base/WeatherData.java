package observer.base;

/**
 * @Description 天气数据类
 * @ClassName WeatherData
 * @Author zzq
 * @Date 2020/10/5 16:51
 */
public class WeatherData {
    private float temperature;
    private float pressure;
    private float humidity;
    private final CurrentConditions currentConditions;

    public WeatherData(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    /**
     * @Description 更新当前的天气信息并推送给网站
     * @Param [temperature, pressure, humidity]
     * @Return void
     * @Author zzq
     * @Date 2020/10/5 16:56
     */
    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        dataChange();
    }

    public void dataChange() {
        this.currentConditions.update(getTemperature(), getPressure(), getHumidity());
    }
}
