package Exer;

public class ExerTest {
	public static void main(String[] args) {
//		Person p1 = new Person();
//		p1.name = "zzq";
//		p1.age = 20;
//		p1.sex = 1;	
//		p1.study();
//		p1.showAge();
//		p1.addAge(2);
//		System.out.println(p1.age);
//		
//		Person p2 = new Person();
//		p2.showAge();
		
		Circle c1 = new Circle();
		
		c1.radius = 2;
		
		double area = c1.findArea();
		System.out.println(area);
	}
}

class Circle {
	
	//属性
	double radius;
	
	//方法一:
	public double findArea() {
		double area = 3.14 * radius * radius;
		return area;
	}
	
}
