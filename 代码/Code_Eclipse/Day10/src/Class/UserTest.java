package Class;
/*
 * 总结：属性赋值的先后顺序
 * 
 * ① 默认初始化
 * ② 显式初始化
 * ③ 构造器中初始化
 * ④ 通过"对象.方法" 或 "对象.属性"的方式，赋值
 * 
 * 以上操作的先后顺序：① - ② - ③ - ④  
 */
public class UserTest {
	public static void main(String[] args) {
		User u1 = new User();
		System.out.println(u1.age);
		
		User u2 = new User(2);
		u2.setAge(3);
		System.out.println(u2.age);
	}
}

class User{
	//方法
	String name;	//① 默认初始化
	int age = 1;	//② 显式初始化
	
	//构造器
	public User() {
		
	}
	
	public User(int a) {
		age = a;	//③ 构造器中初始化
	}
	
	//方法
	public void setAge(int a) {
		age = a;	//④ 通过"对象.方法" 或 "对象.属性"的方式，赋值
	}
}