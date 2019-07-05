package scrrenShot;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo2 {

	@BeforeTest
	void C() {

		System.out.println("This is C");
	}

	@Test
	void D() {
		System.out.println("This is D");
	}

	@AfterTest
	void A() {
		System.out.println("This is A");
	}

	@Test
	void B() {
		System.out.println("This is B");
	}


}
