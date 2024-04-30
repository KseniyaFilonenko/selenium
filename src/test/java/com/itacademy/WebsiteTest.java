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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebsiteTest {
    WebDriver driver;
    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver/chromedriver.exe");
        driver = new ChromeDriver(); // open browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void addToCart() {
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");

        WebElement firstItem = driver.findElement(By.xpath("//p[@class='sc-124al1g-4 eeXMBo']"));

        WebElement addToCart = driver.findElement(By.xpath("//button[@class='sc-124al1g-0 jCsgpZ']"));
        addToCart.click();

        WebElement itemInCart = driver.findElement(By.xpath("//p[@class='sc-11uohgb-2 elbkhN']"));

        Assert.assertEquals(firstItem.getText(), itemInCart.getText());
    }
    @Test
    public void listOfItems(){
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");

        List<WebElement> item = driver.findElements(By.xpath("//div[@class='sc-uhudcz-0 iZZGui']"));
        List<String> itemList = new ArrayList<>();
        for (WebElement items : item){
            itemList.add(items.getText());
        }
        for (WebElement items : item){
            items.click();
        }
        List<WebElement> cartItem = driver.findElements(By.xpath("//div[@class='sc-7th5t8-0 jehOnP']"));
        List<String> cartItemList = new ArrayList<>();
        for (WebElement cartItems : cartItem){
            cartItemList.add(cartItems.getText());
        }
        Assert.assertEquals(itemList, cartItemList);
    }
    @Test
    public void filter(){
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");

        List<WebElement> item = driver.findElements(By.xpath("//div[@class='sc-uhudcz-0 iZZGui']"));
        List<String> itemList = new ArrayList<>();
        for (WebElement items : item){
            itemList.add(items.getText());
        }

        WebElement size = driver.findElement(By.xpath("//span[text()='S']"));
        size.click();

        List<WebElement> item2 = driver.findElements(By.xpath("//div[@class='sc-uhudcz-0 iZZGui']"));
        List<String> itemList2 = new ArrayList<>();
        for (WebElement items2 : item2){
            itemList2.add(items2.getText());
        }
        Assert.assertTrue(itemList.size() > itemList2.size());
    }
    @Test
    public void filter2(){
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");

        WebElement foundItems = driver.findElement(By.xpath("//main[@class='sc-ebmerl-4 iliWeY']"));
        int a = Integer.parseInt(foundItems.getText().replaceAll("[^\\d]", ""));

        WebElement size = driver.findElement(By.xpath("//span[text()='S']"));
        size.click();

        WebElement foundItems2 = driver.findElement(By.xpath("//main[@class='sc-ebmerl-4 iliWeY']"));
        int b = Integer.parseInt(foundItems.getText().replaceAll("[^\\d]", ""));

        Assert.assertTrue(a > b);
    }
    @AfterTest
    public void closeSession(){
        driver.quit();
    }
}
