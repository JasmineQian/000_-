package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBaidu4Axciom {

    public static void main(String args[]) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://www.baidu.com");
        String s = driver.getTitle();
        System.out.println(s);
        driver.findElement(By.id("kw")).sendKeys("安客诚");
        Thread.sleep(3000);
        driver.findElement(By.id("su")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Thread.sleep(3000);
        //driver.quit();

        (new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver dr) {
                int index = dr.getPageSource().indexOf("content_left");
                //dr.getPageSource().in
                if (index != -1) {
                    return true; // 找到，退出等待
                } else {
                    return true; // 未找到，继续等待
                }
            }
        });

        System.out.println("----content_left found----");


        List<WebElement> eleBoxs = driver.findElements(By.cssSelector("div.result.c-container"));
        for (WebElement eleBox : eleBoxs) {
            WebElement eleTitle = eleBox.findElement(By.cssSelector("h3.t"));
            WebElement eleDetail = eleBox.findElement(By.cssSelector("div.c-abstract"));
            WebElement eleURL = eleBox.findElement(By.cssSelector("div.f13"));
            System.out.println(eleTitle.getText() + "\n " + eleDetail.getText() + " \n" + eleURL.getText() + " \n");
        }

        //driver.quit();
        System.out.println("----即将关闭浏览器--");

    }
}
