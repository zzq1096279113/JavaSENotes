import java.util.Scanner;

class ForTest{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("请输入第一个正整数：");
		int m = scan.nextInt();
		System.out.print("请输入第二个正整数：");
		int n = scan.nextInt();

		int min = (m < n)? m : n;//获取较小值
		int max = (m > n)? m : n;//获取较大值

		for(int i = min; i >= 1; i--){
			if(m % i == 0 && n % i == 0){
				System.out.println("最大公约数为：" + i);
				break;
			}
		}
		for(int i = max; i <= (m * n); i++){
			if(i % m == 0 && i % n == 0){
				System.out.println("最小公倍数为：" + i);
				break;
			}
		}
	}
}