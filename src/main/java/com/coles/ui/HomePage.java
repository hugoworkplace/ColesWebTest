package com.coles.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getShopOnlineButton(){
        for(WebElement button : driver.findElements(By.className("rocket__navbar__link"))) {
            if (button.getText().equals("Shop online"))
                return button;
        }
        throw new NotFoundException("shop online button not found");
    }
}
