package good.srp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


class PaymentTest {
	Payment payment1 = new Payment(Payment.PaymentType.credit, "1234567890");
	MovieTicket movieTicket = mock(MovieTicket.class);

	@Test
	public void classNotNullTest(){
		assertNotNull(payment1);
	}

	@Test
	public void paymentForTicketTest() {
		when(movieTicket.bookTicket("B1")).thenReturn(0);
		String result = payment1.paymentForTicket("B1", movieTicket);

		Assert.assertEquals("Booked ticket B1",result);
	}

	@Test
	public void paymentForTicketInvalidTicketTest() {
		when(movieTicket.bookTicket("B2")).thenReturn(-1);
		String result = payment1.paymentForTicket("B2", movieTicket);

		Assert.assertEquals("Something went wrong",result);
	}
}