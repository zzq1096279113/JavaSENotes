package exer2;

public class ComparableCircleTest {
	public static void main(String[] args) {
		
		ComparableCircle c1 = new ComparableCircle(3.4);
		ComparableCircle c2 = new ComparableCircle(3.5);
		
		int c = c1.compareTo(c2);
		if(c > 0)
			System.out.println("c1大");
		else if(c < 0)
			System.out.println("c2大");
		else
			System.out.println("一样大");
		
		int a = c1.compareTo(new String("AA"));
		System.out.println(a);

		
	}
}
