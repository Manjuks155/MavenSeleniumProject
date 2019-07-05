package webTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class webTable {

	@Test
	private void handleWebTable() {
		System.setProperty("webdriver.chrome.driver", "jars/ChromeJar/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.abhibus.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='datepicker1']")).click();
		List<WebElement> dataTags = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/div[1]/table[@class='ui-datepicker-calendar']//td"));

		for(WebElement ele : dataTags) {
			if(ele.getText().equals("24")) {
				ele.click();
				break;
			}
		}
	}

}
