import java.util.Scanner;

class SwitchCaseTest2 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		/*
		System.out.print("亲输入月份：(0-12)");
		int season = scan.nextInt();
		switch (season){
			case 3:
			case 4:
			case 5:
				System.out.println("春季");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("夏季");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("秋季");
				break;
			case 12:
			case 1:
			case 2:
				System.out.println("冬季");
				break;
		}
		*/

		System.out.print("请输入2019年的月份：");
		int month = scan.nextInt();
		System.out.print("请输入2019年的日期：");
		int day = scan.nextInt();

		int sumDays = 0;//定义一个变量来保存总天数

		/*
		//方式一：冗余
		if(month == 1){
			sumDays = day;
		}else if(month == 2){
			sumDays = 31 + day;
		}else if(month == 3){
			sumDays = 31 + 28 + day;
		}else if(month == 4){
			sumDays = 31 + 28 + 31 + day;
		}
		//...
		else{
			//sumDays = ..... + day;
		}
		*/

		/*
		//方式二：冗余
		switch(month){
		case 1:
			sumDays = day;
			break;
		case 2:
			sumDays = 31 + day;
			break;
		case 3:
			sumDays = 31 + 28 + day;
			break;
		...
		}
		*/

		switch(month){
		case 12:
			sumDays += 30;
		case 11:
			sumDays += 31;
		case 10:
			sumDays += 30;
		case 9:
			sumDays += 31;
		case 8:
			sumDays += 31;
		case 7:
			sumDays += 30;
		case 6:
			sumDays += 31;
		case 5:
			sumDays += 30;
		case 4:
			sumDays += 31;
		case 3:
			sumDays += 28;
		case 2:
			sumDays += 31;
		case 1:
			sumDays += day;
		}

		System.out.println("2019年" + month + "月" + day + "日是当年的第" + sumDays + "天");
		
	}
}
