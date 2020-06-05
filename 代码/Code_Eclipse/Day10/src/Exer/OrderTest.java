package Exer;

class OrderTest {
	public static void main(String[] args) {
		Order test = new Order();
		
		//test.orderPrivate = 1;//出了Order类私有结构不可用了
		test.orderDefault = 2;
		test.orderPublic = 3;
		
		test.methodDefault();
		test.methodPublic();
		//test.methodPrivate();//出了Order类私有结构不可用了
	}
}

