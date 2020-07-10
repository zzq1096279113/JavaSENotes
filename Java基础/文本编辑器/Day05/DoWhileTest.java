class DoWhileTest {
	public static void main(String[] args) {
		/*
		int num = 1, sum = 0;
		do{
			if(num % 2 == 0){
				System.out.print(num + " ");
				sum += num;
			}
			num++;
		}while(num <= 100);
		System.out.println();
		System.out.print("×ÜºÍÎª£º" + sum);
		*/

		int num1 = 10;
		while(num1 > 10){
			System.out.println("hello while");
			num1--;
		}

		int num2 = 10;
		do{
			System.out.println("hello do-while");
			num2--;
		}while(num2 > 10);
	}
}
