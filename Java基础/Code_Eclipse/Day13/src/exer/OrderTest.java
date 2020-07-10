package exer;

public class OrderTest{
	public static void main(String[] args) {
		Order o1 = new Order(1001, "zzq");
		Order o2 = new Order(1002, "zzp");
		Order o3 = new Order(1002, "zzp");
		
		System.out.println(o1.equals(o2));
		System.out.println(o2.equals(o3));
	}

}

class Order {
	private int orderId;
	private String orderName;
	
	public Order(int orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj instanceof Order) {
			Order order = (Order)obj;
			return this.orderId == order.orderId && this.orderName.equals(order.orderName);
		}
		return false;
	}
}
