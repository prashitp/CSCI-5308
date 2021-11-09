package good.ocp;

public class Ticket { ;

	String seatNo;
	int price;
	boolean translator = false;

	//Other attributes can also be considered
	//String category;
	//String status;

	Ticket(String seatNo) {
		this.seatNo = seatNo;
		this.price = 3;
	}

	public int getPrice() {
		if(translator) {
			return price + 1;
		}
		return price;
	}
}
