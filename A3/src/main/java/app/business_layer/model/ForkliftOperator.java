package app.business_layer.model;

import app.Constants;
import app.presentation_layer.*;

public class ForkliftOperator extends Employee {
	public ForkliftOperator() {
		super();
	}

	public void storeItem(String item, int count) {
		logTime(Constants.FORK_LIFT_OPERATOR_MINUTES * count);
		Output.printMessage("Stored " + count + " " + item);
	}
}
