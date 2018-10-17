package Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class TestBaiduDriver {

    String url = "http://www.baidu.com/";

    @Test
    public void TestDriver() throws InterruptedException {
        System.out.println("------Begin--------------");
        System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        //System.out.println(driver.getPageSource());
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());
        System.out.println(driver.manage().window().getClass());
        System.out.println(driver.manage().window().toString());

        Point targetPosition = new Point(100,100);
        driver.manage().window().setPosition(targetPosition );
        System.out.println(driver.manage().window().getPosition());

        Dimension targetSize = new Dimension(1024, 768);
        driver.manage().window().setSize(targetSize);
        System.out.println(driver.manage().window().getSize());

        WebElement baiduClick = driver.findElement(By.id("su"));
        System.out.println("baiduClick： " + baiduClick.getTagName());
        System.out.println("------开始点击啦---------");
        baiduClick.click();
        System.out.println("1. 点击完毕");

        WebElement baiduInput = driver.findElement(By.id("kw"));
        System.out.println("baiduInput： " + baiduInput.getTagName());
        if (baiduInput.isDisplayed()) {
            baiduInput.sendKeys("selenium");
            System.out.println("2.输入Selenium完毕");
        } else {
            System.out.println("2.未找到输入框");
        }
        baiduInput.clear();
        System.out.println("3.clear");
        baiduInput.sendKeys("Python");
        System.out.println("4.输入Python");

        WebElement baiduClick2 = driver.findElement(By.id("su"));
        System.out.println("baiduClick： " + baiduClick2.getTagName());
        baiduClick2.click();


        Thread.sleep(3000);
        WebElement PythonLink = driver.findElement(By.xpath("//*[@id='1']/h3/a[1]"));
        System.out.println("PythonLink： " + PythonLink.getTagName());
        System.out.println(PythonLink.getText());
        PythonLink.click();


        Thread.sleep(3000);
        driver.get(url);
        System.out.println(driver.getWindowHandle());

        String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄
        Set<String> handles = driver.getWindowHandles();// 获取所有窗口句柄
        System.out.println("当前窗口数量： " + handles.size());
        Iterator<String> it = handles.iterator();
        while (it.hasNext()) {
            if (currentWindow == it.next()) {
                continue;
            }
            try {
                WebDriver window = driver.switchTo().window(it.next());// 切换到新窗口
                System.out.println("new page title is " + window.getTitle());
            } catch (Exception e) {
                System.out.println("无法切换到新打开窗口" + e.getMessage());

            }

            driver.get(url);

            driver.close();
            driver.quit();
            System.out.println("------End--------------");
        }
    }
}
