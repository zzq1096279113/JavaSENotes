package Exer;
/*
 * 编写两个类，TriAngle和TriAngleTest，其中TriAngle类中声明私有的底边长base和高height，同时声明公共方法访问私有变量。
 * 此外，提供类必要的构造器。另一个类中使用这些公共方法，计算三角形的面积。
 */
public class TriAngleTest {
	public static void main(String[] args) {
		TriAngle t1 = new TriAngle();
		t1.setBase(2.3);
		t1.setHeight(5.4);
		System.out.println("base : " + t1.getBase() + ",height : " + t1.getHeight());
		
		TriAngle t2 = new TriAngle(23, 54);
		System.out.println("base : " + t2.getBase() + ",height : " + t2.getHeight());
	}
}

class TriAngle{
	
	//属性
	private double base;
	private double height;
	
	//构造器
	public TriAngle() {
		
	}
	
	public TriAngle(double b, double h) {
		base = b;
		height = h;
	}
	 
	//方法
	public void setBase(double b) {
		base = b;
	}
	
	public double getBase() {
		return base;
	}
	
	public void setHeight(double h) {
		height = h;
	}
	
	public double getHeight() {
		return height;
	}
	
}