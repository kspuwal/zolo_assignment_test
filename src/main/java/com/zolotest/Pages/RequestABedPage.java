package com.zolotest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.omg.IOP.TAG_ORB_TYPE.value;

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

    /*TODO : Right now I'm unable to set future date , I will get some work around for this or else I have to use Protector to
    automate this function*/
    /*public void setVisitDate(String visitDate) throws InterruptedException {
        System.out.println("Setting visit Date : "+ visitDate);
        // Actions actions = new Actions(driver);
        // actions.moveToElement(visitDateShowCalenderWE).click();
        //visitDateShowCalenderWE.click();
        Thread.sleep(5000);
        JavascriptExecutor jse= (JavascriptExecutor)driver;
        String script= "arguments[0].setAttribute('value property','"+visitDate+"');";
        jse.executeScript(script, dateInputWE);

        Thread.sleep(10000);

        //  visitDateWE.clear();
        // visitDateWE.sendKeys(visitDate);

    }*/
    public void selectSharingType(String sharingType){
        System.out.println("Selecting a "+sharingType+" Bed");
        driver.findElement(By.xpath("//h4[1]/strong[text()='"+sharingType+"']")).click();
    }

    public void clickOnProceedToPayButton(){
        System.out.println("Clicking on 'Proceed To Pay' button ");
        proceedToPayWE.click();
    }

}
