package observer.base;

/**
 * @Description 客户端
 * @ClassName Client
 * @Author zzq
 * @Date 2020/10/5 16:57
 */
public class Client {
    public static void main(String[] args) {
        CurrentConditions currentConditions = new CurrentConditions();
        WeatherData weatherData = new WeatherData(currentConditions);
        weatherData.setData(30, 150, 40);
    }
}
