package Class;
/*
 * 递归方法的使用（了解）
 * 1.递归方法：一个方法体内调用它自身。
 * 2.方法递归包含了一种隐式的循环，它会重复执行某段代码，但这种重复执行无须循环控制。
 * 递归一定要向已知方向递归，否则这种递归就变成了无穷递归，类似于死循环。 
 */
public class RecursionTest {
	public static void main(String[] args) {
		//例一；计算1-100自然数的和
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		RecursionTest test = new RecursionTest();
//		int sum1 = test.getSum(100);
//		System.out.println(sum1);
//		int f = test.function(10);
//		System.out.println(f);
		
		int F = test.Fibonacci(15);
		System.out.println(F);
	}
	
	public int getSum(int n) {
		if(n == 1) {
			return 1;
		}else {
			return n + getSum(n - 1);
		}
	}
	
	//例3：已知有一个数列：f(0) = 1,f(1) = 4,f(n+2)=2*f(n+1) + f(n),
	//其中n是大于0的整数，求f(10)的值。
//	public int function(int i) {
//		if(i == 0) {
//			return 1;
//		}else if(i == 1){
//			return 1;
//		}else {
//			return 2 * function(i - 1) + function(i - 2);
//		}
//	}
	
	//例4：斐波那契数列
	public int Fibonacci(int n) {
		if(n == 1) {
			return 1;
		}else if(n == 2) {
			return 1;
		}else {
			return Fibonacci(n - 1) + Fibonacci(n - 2);
		}
	}
}
