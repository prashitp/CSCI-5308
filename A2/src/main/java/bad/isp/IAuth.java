package bad.isp;

import java.util.Base64;
import java.util.Random;

public interface IAuth {
	String username = "prashitpatel";
	String password = "dal@5308";
	String encodedPass = Base64.getEncoder().encodeToString(password.getBytes());
	String email = "prashitppatel@gmail.com";

	public String loginUsingPassword(String username, String password);

	public int sendOTP(String email);

	public String loginUsingOTP(int OTP);
}

class SimpleLogin implements IAuth {

	@Override
	public String loginUsingPassword(String uname, String password) {
		String enteredPass = Base64.getEncoder().encodeToString(password.getBytes());

		if(uname.equals(username) && encodedPass.equals(enteredPass)) {
			return "Log in successful";
		}
		return "Invalid credentials";
	}

	//here we break isp
	@Override
	public int sendOTP(String email) {
		//Not supported
		return -1;
	}

	//here we break isp
	@Override
	public String loginUsingOTP(int OTP) {
		//Not supported
		return "This method is not allowed";
	}
}

class OTPLogin implements IAuth {
	int otp = (int) (Math.floor(Math.random() * (9999 - 1000) ) + 1000);

	//here we break isp
	@Override
	public String loginUsingPassword(String username, String password) {
		//Not supported
		return  "This method is not allowed";
	}

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
		if(OTP == otp) {
			return "Log in successful";
		}
		return "Invalid OTP";
	}
}
