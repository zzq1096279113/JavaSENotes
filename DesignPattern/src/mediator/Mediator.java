package mediator;

import java.util.HashMap;

/**
 * @Description 具体中介者
 * @ClassName Mediator
 * @Author zzq
 * @Date 2020/10/8 9:48
 */
public class Mediator extends MediatorAbstract {
    private final HashMap<String, ColleagueAbstract> colleagueMap;

    public Mediator() {
        this.colleagueMap = new HashMap<>();
    }

    @Override
    public void register(String colleagueName, ColleagueAbstract colleague) {
        colleagueMap.put(colleagueName, colleague);
    }

    @Override
    public void getMessage(int stateChange, String colleagueName) {
        if (colleagueMap.get(colleagueName) instanceof Alarm) {
            if (stateChange == 0) {
                ((CoffeeMachine) colleagueMap.get("CoffeeMachine")).startCoffee();
                ((TV) (colleagueMap.get("TV"))).startTv();
            } else if (stateChange == 1) {
                ((TV) (colleagueMap.get("TV"))).stopTv();
            }
        } else if (colleagueMap.get(colleagueName) instanceof CoffeeMachine) {
            if (stateChange == 0)
                System.out.println("电视机关闭");
        } else if (colleagueMap.get(colleagueName) instanceof TV) {
            //电视机发出的消息在此处处理
        } else {
            throw new RuntimeException("输入类型错误");
        }
    }

    @Override
    public void sendMessage() {

    }
}
