package good.ocp;

public class TicketWithTranslator extends Ticket {
	public TicketWithTranslator(String seatNo){
		super(seatNo);
		translator = true;
	}
}
