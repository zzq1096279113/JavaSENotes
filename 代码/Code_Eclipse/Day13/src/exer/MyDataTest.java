package exer;

public class MyDataTest {
	public static void main(String[] args) {
        MyData m1 = new MyData(14, 3, 1976);
        MyData m2 = new MyData(14, 3, 1976);
        if (m1 == m2) {
            System.out.println("m1==m2");
        } else {
            System.out.println("m1!=m2"); // m1 != m2
        }

        if (m1.equals(m2)) {
            System.out.println("m1 is equal to m2");// m1 is equal to m2
        } else {
            System.out.println("m1 is not equal to m2");
        }
    }

}

class MyData{
	private int day;
	private int month;
	private int year;
	
	public MyData(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj instanceof MyData) {
			MyData mydata = (MyData)obj;
			return this.day == mydata.day && this.month == mydata.month && this.year == mydata.year;
		}
		return false;
	}
}