package app.business_layer.model;

public class EmployeeFactory {
	public Employee getEmployee(EmployeeType employeeType) {
		if(employeeType.equals(EmployeeType.DRIVER)) {
			return new Driver();
		} else if (employeeType.equals(EmployeeType.FORKLIFT_OPERATOR)) {
			return new ForkliftOperator();
		} else {
			return new Picker();
		}
	}
}
