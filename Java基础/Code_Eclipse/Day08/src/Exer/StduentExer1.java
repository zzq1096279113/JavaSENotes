package Exer;
/*
 * 4. 对象数组题目：
 * 定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩score(int)。
 * 创建20个学生对象，学号为1到20，年级和成绩都由随机数确定
 * 问题一：打印出3年级(state值为3）的学生信息。
 * 问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
 * 提示：
 * 1) 生成随机数：Math.random()，返回值类型double;  
 * 2) 四舍五入取整：Math.round(double d)，返回值类型long.
 */
public class StduentExer1 {
	public static void main(String[] args) {
		
		Student1[] s1 = new Student1[20];//声明一个Student类型的数组
		StduentExer1 ss = new StduentExer1();
		
		for(int i = 0; i < s1.length; i++) {
			s1[i] = new Student1();	//给元素赋值
			s1[i].number = i + 1;	//给学号赋值
			s1[i].state = (int)(Math.random() * 6 + 1);	//给年级赋值[1-6]
			s1[i].score = (int)(Math.random() * 101);	//给成绩赋值[0-100]
		}
			
			//遍历学生数组
			ss.print(s1);
			System.out.println("*****************************");
			
			//问题一：打印出3年级(state值为3）的学生信息。
			ss.searchStudent(s1, 3);
			System.out.println("*****************************");
			
			//问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
			ss.sortScore(s1);
			ss.print(s1);
	}
	
	public void print(Student1[] s1) {
		for(int i = 0; i < s1.length; i++) {
			System.out.println("学号：" + s1[i].number + "\t" + "年级：" + s1[i].state + "\t" + "成绩" + s1[i].score);
		}
	}

	/**
	 * 
	 * @Descripion	查找Student数组中指定年级的学生信息
	 * @author zzq
	 * @date 2020年5月9日下午2:16:03
	 * @param s1	查找的数组
	 * @param state	查找的年级
	 */
	public void searchStudent(Student1[] s1, int state) {
		for(int i = 0; i < s1.length; i++) {
			if(s1[i].state == state) {
				s1[i].info();
			}
		}
	}
	
	/**
	 * 
	 * @Descripion	使用冒泡排序给Student素组排序
	 * @author zzq
	 * @date 2020年5月9日下午2:18:06
	 * @param s1	数组
	 */
	public void sortScore(Student1[] s1) {
		for(int i = 0; i < s1.length - 1; i++) {
			for(int j = 0; j < s1.length - 1 - i; j++) {
				if(s1[j].score > s1[j + 1].score) {
					Student1 temp = s1[j];
					s1[j] = s1[j + 1];
					s1[j + 1] = temp;
				}
			}
		}
	}

}

class Student1{
	int number;//学号
	int state;//年级
	int score;//成绩
	
	public void info() {
		System.out.println("学号：" + number + "\t" + "年级：" + state + "\t" + "成绩" + score);
	}
}