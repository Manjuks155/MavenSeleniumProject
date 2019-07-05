package scrrenShot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CaptureTestCaseResult {

	WebDriver driver;
	
	@Test
	private void capture() {
		System.setProperty("webdriver.chrome.driver", "jars/ChromeJar/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sampleEmailId");
		
	}
	
	@AfterMethod
	private void checkResult(ITestResult result) throws IOException {
		
		if(ITestResult.SUCCESS == result.getStatus()) {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File("screenShot/"+result.getName()+".png");
			
			FileUtils.copyFile(source, destination);
			
			
		}
		driver.quit();
	}

}
