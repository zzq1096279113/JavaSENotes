package Class;

/*
 * 一、数组的概述
 * 1.数组的理解：数组(Array)，是多个相同类型数据按一定顺序排列的集合，并使用一个名字命名，
 * 并通过编号的方式对这些数据进行统一管理。
 * 
 * 2.数组相关的概念：
 * >数组名
 * >元素
 * >角标、下标、索引
 * >数组的长度：元素的个数
 * 
 * 3.数组的特点：
 * 1）数组是有序排列的
 * 2）数组属于引用数据类型的变量。数组的元素，既可以是基本数据类型，也可以是引用数据类型
 * 3）创建数组对象会在内存中开辟一整块连续的空间
 * 4）数组的长度一旦确定，就不能修改。
 * 
 * 4. 数组的分类：
 *   ① 按照维数：一维数组、二维数组、。。。
 *   ② 按照数组元素的类型：基本数据类型元素的数组、引用数据类型元素的数组
 * 
 * 5. 一维数组的使用
 *   ① 一维数组的声明和初始化
 *   ② 如何调用数组的指定位置的元素
 *   ③ 如何获取数组的长度
 *   ④ 如何遍历数组
 *   ⑤ 数组元素的默认初始化值
 *   ⑥ 数组的内存解析
 */
public class ArryTest {
	public static void main(String[] args) {
		
		//① 一维数组的声明和初始化
		int[] ids;	
		ids = new int[] {101,102,103} ;		//静态初始化:数组的初始化和数组元素的赋值操作同时进行
		String [] names = new String[4];	//动态初始化:数组的初始化和数组元素的赋值操作分开进行
		//总结:数组一旦初始化完成，长度就确定了。
		
		//② 如何调用数组的指定位置的元素
		names[0] = "张志秋";
		names[1] = "张志鹏";
		names[2] = "朱泽君";
		names[3] = "张紫陌";
		
		//③ 如何获取数组的长度
		System.out.println(names.length);//4
		System.out.println(ids.length);//3
		
		//④ 如何遍历数组
//		System.out.println(names[0]);
//		System.out.println(names[1]);
//		System.out.println(names[2]);
//		System.out.println(names[3]);
		for(int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		
		//⑤ 数组元素的默认初始化值
		int[] arr1 = new int[2];		//数据元素是整型：0
		for(int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		double[] arr2 = new double[2];	//数据元素是浮点型：0.0
		for(int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		char[] arr3 = new char[2];		//数据元素是char型：0 不是'0'
		for(int i = 0; i < arr3.length; i++) {
			System.out.println(arr3[i]);
		}
		boolean[] arr4 = new boolean[2];//数据元素是boolean型：false
		for(int i = 0; i < arr4.length; i++) {
			System.out.println(arr4[i]);
		}
		String[] arr5 = new String[2];	//数据元素是引用数据类型：null
		for(int i = 0; i < arr5.length; i++) {
			System.out.println(arr5[i]);
		}
		
		//⑥ 数组的内存解析
		
	}
}
