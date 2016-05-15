package jackson1;

public class Teacher extends Person {
	int salary;

	public Teacher() {
	}

	public Teacher(String name, int age, int salary) {
		super(name, age);
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Teacher [salary=" + salary + ", name=" + name + ", age=" + age + ", date=" + getDate() + ", add=" + address + "]";
	}

}
