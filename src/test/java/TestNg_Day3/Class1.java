package TestNg_Day3;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Class1 {
	@BeforeTest
	void login() {
		System.out.println("login");
	}
	
	@AfterTest
	void logout() {
		System.out.println("logout");
	}

}
