class SanYuanTest {
	public static void main(String[] args) {
		
		//获取两个整数的较大值
		int m = 12;
		int n = 5;

		int max = (m > n)? m : n;
		System.out.println(max);//12

		double num = (m > n)? 2 : 1.0;//编译成功

		//(m > n)? 2 : "n大";//编译错误

		n = 12;
		String maxStr = (m > n)? "m大" : ((m == n)? "相等" : "n大");
		System.out.println(maxStr);


		//获取三个数的最大值
		int n1 = 12;
		int n2 = 30;
		int n3 = -43;
		
		int max1 = (n1 > n2)? n1 : n2;
		int max2 = (max1 > n3)? max1 : n3;
		System.out.println("三个数中的最大值为:" + max2);

		//int max3 = (((n1 > n2)? n1 : n2) > n3)? ((n1 > n2)? n1 : n2) : n3;//不建议
		//System.out.println("三个数中的最大值为：" + max3);

		//写成if-else:
		if(m > n){
			System.out.println(m);
		}
		else{
			System.out.println(n);
		}
	}
}
