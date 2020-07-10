import java.util.Scanner;

class SwitchCaseTest1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		/*
		System.out.print("请输入字符：");
		String word = scan.next();
		char c = word.charAt(0);
		switch (c){
			case 'a':
				System.out.println("A");
				break;
			case 'b':
				System.out.println("B");
				break;
			case 'c':
				System.out.println("C");
				break;
			case 'd':
				System.out.println("D");
				break;
			default:
				System.out.println("other");
		}
		*/

		/*
		System.out.print("请输入成绩：");
		String score = scan.nextInt();
		int score = 78;
		switch(score){
		case 0:

		case 1:

		case 2:

			...
		case 100:
		
		}
		*/

		/*
		System.out.print("请输入成绩：");
		String score = scan.nextInt();
		if(score >= 60){
		
		}else{
		
		}
		*/
		
		/*
		int score = 78;
		switch(score / 10){
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("不及格");
			break;
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
			System.out.println("及格");
			break;
		}
		*/

		//更优的解决方案：
		System.out.print("请输入成绩：");
		int score = scan.nextInt();
		switch(score / 60){
		case 0:
			System.out.println("不及格");
			break;
		case 1:
			System.out.println("及格");
			break;
		}
	
	}
}
