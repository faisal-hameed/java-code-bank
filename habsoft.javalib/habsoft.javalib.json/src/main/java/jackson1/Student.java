package jackson1;

public class Student extends Person {

	String studyIn;

	public Student() {
	}

	public Student(String name, int age, String studyIn) {
		super(studyIn, age);
		this.studyIn = studyIn;
	}

	public String getStudyIn() {
		return studyIn;
	}

	public void setStudyIn(String studyIn) {
		this.studyIn = studyIn;
	}

	@Override
	public String toString() {
		return "Student [studyIn=" + studyIn + ", name=" + name + ", age=" + age + ", date=" + getDate() + ", add=" + address + "]";
	}



	

}
