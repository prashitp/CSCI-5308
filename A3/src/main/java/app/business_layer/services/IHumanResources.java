package app.business_layer.services;

import app.business_layer.model.Driver;
import app.business_layer.model.ForkliftOperator;
import app.business_layer.model.Picker;

public interface IHumanResources {
	Driver getDriver();

	Picker getPicker();

	ForkliftOperator getForkLiftOperator();

	int getTotalMinutesWorked();
}
