package observer.improve;

import java.util.Observable;

/**
 * @Description 客户端：观察者模式
 * @ClassName Client
 * @Author zzq
 * @Date 2020/10/5 17:35
 */
public class Client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditions currentConditions = new CurrentConditions();
        weatherData.registerObserver(currentConditions);
        weatherData.setData(30, 150, 40);
    }
}
