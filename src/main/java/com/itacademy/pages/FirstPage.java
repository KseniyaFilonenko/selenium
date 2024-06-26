package com.itacademy.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FirstPage extends BasePage {
    @FindBy(xpath = "//p[@class='sc-124al1g-4 eeXMBo'][1]")
    private WebElement firstItem;
    @FindBy(xpath = "//button[text()='Add to cart']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//p[@class='sc-124al1g-4 eeXMBo']")
    private List<WebElement> itemsList;
    @FindBy(xpath = "//*[text()='Add to cart']")
    private List<WebElement> addToCartItemsList;
    @FindBy(xpath = "//span[text()='S']")
    private WebElement filterButtonS;
    @FindBy(xpath = "//span[text()='XS']")
    private WebElement filterButtonXS;
    @FindBy(xpath = "//span[text()='M']")
    private WebElement filterButtonM;
    @FindBy(xpath = "//span[text()='ML']")
    private WebElement filterButtonML;
    @FindBy(xpath = "//main[@class='sc-ebmerl-4 iliWeY']")
    private WebElement productsFoundLabel;
    public FirstPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void openUrl() {
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
    }
    public void clickAddToCartButton() {
        addToCartButton.click();
    }
    public String getFirstItemText() {
        return firstItem.getText();
    }
    public List<String> getItemsList() {
        return itemsList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
    public void addAllItemsToCart() throws InterruptedException {
        List<WebElement> listOfProductsHomepage = new ArrayList<>(addToCartItemsList);
        for (WebElement items : listOfProductsHomepage){
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", items);
        }
        Thread.sleep(5000);
    }
    public void clickFilterButton() {
        filterButtonS.click();
    }
    public WebElement getProductsFoundLabel() {
        return productsFoundLabel;
    }
    public int getProductsQty() {
        return Integer.parseInt(productsFoundLabel.getText().replaceAll("[^\\d]", ""));
    }
    public void applyFilter(String filterName) throws InterruptedException {
        WebElement filterButton;
        switch (filterName) {
            case "XS":
                filterButton = filterButtonXS;
                break;
            case "S":
                filterButton = filterButtonS;
                break;
            case "M":
                filterButton = filterButtonM;
                break;
            case "ML":
                filterButton = filterButtonML;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + filterName);
        }
        filterButton.click();
        Thread.sleep(5000);
    }
}
