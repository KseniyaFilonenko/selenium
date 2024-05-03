package com.itacademy.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
