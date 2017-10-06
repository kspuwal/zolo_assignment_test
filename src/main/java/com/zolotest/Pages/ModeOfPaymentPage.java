package com.zolotest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kuldeep on 04-10-2017.
 */
public class ModeOfPaymentPage {

    WebDriver driver;

    @FindBy(xpath = "//li/span[text()='Pay Via Link']")
    WebElement payViaLinkWE;

    @FindBy(xpath = "//li/span[text()='Debit Card/Credit Card/ Internet Banking']")
    WebElement debitCreditCardInternetBankingWE;

    @FindBy(xpath = "//li/img[@alt='Pay via PhonePe']")
    WebElement payViaPhonePeWE;

    @FindBy(xpath = "//li/img[@alt='Pay via PayTM']")
    WebElement payViaPaytmWE;

    public ModeOfPaymentPage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        PageFactory.initElements(driver,this);
    }

    public void clickOnPaymentMode(String paymentMode) throws InterruptedException {
        System.out.println("Clicking on "+paymentMode+ " payment mode");
        if(paymentMode.equalsIgnoreCase("PayTM")){
            payViaPaytmWE.click();
        }
        else if(paymentMode.equalsIgnoreCase("Debit Card") || paymentMode.equalsIgnoreCase("Credit Card") || paymentMode.equalsIgnoreCase("Internet Banking")){
            debitCreditCardInternetBankingWE.click();
        }
        else if (paymentMode.equalsIgnoreCase("PhonePe")){
            payViaPhonePeWE.click();
        }
        else if (paymentMode.equalsIgnoreCase("Pay Via Link")){
            payViaLinkWE.click();
        }
    }



}

