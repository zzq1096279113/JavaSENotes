package mediator;

/**
 * @Description 客户端：中介者模式
 * @ClassName Client
 * @Author zzq
 * @Date 2020/10/8 10:18
 */
public class Client {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Alarm alarm = new Alarm(mediator,"Alarm");
        CoffeeMachine coffeeMachine = new CoffeeMachine(mediator, "CoffeeMachine");
        TV tv = new TV(mediator, "TV");
        alarm.sendMessage(0);
        coffeeMachine.finishCoffee();
    }
}
