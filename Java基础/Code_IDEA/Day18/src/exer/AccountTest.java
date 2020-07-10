package exer;

/**
 * 银行有一个账户。有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 * <p>
 * 分析：
 * 1.是否是多线程问题？ 是，两个储户线程
 * 2.是否有共享数据？ 有，账户（或账户余额）
 * 3.是否有线程安全问题？ 有
 * 4.需要考虑如何解决线程安全问题？同步机制：有三种方式。
 *
 * @author zzq
 * @creat 2020-05-24 17:22
 */
public class AccountTest {
    public static void main(String[] args) {
        Account a = new Account(3000);
        Customer c1 = new Customer(a);
        Customer c2 = new Customer(a);
        c1.setName("甲");
        c2.setName("乙");
        c1.start();
        c2.start();
    }
}

class Account {

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized void add(double amt) {
        if (amt > 0) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance += amt;
            System.out.println(Thread.currentThread().getName() + "存钱成功，余额为：" + balance);
        }
    }
}

class Customer extends Thread {

    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.add(1000);
        }
    }
}
