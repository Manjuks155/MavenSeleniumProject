package autoIT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload2 {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "jars/ChromeJar/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("file:///C:/Users/U6062815/Desktop/fileUpload.html");
		
		driver.findElement(By.xpath("//input[@id='1']")).click();
		
		Thread.sleep(5000);
		
		Runtime.getRuntime().exec("testData/fileUpload.exe");
		Thread.sleep(5000);
	}

}


