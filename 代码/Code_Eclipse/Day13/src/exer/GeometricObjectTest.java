package exer;

public class GeometricObjectTest {
	
	public static void main(String[] args) {
		GeometricObjectTest test = new GeometricObjectTest();
		
		Circle c1 = new Circle(2.3, "white", 1.0);
		test.dispalyGeometricObject(c1);
		Circle c2 = new Circle(3.5, "white", 1.0);
		test.dispalyGeometricObject(c2);
		
		boolean isEqual = test.equalsArea(c1, c2);
		System.out.println("面积是否相等：" + isEqual);
		
		MyRectangle m1 = new MyRectangle(3.1, 5.6, "black", 2.0);
		test.dispalyGeometricObject(m1);
	}
	
	public boolean equalsArea(GeometricObject o1, GeometricObject o2) {
		return o1.findArea() == o2.findArea();
	}
	
	public void dispalyGeometricObject(GeometricObject o) {
		System.out.println("面积为：" + o.findArea());
	}
}
