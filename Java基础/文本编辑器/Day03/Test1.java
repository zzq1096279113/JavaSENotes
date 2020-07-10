class Test1{
	public static void main(String[] args) {
		int m1 = 4, m2 = 2, m3 = 3;
		int max;

		if(m1 > m2){
			if(m1 > m3){
				max = m1;
			}
			else{
				max = m3;
			}
		}
		else{
			if(m2 > m3){
				max = m2;
			}
			else{
				max = m3;
			}
		}
		System.out.print("max = " + max);

		if(m1 > m2 && m1 > m3){
			max = m1;
		}
		else if (m2 > m1 && m2 > m3){
			max = m2;
		}
		else{
			max = m3;
		}

		/*
		int a = 3;
		int x = 100;
		switch(a){
			case 1:
				x += 5;
				break;
			case 2:
				x += 10;
				break;
			case 3:
				x += 16;
				break;
			default:
				x += 34;
		}
		*/
	}
}