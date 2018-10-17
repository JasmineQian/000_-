package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestZhihu4Acxiom {

    public static void main(String args[]) throws InterruptedException {

        System.setProperty("webdriver.ie.driver", ".\\Tools\\IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver();

        //System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://zhihu.sogou.com/");
        String s = driver.getTitle();
        System.out.println(s);

        WebElement eleKW = driver.findElement(By.id("query"));
        eleKW.clear();
        eleKW.sendKeys("安客诚");
        WebElement eleBtn = driver.findElement(By.cssSelector("input.swz"));
        eleBtn.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Thread.sleep(300);
        //driver.quit();



        // 等待页面加载完毕，直到条件满足
        (new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver dr) {
                int index = dr.getPageSource().indexOf("result-about-list");
                if (index != -1) {
                    return true; // 找到，退出等待
                } else {
                    return false; // 未找到，继续等待
                }
            }
        });
        List<WebElement> eleBoxs = driver.findElements(By.cssSelector("div.result-about-list"));
        for (WebElement eleBox : eleBoxs) {
            WebElement eleTitle = eleBox.findElement(By.cssSelector("h4.about-list-title"));
            WebElement eleAnswer = eleBox.findElement(By.cssSelector("p.about-answer"));
            WebElement eleTxt = eleBox.findElement(By.cssSelector("div.about-text"));
            System.out.println(eleTitle.getText() + eleAnswer.getText() + eleTxt.getText());
        }
        //driver.close();
        //driver.quit();
    }

    }


