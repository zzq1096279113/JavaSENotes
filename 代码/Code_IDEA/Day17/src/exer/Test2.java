package exer;

/**
 * @author zzq
 * @creat 2020-05-24 10:58
 */
class Number2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}

public class Test2 {
    public static void main(String[] args) {
        Number2 n2 = new Number2();
        Thread t1 = new Thread(n2);
        t1.start();
    }
}
