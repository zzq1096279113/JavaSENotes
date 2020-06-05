package Test2;

public class Account {
	//属性
	private double balance;

	//构造器
	public Account(double init_balance) {
		this.balance = init_balance;
	}

	//方法
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amt) {//存钱
		if(amt > 0) {
			this.balance += amt;
			System.out.println("存钱成功");
		}
	}
	
	public void wihtdraw(double amt) {//取钱
		if(balance >= amt) {
			this.balance -= amt;
			System.out.println("取钱成功");
		}else {
			System.out.println("余额不足");
		}
	}
	
}
