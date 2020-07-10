package Exer;
/*
 * 1.编写程序，定义三个重载方法并调用。方法名为mOL。
 * 三个方法分别接收一个int参数、两个int参数、一个字符串参数。
 * 分别执行平方运算并输出结果，相乘并输出结果，输出字符串信息。
 * 在主类的main ()方法中分别用参数区别调用三个方法。
 * 
 * 2.定义三个重载方法max()，
 * 第一个方法求两个int值中的最大值，
 * 第二个方法求两个double值中的最大值，
 * 第三个方法求三个double值中的最大值，
 * 并分别调用三个方法。 
 */
public class Overload {
	public static void main(String[] args) {
		
		Overload test = new Overload();
		//1.
		test.mOL(3);
		test.mOL(2, 3);
		test.mOL("张志秋");
		
		//2.
		 test.max(4, 8);
		 test.max(9.4, 8.4);
		 test.max(2.3, 1.23, 5.43);
	}
	
	//1.
	public void mOL(int i) {
		System.out.println(i * i);
	}
	
	public void mOL(int i, int j) {
		System.out.println(i * j);
	}
	
	public void mOL(String s) {
		System.out.println(s);
	}
	
	//2.
	public void max(int i, int j) {
		System.out.println(i > j? i : j);
	}
	
	public void max(double d1, double d2) {
		System.out.println(d1 > d2? d1 : d2);
	}
	
	public void max(double d1, double d2, double d3) {
		double max = d1 > d2? d1 : d2;
		System.out.println(max > d3? max : d3);
	}
}
