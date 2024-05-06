package com.itacademy.listeners;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.List;

public class ElementActionListener implements WebDriverListener {
    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.println(String.valueOf(keysToSend) + "was typed into" + element.toString());
    }
    @Override
    public void afterGet(WebDriver driver, String url) {
        System.out.println("Website " + String.valueOf("https://react-shopping-cart-67954.firebaseapp.com/") + " is loaded");
    }

    @Override
    public void afterClick(WebElement element) {
        System.out.println("Element " + element.getText() + " was clicked");
    }

    @Override
    public void afterGetText(Alert alert, String result) {
        System.out.println(alert.getText() + " " + result.toString() + " were compared");
    }

    @Override
    public void afterGetTitle(WebDriver driver, String result) {
        System.out.println(driver.getTitle() + " is found");
    }
    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
            System.out.println(driver.getTitle() + " is found");
    }
    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        System.out.println(result.toString() + " list is done");
    }
    @Override
    public void afterGetText(WebElement element, String result) {
        System.out.println("Element's text " + "'" + element.getText() + "' is found");
    }
}
