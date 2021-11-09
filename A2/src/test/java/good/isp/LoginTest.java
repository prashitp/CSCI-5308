package good.isp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class LoginTest {
	SimpleLogin simpleLogin = new SimpleLogin();
	OTPLogin otpLogin = new OTPLogin();

	@Test
	public void simpleLoginClassNotNullTest() {
		assertNotNull(simpleLogin);
	}

	@Test
	public void otpLoginClassNotNullTest() {
		assertNotNull(otpLogin);
	}

	@Test
	public void loginUsingPasswordTest() {
		String result = simpleLogin.loginUsingPassword("prashitpatel", "dal@5308");
		Assert.assertEquals("Log in successful", result);
	}

	@Test
	public void loginUsingIncorrectPasswordTest() {
		String result = simpleLogin.loginUsingPassword("prashitpatel", "dal5308");
		Assert.assertEquals("Invalid credentials", result);
	}

	@Test
	public void sendOTPTest() {
		int otp = otpLogin.sendOTP("prashitppatel@gmail.com");
		Assert.assertEquals(4,String.valueOf(otp).length());
	}

	@Test
	public void sendOTPIncorrectEmailTest() {
		int otp = otpLogin.sendOTP("prashitpatel@gmail.com");
		Assert.assertEquals(-1,otp);
	}

	@Test
	public void loginUsingOTPTest() {
		String result = otpLogin.loginUsingOTP(1234);
		Assert.assertEquals("Log in successful",result);
	}

	@Test
	public void loginUsingOTPIncorrectTest() {
		String result = otpLogin.loginUsingOTP(1235);
		Assert.assertEquals("Invalid OTP",result);
	}

}