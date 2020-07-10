package Exer;

public class MethodExer {
	public static void main(String[] args) {
		MethodExer m1 = new MethodExer();
		System.out.println("面积为：" + m1.method3(5,3));;
	}
	
//	public void method() {
//		for(int i = 1; i <= 10; i++) {
//			for(int j = 1; j <= 8; j++) {
//				System.out.print("* ");
//			}
//			System.out.println();
//		}
//	}
	
//	public int method2() {
//		for(int i = 1; i <= 10; i++) {
//			for(int j = 1; j <= 8; j++) {
//				System.out.print("* ");
//			}
//			System.out.println();
//		}
//	
//		return 10 * 8;
//	}

	public int method3(int m, int n) {
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		return m * n;
	}
}
