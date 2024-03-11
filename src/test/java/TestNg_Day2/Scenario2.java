package TestNg_Day2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Scenario2 {
	@BeforeClass
	void login() {
		System.out.println("login");
	}
	@AfterClass
	void logout() {
		System.out.println("logout");
	}
	@Test(priority=1)
	void search() {
		System.out.println("search");
	}
	@Test(priority=2)
	void addproduct() {
		System.out.println("addproduct");
	}

}
