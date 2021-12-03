package app.business_layer.services;

import app.business_layer.model.Driver;
import app.business_layer.model.Picker;
import app.persistence_layer.*;
import app.presentation_layer.*;

public class ShippingOperation implements IShippingOperation {
	private IHumanResources humanResources;
	private IWarehouse warehouse;

	public ShippingOperation(IHumanResources humanResources, IWarehouse warehouse) {
		this.humanResources = humanResources;
		this.warehouse = warehouse;
	}

	public void ship(String item, String account, int count) {
		pick(item,count);

		deliver(item, account, count);

		Output.printMessage("Shipped " + count + " " + item + " to " + account);
	}

	private void pick(String item, int count) {
		Picker picker = humanResources.getPicker();
		picker.retrieve(item, count);

		warehouse.remove(item, count);
	}

	private void deliver(String item, String account, int count) {
		Driver driver = humanResources.getDriver();
		driver.deliver(account, item, count);
	}
}
