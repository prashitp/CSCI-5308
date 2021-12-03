package app.business.model;

import app.Constants;
import app.presentation.*;

public class Picker extends Employee {
	public Picker() {
		super();
	}

	public void retrieve(String item, int count) {
		logTime(Constants.PICKER_MINUTES * count);
		Output.printMessage("Picked " + count + " " + item);
	}
}
