package classes;

public class OrderTest {
	public static void main(String[] args) {
		Order o = new Order();
			
		o.orderDefault = 1;
		o.orderProtected = 2;
		o.orderPublic = 3;
		
		o.methodDefault();
		o.methodProtected();
		o.methodPublic();
	}	
}
