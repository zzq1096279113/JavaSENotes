package Exer;

public class Test {
	public static void main(String[] args) {
		Test test = new Test();
		
		int n = 3;
		char a = 'A', b = 'B', c = 'C';
		test.h(n, a, b, c);
	}
	
	//汉诺塔
	public void h(int n, char a, char b, char c) {
		if(n == 1) {
			System.out.println(a + " -> " + c);
		}else {
			h(n - 1, a, c, b);
			h(1, a, b, c);
			h(n - 1, b, a, c);
		}
	}
}
