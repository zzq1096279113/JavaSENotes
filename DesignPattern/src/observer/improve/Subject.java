package observer.improve;

/**
 * @Description 被观察者接口
 * @ClassName Subject
 * @Author zzq
 * @Date 2020/10/5 17:14
 */
public interface Subject {
    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObserver();

}
