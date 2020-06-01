class PrimeNumberTest2 {
	public static void main(String[] args) {
	
		int count = 0;//记录质数的个数

		long start = System.currentTimeMillis();//获取当前时间

		label:for(int i = 2;i <= 100000;i++){
			for(int j = 2;j <= Math.sqrt(i);j++){
				if(i % j == 0){
					continue label;
				}
			}
			count++;
		}

		long end = System.currentTimeMillis();//获取当前时间
		System.out.println("质数的个数为：" + count);
		System.out.println("所花费的时间为：" + (end - start));

	}
}