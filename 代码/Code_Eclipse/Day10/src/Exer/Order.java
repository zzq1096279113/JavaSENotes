package Exer;

public class Order {
	private int orderPrivate;
	int orderDefault;
	public int orderPublic;

	private void methodPrivate() {
		orderPrivate = 1;
		orderDefault = 2;
		orderPublic = 3;
	}

	void methodDefault() {
		orderPrivate = 4;
		orderDefault = 5;
		orderPublic = 6;
	}

	public void methodPublic() {
		orderPrivate = 7;
		orderDefault = 8;
		orderPublic = 9;
	}
}
