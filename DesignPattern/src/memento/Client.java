package memento;

/**
 * @Description 客户端：备忘录模式
 * @ClassName Client
 * @Author zzq
 * @Date 2020/10/8 19:16
 */
public class Client {
    public static void main(String[] args) {
        Aims aims = new Aims("1000", "500");
        aims.show();
        CareMemento careMemento = new CareMemento();
        careMemento.add(aims.save());   //保存第0个状态
        aims.setAttack("800");
        aims.show();
        careMemento.add(aims.save());   //保存第1个状态
        aims.read(careMemento.get(0));    //读取第0个状态
        aims.show();
    }
}
