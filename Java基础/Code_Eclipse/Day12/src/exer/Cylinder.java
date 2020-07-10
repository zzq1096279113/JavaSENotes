package exer;

public class Cylinder extends Circle{
	private double length;

	public Cylinder(double length) {
		this.length = length;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	public double findVolume() {//圆柱的体积
		return Math.PI * getRadius() * getRadius() * length;
	}
	
	public double findArea() {//圆柱的表面积
		return Math.PI * getRadius() * getRadius() * 2 + 2 * Math.PI * getRadius() * length;
	}
}
