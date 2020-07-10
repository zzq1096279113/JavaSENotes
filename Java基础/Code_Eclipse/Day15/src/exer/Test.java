package exer;

public class Test {
	public static void main(String[] args) {
		AA a = new AA() {

			@Override
			public void m() {
				
			}
		};
		a.m();
		
		BB.CC c = new BB.CC();
		c.name = "小甲";
		BB b = new BB();
		BB.DD d = b.new DD();
		d.name = "小乙";
		
	}
}

abstract class AA{
	public abstract void m();
}

class BB{
	class CC{
		String name;
	}
	
	static class DD{
		String name;
	}
}