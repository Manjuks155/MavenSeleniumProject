package tests;

import org.testng.annotations.Parameters;


public class B {

	@org.testng.annotations.Test
	@Parameters("browser")
	public void verifyB(String str) {
		if(str.equals("IE")) {
			System.out.println("This is IE browser");
		} else
			System.out.println("This is not IE browser");
	}
}
