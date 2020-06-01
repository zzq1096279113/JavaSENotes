class SwitchCaseTest {
	public static void main(String[] args) {
		/*
		int number = 5;
		switch(number){
		case 0:
			System.out.println("zero");
			break;
		case 1:
			System.out.println("one");
			break;
		case 2:
			System.out.println("two");
			break;
		case 3:
			System.out.println("three");
			break;
		default:
			System.out.println("other");
		}
		*/
		
		/*
		String season = "summer";
		switch (season) {
		case "spring":
			System.out.println("春暖花开");
			break;
		case "summer":
			System.out.println("夏日炎炎");
			break;
		case "autumn":
			System.out.println("秋高气爽");
			break;
		case "winter":
			System.out.println("冬雪皑皑");
			break;
		default:
			System.out.println("季节输入有误");
			break;
		}
		*/


		//**************如下的两种情况都编译不通过*********************
		//情况一
		/*
		boolean isHandsome = true;
		switch(isHandsome){
		
		case true:
			System.out.println("我好帅啊~~~");
			break;
		case false:
			System.out.println("我好丑啊~~~");
			break;
		default:
			System.out.println("输入有误~~~");
		}
		*/
		//情况二
		
		int age = 10;
		switch(age){
		case 8:
			System.out.println("成年了");
			break;
		default:
			System.out.println("未成年");
		}
		
	}
}
