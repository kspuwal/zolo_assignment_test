package com.zolotest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kuldeep on 23-09-2017.
 */
public class PropertyDetailsPage {

    WebDriver driver;

    @FindBy(tagName = "h1")
    WebElement propertyNameWE;

    @FindBy(linkText = "Schedule a Visit")
    WebElement scheduleVisitWE;

    @FindBy(xpath = "//a[text()='Request a Bed']")
    WebElement requestABedWE;

    public PropertyDetailsPage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        PageFactory.initElements(driver,this);
    }

    public String getPropertyName() {
        System.out.println("Getting Property Name from Property Details Page");
        String propertyName = propertyNameWE.getText();
        System.out.println("Property Name is :" + propertyName);
        return propertyName;
    }

    public void clickOnRequestABed(){
        System.out.println("Click on Request A Bed button");
        requestABedWE.click();
    }

    public void verifyPropertiesDetails(String expectedPropertyName) {
        System.out.println("Verifying Property details : ");
        String actualPropertyName = getPropertyName();
        System.out.println("Actual Property Name is : "+actualPropertyName);
        System.out.println("Expected property Name is : "+expectedPropertyName);
        Assert.assertTrue(actualPropertyName.equalsIgnoreCase(expectedPropertyName), "\n You are on wrong Property, Please check your expected property name");
        System.out.println("Property verified successfully, You are on correct property");
    }

    public void clickOnScheduleVisit() throws InterruptedException {
        scheduleVisitWE.click();
        Thread.sleep(5000);
    }
}
