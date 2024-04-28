package com.itacademy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebsiteTest {
    WebDriver driver;
    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C/Drivers/chromedriver");
        WebDriver driver = new ChromeDriver(); // open browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void addToCart() {
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        driver.findElement(By.xpath("//*[@alt='Cropped Stay Groovy off white')]//*[text() = 'Add to cart']")).click();
        driver.findElement(By.className("sc-1h98xa9-4 hzlwTK"));
        WebElement name = driver.findElement(By.className("sc-11uohgb-2 elbkhN"));
        Assert.assertEquals(name.getText(), "Cropped Stay Groovy off white");
    }

    @Test
    public void listOfItems(){
        
    }
    @Test
    public void googleTest(){

        driver.get("http://www.google.com"); // open session

        WebElement element = driver.findElement(By.name("q"));
        driver.findElement(By.className("gLFyf"));
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
