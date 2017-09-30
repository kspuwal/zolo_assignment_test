package com.zolotest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kuldeep on 24-09-2017.
 */
public class RequestABedPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@type='date']")
    WebElement dateInputWE;

    @FindBy(className = "fa fa-calendar")
    WebElement calendarIconWE;

    @FindBy(xpath = "//button[text()='Proceed to Pay']")
    WebElement proceedToPayWE;

    public RequestABedPage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        PageFactory.initElements(driver,this);
    }

    public void selectSharingType(String sharingType){
        System.out.println("Selecting a "+sharingType+" Bed");
        driver.findElement(By.xpath("//h4[1]/strong[text()='"+sharingType+"']")).click();
    }

    public void clickOnProceedToPayButton(){
        System.out.println("Clicking on Proceed To Pay button ");
        proceedToPayWE.click();
    }

}
