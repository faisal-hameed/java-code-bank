package jackson;

import java.util.List;

public class User {

	public int age;
	private String name;
	private List<String> messages;
	private Address address;
	private int[] marks;

	// getter and setter methods

	public User(int age, String name, List<String> messages, Address address) {
		super();
		this.age = age;
		this.name = name;
		this.messages = messages;
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + ", messages=" + messages + ", address=" + address + "]";
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int[] getMarks() {
		return marks;
	}

	public void setMarks(int[] marks) {
		this.marks = marks;
	}

}
