package com.itacademy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FacebookTest {
    WebDriver driver;
    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C/Drivers/chrome-win64");
        WebDriver driver = new ChromeDriver(); // open browser
    }
    @Test
    public void signUp() throws InterruptedException {
        driver.get("https://www.facebook.com");
        Thread.sleep(5000);

    }
    @Test
    public void googleTest(){

        driver.get("http://www.google.com"); // open session

        WebElement element = driver.findElement(By.name("q"));
        driver.findElement(By.className("gLFyf");
        driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        driver.findElement(By.id("APjFqb"));

        element.sendKeys("Selenium");
        element.submit();
    }
    @AfterTest
    public void closeSession(){
        driver.quit();
    }
}
