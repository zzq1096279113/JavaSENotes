class PrimeNumberTest1 {
	public static void main(String[] args){
		
		long start = System.currentTimeMillis();
		int count = 0;

		for(int i = 2; i <= 100000; i++){
			boolean isFlag = true;
			for(int j = 2; j <= Math.sqrt(i); j++){//优化二：对本身是素数的自然数有效 0.5秒
				if(i % j == 0){
					isFlag = false;
					break;//优化一：只对本身非素数的自然数有用	2秒
				}
			}
			if(isFlag){
				//System.out.print(i + " ");
				count++;
			}
		}

		long end = System.currentTimeMillis();
		System.out.println("个数为：" + count);
		System.out.println("所花费的时间是：" + (end - start));//未优化：24.0秒

	}
}
