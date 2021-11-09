package good.isp;

import java.util.Base64;

interface IAuthSimple {
	String username = "prashitpatel";
	String password = "dal@5308";
	String encodedPass = Base64.getEncoder().encodeToString(password.getBytes());

	public String loginUsingPassword(String username, String password);
}

interface IAuthOTP {
	String email = "prashitppatel@gmail.com";

	public int sendOTP(String email);

	public String loginUsingOTP(int OTP);
}

class SimpleLogin implements IAuthSimple {
	@Override
	public String loginUsingPassword(String uname, String password) {
		String enteredPass = Base64.getEncoder().encodeToString(password.getBytes());

		if(uname.equals(username) && encodedPass.equals(enteredPass)) {
			return "Log in successful";
		}
		return "Invalid credentials";
	}
}

class OTPLogin implements IAuthOTP {
	int otp = (int) (Math.floor(Math.random() * (9999 - 1000) ) + 1000);

	@Override
	public int sendOTP(String enteredEmail) {
		if(enteredEmail.equals(email)) {
			//send generated otp via smtp on the specified email.
			return otp;
		}
		return -1;
	}

	@Override
	public String loginUsingOTP(int OTP) {
		//OTP = 1234 for testing purposes
		if(OTP == 1234) {
			return "Log in successful";
		}
		return "Invalid OTP";
	}
}
