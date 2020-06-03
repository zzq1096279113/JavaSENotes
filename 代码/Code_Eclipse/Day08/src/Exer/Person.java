package Exer;

public class Person {
	//属性
	String name;
	int age;
	/**
	 * sex:0为女
	 * sex:1为男
	 */
	int sex;
	
	//方法
	public void study() {
		System.out.println("studying");
	}
	
	public void showAge() {
		System.out.println("Age:" + age);
	}
	
	public int addAge(int i) {
		age += i;
		return age;
	}
}
