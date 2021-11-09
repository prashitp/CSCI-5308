package good.srp;

public class Payment {
	public enum PaymentType {
		credit, debit
	}

	PaymentType type;
	String cardNumber;

	public Payment(PaymentType type, String cardNumber) {
		this.type = type;
		this.cardNumber = cardNumber;
	}

	public String paymentForTicket(String seatNo, MovieTicket m) {
		//payment related code
		//if payment is successful call bookTicket method
		int success = m.bookTicket(seatNo);
		if(success == 0) {
			return "Booked ticket " + seatNo;
		}
		return "Something went wrong";
	}
}
