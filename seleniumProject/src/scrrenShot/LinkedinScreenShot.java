package scrrenShot;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LinkedinScreenShot {

	@Test
	public void linkedInTest() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "./jars/GeckoJar/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.get("https://in.linkedin.com/");
//		driver.switchTo().frame("login-form");
		driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("login");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenShot/linkedInScreenShot.png"));
	}
}
