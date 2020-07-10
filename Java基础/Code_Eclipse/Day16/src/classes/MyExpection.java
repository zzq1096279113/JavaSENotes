package classes;
/*
 * 如何自定义异常类？
 * 1. 继承于现有的异常结构：RuntimeException、Exception
 * 2. 提供全局常量：serialVersionUID
 * 3. 提供重载的构造器
 */
public class MyExpection extends RuntimeException{
	
    static final long serialVersionUID = -7034897190745766999L;

	public MyExpection() {
        super();
    }
	
	public MyExpection(String message) {
        super(message);
    }

}
