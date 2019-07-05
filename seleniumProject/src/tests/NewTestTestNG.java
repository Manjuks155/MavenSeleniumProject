package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class NewTestTestNG {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This is before suite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("This is after suite");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("This is before class");
	}

	@Test(groups = "group1")
	public void testMethod1() {
		System.out.println("This is test1 before false");
		AssertJUnit.assertTrue(false);
		System.out.println("This is test1 After false");
	}
	
	@Test(dependsOnGroups = "group1")
	public void testMethod2() {
		System.out.println("This is test2");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("This is after class");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("This is before test");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("This is after test");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is before method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("This si after method");
	}
	
	
}
