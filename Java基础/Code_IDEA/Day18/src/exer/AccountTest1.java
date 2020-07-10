package exer;

/**
 * @author zzq
 * @creat 2020-05-24 17:40
 */
class Account1 implements Runnable{
    private double balance = 3000;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            synchronized (this) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                balance += 1000;
                System.out.println(Thread.currentThread().getName() + "存钱成功，余额为：" + balance);
            }
        }
    }
}
public class AccountTest1 {
    public static void main(String[] args) {
        Account1 a = new Account1();
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(a);
        t1.setName("甲");
        t2.setName("乙");
        t1.start();
        t2.start();
    }
}
