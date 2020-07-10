package classes1;

import org.junit.Test;

/*
 * 包装类的使用:
 * 1.java提供了8种基本数据类型对应的包装类，使得基本数据类型的变量具有类的特征
 * 
 * 2.掌握的：基本数据类型、包装类、String三者之间的相互转换 
 */
public class WarpperTest {
	//String类型 ——>基本数据类型、包装类
	@Test
	public void test5(){
		String s1 = "1324";
		int num = Integer.parseInt(s1);//可能会报NumberFormat
		System.out.println(num);
		
		String s2 = "true1";
		boolean b1 = Boolean.parseBoolean(s2);
		System.out.println(b1);
		
	}
	
	//基本数据类型、包装类 ——>String类型
	@Test
	public void test4(){
		int num1 = 13;
		
		//方式1：
		String s1 = num1 + "";
		
		//方式2：String.valueOf()
		float f1 = 12.34f;
		String.valueOf(f1);
	}
	
	@Test
	public void test3(){
//		int num = 10;
//		method(num);
		
		//自动装箱
		int num1 = 12;
		Integer num2 = num1;
		boolean b1 = true;
		Boolean b2 = b1;
		
		//自动拆箱
		int num3 = num2;
	}
	
	public void method(Object obj) {
		System.out.println(obj);
	}
	
	//包装类 ——>基本数据类型
	@Test
	public void test2(){
		Integer int1 = Integer.valueOf(12);
		int i1 = int1.intValue();
		System.out.println(i1);
		
		Float f1 = Float.valueOf("12.56");
		float f2 = f1.floatValue();
		System.out.println(f2);
	}
	
	//基本数据类型 ——>包装类
	@Test
	public void test1(){
		int num = 10;
		Integer in1= Integer.valueOf(num);
		System.out.println(in1.toString());
		Integer in2= Integer.valueOf("1325");
		System.out.println(in2.toString());
		
		Float f1 = Float.valueOf(12.3f);
		Float f2 = Float.valueOf("16.3");
		
		Boolean b1 = Boolean.valueOf(true);
		Boolean b2 = Boolean.valueOf("false");
		
		Order o = new Order();
		System.out.println(o.isMale);
		System.out.println(o.isFemale);
	}
	
	class Order{
		boolean isMale;
		Boolean isFemale;
	}
}
