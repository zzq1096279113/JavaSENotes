package Exer;
/*
 * 1.创建程序,在其中定义两个类：Person和PersonTest类。定义如下：
 * 		用setAge()设置人的合法年龄(0~130)，用getAge()返回人的年龄。
 * 
 * 2.练习2：
 * 	2.1. 在前面定义的Person类中添加构造器，利用构造器设置所有人的age属性初始值都为18。
 * 	2.2. 修改上题中类和构造器，增加name属性,使得每次创建Person对象的同时初始化对象的age属性值和name属性值。
 * 
 */
public class PersonTest {
	public static void main(String[] args) {
		Person p1 = new Person();	
//		p1.setAge(12);
		System.out.println("年龄为：" + p1.getAge());
		
		Person p2 = new Person(21, "ZZQ");
		System.out.println("name:" + p2.getName() + ", age:" + p2.getAge());
	}
}

class Person{
	//属性
	String name;
	private int age;
	
	//构造器
	public Person() {
		age = 18;
	}
	
	public Person(int a, String n) {
		name = n;
		age = a;
	}
	
	//方法
	public void setAge(int i) {
		if(i >= 0 && i <= 130) {
			age = i;
		}else {
			System.out.println("输入数据不合法!");
		}
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
}