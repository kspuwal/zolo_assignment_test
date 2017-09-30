package com.zolotest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kuldeep on 23-09-2017.
 */
public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id='navbar']/ul/..//a[contains(text(),'LOGIN')]")
    WebElement loginTabWE;

    public HomePage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this); // Initialize all web Elements using PageFactory.initElements()
    }

    public void clickOnLoginTab(){
        System.out.println("Clicking on Login Tab shown in Home Page");
        loginTabWE.click();
    }

}
