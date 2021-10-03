package com.coles.webtest;

import com.coles.ui.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashSet;

public class HomePageTestSuite {
    WebDriver driver;

    @BeforeEach
    public void Setup(){
        driver = new ChromeDriver();
        driver.get("https://www.coles.com.au/");
    }

    @AfterEach
    public void close(){
//        if(driver!=null)
//            driver.quit();
    }

    @Test
    public void shopOnlineButtonTest(){
        var button = new HomePage(driver).getShopOnlineButton();

        button.click();
        System.out.println(driver.getCurrentUrl());

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }


        //new WebDriverWait(driver,10)
                //.until(ExpectedConditions.urlToBe("https://shop.coles.com.au/a/national/home?cid=cdc:navigation:shop-online"));
        Assertions.assertEquals("https://shop.coles.com.au/a/national/home?cid=cdc:navigation:shop-online",
                driver.getCurrentUrl());
    }
}
