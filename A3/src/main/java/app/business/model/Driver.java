package app.business.model;

import app.Constants;
import app.presentation.*;

public class Driver extends Employee {
	public Driver() {
		super();
	}

	public void deliver(String account, String item, int count) {
		logTime(Constants.DRIVER_MINUTES * count);
		Output.printMessage("Delivered " + item + " to " + account);
	}
}