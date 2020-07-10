package classes1;
/*
 * 知识点1：接口中定义的静态方法，只能通过"接口.方法"来调用。
 * 知识点2：通过实现类的对象，可以调用接口中的默认方法。如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写以后的方法。
 * 知识点3：如果子类(或实现类)继承的父类和实现的接口中声明了同名同参数的默认方法，那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数的方法。-->类优先原则
 * 知识点4：如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法，那么在实现类没有重写此方法的情况下，报错。-->接口冲突。
 */
public class SubClass {
	public static void main(String[] args) {
		Sub s = new Sub();
		s.method2();
		s.method3();
	}
}

class Sub extends SuperClass implements CompareA, CompareB{
	
	public void method2(){
		System.out.println("SubClass:上海");
	}
	
	public void myMethod() {
		super.method3();
		CompareA.super.method3();
	}
}

class SuperClass{
	
	public void method3(){
		System.out.println("SuperClass:广州");
	}
	
}