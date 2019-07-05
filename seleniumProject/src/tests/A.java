package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;


public class A {

	@org.testng.annotations.Test
	@Parameters("browser")
	public void verifyA(String str) {
		WebDriver driver = null;
		if(str.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "jars/IEJar/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			System.out.println("This is IE browser");
		} else if(str.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "jars/ChromeJar/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			System.out.println("This is Chrome browser");
		}else if(str.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "jars/GeckoJar/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			System.out.println("This is Firefox browser");
		}

		driver.quit();
	}
}
