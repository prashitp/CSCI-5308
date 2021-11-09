package good.ocp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TicketTest {
	Ticket ticket = new Ticket("B1");

	@Test
	public void classNotNullTest() {
		assertNotNull(ticket);
	}

	@Test
	public void getPriceTest() {
		int result = ticket.getPrice();
		Assert.assertEquals(3,result);
	}
}