package jackson1;

import jackson.Address;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = Student.class, name = "student"), @JsonSubTypes.Type(value = Teacher.class, name = "teacher"),
		@JsonSubTypes.Type(value = Address.class, name = "address") })
public abstract class Person {
	String name;
	int age;
	private Date date;
	Address address;

	// @JsonCreator
	public Person() {
		setDate(new Date());
		address = new Address("Pakistan", "Lahore", "st 1");
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		this.setDate(new Date());
		address = new Address("Pakistan", "Lahore", "st 1");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
