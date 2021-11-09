package bad.ocp;

public class Ticket {
	public enum Category {
		Silver,Gold,Platinum
	}

	String seatNo;
	Category category;
	int price;

	Ticket(String seatNo, Category category, int price) {
		this.seatNo = seatNo;
		this.category = category;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	//here we break OCP by adding new method if translator is required with the ticket which costs 1$ extra
	public int getPriceWithTranslator() {
		return price + 1;
	}
}
