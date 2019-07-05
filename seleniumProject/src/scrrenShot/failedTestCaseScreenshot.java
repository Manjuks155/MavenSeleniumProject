package scrrenShot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class failedTestCaseScreenshot {
	
	WebDriver driver;
	
	@Test
	public void testCase() {
		System.setProperty("webdriver.gecko.driver", "jars/GeckoJar/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://in.linkedin.com/");
		driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("login");
	}
	
	@AfterMethod
	public void resultMethod(ITestResult result) throws IOException {
		
		if(ITestResult.SUCCESS == result.getStatus()) {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./screenShot/"+result.getName()+".png"));
		}
		
	}
	
	

}
