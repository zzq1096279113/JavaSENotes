package classes1;

public interface CompareA {
	
	//静态方法
	public static void method1(){
		System.out.println("CompareA:北京");
	}
	
	//默认方法
	public default void method2(){
		System.out.println("CompareA:上海");
	}
	
	public default void method3(){
		System.out.println("CompareA:广州");
	}
	
}

interface CompareB{
	
	public default void method3(){
		System.out.println("CompareB:广州");
	}
}