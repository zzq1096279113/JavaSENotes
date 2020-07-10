package classes;

public class StudentTest {
	public static void main(String[] args) {
		Student s = new Student();
		s.regist(-1001);
	}
}

class Student{
	private int id;
	
	public void regist(int id) {
		if(id > 0)
			this.id = id;
		else {
//			System.out.println("输入数据非法");
			//手动抛出异常
//			throw new RuntimeException("输入数据非法");
			throw new MyExpection("不能输入负数");
		}
	}

	@Override
	public String toString() {
		return "Student [id=" + id + "]";
	}
	
	
}
