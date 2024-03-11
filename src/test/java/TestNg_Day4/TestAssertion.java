package TestNg_Day4;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestAssertion {
	int a=10;
	int b=10;
	@Test
	void validation() {
		/*if(a==b) {
		System.out.println("test is passed");
	}else {
		System.out.println("test is failed");
	}*/
		//hard assert
	/*	Assert.assertEquals(a,b);
		System.out.println("test is failed");*/
		//Soft assert
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(a, b);
		sa.assertAll();
	}
}
