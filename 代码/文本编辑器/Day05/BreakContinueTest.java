class BreakContinueTest {
	public static void main(String[] args) {

		/*
		for(int i = 1; i <= 10; i++){
			if(i % 4 == 0)
				//break;//123
				continue;//123567910
			System.out.print(i);
		}
		*/
		label:for(int i = 1; i <= 4; i++){
			for(int j = 1; j <=10; j++){
				if(j % 4 == 0)
					//break;
					//continue;
					//break label;//结束指定表示的循环
					continue label;
				System.out.print(j);
			}
		}
	}
}
