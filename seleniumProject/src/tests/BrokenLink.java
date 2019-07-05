package tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLink {

	@Test
	private void checkURL() throws IOException {
		System.setProperty("webdriver.chrome.driver", "jars/ChromeJar/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(WebElement link : links) {
			String url = link.getAttribute("href");
			verifyUrl(url);

		}

	}

	private static void verifyUrl(String urlString) throws IOException {
		URL url = new URL(urlString);
		HttpURLConnection urlConnect = (HttpURLConnection)url.openConnection();
		urlConnect.setConnectTimeout(3000);
		urlConnect.connect();
		if(urlConnect.getResponseCode() == 200) {
			System.out.println(urlString + " - " + urlConnect.getResponseMessage());
		}
		if(urlConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
			System.out.println(urlString + " - " + urlConnect.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
		}
		
	}

}
