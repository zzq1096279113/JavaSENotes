package Test2;

public class BankTest {
	public static void main(String[] args) {
		Bank test = new Bank();
		
		test.addCustomer("Jane", "Smith");
		
		test.getCustomer(0).setAccount(new Account(2000));
		
		test.getCustomer(0).getAccount().wihtdraw(500);
		
		double balance = test.getCustomer(0).getAccount().getBalance();
		System.out.println("客户余额：" + balance);
	}
}
