package com.zolotest.Pages;

import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kuldeep on 24-09-2017.
 */
public class ConfirmationVisitPage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='col-md-6']/h4[contains(@class,'text-blue')]")
    WebElement propertyNameWE;

    @FindBy(xpath = "//h4[contains(@class,'text-blue')]/../p")
    WebElement propertyAddressWE;

    @FindBy(xpath = "//div[@class='col-md-6']/h4[contains(@class,'pull-right')]")
    WebElement visitStatusWE;

    @FindBy(xpath = "//p[text()='Date of Visit']/../h4")
    WebElement dateOfVisitWE;

    @FindBy(xpath = "//p[text()='Confirmation Date']/../h4")
    WebElement dateOfConfirmationWE;

    @FindBy(xpath = "//p[text()='Time of Visit']/../h4")
    WebElement timeOfVisitWE;

    @FindBy(xpath = "//p[text()='Visit Contact Number']/../h4")
    WebElement visitContactNumWE;



    public ConfirmationVisitPage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver,this);
    }

    public String getPropertyName(){
        String propertyName = propertyNameWE.getText();
        System.out.println("Property Name on Confirmation Visit Page : "+propertyName);
        return propertyName;
    }

    public String getPropertyAddress(){
        String propertyAddress = propertyAddressWE.getText();
        System.out.println("Property Address on Confirmation Visit Page : "+propertyAddress);
        return propertyAddress;
    }

    public String getVisitStatusCode(){
        String visitStatusCode = visitStatusWE.getText();
        System.out.println("Visit Status code is : "+visitStatusWE.getText());
        return visitStatusCode;
    }

    public String getDateOfConfirmation(){
        String dateOfConfirmation = dateOfConfirmationWE.getText();
        System.out.println("Confirmation Date is : "+dateOfConfirmation);
        return dateOfConfirmation;
    }

    public String getTimeOfVisit(){
        String timeOfVisit = timeOfVisitWE.getText();
        System.out.println("Time of Visit is : "+timeOfVisit);
        return timeOfVisit;
    }

    public String getDateOfVisit(){
        String dateOfVisit = dateOfVisitWE.getText();
        System.out.println("Date of Visit is : "+dateOfVisit);
        return dateOfVisit;
    }

    public String getVisitContactNum(){
        String visitContactNum = visitContactNumWE.getText();
        System.out.println("Visit Contact Number is : "+visitContactNum);
        return visitContactNum;
    }

    public void getAllConfirmationDetails(){
        System.out.println("Getting all the details from Visit Confirmation Page");
        getPropertyName();
        getPropertyAddress();
        getVisitStatusCode();
        getDateOfConfirmation();
        getDateOfVisit();
        getTimeOfVisit();
        getVisitContactNum();
    }
}
