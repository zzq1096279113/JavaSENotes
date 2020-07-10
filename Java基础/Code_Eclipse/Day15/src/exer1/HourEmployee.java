package exer1;
/*
 * 参照SalariedEmployee类定义HourlyEmployee类，实现按小时计算工资的员工处理。该类包括：
 * private成员变量wage和hour；
 * 实现父类的抽象方法earnings(),该方法返回wage*hour值；
 * toString()方法输出员工类型信息及员工的name，number,birthday。
 */
public class HourEmployee extends Employee{
	private double wage;
	private double hour;

	public HourEmployee(String name, int number, MyDate birthday) {
		super(name, number, birthday);
	}
	
	public HourEmployee(String name, int number, MyDate birthday, double wage, double hour) {
		super(name, number, birthday);
		this.wage = wage;
		this.hour = hour;
	}

	@Override
	public double earnings() {
		return wage * hour;
	}

	public String toString() {
		return "HourEmployee[" + super.toString() + "]";
	}
}
