package app.business.model;

import app.Constants;
import app.presentation.*;

public class ForkliftOperator extends Employee {
	public ForkliftOperator() {
		super();
	}

	public void storeItem(String item, int count) {
		logTime(Constants.FORK_LIFT_OPERATOR_MINUTES * count);
		Output.printMessage("Stored " + count + " " + item);
	}
}
