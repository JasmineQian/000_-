package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestBaiduElement {

    String url = "http://www.baidu.com/";

    @Test
    public void TestElement() {
        System.out.println("------Begin--------------");
        System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        (new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver dr) {
                int index = dr.getPageSource().indexOf("百度一下");
                if (index != -1) {
                    return true; // 找到，退出等待
                } else {
                    return false; // 未找到，继续等待
                }
            }
        });


        WebElement baidu = driver.findElement(By.id("su"));
        System.out.println("border-bottom-color = " + baidu.getCssValue("border-bottom-color"));
        System.out.println("border-bottom-style = " + baidu.getCssValue("border-bottom-style"));
        System.out.println("border-bottom-width = " + baidu.getCssValue("border-bottom-width"));
        System.out.println("box-sizing = " + baidu.getCssValue("box-sizing"));
        System.out.println("color = " + baidu.getCssValue("color"));
        System.out.println("display = " + baidu.getCssValue("display"));
        System.out.println("text-align = " + baidu.getCssValue("text-align"));
        System.out.println("background = " + baidu.getCssValue("background"));
        System.out.println("line-height = " + baidu.getCssValue("line-height"));
        System.out.println("height = " + baidu.getCssValue("height"));
        System.out.println("font-family = " + baidu.getCssValue("font-family"));
        System.out.println("font-size = " + baidu.getCssValue("font-size"));
        System.out.println("margin-bottom = " + baidu.getCssValue("margin-bottom"));
        System.out.println("margin-top = " + baidu.getCssValue("margin-top"));
        System.out.println("margin-left = " + baidu.getCssValue("margin-left"));
        System.out.println("margin-right = " + baidu.getCssValue("margin-right"));


        //System.out.println(baidu.getText());
        driver.quit();
        System.out.println("------End--------------");
    }
}
