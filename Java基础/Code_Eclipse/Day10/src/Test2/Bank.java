package Test2;

public class Bank {
	//属性
	private Customer[] customers;
	private int numberOfCustomer;
	
	//构造器
	public Bank(){
		customers = new Customer[10];
	}
	
	//方法
	public void addCustomer(String f, String l) {//添加客户
		Customer cust = new Customer(f, l);
		customers[numberOfCustomer] = cust;
		numberOfCustomer++;
	}
	
	public int getNumOfCustomers() {//获取客户个数
		return numberOfCustomer;
	}
	
	public Customer getCustomer(int index) {
		if(index >= 0 && index < numberOfCustomer) {
			return customers[index];
		}else {
			return null;
		}
	}


}
