package exer2;
/*
 * 定义一个ComparableCircle类，继承Circle类并且实现CompareObject接口。
 * 在ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半径大小。
 */
public class ComparableCircle extends Circle implements CompareObject{
	
	public ComparableCircle(Double radius) {
		super(radius);
	}
	
	@Override
	public int compareTo(Object o) {
		if(this == o)
			return 0;
		if(o instanceof ComparableCircle) {
			ComparableCircle c = (ComparableCircle)o;
//			if(this.getRadius() > c.getRadius())
//				return 1;
//			else if(this.getRadius() < c.getRadius()) {
//				return -1;
//			}else
//				return 0;
			return this.getRadius().compareTo(c.getRadius());
		}else
			return 0;
	}
	
}
