package Exer;

import java.util.Scanner;

public class ArryExer {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入学生人数：");
		int num = scan.nextInt();
		int[] score = new int[num];
		
		int maxscore = 0;	//获得最大值：最高分
		System.out.println("请输入" + "个学生成绩：");//录入成绩
		for(int i = 0; i <score.length; i++) {
			score[i] = scan.nextInt();
			if(maxscore < score[i]) {
				maxscore = score[i];
			}
		}
		System.out.println("最高分是：" + maxscore);
		
		char level;	//根据成绩评级
		for(int i = 0; i <score.length; i++) {
			if(maxscore - score[i] <= 10) {
				level = 'A';
			}else if(maxscore - score[i] <= 20){
				level = 'B';
			}else if(maxscore - score[i] <= 30){
				level = 'C';
			}else{	
				level = 'D';
			}
			System.out.println("student " + i + " score is " + score[i] + ", grade is " + level);
		}
		
		scan.close();
	}
}
