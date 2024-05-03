package com.itacademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage{
    @FindBy(xpath = "//p[@class='sc-11uohgb-2 elbkhN']")
    private WebElement itemInCart;
    @FindBy(xpath = "//div[@class='sc-7th5t8-0 jehOnP']")
    private List <WebElement> itemsListInCart;
    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public WebElement getItemInCart() {
        return itemInCart;
    }
    public List<String> getItemsListInCart() {
        return itemsListInCart.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
