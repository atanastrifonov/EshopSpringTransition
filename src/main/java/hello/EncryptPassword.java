package hello;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptPassword {

	public static void main(String[] args) {
		
		//admin -nimda
		//user - init1234
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String cryptedPassword = new BCryptPasswordEncoder().encode("init1234");
		System.out.println(cryptedPassword);
	}

}
