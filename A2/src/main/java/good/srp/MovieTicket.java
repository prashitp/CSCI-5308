package good.srp;

import java.util.ArrayList;

public class MovieTicket {
	String movieName;
	String date;
	String time;
	Ticket[] tickets;

	public MovieTicket(String movieName, String date, String time) {
		Constants c = new Constants();
		this.movieName = movieName;
		this.date = date;
		this.time = time;
		tickets = c.tickets;
	}

	public ArrayList<Ticket> getAvailableTickets() {
		var availableTickets = new ArrayList<Ticket>();
		for (Ticket t: tickets) {
			if(t.status == Ticket.Status.available) {
				availableTickets.add(t);
			}
		}
		return availableTickets;
	}

	public void selectTicket(String seatNo) {
		for (Ticket t: tickets) {
			if(t.seatNo.equals(seatNo)) {
				t.status = Ticket.Status.blocked;
				return;
			}
		}
	}

	public ArrayList<Ticket> getBookedTickets() {
		var availableTickets = new ArrayList<Ticket>();
		for (Ticket t: tickets) {
			if(t.status.equals(Ticket.Status.booked)) {
				availableTickets.add(t);
			}
		}
		return availableTickets;
	}

	public int getPrice(String seatNo) {
		for (Ticket t: tickets) {
			if(t.seatNo.equals(seatNo)) {
				return t.price;
			}
		}
		return -1;
	}

	 public int bookTicket(String seatNo) {
		for (Ticket t: tickets) {
			if(t.seatNo.equals(seatNo)) {
				t.payment = true;
				t.status = Ticket.Status.booked;
				return 0;
			}
		}
		return -1;
	}
}
