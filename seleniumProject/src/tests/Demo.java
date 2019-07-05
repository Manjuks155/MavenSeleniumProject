package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C://Projects/Backup/Manju/Selenium/GeckoJar/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://login.wordpress.org/?locale=en_US");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[contains(@id, 'user_login')]")).sendKeys("Qwerty");
		driver.findElement(By.xpath("//a[text()='Lost password?']")).click();
	
	}
}
