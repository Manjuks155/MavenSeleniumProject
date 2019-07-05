package autoIT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FilesUpload {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "jars/ChromeJar/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/U6062815/Desktop/fileUpload.html");
		driver.findElement(By.xpath("//input[@name='upload']")).click();

		Runtime.getRuntime().exec("testData/filesUpload.exe" + " " + "testData/33833372_1243868732415174_6478786277129846784_n.jpg");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@name='upload']")).click();

		Runtime.getRuntime().exec("testData/filesUpload.exe" + " " + "testData/store procedure.txt");

		Thread.sleep(2000);

//		driver.findElement(By.xpath("//input[@name='upload']")).click();
//
//		Runtime.getRuntime().exec("testData/filesUpload.exe" + " " + "testData/store procedure.txt");
//
//		Thread.sleep(2000);


	}

}
