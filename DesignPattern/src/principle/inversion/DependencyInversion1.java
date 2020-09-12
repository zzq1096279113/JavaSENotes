package principle.inversion;

/**
 * @Description 依赖倒置原则：未使用
 * @ClassName DependencyInversion1
 * @Author zzq
 * @Date 2020/9/12 9:44
 */
public class DependencyInversion1 {
    public static void main(String[] args) {
        Person1 p = new Person1();
        p.receive(new Email1());
    }
}

/*
    当获取信息的对象为微信、qq、短信等时，需要新增类在Person1类中增加相应地接收方法
*/

class Person1 {
    public void receive(Email1 email) {
        System.out.println(email.getInfo());
    }
}

class Email1 {
    public String getInfo() {
        return "Hello World";
    }
}