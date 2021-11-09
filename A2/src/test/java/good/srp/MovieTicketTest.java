package good.srp;

import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MovieTicketTest {
	MovieTicket movie1 = new MovieTicket("Avengers", "9/10/21", "1 PM");

	@Test
	@Order(1)
	public void classNotNullTest(){
		assertNotNull(movie1);
	}

	@Test
	@Order(2)
	public void getAvailableTicketsTest() {
		Ticket[] availableTickets = movie1.getAvailableTickets().toArray(Ticket[]::new);
		Ticket[] expectedOutput = {
				new Ticket("A1", Ticket.Category.Silver,2),
				new Ticket("B1", Ticket.Category.Gold, 3),
				new Ticket("C1", Ticket.Category.Platinum, 5),
		};

		Assert.assertEquals(expectedOutput.length, availableTickets.length);
		Assert.assertEquals(expectedOutput[0].seatNo, availableTickets[0].seatNo);
		Assert.assertEquals(expectedOutput[0].category, availableTickets[0].category);
		Assert.assertEquals(expectedOutput[0].price, availableTickets[0].price);
		Assert.assertEquals(expectedOutput[0].status, availableTickets[0].status);
		Assert.assertEquals(expectedOutput[0].payment, availableTickets[0].payment);
	}

	@Test
	@Order(3)
	public void selectTicketTest() {
		movie1.selectTicket("B1");
		Ticket[] t = Arrays.stream(movie1.tickets).filter(item -> item.seatNo.equals("B1")).toArray(Ticket[]::new);

		Assert.assertEquals(Ticket.Status.blocked, t[0].status);
	}

	@Test
	@Order(4)
	public void getPriceTest() {
		int result = movie1.getPrice("B1");

		Assert.assertEquals(3, result);
	}

	@Test
	@Order(5)
	public void getPriceInvalidInputTest() {
		int result = movie1.getPrice("B2");

		Assert.assertEquals(-1, result);
	}

	@Test
	@Order(6)
	public void bookTicketInvalidSeatNoTest() {
		int result = movie1.bookTicket("B2");
		Assert.assertEquals(result, -1);
	}

	@Test
	@Order(7)
	public void bookTicketTest() {
		int result = movie1.bookTicket("B1");
		Ticket[] t = Arrays.stream(movie1.tickets).filter(item -> item.seatNo.equals("B1")).toArray(Ticket[]::new);

		Assert.assertEquals(Ticket.Status.booked, t[0].status);
		Assert.assertEquals(0, result);
	}

	@Test
	@Order(8)
	public void getBookedTicketsTest() {
		int result = movie1.bookTicket("B1");
		ArrayList<Ticket> t = movie1.getBookedTickets();
		Ticket[] expectedOutput = {
				new Ticket("B1", Ticket.Category.Gold, 3),
		};

		Assert.assertEquals(Ticket.Status.booked, t.get(0).status);
		Assert.assertEquals(true, t.get(0).payment);
	}
}