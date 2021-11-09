package good.ocp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TicketWithTranslatorTest {
	TicketWithTranslator ticket = new TicketWithTranslator("B1");

	@Test
	public void classNotNullTest() {
		assertNotNull(ticket);
	}

	@Test
	public void getPriceWithTranslatorTest() {
		int result = ticket.getPrice();
		Assert.assertEquals(4,result);
	}

}