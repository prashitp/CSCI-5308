package good.srp;

public class Ticket {
	public enum Category {
		Silver,Gold,Platinum
	};

	public enum Status {
		available, blocked, booked
	};

	String seatNo;
	Category category;
	Status status;
	int price;
	boolean payment;

	Ticket(String seatNo, Category category, int price) {
		this.seatNo = seatNo;
		this.category = category;
		this.status = Status.available;
		this.price = price;
		this.payment = false;
	}
}
