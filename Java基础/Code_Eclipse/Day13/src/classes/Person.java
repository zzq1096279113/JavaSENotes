package classes;

public class Person {
	String name;
	int age;
	String id = "110228199909234xxx";//身份证号
	
	public Person() {
		
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void eat() {
		System.out.println("吃饭");
	}
	public void walk() {
		System.out.println("走路");
	}	
}
