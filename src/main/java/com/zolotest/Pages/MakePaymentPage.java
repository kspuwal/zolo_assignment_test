package com.zolotest.Pages;

import org.apache.poi.hssf.record.SaveRecalcRecord;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.sql.rowset.spi.SyncResolver;

import static java.lang.Thread.*;

/**
 * Created by Kuldeep on 24-09-2017.
 */
public class MakePaymentPage {

    WebDriver driver;

    @FindBy(tagName = "h2")
    WebElement propertyNameWE;

    @FindBy(xpath = "//p[text()='Date of Occupancy']/../h4")
    WebElement dateOfOccupancyWE;

    //Error in Contact Person label on UI
    @FindBy(xpath = "//p[text()='Conatct Person']/../h4")
    WebElement contactPersonWE;

    @FindBy(xpath = "//p[text()='Sharing']/../h4")
    WebElement sharingWE;

    @FindBy(xpath = "//p[text()='Contact Number']/../h4")
    WebElement contactNumberWE;

    @FindBy(name = "fullname")
    WebElement userNameWE;

    @FindBy(name = "email")
    WebElement userEmailAddressWE;

    @FindBy(name = "name")
    WebElement phoneNumWE;

    @FindBy(xpath = "//label/input[@type='checkbox']")
    WebElement applyPromoCheckBoxWE;

    @FindBy(xpath = "//input[@placeholder='Enter Promo Code']")
    WebElement enterPromoCodeInputBox;

    @FindBy(xpath = "//button[text()='Apply Code']")
    WebElement applyCodeButton;

    @FindBy(xpath = "//p[text()='Booking Amount Deposit']/../h4")
    WebElement bookingAmtDepositWE;

    @FindBy(xpath = "//h4/i[@class='fa fa-inr']/../b")
    WebElement finalAmountWE;

    @FindBy(xpath = "//div[text()='Make Payment']")
    WebElement makePaymentBtn;

    
    public MakePaymentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getPropertyName(){
        String propertyName = propertyNameWE.getText();
        System.out.println("Property Name on Make Payment page :"+propertyName);
        return propertyName;
    }

    public String getDateOfOccupancy(){
        String dateOfOccupancy = dateOfOccupancyWE.getAttribute("value");
        System.out.println(" Date of Occupancy : "+dateOfOccupancy);
        return dateOfOccupancy;
    }

    public String getContactPersonName(){
        String contactPerson = contactPersonWE.getAttribute("value");
        System.out.println(" Contact Person name on Make payment page :"+contactPerson);
        return contactPerson;
    }

    public String getSharingType(){
        String sharingType = sharingWE.getText();
        System.out.println("Sharing Type on Make Payment page :"+sharingType);
        return sharingType;
    }

    public String getContactNumber(){
        String contactNum = contactNumberWE.getText();
        System.out.println("Contact Number on Make payment page :"+contactNum);
        return contactNum;
    }

    public String getUserName(){
        String userName = userNameWE.getAttribute("value");
        System.out.println("User name on Make payment page :"+userName);
        return userName;
    }

    public String getUserEmailAddress(){
        String emailAddress = userEmailAddressWE.getAttribute("value");
        System.out.println("User Email address on Make payment page :"+emailAddress);
        return emailAddress;
    }

    public String getUserPhoneNum(){
        String phoneNum = phoneNumWE.getAttribute("value");
        System.out.println("User phone Number on Make payment page :"+phoneNum);
        return phoneNum;
    }

    public void clickOnApplyPromoCodeCheckBox(){
        System.out.println("Clicking on Apply Promo Code Check box shown on Make Payment page");
        applyPromoCheckBoxWE.click();
    }

    public void applyPromoCode(String promoCode){
        System.out.println("Applying promo code : "+promoCode);
        clickOnApplyPromoCodeCheckBox();
        enterPromoCodeInputBox.sendKeys(promoCode);
        applyCodeButton.click();
    }

    public String getBookingAmtDeposit(){
        System.out.println("Getting Booking amount deposit from make payment page ");
        String bookingAmtDeposit = bookingAmtDepositWE.getText();
        System.out.println("Booking amount deposit on Make Payment page is : "+bookingAmtDeposit);
        return bookingAmtDeposit;
    }


    public String getFinalAmount(){
        String findAmt = finalAmountWE.getText();
        System.out.println("Final Amount on Make payment page is :"+findAmt);
        return findAmt;
    }

    public void gettingDetails() throws InterruptedException {
        //Property Details
        System.out.println("Property Details on Make Payment page :-");
        Thread.sleep(3000);
        getPropertyName();
        getDateOfOccupancy();
        getContactPersonName();
        getSharingType();
        getContactNumber();

        //User details
        System.out.println("User details on make Payment page :-");
        getUserName();
        getUserEmailAddress();
        getUserPhoneNum();

        //Amount details
        getBookingAmtDeposit();
        getFinalAmount();
    }

    public void clickOnMakePayment() throws InterruptedException {
        System.out.println("Click on Make Payment button ");
        makePaymentBtn.click();
        //Wait for 5 sec
        sleep(5000);
    }


}
