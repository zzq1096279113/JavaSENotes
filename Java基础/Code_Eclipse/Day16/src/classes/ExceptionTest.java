package classes;

import java.util.Date;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

/*
 * 一、异常体系结构
 * java.lang.Throwable
 * 		|-----java.lang.Error:一般不编写针对性的代码进行处理。
 * 		|-----java.lang.Exception:可以进行异常的处理
 * 			|-----编译时异常(checked)
 * 					|-----IOException
 * 						|-----FileNotFoundException
 * 					|-----ClassNotFoundException
 * 			|-----运行时异常(unchecked,RuntimeException)
 * 					|-----NullPointerException
 * 					|-----ArrayIndexOutOfBoundsException
 * 					|-----ClassCastException
 * 					|-----NumberFormatException
 * 					|-----InputMismatchException
 * 					|-----ArithmeticException
 * 
 * 
 * 
 * 面试题：常见的异常都有哪些？举例说明
 */
public class ExceptionTest {
//******************运行时异常********************
	@Test
	public void test1(){
		//空指针：NullPointerException
//		int[] arr = null;
//		System.out.println(arr[2]);	
	}
	
	@Test
	public void test2(){
		//角标越界：ArrayIndexOutOfBoundsException
//		String str = "abc";
//		System.out.println(str.charAt(3));
	}
	
	@Test
	public void test3(){
		//类型转换异常：ClassCastException
		Object obj = new Date();
		String str = (String)obj;
	}
	
	@Test
	public void test4(){
		//数据格式异常：NumberFormatException
		String str = "abc";
		Integer.parseInt(str);
	}
	
	@Test
	public void test5(){
		//输入类型不匹配：InputMismatchException
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		System.out.println(score);
		scan.close();
	}
	
	@Test
	public void test6(){
		//算数异常：ArithmeticException
		int a = 10, b = 0;
		System.out.println(a / b);
	}
	
//******************编译时异常********************
	@Test
	public void test7(){
//		File file = new File("hello.txt");
//		FileInputStream fis = new FileInputStream(file);
//		
//		int data = fis.read();
//		while(data != -1){
//			System.out.print((char)data);
//			data = fis.read();
//		}
//		
//		fis.close();
	}
}
