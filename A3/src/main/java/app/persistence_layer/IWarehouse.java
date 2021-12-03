package app.persistence_layer;

public interface IWarehouse {
	void add(String item, int count);

	void remove(String item, int count);
}
