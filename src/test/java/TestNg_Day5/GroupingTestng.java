package TestNg_Day5;

import org.testng.annotations.Test;

public class GroupingTestng {
	@Test(groups="smoke")
	void lanuch() {
		System.out.println("lanuch");
		
	}
	@Test(groups={"smoke","sanity"})
	void login() {
		System.out.println("login");
	}
	@Test(groups="regression")
	void search() {
		System.out.println("search");
	}
	@Test(groups={"regression","retest"})
	void addproduct( ) {
		System.out.println("addproduct");
	}

}
