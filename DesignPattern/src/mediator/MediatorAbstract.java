package mediator;

/**
 * @Description 抽象中介者
 * @ClassName MediatorAbstract
 * @Author zzq
 * @Date 2020/10/8 9:46
 */
public abstract class MediatorAbstract {
    public abstract void register(String colleagueName, ColleagueAbstract colleague);

    public abstract void getMessage(int stateChange, String colleagueName);

    public abstract void sendMessage();
}
