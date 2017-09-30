package com.zolotest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Kuldeep on 24-09-2017.
 */
public class MakePaymentPage {

    WebDriver driver;

    @FindBy(xpath = "//p[text()='Date of Occupancy']/../h4")
    WebElement dateOfOccupancyWE;

    //Error in Contact Person label
    @FindBy(xpath = "//p[text()='Conatct Person']/../h4")
    WebElement conatctPersonWE;

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

    @FindBy(xpath = "//p[text()='Booking Amount Deposit']/../h4")
    WebElement bookingAmtDepositWE;

    @FindBy(xpath = "//h4/i[@class='fa fa-inr']/../b")
    WebElement finalAmountWE;

    





}
