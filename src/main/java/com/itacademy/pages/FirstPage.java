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
    @FindBy(xpath = "//p[@class='sc-124al1g-4 eeXMBo']")
    private WebElement firstItem;
    @FindBy(xpath = "//button[@class='sc-124al1g-0 jCsgpZ']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//div[@class='sc-uhudcz-0 iZZGui']")
    private List <WebElement> itemsList;
    @FindBy(xpath = "//span[text()='S']")
    private WebElement filterButton;
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
    public WebElement getFirstItem() {
        return firstItem;
    }
    public List<String> getItemsList() {
        return itemsList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
    public void addAllItemsToCart() {
        List<WebElement> listOfProductsHomepage = new ArrayList<>(itemsList);
        for (WebElement items : listOfProductsHomepage){
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", items);
        }
    }
    public void clickFilterButton() {
        filterButton.click();
    }
    public WebElement getProductsFoundLabel() {
        return productsFoundLabel;
    }
    public int getProductsQty() {
        Integer.parseInt(productsFoundLabel.getText().replaceAll("[^\\d]", ""));
        return 0;
    }
}
