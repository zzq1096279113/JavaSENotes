package exer;

public class Test {
	
}

class eHan{
	
	private eHan() {
		
	}
	
	private static eHan instance = new eHan();
	
	public static eHan getEHan() {
		return instance;
	}
}

class lanHan{
	
	private lanHan() {
		
	}
	
	private static lanHan instance = null;
	
	public static lanHan getEHan() {
		if(instance == null)
			instance = new lanHan();
		return instance;
	}
}
