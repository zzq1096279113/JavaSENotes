package classes;

public class Student extends Person{

	String major;
	String id = "2017310807";//学号
	
	public Student(){
		
	}
	
	public Student(String major){
		this.major = major;
	}
	
	public Student(String name, int age, String major, String id) {
		super(name, age);
		this.major = major;
		this.id = id;
	}
	
	public void study(){
		System.out.println("学习专业是：" + major);
		super.eat();
	}
	
	//对父类中的eat方法重写
	public void eat() {
		System.out.println("学生吃饭多吃有营养的食物");
	}
	
	public  void show() {
		System.out.println("name:" + this.name + ", age:" + super.age);
		System.out.println("id:" + this.id);
		System.out.println("id:" + super.id);
	}

}