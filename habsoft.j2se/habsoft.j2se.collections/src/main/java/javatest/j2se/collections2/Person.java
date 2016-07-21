package javatest.j2se.collections2;

public class Person implements Comparable<Person> {

	private String firstName;
	private String lastName;
	private Long phNumber;
	private String email;

	/**
	 * Constructor
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phNumber
	 */
	public Person(String firstName, String lastName, String email, Long phNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phNumber = phNumber;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phNumber
	 */
	public Long getPhNumber() {
		return phNumber;
	}

	/**
	 * @param phNumber
	 *            the phNumber to set
	 */
	public void setPhNumber(Long phNumber) {
		this.phNumber = phNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int compareTo(Person o) {
		int index = getFirstName().compareTo(o.getFirstName());
		if (index == 0) {
			index = getLastName().compareTo(o.getLastName());
			if (index == 0) {
				index = getEmail().compareTo(o.getEmail());
				if (index == 0) {
					index = getPhNumber().compareTo(o.getPhNumber());
				}
			}
		}
		return index;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", phNumber=" + phNumber + ", email=" + email + "]";
	}

}
