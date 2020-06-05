package exer;

public class KidsTest {
	public static void main(String[] args) {
		Kids somekids = new Kids(12);
		
		somekids.printAge();
		
		somekids.setSalary(0);
		somekids.setSex(1);
		
		somekids.manOrWoman();
		somekids.employeed();
		
	}
}
