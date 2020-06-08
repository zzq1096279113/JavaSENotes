package exer;

/**
 * 遍历100以内的自然数
 * @author zzq
 * @creat 2020-05-24 10:56
 */
class Number1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}

public class Test1 {
    public static void main(String[] args) {
        Number1 n1 = new Number1();
        n1.start();
    }
}
