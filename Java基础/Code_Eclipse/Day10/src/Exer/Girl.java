package Exer;

public class Girl {
	// 属性
	private String name;
	private int age;

	// 构造器
	public Girl() {

	}

	public Girl(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// 方法
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void marry(Boy boy) {
		System.out.println("我想嫁给" + boy.getName());
		boy.marry(this);
	}

	public int compare(Girl girl) {
		return this.age - girl.age;
	}

}
