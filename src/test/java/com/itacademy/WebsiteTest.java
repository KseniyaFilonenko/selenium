package com.itacademy;

import com.itacademy.pages.CartPage;
import com.itacademy.pages.FirstPage;
import com.itacademy.utils.ScreenshotUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebsiteTest extends BaseTest {
    @Test
    public void addToCart() {
        FirstPage firstPage = new FirstPage(driver);
        firstPage.openUrl();
        firstPage.clickAddToCartButton();
        ScreenshotUtils.takeScreenshot(driver);
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(firstPage.getFirstItem().getText(), cartPage.getItemInCart().getText());
    }
    @Test
    public void listOfItems() throws InterruptedException {
        FirstPage firstPage = new FirstPage(driver);
        firstPage.openUrl();
        List<String> listOfProductsHomepage = firstPage.getItemsList();
        firstPage.addAllItemsToCart();
        CartPage cartPage = new CartPage(driver);
        List<String> listOfProductsInCart = cartPage.getItemsListInCart();
        Assert.assertEquals(listOfProductsHomepage, listOfProductsInCart);
    }
    @Test
    public void filter() throws InterruptedException {
        FirstPage firstPage = new FirstPage(driver);
        firstPage.openUrl();
        List<String> listBeforeFilter = firstPage.getItemsList();
        firstPage.clickFilterButton();
        Thread.sleep(5000);
        List<String> listAfterFilter = firstPage.getItemsList();
        Assert.assertTrue(listBeforeFilter.size() > listAfterFilter.size());
    }
    @Test
    public void filter2() throws InterruptedException {
        FirstPage firstPage = new FirstPage(driver);
        firstPage.openUrl();
        firstPage.getProductsFoundLabel();
        int a = firstPage.getProductsQty();
        firstPage.clickFilterButton();
        Thread.sleep(5000);
        firstPage.getProductsFoundLabel();
        int b = firstPage.getProductsQty();
        Assert.assertTrue(a > b);
    }
}
