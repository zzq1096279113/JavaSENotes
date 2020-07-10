package exer;

public class EmployeeTest {
	public static void main(String[] args) {
		Manager m = new Manager("张紫陌", 1001, 10000, 50000);
		m.work();
		
		CommonEmployee c = new CommonEmployee();
		c.work();
	}
}
