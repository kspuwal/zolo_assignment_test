package com.zolotest.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kuldeep on 23-09-2017.
 */
public class ScheduleVisitPage {

    WebDriver driver;

    @FindBy(xpath = "//a[@class='ng-binding']")
    WebElement propertyNameWE;

    @FindBy(name = "visitDate")
    WebElement visitDateWE;

    @FindBy(className = "caret caret-extra")
    WebElement visitDateShowCalenderWE;

    @FindBy(name = "visitTime")
    WebElement selectVisitTimeWE;

    @FindBy(xpath = "//div[contains(text(),'Schedule aVisit')]")
    WebElement scheduleVisitButton;

    public ScheduleVisitPage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver,this);
    }


    public String getPropertyName() throws InterruptedException {
        Thread.sleep(5000);
        String propertyName = propertyNameWE.getText();
        System.out.println("Actual Property Name on Schedule Visit Page :" + propertyName);
        return propertyName;
    }

    public void verifyPropertiesDetailsOnScheduleVisit(String expectedPropertyName) throws InterruptedException {
        Assert.assertTrue(getPropertyName().equalsIgnoreCase(expectedPropertyName), "You are on wrong Property, Please check your expected property name");
        System.out.println("Expected and actual property name matched on Schedule Visit Page , You are on correct property");
    }

    public void setVisitDate(String visitDate) throws InterruptedException {
        System.out.println("Setting visit Date : "+ visitDate);
       // Actions actions = new Actions(driver);
       // actions.moveToElement(visitDateShowCalenderWE).click();
        //visitDateShowCalenderWE.click();
        JavascriptExecutor jse= (JavascriptExecutor)driver;
        String script= "arguments[0].setAttribute('ng-change','"+visitDate+"');";
        jse.executeScript(script, visitDateWE);

        Thread.sleep(15000);

      //  visitDateWE.clear();
       // visitDateWE.sendKeys(visitDate);

    }

    public void setVisitTime(String visitTime){
        System.out.println("Selecting Visit Time :"+visitTime);
        Select selectVisitTime = new Select(selectVisitTimeWE);
        selectVisitTime.selectByVisibleText(visitTime);
    }

    public void clickOnScheduleVisitButton() throws InterruptedException {
        scheduleVisitButton.click();
        Thread.sleep(3000);
    }
//Please set a visitTime from below option like : 8 am - 9 am
   /* <option value="" selected="">Please Select A Time</option>
    <option value="[800,900]">8 am - 9 am</option>
    <option value="[900,1000]">9 am - 10 am</option>
    <option value="[1000,1100]">10 am - 11 am</option>
    <option value="[1100,1200]">11 am - 12 pm</option>
    <option value="[1200,1300]">12 pm - 1 pm</option>
    <option value="[1300,1400]">1 pm - 2 pm</option>
    <option value="[1400,1500]">2 pm - 3 pm</option>
    <option value="[1500,1600]">3 pm - 4 pm</option>
    <option value="[1600,1700]">4 pm - 5 pm</option>
    <option value="[1700,1800]">5 pm - 6 pm</option>
    <option value="[1800,1900]">6 pm - 7 pm</option>
    </select>*/
}
