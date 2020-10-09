package mediator;

/**
 * @Description 具体同事类：咖啡机
 * @ClassName CoffeeMachine
 * @Author zzq
 * @Date 2020/10/8 10:52
 */
public class CoffeeMachine extends ColleagueAbstract {
    public CoffeeMachine(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange, this.name);
    }

    public void startCoffee() {
        System.out.println("开始煮咖啡");
    }

    public void finishCoffee() {
        System.out.println("咖啡煮完了");
        sendMessage(0);
    }
}
