package exer1;

public class User{
	
	String name;
	int age;
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj instanceof User) {
			User user = (User) obj;
			return this.age == user.age && this.name.equals(user.name);
		}
		return false;
	}

	
}
