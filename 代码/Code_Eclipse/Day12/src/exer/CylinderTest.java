package exer;

public class CylinderTest {
	public static void main(String[] args) {
		Cylinder cy = new Cylinder(3.4);
		
		cy.setRadius(2.1);
//		System.out.println("面积为：" + cy.findArea());
		System.out.println("体积为：" + cy.findVolume());
		System.out.println("表面积为：" + cy.findArea());
	}
}
