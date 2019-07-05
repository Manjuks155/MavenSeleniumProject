package extentReport;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportWithScreenShot {

	WebDriver driver;
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeClass
	public void m2() {
		reporter = new ExtentHtmlReporter("./ExtentReportNew.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@BeforeTest
	public void start() {
		System.setProperty("webdriver.gecko.driver", "./jars/GeckoJar/geckodriver.exe");
	}
	
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void checkGoogle() {
		
		logger = extent.createTest("Google test case");
		
		driver.get("https://google.co.in");
		logger.log(Status.INFO, "google opened");
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Automation");
		logger.pass("Automation is entered correctly");
		driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Google Search']")).click();
		logger.info("clicked on the search button");
	}
	
	@Test
	public void sampleTestCase() {
		logger = extent.createTest("sample test case");
		Assert.assertEquals(10, 12);
		logger.info("sample test case passed");
	}
	
	@AfterMethod
	public void captureStatus(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.SUCCESS) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("./capturedResult");
			FileUtils.copyFile(src, dest);
			logger.pass("Succesfully captured", MediaEntityBuilder.createScreenCaptureFromPath(dest.getAbsolutePath()).build());
		} else if(result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("./capturedResult");
			FileUtils.copyFile(src, dest);
			logger.fail("Succesfully captured", MediaEntityBuilder.createScreenCaptureFromPath(dest.getAbsolutePath()).build());
		}
		driver.close();
	}
	
	@AfterClass
	public void m1() {
		extent.flush();
		
	}
	
	@AfterTest
	public void shutDown() {
//		driver.quit();
	}
	
}
