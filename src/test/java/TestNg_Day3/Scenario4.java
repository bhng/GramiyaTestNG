package TestNg_Day3;

import org.testng.annotations.*;

public class Scenario4 {
	@Test(priority=1)
	void test1() {
		System.out.println("test1");
	}
	@Test(priority=2)
	void test2() {
		System.out.println("test2");
	}
	@BeforeMethod
	void beforemethod() {
		System.out.println("beforemethod");
	}
	@AfterMethod
	void aftermethod() {
		System.out.println("aftermethod");
	}
	@BeforeClass
	void beforeclass() {
		System.out.println("beforeclass");
	}
	@AfterClass
	void afterclass() {
		System.out.println("afterclass");
	}
	@BeforeTest
	void beforetest() {
		System.out.println("beforetest");
	}
	@AfterTest
	void aftertest() {
		System.out.println("aftertest");
	}
	@BeforeTest
	void beforesuite() {
		System.out.println("beforesuite");
	}
	@AfterSuite
	void aftersuite() {
		System.out.println("aftersuite");
	}

}
