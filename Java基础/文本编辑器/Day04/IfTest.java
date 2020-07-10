import java.util.Scanner;

class IfTest{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("请输入薛小鹏的期末成绩(0-100):");
		int score = scan.nextInt();

		if(score == 100){
			System.out.println("奖励一辆宝马");
		}
		else if(score > 80 && score <= 99){
			System.out.println("奖励一台iPhone");
		}
		else if(score >= 60 && score <= 80){
			System.out.println("奖励一个iPad");
		}
		else{
			System.out.println("什么也没有");
		}
	}
}