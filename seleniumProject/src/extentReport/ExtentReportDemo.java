package extentReport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo {

	@Test
	public void extentReportMethod() {

		ExtentHtmlReporter extentReporter = new ExtentHtmlReporter("./extentReport.html"); 

		ExtentReports reports = new ExtentReports();
		reports.attachReporter(extentReporter);

		ExtentTest test = reports.createTest("First google test", "This is check google search");

		System.setProperty("webdriver.gecko.driver", "./jars/GeckoJar/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		test.log(Status.INFO, "browser opened");
		driver.get("http://google.co.in");
		test.pass("google page opened");
		driver.findElement(By.name("q")).sendKeys("Automation");
		test.pass("Typed Automation");
		driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Google Search']")).click(); 



		test.pass("click button");

		test.info("test completed");

		reports.flush();

	}


}
