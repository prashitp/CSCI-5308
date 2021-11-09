package bad.dip;

import java.util.ArrayList;

public class StudentRegister {
	ArrayList<Student> records = new ArrayList<Student>();

	public void addStudent(Student student) {
		records.add(student);
	}

	public Student getStudent(String email) {
		for (Student student:records) {
			if(email.equals(student.email)) {
				return student;
			}
		}
		return null;
	}
}

class Student {
	String firstname;
	String email;

	StudentRegister sr = new StudentRegister();

	Student(String firstname, String email) {
		this.firstname = firstname;
		this.email = email;
	}

	public void addStudent() {
		sr.addStudent(this);
	}
	public Student getStudentInfo(String email) {
		return sr.getStudent(email);
	}

}
