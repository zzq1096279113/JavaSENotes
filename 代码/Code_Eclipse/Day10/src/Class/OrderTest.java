package Class;

import Exer.Order;

public class OrderTest {
	public static void main(String[] args) {
		Order test = new Order();
		
		//test.orderPrivate = 1;//出了Order类私有结构不可用了
		//test.orderDefault = 2;//出了Order包后私有、缺省就不可用了
		test.orderPublic = 3;
		
		//test.methodDefault();//出了Order包后私有、缺省就不可用了
		//test.methodPrivate();//出了Order类私有结构不可用了
		test.methodPublic();
	}
}
