package observer.improve;

import java.util.ArrayList;

/**
 * @Description 天气数据类
 * @ClassName WeatherData
 * @Author zzq
 * @Date 2020/10/5 16:51
 */
public class WeatherData implements Subject {
    private float temperature;
    private float pressure;
    private float humidity;
    private final ArrayList<Observer> observers;

    public WeatherData() {
        this.observers = new ArrayList<>();
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
        notifyObserver();
    }

    /**
     * @Description 注册一个观察者
     * @Param [o]
     * @Return void
     * @Author zzq
     * @Date 2020/10/5 17:29
     */
    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    /**
     * @Description 移除一个观察者
     * @Param [o]
     * @Return void
     * @Author zzq
     * @Date 2020/10/5 17:29
     */
    @Override
    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }

    /**
     * @Description 遍历所有观察者并更新
     * @Param []
     * @Return void
     * @Author zzq
     * @Date 2020/10/5 17:32
     */
    @Override
    public void notifyObserver() {
        for (Observer o : observers)
            o.update(this.temperature, this.pressure, this.humidity);
    }
}
