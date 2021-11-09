package good.dip;

import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RegisterTest {
	IRegister iRegister = new StudentRegister();
	StudentRegister studentRegister = new StudentRegister();
	Student student = new Student("Prashit","prashitppatel@gmail.com");
	Student student2 = new Student("Scahin","sachin@gmail.com");


	@Test
	@Order(1)
	public void studentRegisterClassNotNullTest() {
		assertNotNull(studentRegister);
	}

	@Test
	@Order(2)
	public void studentClassNotNullTest() {
		assertNotNull(student);
	}

	@Test
	@Order(3)
	public void addStudentRegisterClassTest() {
		studentRegister.addStudent(student);
		ArrayList<Student> expectedRecords = studentRegister.records;

		Assert.assertEquals(1, expectedRecords.size());
	}

	@Test
	@Order(4)
	public void getStudentTest() {
		Student studentResult = studentRegister.getStudent("prashitppatel@gmail.com");

		Assert.assertEquals(student.firstname, studentResult.firstname);
	}

	@Test
	@Order(5)
	public void getStudentIncorrectTest() {
		Student studentResult = studentRegister.getStudent("prashitpatel@gmail.com");

		Assert.assertEquals(null, studentResult);
	}

	@Test
	@Order(5)
	public void addStudentTest() {
		student.addStudent(iRegister);
		ArrayList<Student> expectedRecords = iRegister.records;
		Assert.assertEquals(2, expectedRecords.size());
	}

	@Test
	@Order(6)
	public void getStudentInfoTest() {
		Student studentResult = student.getStudentInfo("prashitppatel@gmail.com", iRegister);

		Assert.assertEquals(student.firstname, studentResult.firstname);
	}
}