package headLess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class ChromeHeadLess {

	@Test
	private static void headLessTest() {
		System.setProperty("webdriver.gecko.driver", "jars/GeckoJar/geckodriver.exe");
//		ChromeOptions option = new ChromeOptions();
		FirefoxOptions option = new FirefoxOptions();
		option.setHeadless(true);
		
		WebDriver driver = new FirefoxDriver(option);
		driver.manage().window().maximize();
		driver.get("https://google.co.in");
		System.out.println("Title : " + driver.getTitle());
	}
}
