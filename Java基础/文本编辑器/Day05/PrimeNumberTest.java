class PrimeNumberTest {
	public static void main(String[] args){

		for(int i = 2; i <= 100; i++){
			boolean isFlag = true;
			for(int j = 2; j < i; j++){
				if(i % j == 0){
					isFlag = false;
				}
			}
			if(isFlag){
				System.out.print(i + " ");
			}
		}
	}
}
