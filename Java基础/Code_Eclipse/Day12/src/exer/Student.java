package exer;

public class Student extends Person{
	long number;
	int math;
	int english;
	int computer;
	
	public Student(String name, char sex, int age, long number, int math, int english, int computer) {
		super(name, sex, age);
		this.number = number;
		this.math = math;
		this.english = english;
		this.computer = computer;
	}
	
	public double aver() {
		return 0.0;
	}
	public int max() {
		return 222;
	}
	public int min() {
		return 1;
	}
}
