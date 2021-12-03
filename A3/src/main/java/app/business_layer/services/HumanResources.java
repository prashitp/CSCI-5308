package app.business_layer.services;

import app.Constants;
import app.business_layer.model.*;

import java.util.*;

public class HumanResources implements IHumanResources {
	private int nextDriver = 0;
	private int nextForkLiftOperator = 0;
	private int nextPicker = 0;
	private final List<Employee> drivers;
	private final List<Employee> forkLiftOperators;
	private final List<Employee> pickers;
	EmployeeFactory employeeFactory = new EmployeeFactory();

	public HumanResources() {
		drivers = new ArrayList<>();
		addEmployee(drivers, EmployeeType.DRIVER, Constants.DRIVER_COUNT);

		forkLiftOperators = new ArrayList<>();
		addEmployee(forkLiftOperators, EmployeeType.FORKLIFT_OPERATOR, Constants.FORKLIFT_OPERATOR_COUNT);

		pickers = new ArrayList<>();
		addEmployee(pickers, EmployeeType.PICKER, Constants.PICKER_COUNT);
	}

	private void addEmployee(List<Employee> employeeList, EmployeeType employeeType, int employeeCount) {
		for (int index = 0; index<employeeCount; index++) {
			employeeList.add(employeeFactory.getEmployee(employeeType));
		}
	}

	public Driver getDriver() {
		Driver driver = (Driver) drivers.get(nextDriver);
		nextDriver = (nextDriver + 1) % Constants.DRIVER_COUNT;
		return driver;
	}

	public Picker getPicker() {
		Picker picker = (Picker) pickers.get(nextPicker);
		nextPicker = (nextPicker + 1) % Constants.PICKER_COUNT;
		return picker;
	}

	public ForkliftOperator getForkLiftOperator() {
		ForkliftOperator forkliftOperator = (ForkliftOperator) forkLiftOperators.get(nextForkLiftOperator);
		nextForkLiftOperator = (nextForkLiftOperator + 1) % Constants.FORKLIFT_OPERATOR_COUNT;
		return forkliftOperator;
	}

	public int getTotalMinutesWorked() {
		int totalMinutes = getTotalMinutesWorkedByCategory(drivers) +
				getTotalMinutesWorkedByCategory(pickers) +
				getTotalMinutesWorkedByCategory(forkLiftOperators);
		return totalMinutes;
	}

	private int getTotalMinutesWorkedByCategory(List<Employee> employee) {
		int count = 0;
		Iterator<Employee> iterator = employee.iterator();
		while (iterator.hasNext()) {
			count += iterator.next().getMinutesWorkedSinceLastPay();
		}
		return count;
	}
}
