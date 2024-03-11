package TestNg_Day3;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Scenario3 {
	@BeforeTest
	void login() {
		System.out.println("login");
	}
	@AfterTest	
	void logout() {
		System.out.println("logout"); 
	}
	@Test(priority=1)
	void search() {     
		System.out.println("search product");
	}
	@Test(priority=2)
	void addproduct() {     
	System.out.println("add product to cart");	
	}

}
