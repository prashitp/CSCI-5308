package app.persistence_layer;

import app.presentation_layer.*;
import java.util.HashMap;
import java.util.Map;

public class Warehouse implements IWarehouse {
	private Map<String, Integer> storedItems;

	public Warehouse() {
		storedItems = new HashMap<>();
	}

	public void add(String item, int count) {
		if (storedItems.containsKey(item)) {
			storedItems.put(item, storedItems.get(item) + count);
		}
		else {
			storedItems.put(item, count);
		}
	}

	public void remove(String item, int count) {
		if(storedItems.get(item) != null) {
			storedItems.put(item, storedItems.get(item) - count);
		} else {
			Output.printMessage(item +" not available");
		}
	}
}
