package autoIT;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowAuthentication {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.gecko.driver", "jars/GeckoJar/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
//		Thread.sleep(3000);
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
//		Runtime.getRuntime().exec("testData\\windowAuthentication.exe");
		
//		System.out.println(driver.switchTo().alert().getText());
//		Thread.sleep(3000);
		
//		Thread.sleep(3000);		
		driver.quit();


	}

}
