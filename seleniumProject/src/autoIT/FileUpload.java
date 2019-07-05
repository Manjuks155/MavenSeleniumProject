package autoIT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) throws Exception {
		
//		System.setProperty("webdriver.gecko.driver", "jars/GeckoJar/geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "jars/ChromeJar/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/U6062815/Desktop/fileUpload.html");
		Thread.sleep(3000);
		driver.findElement(By.id("1")).click();
		System.out.println("Before");
		Thread.sleep(5000);
		Runtime.getRuntime().exec("testData/fileUpload.exe");
		System.out.println("After");
		
	}

}
