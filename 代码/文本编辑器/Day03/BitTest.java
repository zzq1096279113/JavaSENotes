class BitTest {
	public static void main(String[] args) {

		int i = 21;
		System.out.println("i << 2 :" + (i << 2));//-84 <- (-21 * 2^2)
		System.out.println("i << 3 :" + (i << 3));//-168 <- (-21 * 2^3)
		System.out.println("i << 27 :" + (i << 27));//-1476395008

		int m = 12;
		int n = 5;
		System.out.println("m & n :" + (m & n));//与	4
		System.out.println("m | n :" + (m | n));//或	13
		System.out.println("m ^ n :" + (m ^ n));//异或	9

		//练习：交换两个变量的值
		int num1 = 10;
		int num2 = 20;

		//方式一：定义临时变量的方式
		//推荐的方式
		int temp = num1;
		num1 = num2;
		num2 = temp;

		//方式二：相加再相减
		//弊端：① 相加操作可能超出存储范围 ② 有局限性：只能适用于数值类型
		//num1 = num1 + num2;
		//num2 = num1 - num2;
		//num1 = num1 - num2;

		//方式三：使用位运算符
		//有局限性：只能适用于数值类型
		//num1 = num1 ^ num2;
		//num2 = num1 ^ num2;
		//num1 = num1 ^ num2;

		System.out.println("num1 = " + num1 + ",num2 = " + num2);

	}
}
