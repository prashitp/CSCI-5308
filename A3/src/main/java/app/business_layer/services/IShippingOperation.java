package app.business_layer.services;

public interface IShippingOperation {
	void ship(String item, String account, int count);
}
