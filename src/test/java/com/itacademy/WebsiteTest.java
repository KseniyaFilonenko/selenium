package com.itacademy;

import com.itacademy.pages.CartPage;
import com.itacademy.pages.FirstPage;
import com.itacademy.utils.ScreenshotUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
        Assert.assertEquals(firstPage.getFirstItemText(), cartPage.getItemInCartText());
    }
//    @DataProvider(name = "itemsData")
//    public Object[][] getData(){
//        FirstPage firstPage = new FirstPage(driver);
//        List<String> listOfProductsHomepage = firstPage.getItemsList();
//        return new Object[][]{
//                {listOfProductsHomepage}
//        };
//    }
    @Test
    public void listOfItems() throws InterruptedException {
        FirstPage firstPage = new FirstPage(driver);
        firstPage.openUrl();
        List<String> listOfProductsHomepage = firstPage.getItemsList();
        firstPage.getItemsList();
        firstPage.addAllItemsToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.getItemsListInCart();
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
    @DataProvider(name = "filters")
    public Object[][] getData(){
        return new Object[][]{
                {"XS", "1 Product(s) found"},
                {"S", "2 Product(s) found"},
                {"M", "1 Product(s) found"},
                {"ML", "2 Product(s) found"}
        };
    }
    @Test(dataProvider = "filters")
    public void filter3(String filterName, String message) throws InterruptedException {
        FirstPage firstPage = new FirstPage(driver);
        firstPage.openUrl();
        firstPage.applyFilter(filterName);
        Assert.assertEquals(firstPage.getProductsFoundLabel().getText(), message);
    }
}
