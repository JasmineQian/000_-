package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestFireFoxDriver {

	public static void main(String args[]) throws InterruptedException {

		System.setProperty("webdriver.Firefox.driver", ".\\Tools\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.baidu.com");
		String s = driver.getTitle();
		System.out.print(s);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.close();

	}

}
