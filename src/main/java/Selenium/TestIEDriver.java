package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestIEDriver {

	public static void main(String args[]) throws InterruptedException {

		System.setProperty("webdriver.ie.driver", ".\\Tools\\IEDriverServer.exe");

		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("http://www.baidu.com");
		String s = driver.getTitle();
		System.out.print(s);
		WebElement aa =driver.findElement(By.id("kw"));
		aa.sendKeys("安客诚");
		Thread.sleep(1000);
		driver.findElement(By.id("su")).click();
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//Thread.sleep(1000);
		//driver.quit();

	}
}