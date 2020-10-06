package observer.improve;

/**
 * @Description 观察者接口
 * @ClassName Observer
 * @Author zzq
 * @Date 2020/10/5 17:17
 */
public interface Observer {
    public void update(float temperature, float pressure, float humidity);
}
