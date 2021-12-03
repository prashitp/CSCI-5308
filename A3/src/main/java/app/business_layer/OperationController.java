package app.business_layer;

import app.business_layer.services.*;
import app.persistence_layer.*;

public class OperationController {
	private IHumanResources humanResources;
	private IShippingOperation shippingOperation;
	private IReceivingOperation receivingOperation;
	private IWarehouse warehouse;

	public OperationController(IWarehouse warehouse) {
		humanResources = new HumanResources();
		this.warehouse = warehouse;
		shippingOperation = new ShippingOperation(humanResources, warehouse);
		receivingOperation = new ReceivingOperation(humanResources, warehouse);
	}

	public void shipItem(String item, String account, int count) {
		shippingOperation.ship(item,account,count);
	}

	public void receiveItem(String item, int count) {
		receivingOperation.receive(item,count);
	}

	public int getTotalMinutesWorked() {
		return humanResources.getTotalMinutesWorked();
	}
}
