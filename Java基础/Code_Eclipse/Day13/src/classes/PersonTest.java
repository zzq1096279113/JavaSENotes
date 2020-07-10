package classes;
/*
 * instanceof关键字的使用
 * 
 * a instanceof A:判断对象a是否是类A的实例。如果是，返回true；如果不是，返回false。
 * 
 *  使用情境：为了避免在向下转型时出现ClassCastException的异常，我们在向下转型之前，先进行instanceof的判断，一旦返回true，就进行向下转型。如果返回false，不进行向下转型。
 *  
 *  如果 a instanceof A返回true,则 a instanceof B也返回true.
 *  其中，类B是类A的父类。
 */
public class PersonTest {
	public static void main(String[] args) {
		Person p1 = new Man();
		
		if(p1 instanceof Woman) {
			Woman w1 = (Woman)p1;
			w1.goShopping();
			System.out.println("*****Woman*****");
		}
		
		if(p1 instanceof Man) {
			Man m1 = (Man)p1;
			m1.earnMoney();;
			System.out.println("*****Man*****");
		}
		
	}
}
