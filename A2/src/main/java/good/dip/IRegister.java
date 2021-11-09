package good.dip;

import java.util.ArrayList;

public interface IRegister {
	ArrayList<Student> records = new ArrayList<Student>();
	public void addStudent(Student student);
	public Student getStudent(String email);
}

class StudentRegister implements IRegister {
	@Override
	public void addStudent(Student student) {
		records.add(student);
	}

	@Override
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

	Student(String firstname, String email) {
		this.firstname = firstname;
		this.email = email;
	}

	public void addStudent(IRegister ir) {
		ir.addStudent(this);
	}

	public Student getStudentInfo(String email, IRegister ir) {
		return ir.getStudent(email);
	}
}
