package exer;

public class AccountTest {
	public static void main(String[] args) {
		Account acc1 = new Account();
		Account acc2 = new Account("81082578", 15000);
		
		Account.setInterestRate(0.0123);
		Account.setMinMoney(1000);
		
		System.out.println(acc1.toString());
		System.out.println(acc2.toString());
	}
}
