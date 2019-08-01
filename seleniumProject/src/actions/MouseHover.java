package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "jars/ChromeJar/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/  ");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Your Orders']"))).build().perform();;
		
//		action.moveToElement(driver.findElement(By.xpath("//nav[@class='menu-wrapper']//li[7]//a[1]//span[1]//span[1]"))).build().perform();
//		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'APIs and Integration')]"))).click().build().perform();
		
//		driver.findElement(By.xpath("//a[contains(text(),'APIs and Integration')]")).click();
		
	}

}
