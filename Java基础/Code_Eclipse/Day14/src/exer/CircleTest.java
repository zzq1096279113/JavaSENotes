package exer;

public class CircleTest {
	public static void main(String[] args) {
		Circle c1 = new Circle();
		System.out.println("c1的id:" + c1.getId());
		Circle c2 = new Circle();
		System.out.println("c2的id:" + c2.getId());
		
		System.out.println("创建的圆的个数：" + Circle.getTotal());
	}
}

class Circle{
	private double radius;
	private int id;
	private static int total;
	private static int init = 1001;
	
	public Circle() {
		this.id = init++;
		total++;
	}
	public Circle(double radius) {
		this();
//		this.id = init++;
//		total++;
		this.radius = radius;
	}
	
	public double findArea() {
		return radius * radius * Math.PI;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public int getId() {
		return id;
	}

	public static int getTotal() {
		return total;
	}
	
}
