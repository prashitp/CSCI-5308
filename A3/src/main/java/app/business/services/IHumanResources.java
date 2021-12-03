package app.business.services;

import app.business.model.Driver;
import app.business.model.ForkliftOperator;
import app.business.model.Picker;

public interface IHumanResources {
	Driver getDriver();

	Picker getPicker();

	ForkliftOperator getForkLiftOperator();

	int getTotalMinutesWorked();
}
