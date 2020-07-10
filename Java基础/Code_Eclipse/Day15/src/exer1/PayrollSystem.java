package exer1;

import java.util.Calendar;
import java.util.Scanner;

/*
 * 定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各类雇员对象的引用。
 * 利用循环结构遍历数组元素，输出各个对象的类型,name,number,birthday。
 * 当键盘输入本月月份值时，如果本月是某个Employee对象的生日，还要输出增加工资信息。
 */
public class PayrollSystem {
	public static void main(String[] args) {
		//方式一：
//		Scanner scan = new Scanner(System.in);
//		System.out.print("请输入当前月份：");
//		int month = scan.nextInt();
		
		//方式二：
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH) + 1;//从零开始
		
		Employee[] e = new Employee[2];
		e[0] = new SalariedEmployee("张志秋", 1001, new MyDate(1999, 9, 23), 10000);
		e[1] = new HourEmployee("张紫陌", 1002, new MyDate(1999, 3, 22), 240, 60);
		
		for(int i = 0; i < e.length; i++) {
			System.out.println(e[i]);
			double salary = e[i].earnings();
			System.out.println("月工资为：" + salary);
			if(month == e[i].getBirthday().getMonth()) {
				System.out.println("奖励100元");
			}	
		}
	}
}
