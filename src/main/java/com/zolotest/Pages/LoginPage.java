package com.zolotest.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kuldeep on 23-09-2017.
 */
public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id='signin']/..//input[@placeholder='10 digit Mobile number']")
    WebElement enterMobileNumWE;

    @FindBy(xpath = "//*[@id='signin']/..//input[@placeholder='Password']")
    WebElement enterPasswordWE;

    @FindBy(xpath = "//input[@value='Sign In']")
    WebElement signInButtonWE;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver,this);
    }

    public void enterMobileNumber(String mobileNum){
        enterMobileNumWE.clear();
        enterMobileNumWE.sendKeys(mobileNum);
    }

    public void enterPassword(String password){
        enterPasswordWE.clear();
        enterPasswordWE.sendKeys(password);
    }

    public void clickOnSignInButton(){
        /*Actions actions = new Actions(driver);
        actions.moveToElement(signInButtonWE);*/
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,"+signInButtonWE.getLocation().y+")");
        signInButtonWE.click();
    }


    public void loginToZolo(String mobileNum, String password) throws InterruptedException {
        enterMobileNumber(mobileNum);
        enterPassword(password);
        Thread.sleep(3000);
        clickOnSignInButton();
    }



}
