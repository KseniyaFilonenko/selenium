package com.itacademy.listeners;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class ElementActionListener implements WebDriverListener {
    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.println(String.valueOf(keysToSend) + "was typed into" + element.toString());
    }
}
